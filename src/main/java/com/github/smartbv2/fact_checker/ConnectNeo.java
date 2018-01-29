package com.github.smartbv2.fact_checker;


import org.neo4j.jdbc.Connection;
import org.neo4j.jdbc.PreparedStatement;

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


            //Refresh database
            String queryDelete = "MATCH (n)" +
                    "DETACH DELETE n";
            try (PreparedStatement stmtDelete = (PreparedStatement) con.prepareStatement(queryDelete)) {
                stmtDelete.executeQuery();
            }

            String statement = "Nobel Peace Prize is Henry Dunant honour.";
            String queryInsert = "WITH split(tolower(\"" + statement +
                    "\"),\" \") AS text" +
                    " UNWIND range(0,size(text)-2) AS i" +
                    " MERGE (w1:Word {name: text[i]})" +
                    " MERGE (w2:Word {name: text[i+1]})" +
                    " MERGE (w1)-[:NEXT]->(w2)";
            try (PreparedStatement stmtInsert = (PreparedStatement) con.prepareStatement(queryInsert)) {
                stmtInsert.executeQuery();
            }

        }
    }

}
