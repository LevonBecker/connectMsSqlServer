package com.levon.mssql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class connectMsSqlServer
{
    public void dbConnect(String db_connect_string,
                          String db_userid,
                          String db_password)
    {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection conn = DriverManager.getConnection(db_connect_string,
                    db_userid, db_password);
            System.out.println("connected");
            Statement statement = conn.createStatement();
            String queryString = "select * from sysobjects where type='u'";
            ResultSet rs = statement.executeQuery(queryString);
            while (rs.next()) {
                System.out.println(rs.getString(1));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args)
    {
        connectMsSqlServer connServer = new connectMsSqlServer();
        connServer.dbConnect("jdbc:sqlserver://<hostname>:<port>", "<username>",
                "<password>");
    }
}

/**
 This is the list of all possible values for this column (xtype):
     C = CHECK constraint
     D = Default or DEFAULT constraint
     F = FOREIGN KEY constraint
     L = Log
     P = Stored procedure
     PK = PRIMARY KEY constraint (type is K)
     RF = Replication filter stored procedure
     S = System table
     TR = Trigger
     U = User table
     UQ = UNIQUE constraint (type is K)
     V = View
     X = Extended stored procedure

 For example, you can find all the user tables in a database by using this query:

 select * from sysobjects where xtype='U'
 */
