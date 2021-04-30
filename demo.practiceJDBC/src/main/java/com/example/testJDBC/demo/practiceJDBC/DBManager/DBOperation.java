package com.example.testJDBC.demo.practiceJDBC.DBManager;

import com.example.testJDBC.demo.practiceJDBC.DAOs.Person;
import com.example.testJDBC.demo.practiceJDBC.Request.CreateRequest;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DBOperation {

    public static volatile Connection connection;

    public static Connection getConnection() throws SQLException {
        if(connection == null){
            synchronized (DBOperation.class){
                if(connection == null){
                    connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/practice","root","rawatravi");
                }
            }
        }
        return connection;
    }

    public static void closeConnection(){
        if(connection != null){
            synchronized (DBOperation.class){
                if(connection != null){
                    connection=null;
                }
            }
        }
    }

    public static void createTable(String name) throws SQLException {
        getConnection();

        Statement statement= connection.createStatement();

        // two ways to initialise the query

//       String q ="create table" + name +"(tid int(200) primary key auto_increment,tname varchar(200),tage int(200),tstreet int(200),tcity varchar(200)";
//        statement.executeUpdate(q);

        ////***********************************************//
        boolean isCreated = statement.execute("CREATE TABLE " + name + " ( id INT PRIMARY KEY AUTO_INCREMENT, name VARCHAR(20), age INT, street INT(20),city VARCHAR(50))");


        // **********************************//
        if(isCreated){
            System.out.print("table" + name + "is created sucessfully..");
        }

        closeConnection();
    }

    public static void insertPerson(CreateRequest request) throws SQLException {

        getConnection();

        PreparedStatement preparedStatement = connection.prepareStatement("insert into JDBC(id,name,age,street,city) VALUES (null,?,?,?,?)");
//        preparedStatement.setInt(1,request.getId()); // you will not put the value to the auto incremented variable.
        preparedStatement.setString(1,request.getName());
        preparedStatement.setInt(2,request.getAge());
        preparedStatement.setInt(3,request.getStreet());
        preparedStatement.setString(4,request.getCity());

        int rows_affected = preparedStatement.executeUpdate();
        if(rows_affected > 0){
            System.out.println("Sucessfully inserted the record ,..");
        }
        else {
            System.out.println("unable to insert the record..");
        }
        closeConnection();

    }




    public static List<Person> getperson() throws SQLException {
        getConnection();

        Statement statement = connection.createStatement();
        ResultSet resultSet=statement.executeQuery("select * from JDBC");
        List<Person> list = new ArrayList<>();
        while(resultSet.next()) {
            int id = resultSet.getInt(1);
            String name = resultSet.getString(2);
            int age = resultSet.getInt(3);
            int street = resultSet.getInt(4);
            String city = resultSet.getString(5);

            Person person = new Person(id, name, age, street, city);
            System.out.println(person);
            list.add(person);

        }
        closeConnection();
        return list;
    }


}
