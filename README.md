# dao-jdbc

- This project was just to test my knowledge. Where I implement jdbc with mysql. I also used the DAO pattern and made a CRUD.

- DB package: Package where reads the db.properties file(where the database configuration is) and gets the connection to it. It has the methods that close the Connection, Statement and ResultSet interface. And there are also exception classes.

- dao package: This package has the factory class to get the connection and the interface that dictates the methods used in CRUD. 

- dao.impl package: Package where the CRUD is available.
