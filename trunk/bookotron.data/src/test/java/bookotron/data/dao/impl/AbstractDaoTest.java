package bookotron.data.dao.impl;

import bookotron.data.dao.IBaseDao;
import bookotron.model.entity.IEntity;
import org.dbunit.database.DatabaseConnection;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.CompositeDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSet;
import org.dbunit.operation.DatabaseOperation;
import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceUtils;
import org.springframework.test.AbstractTransactionalDataSourceSpringContextTests;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;
import java.io.InputStream;
import java.io.File;
import java.sql.Connection;
import java.util.List;
import java.util.ArrayList;

@RunWith(SpringJUnit4ClassRunner.class)
//This annotation tells Spring that we want each method in this class to be
//executed within it's own transaction.  You can also apply this annotation
//selectively to each method that needs a transaction, and have other
//methods execute outside a transaction.
@Transactional
//This annotation tells the Spring test runner to always roll back each
//transaction it creates.
@TransactionConfiguration(defaultRollback=true)
@ContextConfiguration(locations = {"classpath:test-context.xml"})
/**
 * An abstract class which provides support for other DAO tests
 */
public abstract class AbstractDaoTest extends AbstractTransactionalDataSourceSpringContextTests {

    @Autowired
    protected DataSource dbDataSource;

    @Before
    public void init() throws Exception {
        DatabaseOperation.CLEAN_INSERT.execute(getConnection(), getDataSet());
    }

    @After
    public void after() throws Exception {
       DatabaseOperation.DELETE_ALL.execute(getConnection(), getDataSet());
    }

    private IDatabaseConnection getConnection() throws Exception {
        Connection conn = DataSourceUtils.getConnection(dbDataSource);
        IDatabaseConnection dbUnitCon = new DatabaseConnection(conn);
        return dbUnitCon;
    }

    private IDataSet getDataSet() throws Exception {
        final ClassLoader cl = getClass().getClassLoader();
        final List<String> dataLocations = getTestDataLocations();
        final List<IDataSet> dataSets = new ArrayList<IDataSet>();

        InputStream stream = null;
        for (String location : dataLocations) {
            stream = cl.getResourceAsStream(location);
            if (stream != null) {
                dataSets.add(new FlatXmlDataSet(stream));
            }
        }

        return new CompositeDataSet(dataSets.toArray(new IDataSet[dataSets.size()]));
    }

    /**
     * Returns the paths to the DBUnit test data files, by default it uses the name of the class with the suffix "data".
     * 
     * @return
     */
    protected List<String> getTestDataLocations() {
        final List<String> testClasses = getTestDataClassNames();
        final List<String> locations = new ArrayList<String>(testClasses.size());

        for (String testClassName : testClasses) {
            locations.add("dbunit-test-data/" + testClassName + "Data.xml");
        }

        return locations;
    }

    /**
     * Returns a list of Class names used to retrieve test data files.
     * @return
     */
    protected List<String> getTestDataClassNames() {
        final List<String> classNames = new ArrayList<String>();

        classNames.add(getClass().getSimpleName());

        return classNames;
    }
}
