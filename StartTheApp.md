These instructions are provided to help you get the application "installed" and started.

  1. Build Book-o-Tron 4000
```
    $ cd <bookotron_home>
    $ mvn clean install
```
  1. Setup the Database and Start the Application
```
    // create a directory for the DB (BoT-4k uses HSQL)
    $ mkdir /home/<myuser>/bot-db
    $ cd /home/<myuser>/bot-db

    // include the HSQL JAR
    $ cp <somewhere>/hsqldb-1.8.0.7.jar .

    // copy the server.properties (for HSQL)
    $ cp <bookotron_home>/bookotron.data/target/classes/server.properties .

    // copy and rename the db schema
    $ cp <bookotron_home>/bookotron.data/target/hibernate3/sql/book-o-tron-schema.ddl bot-db.script

    // start the DB
    $ java -cp hsqldb-1.8.0.7.jar org.hsqldb.Server

    // start the webserver
    $ cd <bookotron_home>/bookotron.web
    $ mvn jetty:run
```

You'll need to get the _hsqldb-1.8.0.7.jar_ (should be in your local maven repo or you can download it from the Internet).  Also, these instructions assume _bookotron\_home_ is a directory where the bookotron code is checked out to.

To view the application, open a browser and browse to: http://localhost:8080