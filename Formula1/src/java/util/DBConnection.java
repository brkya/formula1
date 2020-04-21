/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Burak
 */

public class DBConnection {

    public Connection connect() {
        Connection c = null;

        try {
            Class.forName("org.postgresql.Driver").newInstance();
            c =  (Connection) DriverManager.getConnection("jdbc:postgresql://localhost/formula1?user=postgres&password=123");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException ex) {
            System.out.println(ex.getMessage());
        }

        return c;
    }
}






            