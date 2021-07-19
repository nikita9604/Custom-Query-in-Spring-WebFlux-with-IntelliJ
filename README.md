## Custom-Query-in-Spring-WebFlux-with-IntelliJ
To create different types of Custom Queries in Spring WebFlux with IntelliJ over a Postgres Database.

### Summary of the Project :

  * Created 2 entities/tables namely - Patient and Doctor within a postgres database and link both together.
 
```create table patient (id serial primary key, name text, age integer);```

```create table doctor (did serial primary key, dname text, specs text, pid integer, CONSTRAINT "pid_FK" FOREIGN KEY (pid) REFERENCES public.patient(id) MATCH SIMPLE ON UPDATE NO ACTION ON DELETE SET NULL);```

#### Perform different CRUD operations for both tables
  * Add 1 entry of Patient by Id
  * Get all list of Patients 
  * Get Patient by Id
  * Update Patient (find and match by PID)
  * Delete Patient by PId

  _Same CRUD operations for Doctor table._

#### Custom Queries created are mentioned below
##### Patient Repository
  * Get only Top 3 entry with age in descending order 
  * Get all Patient entries through specified string by user contained in the name
  * Get all Patient entries having age > age specified by user
  * Get only the Patient entry through specified id by user
##### Doctor Repository
  * Get all Doctor entries through specified specs by user
  * Get all Doctor entries through specified specs by user with name in descending order.
  * Get only the Doctor entry through specified name by user
  * Update only specs of the Doctor entry through specified name by user
  * Get all Doctor entries through specified id by user

#### Perform JOIN Multiple Tables in R2DBC and Spring WebFlux for Relational Database
  * This is also included in the application that performs JOIN between Patient and Doctor 
