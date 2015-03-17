This page describes some conventions used in the data layer.

# Testing #
The testing in the data layer makes use of DbUnit and XML files for testing purposes.  There is an abstract class, _[AbstractDaoTest.java](http://code.google.com/p/book-o-tron-4000/source/browse/trunk/bookotron.data/src/test/java/bookotron/data/dao/impl/AbstractDaoTest.java)_ which handles setting up the database for testing.

By convention, it looks in _src\test\resources\dbunit-test-data\_ for an XML file which is named after the unit test class and appended with _Data.xml_.

For example if a test class is named _AuthorDaoTest_ then a data file should exist in _src\test\resources\dbunit-test-data_ with the name _AuthorDaoTestData.xml_. This behavior can be changed by having a subclass of _AbstractDaoTest_ override the following method:
```
protected String getTestDataLocation() { ... }
```

# DAO Implementation #

## Creating a New Instance ##
To create a new instance of the _[BaseDao](http://code.google.com/p/book-o-tron-4000/source/browse/trunk/bookotron.data/src/main/java/bookotron/data/dao/impl/BaseDao.java)_ for a particular entity you have two options:

```
// Notice Author is given as the entity since IAuthor isn't represented in the database
IBaseDao<IAuthor> dao = new BaseDao<Author>();
```

OR

```
// this option primarily exists because Spring (as of 2.5.x) doesn't support generic
// types in the XML configuration
IBaseDao<IAuthor> dao = new BaseDao(Author.class);
```

## FindAll Method ##
The _[BaseDao](http://code.google.com/p/book-o-tron-4000/source/browse/trunk/bookotron.data/src/main/java/bookotron/data/dao/impl/BaseDao.java)_ class creates a [Query](http://java.sun.com/javaee/5/docs/api/javax/persistence/Query.html) used in the implementation of the _findAll_ method.

It will first look for a [NamedQuery](http://java.sun.com/javaee/5/docs/api/javax/persistence/NamedQuery.html) whose _name_ ends with "findAll" (case insensitive).  If it can't find that it will create a query based on the table name.