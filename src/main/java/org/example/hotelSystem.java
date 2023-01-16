package org.example;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;

import static java.lang.System.exit;

public class hotelSystem {

    public static void main(String[] args) {


//        Scanner sc = new Scanner(System.in);
//        boolean exitMenue = true;
//        do {
//            System.out.println("1- Create Hotels table"+"\n");
//            System.out.println("2- Create Room type table"+"\n");
//            System.out.println("3- Create Rooms table"+"\n");
//            System.out.println("4- Create Guests table"+"\n");
//            System.out.println("5- Create Employee type table"+"\n");
//            System.out.println("6- Create Employees table"+"\n");
//            System.out.println("7- Exit "+"\n");
//
//            int option = sc.nextInt();
//            switch(option) {
//                case 1:
//                  hotels.createHotelTable();
//                    break;
//                case 2:
//                   Room_type.createRoomTypeTable();
//                    break;
//                case 3:
//                    Rooms.createRoomsTable();
//                    break;
//                case 4:
//                    Guests.createGuestsTable();
//                    break;
//                case 5:
//                   Employee_type.createEmployeeTypeTable();
//                    break;
//                case 6:
//                   Employees.createEmployeeTable();
//                    break;
//                case 7:
//                    System.exit(0);
//                    break;
//            }
//        }while(exitMenue);




        Scanner sc = new Scanner(System.in);
        boolean exitMenue = true;
        Scanner scanner = new Scanner(System.in);
        boolean exit= true;
        do {

            System.out.println("1- Insert 10,000 hotels");
            System.out.println("2- Insert 1 hotel");
            System.out.println("3- Print 10 hotels");
            System.out.println("4- Make first 10 hotels 'is_Active' = false");
            System.out.println("5- Print Hotel Information");
            System.out.println("6- Exit");

            int selOption = scanner.nextInt();

            switch (selOption) {
                case 1:
                    System.out.println("Enter Numbers Of Hotels You Want To Enter: ");
                    int numH = scanner.nextInt();
                    hotels.inpustUser(numH);

                    //System.out.println("Enter Numbers Of Room_Type You Want To Enter: ");
                    //int numR_T = scanner.nextInt();
                    //Room_Type.inpustUser(numR_T);

//                    System.out.println("Enter Numbers Of Rooms You Want To Enter: ");
//                    int numR = scanner.nextInt();
//                    Rooms.inpustUser(numR);

                    //System.out.println("Enter Numbers Of Guests You Want To Enter: ");
                    //int numG = scanner.nextInt();
                    //Guests.inpustUser(numG);

                    //System.out.println("Enter Numbers Of Employee_Type You Want To Enter: ");
                    //int numE_T = scanner.nextInt();
                    //Employee_Type.inpustUser(numE_T);

                    //System.out.println("Enter Numbers Of Employees You Want To Enter: ");
                    //int numE = scanner.nextInt();
                    //Employees.inpustUser(numE);

                    break;

                case 2:
                    hotels.inpustUser(1);
                   // Room_type.inpustUser(1);
                    //Rooms.inpustUser(1);
                    //Guests.inpustUser(1);
                    //Employee_type.inpustUser(1);
                    //Employees.inpustUser(1);
                    break;

                case 3:
                    hotels.Printhotels(10);
                   // Room_type.Printroom_Type(10);
                    //Rooms.PrintRooms(10);
                    //Guests.PrintGuests(10);
                    //Employee_type.PrintEmployee_Type(10);
                    //Employees.PrintEmployees(10);
                    break;

                case 4:
                    hotels.makeIsActiveFalseById();
                    //Room_type.makeIsActiveFalseById();
                    //Rooms.makeIsActiveFalseById();
                    //Guests.makeIsActiveFalseById();
                    //Employee_type.makeIsActiveFalseById();
                    //Employees.makeIsActiveFalseById();
                    break;

                case 5:
                    System.out.println("Enter Numbers Of Hotels You Want To Enter: ");
                    int info = scanner.nextInt();
                    hotels.Printhotels(info);
                    break;
            }
        }while (exit);



    }

    }







