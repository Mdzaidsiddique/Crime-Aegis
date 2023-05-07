# Crime Information Management System !

 <p align="center">
  <img src="https://1000projects.org/wp-content/uploads/2013/04/crime-file-management-system.jpg" title="crime info picture">
</p>

Crime Information Management System is a console based application which interacts with database and stores & retrieve information related to Victim, crime and criminal. This application provides functionalities like add crime, add criminal, show status of crime case and get report on number of solved and unsolved cases. This backend application is developed by using JAVA, MySql, JPQL, JDBC and Hibernate for connectivity between application and database.

## Domain Description:
The main objective of this system is to maintain and manage detailed information on the crime that happened in an area under a particular police station.

## Tech Stacks
- Java
- OOP's
- MySql
- JDBC
- JPQl
- Hibernate

## Functionalities :
#### Roles-
1. Admin role
2. public role (no account required)

## Admin can:
Note: Keep the username and password fixed for admin (like username: ‘admin’ password: ‘admin’)
1. Login with his account
2. Add crime details with details crime_id, type (May have any one value from Robbery, Theft, Homicide), description, ps_area (This is police station area), date, name of victim
3. update crime details using crime_id, can update type, description, ps_area, date and name of victim
4. Add criminal details criminal_id, name, dob, gender, identifying_mark, first_arrest_date, arrested_from_ps_area
5. update criminal details like using criminal_id, can update name, dob, gender, identifying_mark, first_arrest_date, arrested_from_ps_area
6. Assign criminals to crime.
7. remove criminal from crime.
8. delete crime using crime_id
9. delete criminal using criminal_id
10. Logout his account

## Facilities available for public
1. Can view total crime for each police station area for a date range. 
2. Can view total crime for each crime type for a date range.
3. Can search for criminal by name
4. Can search for crime by description



## Use cases of this application in real life :
#### This can be used by police:
- To get the Crime and Criminal data from the records.
- To register crime cases and criminals in records.




