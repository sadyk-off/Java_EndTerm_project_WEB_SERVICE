package data;

import data.interfaces.IDB;

import javax.ws.rs.ServerErrorException;
import java.sql.Connection;
import java.sql.DriverManager;

public class PostgresDB implements IDB {


    @Override
    public Connection getConnection() {
        String connectionUrl = "jdbc:postgresql://localhost:5432/postfornomad";
        try {
            Connection con = DriverManager.getConnection(connectionUrl, "postgres", "Owner123456789");

            return con;
        } catch (Exception e) {
            System.out.println(e);
            throw new ServerErrorException("Cannot connect to DB", 500);
        }
    }
}