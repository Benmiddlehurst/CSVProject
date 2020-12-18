# CSVProject

Project to transfer Employee data from a CSV file to a MySQL Database.

For this project to work for you there are a number of requirements:

Java Code Requirements:
1. Inside the file in resources named login.properties the username and password must be changed to YOUR username and password for your MySQL database.
2. If you want to upload a different CSV file any mention of "src/main/resources/EmployeeRecordsLarge.csv" must be changed to the content root path for your file.
3. The url "jdbc:mysql://localhost:3306/employee_database?serverTimezone=GMT" must match the url for your MySQL datbase table.
4. In order to successfully transfer into your SQL database the Schema, Table name and tables heading must match the names in your SQL Database.

MySQL Requirements:
1. A table with 10 columns, the first 7 being VARCHARs and the final 3 being DATE, DATE and INT in the order must be set up. The heading names are required to match
those listed in the java code as previously mentioned.
