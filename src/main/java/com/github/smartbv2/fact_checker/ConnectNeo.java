package com.github.smartbv2.fact_checker;


import org.neo4j.jdbc.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
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
            String query = "MATCH (tom {name: {1}}) RETURN tom"; // Movie database

            try (PreparedStatement stmt = con.prepareStatement(query)) {
                stmt.setString(1, "Tom Hanks");

                // Iterate and print out the result set
                try (org.neo4j.jdbc.ResultSet rs = (org.neo4j.jdbc.ResultSet) stmt.executeQuery()) {
                    while (rs.next()) System.out.println(
                            // "Person: " + rs.getString("name") + " born in " + rs.getInt("born"));
                            rs.toString());
                }
            }
        }
    }
}