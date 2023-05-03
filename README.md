# righteous-glove-4452
🕵
Project : Crime Information Management System 

Domain Description:
The main objective of this system is to maintain and manage detailed information on the
crime that happened in an area under a particular police station.

Roles-
1. Admin role

2. public role (no account required)
Admin can:
Note: Don't create a table to store the credentials of the administrator. Keep the
username and password fixed for admin (like username: ‘admin’ password: ‘admin’)
1. Login with his account
2. Add crime details with details crime_id, type (May have any one value from
Robbery, Theft, Homicide), description, ps_area (This is police station area), date,
name of victim
3. update crime details using crime_id, can update type, description, ps_area, date
and name of victim

Crime Information Management System 2
4. Add criminal details criminal_id, name, dob, gender, identifying_mark,
first_arrest_date, arrested_from_ps_area
5. update criminal details like using criminal_id, can update name, dob, gender,
identifying_mark, first_arrest_date, arrested_from_ps_area
6. Assign criminals to crime.
7. remove criminal from crime.
8. delete crime using crime_id
9. delete criminal using criminal_id
10. Logout his account
Facilities available for public
1. Can view total crime for each police station area for a date range.
2. Can view total crime for each crime type for a date range.
3. Can search for criminal by name
4. Can search for crime by description

Note:
1. Please maintain many to many relationships between crime and criminals because
a crime can be committed by more than one criminal and one criminal can be
involved in many crimes.
2. Kindly throw the appropriate exception for any invalid data entry.
3. Always use the auto_increment column as the primary key and the same column
should be a foreign key in another table.
4. All the required columns must have a value like the date and place of the crime that
can’t be null.
5. Kindly prepare ER-Diagram & database credentials must be read from the
properties file do not put them in code.
6. The project must be started from one class and shouldn't be started again and
again for different use cases.

Crime Information Management System 3
Additional Features (Great to have but not compulsory)
1. Allow public to file complaint using this software
2. Integrate system to contain information about the unsolved cases (You have to
maintain suspects also)
