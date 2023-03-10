package org.example;

import java.sql.*;
import java.util.Random;
import java.util.Scanner;

public class Rooms {

    public static boolean createRoomsTable() {

        String url = "jdbc:sqlserver://localhost:1433;databaseName=JOIN_EXAMPLE;encrypt=true;trustServerCertificate=true";
        String user = "sa";
        String pass = "root";

        String sql = "CREATE TABLE Rooms " +
                "(id INTEGER PRIMARY KEY, "
                + " room_type_id INTEGER FOREIGN KEY REFERENCES Room_Type (id), "
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

    public static void inpustUser(int h) {
        Scanner sc = new Scanner(System.in);
        String url = "jdbc:sqlserver://localhost:1433;databaseName=JOIN_EXAMPLE;encrypt=true;trustServerCertificate=true";
        String user = "sa";
        String pass = "root";

        int room_type_id = 1;
        int hotel_id = 01;
        Date created_date = new Date(System.currentTimeMillis());
        Date updated_date = new Date(System.currentTimeMillis());
        String is_Active="true";

        Random rn = new Random();
        Integer randomNumber = (Integer) rn.nextInt(100);

        Connection conn = null;
        try {
            Driver driver = (Driver) Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
            DriverManager.registerDriver(driver);
            conn = DriverManager.getConnection(url, user, pass);
            for (int i = 0; i <= h ;i++) {
                String ins = "Insert into Rooms values(" + i +"," +room_type_id + "," + hotel_id + ",'" +created_date + "','" + updated_date + "','" + is_Active +"')";
                System.out.println(ins);
                Statement st = conn.createStatement();
                int m = st.executeUpdate(ins);
                System.out.println("Done...");
            }
            conn.close();
        }
        catch (Exception ex) {
            System.err.println(ex);
        }
    }
    public static void getById() {
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
            String inpId = "SELECT * FROM Rooms WHERE id='" + inId +"'";
            ResultSet res = st.executeQuery(inpId);
            while (res.next() && coun<= inId) {
                int id = res.getInt("id");


                int room_type_id = res.getInt("room_type_id");
                int hotel_id  = res.getInt("hotel_id");
                Date created_date = res.getDate("created_date");
                Date updated_date = res.getDate("updated_date");
                String is_Active= res.getString("is_Active");
                System.out.println(id + " "+ room_type_id +" " +" "+hotel_id+" "  +created_date + " "+ updated_date + " "+ is_Active);
                coun++;
            }
        }
        catch (Exception ex) {
            System.err.println(ex);
        }
    }
    public static void PrintRooms(int pri) {

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
            String sql = "SELECT * FROM Rooms ORDER by id LIMT"+pri;
            ResultSet res = st.executeQuery(sql);
            while (res.next() && coun <= pri) {
                int id = res.getInt("id");
                String roomsname = res.getString("hotel_name");
                String roomslocation = res.getString("hotel_location");
                Date createddate = res.getDate("created_date");
                Date updateddate = res.getDate("updated_date");
                boolean isActive = res.getBoolean("is_Active");
                System.out.println(id + " " + roomsname + " " + roomslocation + " " + createddate + " " + updateddate
                        + " " + isActive);
                coun++;
            }
        } catch (Exception ex) {
            System.err.println(ex);
        }
    }
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
            System.out.println("Enter Rooms Id to Update data");
            int upId = scanner.nextInt();

            System.out.println("Set up New Rooms");
            String RoomsName = scanner.next();

            System.out.println("Set up New Rooms Location");
            String RoomsLoc = scanner.next();

            String sql = "UPDATE Rooms SET hotel_name='" + RoomsName +"',hotel_location='" + RoomsLoc  + "' WHERE id ='"+ upId +"'";
            int resl = st.executeUpdate(sql);
        }
        catch (Exception ex) {
            System.err.println(ex);
        }
    }
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

            System.out.println("Enter Rooms Id to Get the Activated Rooms");
            int actRooms = scanner.nextInt();

            String sql = "UPDATE Rooms SET is_Active=false WHERE id<=" + actRooms;
            int rs = st.executeUpdate(sql);
            conn.close();

        } catch (Exception ex) {
            System.err.println(ex);
        }
    }
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
            String sql = "select * from Rooms where id='" + delid + "'";

            int rs = st.executeUpdate(sql);
            conn.close();

        } catch (Exception ex) {
            System.err.println(ex);
        }
    }
    public static void inputRooms(int numR) {

        String url = "jdbc:sqlserver://localhost:1433;databaseName=JOIN_EXAMPLE;encrypt=true;trustServerCertificate=true";
        String user = "sa";
        String pass = "root";
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter ID");
        int id = scanner.nextInt();

        System.out.println("Enter Rooms Name");
        String name = scanner.next();

        System.out.println("Enter Rooms Location");
        String loc = scanner.next();

        System.out.println("Enter Created Date");
        String crDate = scanner.next();

        System.out.println("Enter Update Date");
        String upDate = scanner.next();

        System.out.println("Enter If Active Or In Active");
        String act = scanner.next();

        String insRooms = "insert into Rooms values(" + "" + ",'" + name + "'," + loc + ",'" +crDate +"','" + upDate +"','" + act +"')";

        Connection con = null;

        try {

            Driver driver = (Driver) Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
            DriverManager.registerDriver(driver);
            con = DriverManager.getConnection(url, user,pass);
            Statement st = con.createStatement();

            int m = st.executeUpdate(insRooms);
            if (m >=  1)
                System.out.println("inserted successfully : " + insRooms);
            else
                System.out.println("insertion failed");
            con.close();
        }

        catch (Exception ex) {
            System.err.println(ex);
        }
    }
}
