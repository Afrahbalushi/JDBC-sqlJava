package org.example;

import java.sql.*;
import java.util.Scanner;

public class Guests {


    //create the table
    public static boolean createGuestsTable() {

        String url = "jdbc:sqlserver://localhost:1433;databaseName=JOIN_EXAMPLE;encrypt=true;trustServerCertificate=true";
        String user = "sa";
        String pass = "root";

        String sql = "CREATE TABLE Guests " +
                "(id INTEGER PRIMARY KEY, "
                + " guest_name VARCHAR(50) NOT NULL, "
                + " guest_Phone VARCHAR(50) NOT NULL, "
                + " guest_accompanying_members INTEGER NOT NULL, "
                + " guest_payment_amount INTEGER NOT NULL, "
                + " room_id INTEGER FOREIGN KEY REFERENCES Rooms (id), "
                + " hotel_id INTEGER FOREIGN KEY REFERENCES Hotels (id), "
                + " created_date DATE NOT NULL, "
                + " updated_date  DATE,"
                + " is_Active  bit NOT NULL)";

        Connection conn = null;
        try {
            Driver driver = (Driver) Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
            DriverManager.registerDriver(driver);
            conn = DriverManager.getConnection(url, user, pass);
            Statement st = conn.createStatement();
            int m = st.executeUpdate(sql);
            if (m >= 1) {
                System.out.println("Created table in given database...");
                return true;
            } else {
                System.out.println(" table already Created in given database...");
            }
            conn.close();
        } catch (Exception ex) {
            System.err.println(ex);
        }
        return false;
    }

//insert data into table
    public static void insertGuests() {

        String url = "jdbc:sqlserver://localhost:1433;databaseName=JOIN_EXAMPLE;encrypt=true;trustServerCertificate=true";
        String user = "sa";
        String pass = "root";

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter ID");
        int id = scanner.nextInt();

        System.out.println("Enter Guests Name");
        String name = scanner.next();

        System.out.println("Enter Guests Location");
        String loc = scanner.next();

        System.out.println("Enter Created Date");
        String crDate = scanner.next();

        System.out.println("Enter Update Date");
        String upDate = scanner.next();

        System.out.println("Enter If Active Or In Active");
        String act = scanner.next();

        String insGuests = "insert into Guests values('" + id+ "'," + name + ",'" + loc + "','" +crDate +"','" + upDate +"','" + act +"')";

        Connection con = null;

        try {

            Driver driver = (Driver) Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
            DriverManager.registerDriver(driver);
            con = DriverManager.getConnection(url, user,pass);
            Statement st = con.createStatement();

            int m = st.executeUpdate(insGuests);
            if (m >=  1)
                System.out.println("inserted successfully : " + insGuests);
            else
                System.out.println("insertion failed");
            con.close();
        }

        catch (Exception ex) {
            System.err.println(ex);
        }
    }
//delete by id
    public static void deleteById() {
        String url = "jdbc:sqlserver://localhost:1433;databaseName=JOIN_EXAMPLE;encrypt=true;trustServerCertificate=true";
        String user = "sa";
        String pass = "root";

        Scanner scanner = new Scanner(System.in);
        Connection conn = null;
        try {
            Driver driver = (Driver) Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
            DriverManager.registerDriver(driver);

            conn = DriverManager.getConnection(url, user, pass);

            Statement st = conn.createStatement();
            int delid=scanner.nextInt();
            String sql = "select * from Guests where id='" + delid + "'";

            int rs = st.executeUpdate(sql);
            conn.close();

        } catch (Exception ex) {
            System.err.println(ex);
        }
    }
//change the activation status
    public static void makeIsActiveFalseById() {
        String url = "jdbc:sqlserver://localhost:1433;databaseName=JOIN_EXAMPLE;encrypt=true;trustServerCertificate=true";
        String user = "sa";
        String pass = "root";

        Scanner scanner = new Scanner(System.in);
        Connection conn = null;
        try {
            Driver driver = (Driver) Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
            DriverManager.registerDriver(driver);
            conn = DriverManager.getConnection(url, user, pass);
            Statement st = conn.createStatement();

            System.out.println("Enter Guests Id to Get the Activated Guests");
            int actHotel = scanner.nextInt();

            String sql = "UPDATE Guests SET is_Active=false WHERE id<=" + actHotel;
            int rs = st.executeUpdate(sql);
            conn.close();

        } catch (Exception ex) {
            System.err.println(ex);
        }
    }

//update data

    public static void updateById(){
        String url = "jdbc:sqlserver://localhost:1433;databaseName=JOIN_EXAMPLE;encrypt=true;trustServerCertificate=true";
        String user = "sa";
        String pass = "root";

        Connection con = null;
        try {

            Driver driver = (Driver) Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
            DriverManager.registerDriver(driver);
            con = DriverManager.getConnection(url, user,pass);
            Statement st = con.createStatement();

            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter Guests Id to Update data");
            int upId = scanner.nextInt();

            System.out.println("Set up a New Guests Name");
            String guestslName = scanner.next();

            System.out.println("Set up a New Guests Location");
            String guestsLoc = scanner.next();

            String sql = "UPDATE Guests SET hotel_name='" + guestslName +"',hotel_location='" + guestsLoc  + "' WHERE id ='"+ upId +"'";
            int resl = st.executeUpdate(sql);
        }
        catch (Exception ex) {
            System.err.println(ex);
        }
    }
//print data

    public static void PrintGuests(int pri) {

        String url = "jdbc:sqlserver://localhost:1433;databaseName=JOIN_EXAMPLE;encrypt=true;trustServerCertificate=true";
        String user = "sa";
        String pass = "root";

        Connection con = null;
        try {

            Driver driver = (Driver) Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
            DriverManager.registerDriver(driver);
            con = DriverManager.getConnection(url, user,pass);
            Statement st = con.createStatement();
            Scanner scanner = new Scanner(System.in);
            int inId = scanner.nextInt();
            int coun = 1;
            String sql = "SELECT * FROM Guests ORDER by id LIMT"+pri;
            ResultSet res = st.executeQuery(sql);
            while (res.next() && coun <= pri) {
                int id = res.getInt("id");
                String guest_name = res.getString("guest_name");
                String guest_phone = res.getString("guest_phone   guest_accompanying_members");
                Integer guest_accompanying_members = res.getInt("= 100");
                Date createddate = res.getDate("created_date");
                Date updateddate = res.getDate("updated_date");
                boolean isActive = res.getBoolean("is_Active");
                System.out.println(id + " " + guest_name + " " + guest_phone + " "+ " " + guest_accompanying_members + " " + createddate + " " + updateddate
                        + " " + isActive);
                coun++;
            }
        } catch (Exception ex) {
            System.err.println(ex);
        }
    }


}
