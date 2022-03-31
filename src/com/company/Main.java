package com.company;

import java.sql.*;

public class Main {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
	// write your code here



        // the postgresql driver string
        Class.forName("org.postgresql.Driver");

        Connection con = DriverManager.getConnection(
                "jdbc:postgresql://msz-test.chq8qedm9jee.eu-west-1.rds.amazonaws.com/postgres",
                "postgres","1dQxvBLTEpKTfgxQGD5FN"
        );

        System.out.println("Database connected correctly");



        Statement st = con.createStatement();

        st.execute("DROP TABLE students");

        st.execute("CREATE TABLE students(first_name varchar, last_name varchar, class_id int)");

        st.execute("INSERT INTO students (first_name, last_name, class_id) VALUES ('Maks', 'Wielgomasz', 2)");

//      st.executeUpdate("DELETE FROM students WHERE first_name='Maks'");

        ResultSet rs = st.executeQuery("SELECT first_name, last_name, class_id FROM students");

        while(rs.next()){
            System.out.println(rs.getString("first_name"));
            System.out.println(rs.getString("last_name"));
            System.out.println(rs.getInt("class_id"));
        }

        st.close();

        con.close();

    }
}
