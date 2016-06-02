# connectMsSqlServer
Example Jar that connects to a Microsoft SQL Server and Outputs the User Tables.

## Purpose
Demonstrate code that can be used to connect to a Microsoft SQL Server.
It is extremely simplified code mean to be give a jump start for your own project.
This has been tested against a MS SQL Server 2012 RDS instance from a bastion host with access to the RDS instance.

I currently don't have any tests created. Maybe at a later date I'll have time to add them.

## Requirements
* Download [sqlijdbc42.jar](https://www.microsoft.com/en-us/download/details.aspx?id=11774) to the lib folder.
* Java SDK 1.8.x+

## Configure
Enter credentials in the file **src/main/java/com/levon/mssql/connectMsSqlServer.class**
```java
connServer.dbConnect("jdbc:sqlserver://<hostname>:<port>", "<username>",
                "<password>");
```

## Build (Create Jar)
Once you have the SQL driver Jar downloaded to the **lib** folder you can use Gradle to build a fat Jar that includes the SQL driver and this projects code.

#### Gradle Build Command
```bash
gradle clean fatJar
```

#### Jar Location
The Jar file will be located under the build directory **build/libs/connecMsSqlServer-all-1.x.x.jar**

## Execute
* Browse to the location of the built Jar in a Shell
    * ```cd ../connectMsSqlServer/build/libs/```
* Run the Jar
    * ```java -jar connecMsSqlServer-all-1.x.x.jar```