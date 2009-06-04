package bookotron.data.dao.impl;

import org.springframework.test.AbstractTransactionalDataSourceSpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceUtils;
import org.springframework.transaction.annotation.Transactional;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.dbunit.operation.DatabaseOperation;
import org.dbunit.dataset.xml.FlatXmlDataSet;
import org.dbunit.dataset.IDataSet;
import org.dbunit.database.DatabaseConnection;
import org.dbunit.database.IDatabaseConnection;
import bookotron.data.dao.IBaseDao;
import bookotron.data.model.entity.impl.author.BaseAuthor;
import bookotron.model.entity.author.IAuthor;

import static org.junit.Assert.*;

import javax.sql.DataSource;
import java.io.FileInputStream;
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
public class AuthorDaoTest extends AbstractTransactionalDataSourceSpringContextTests {

    // under test
    @Autowired
    private IBaseDao<IAuthor> authorDao;

    @BeforeClass
    protected void setup() {
        assertNotNull(authorDao);
    }

    @Override
    protected String[] getConfigLocations() {
        return new String[] {"test-context.xml"};
    }

    @Override
    protected void onSetUpInTransaction() throws Exception {
        DataSource dataSource = jdbcTemplate.getDataSource();
        Connection con = DataSourceUtils.getConnection(dataSource);
        IDatabaseConnection dbUnitCon = new DatabaseConnection(con);
        IDataSet dataSet = new FlatXmlDataSet(new FileInputStream("./src/test/resources/dbunit-test-data/AuthorDaoTestData.xml"));

        try {
            DatabaseOperation.REFRESH.execute(dbUnitCon, dataSet);
        } finally {
            DataSourceUtils.releaseConnection(con, dataSource);
        }
    }

    @Test
    public final void testSave() {
        IAuthor author = new BaseAuthor();
        author.setFirstName("John");
        author.setLastName("Doe");

        IAuthor persistedAuthor = authorDao.insert(author);
        
    }
}
