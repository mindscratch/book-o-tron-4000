package bookotron.data.dao.impl;

import org.junit.runner.RunWith;
import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.test.context.transaction.BeforeTransaction;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.AbstractTransactionalDataSourceSpringContextTests;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.datasource.DataSourceUtils;
import org.dbunit.operation.DatabaseOperation;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.database.DatabaseConnection;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.CompositeDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSet;

import javax.sql.DataSource;
import java.sql.Connection;
import java.util.List;
import java.util.ArrayList;
import java.util.Date;
import java.io.InputStream;
import static org.junit.Assert.*;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.log4j.lf5.viewer.LogFactor5LoadingDialog;
import bookotron.data.dao.IBaseDao;
import bookotron.data.model.entity.impl.author.Author;
import bookotron.data.model.entity.impl.user.User;
import bookotron.model.entity.author.IAuthor;
import bookotron.model.entity.user.IUser;

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
public class AddSeedDataTest {
        Log log = LogFactory.getLog(AddSeedDataTest.class);
    @Autowired
    protected DataSource dbDataSource;

    @Autowired
    @Qualifier("authorDao")
    private IBaseDao<IAuthor> dao;

    @Test
    public void nothing() {
        IUser user = new User();
        user.setAddDate(new Date());
        user.setEmail("rwickesser@proteus-technologies.com");
        user.setName("Craig");

        IAuthor author = new Author();
        author.setFirstName("Craig");
        author.setLastName("Wickesser");
        author.setAddDate(new Date());
        author.setAddedBy(user);

        dao.insert(author);
    }
}