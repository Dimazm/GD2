package by.it_academy.jd2.classwork.jdbc;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PostgresClass {


        public static void main(String[] args) throws ClassNotFoundException, SQLException {
            Class.forName("org.postgresql.Driver");
            try (Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/edu", "postgres",
                    "postgres")) {
                DatabaseMetaData metaData = conn.getMetaData();
                List<String> tables = getTablesMetadata(metaData);
                Map<String, List<String>> columnsMetadata = getColumnsMetadata(metaData, tables);


                columnsMetadata.forEach((table, columns) -> {
                    System.out.println(table);
                    columns.forEach(System.out::println);
                    System.out.println();
                });
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }

        }

    public static List<String> getTablesMetadata(DatabaseMetaData dbMetaData) throws SQLException{
        List<String> tables = new ArrayList<>();
        try(ResultSet rs = dbMetaData.getTables (null, null, null, new String[]{"TABLE"})){
            while (rs.next()){
                tables.add(((ResultSet) rs).getString("TABLE_NAME"));
            }
        }
        return tables;
    }

    private static Map<String, List<String>> getColumnsMetadata (DatabaseMetaData dbMetaData, List<String> tables) throws SQLException{
        Map <String, List<String>> structures = new HashMap<>();
        for (String actualTable : tables){
            List <String> columns = new ArrayList<>();
            structures.put(actualTable, columns);
            try(ResultSet rs = dbMetaData.getColumns(null, null, actualTable, null)){
                while (rs.next()){
                    columns.add(rs.getString("COLUMN_NAME") + " " + rs.getString("TYPE_NAME") + " " + rs.getString("COLUMN_SIZE"));
                }
            }
        }
        return structures;
    }
}

