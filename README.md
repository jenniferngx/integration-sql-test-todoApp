# Project: Integration and SQL Testing

In this project, we are implementing integration testing with the database of a TODO App. Milestone 2, you are provided with the adapter classes that implement the port interfaces provided in Milestone 1: `TodoDAO.java` and `UserDAO.java`. For this milestone you are required to implement the integration testing with the database.

### TODO Database information

Suppose the application uses a database called `tododb` with two tables. One table is called `users` and has 2 columns: 
- `id` of `bigint` type - a Long integer
- `username` of `varchar(20)` type - a string of upto 20 characters 

The other table is called `todos` and has 2 columns:
- `username` of `varchar(20)` type - a string of upto 20 characters 
- `todo` of `varchar(100)` type - a string of upto 100 characters 

### Steps in implementing integration testing

1. In `SQLIntegrationTestBase.java`, we implement setup and cleanup. Setup includes creating the database and the tables. For the database connection, we use the `jdbc:hsqldb:mem:` or `jdbc:hsqldb:file:`. For more details on HSQLDB see [here.](https://www.hsqldb.org/doc/2.0/guide/running-chapt.html)

2. We implement integration tests for `UserDAO.java` in `UserDAOIntegrationTest.java`.

3. We implement integration tests for `TodoDAO.java` in `TodoDAOIntegrationTest.jav`.
   
