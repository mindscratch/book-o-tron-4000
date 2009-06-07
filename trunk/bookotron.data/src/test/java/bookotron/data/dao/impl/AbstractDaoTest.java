package bookotron.data.dao.impl;

import bookotron.data.dao.IBaseDao;
import org.dbunit.database.DatabaseConnection;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.dataset.IDataSet;
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
import java.sql.Connection;

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
public abstract class AbstractDaoTest<T> extends AbstractTransactionalDataSourceSpringContextTests {

    @Autowired
    protected IBaseDao<T> dao;

    @Autowired
    protected DataSource dbDataSource;

    @Override
    protected void onSetUp() throws Exception {
        super.onSetUp();
        assertNotNull(dao);
    }

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
        InputStream s = getClass().getClassLoader().getResourceAsStream(getTestDataLocation());

        return new FlatXmlDataSet(s);//new File("bookotron.data/src/test/resources/dbunit-test-data/AuthorDaoTestData.xml"));
    }

    /**
     * Returns the path to the DBUnit test data, by default it uses the name of the class with the suffix "data".
     * 
     * @return
     */
    protected String getTestDataLocation() {
        return "dbunit-test-data/" + getClass().getSimpleName() + "Data.xml";
    }
}
