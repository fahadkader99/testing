package automation.utils;

import java.sql.*;

// https://docs.oracle.com/cd/E19509-01/820-3497/agqju/index.html
    // oracle website - refer for how to set up the connection and driver

public class DataBaseUtils {
    static Connection con;
    static  Statement stmt;

    public static void createDB_Connection(){
        // 1 connect to database - > put url, username,  pass
        try {
            String url = PropertyReader.getProperty("db.url");
            String username = PropertyReader.getProperty("db.username");
            String password = PropertyReader.getProperty("db.password");

            Class.forName(PropertyReader.getProperty("db.class"));
            con = DriverManager.getConnection(url,username,password);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    public static ResultSet execute_Query(String query){
        ResultSet rs = null;

        // 2. Execute Query
        try {
            stmt = con.createStatement();
            rs =stmt.executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return rs;
    }


    public static void closeDB_Connection(){
        //4. closing the connection
        try {
            stmt.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }





    public static void main(String[] args) throws Exception {       // main method is extra staying here for my reference but we are not going to use

        // 1 connect to database - > put url, username,  pass
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://3.129.60.236:3306/digitalbank","digitaluser","Demo123!");
        // pass the url, username , pass of the Database

        // 2. Execute Query
        Statement statement = con.createStatement();
        ResultSet rs =statement.executeQuery("select username from users;");
        // we are passing the query from the DB which is connected to the digital Bank DB in step 1
        // ResultSet is where we are saving the result which is thrown from execute query


        // 3. Process / print result
        while (rs.next()){                          // Step 3 or while loop is only for printing the result or saving it on arraylist / map
            System.out.println(rs.getString("username"));
        }



        // 4. close the connection
        con.close();


    }
}


/*
* this is how we do data-base testing by sending data, in future we will be doing from
* property files*/