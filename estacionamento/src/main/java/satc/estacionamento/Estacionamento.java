/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package satc.estacionamento;

import liquibase.Liquibase;
import liquibase.database.DatabaseFactory;
import liquibase.database.jvm.JdbcConnection;
import liquibase.resource.ClassLoaderResourceAccessor;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author gusta
 */
public class Estacionamento {

    public static void main(String[] args) throws Exception {
        // Load the Oracle JDBC driver
        Class.forName("oracle.jdbc.driver.OracleDriver");

        // Connect to the Oracle database
        String url = "jdbc:oracle:thin:@localhost:1521:ORCL";
        String username = "SYSTEM";
        String password = "oracle";
        Connection connection = DriverManager.getConnection(url, username, password);

        // Create a Liquibase instance
        Liquibase liquibase = new Liquibase("changelog.xml", new ClassLoaderResourceAccessor(), DatabaseFactory.getInstance().findCorrectDatabaseImplementation(new JdbcConnection(connection)));

        // Apply the database changes
        liquibase.update("");

        // Close the database connection
        connection.close();
    }
}
