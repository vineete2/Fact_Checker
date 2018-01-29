package com.github.smartbv2.fact_checker;


import org.neo4j.jdbc.Connection;
import org.neo4j.jdbc.PreparedStatement;
import org.neo4j.jdbc.ResultSet;
import org.neo4j.jdbc.ResultSetMetaData;

import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author Varma G.S.
 */
public class ConnectNeo {

    public static void main(String[] args) throws SQLException {


        // Create a new instance of the JDBC Driver for Neo4j and connect to the URL:
        String url = "jdbc:neo4j:bolt://localhost";
        try (Connection con = (Connection) DriverManager.getConnection(url, "neo4j", "varma")) {

            // Create a PreparedStatement and submit a Cypher query:
            // String query = "MATCH (tom {name: {1}}) RETURN tom"; // Movie database

            //Refresh database
            String queryDelete = "MATCH (n)" +
                    "DETACH DELETE n";
            try (PreparedStatement stmtDelete = (PreparedStatement) con.prepareStatement(queryDelete)) {
                stmtDelete.executeQuery();
            }

            String query = "CREATE (baeldung:Company {name:\"Baeldung\"}) "
                    + "-[:owns]-> (tesla:Car {make: {1}, model: {2}})"
                    + "RETURN baeldung, tesla";

//            try (PreparedStatement stmt = con.prepareStatement(query)) {
//                stmt.setString(1, "Tom Hanks");
//
//                // Iterate and print out the result set
//                try (org.neo4j.jdbc.ResultSet rs = (org.neo4j.jdbc.ResultSet) stmt.executeQuery()) {
//                    while (rs.next()) System.out.println(
//                             "Person: " + rs.getString("name") + " born in " + rs.getInt("born"));
//                           // rs.toString());

            try (PreparedStatement stmt = (PreparedStatement) con.prepareStatement(query)) {
                stmt.setString(1, "tesla");
                stmt.setString(2, "Model1X");

                ResultSet rs = (ResultSet) stmt.executeQuery();
                ResultSetMetaData rsmd = rs.getMetaData();
                int columnsNumber = rsmd.getColumnCount();
                // Read data from result set
                while (rs.next()) {
                    for (int i = 1; i <= columnsNumber; i++) {
                        if (i > 1) System.out.print(",  ");
                        String columnValue = rs.getString(i);
                        System.out.print(columnValue + " " + rsmd.getColumnName(i));
                    }
                }

            }
        }
    }
}
