package com.halyph;

import org.h2.tools.Server;

import java.io.IOException;
import java.sql.*;


public class App {
    private static final String DBNAME = "mytest";

    public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException {
// open the in-memory database within a VM

        Class.forName("org.h2.Driver");
        Connection conn = DriverManager.getConnection("jdbc:h2:mem:" + DBNAME, "sa", "sa");
        // username:password are very important and must be used for connecting via H2 Console

        Statement stat = conn.createStatement();

        // this line would initialize the database
        // from the SQL script file 'init.sql'
        // stat.execute("runscript from 'init.sql'");

        stat.executeUpdate("create table mytbl(id int primary key, name varchar(255))");
        stat.executeUpdate("insert into mytbl values(1, 'Hello')");
        stat.executeUpdate("insert into mytbl values(2, 'World')");
        ResultSet rs = stat.executeQuery("select * from mytbl");
        System.out.println("ResultSet output:");
        while (rs.next()) {
            System.out.println(rs.getString("name"));
        }

        // start a TCP server
        Server server = Server.createTcpServer().start();
        // .. use in embedded mode ..

        // or use it from another process:
        System.out.println("Server started and connection is open.");
        System.out.println("URL: jdbc:h2:" + server.getURL() + "/mem:" + DBNAME);

        // now start the H2 Console here or in another process using
        // java org.h2.tools.Console -web -browser

        System.out.println("Press [Enter] to stop.");
        System.in.read();

        System.out.println("Stopping server and closing the connection");

        rs.close();
        server.stop();
        conn.close();
        System.out.println("Server is STOPPED");
    }
}
