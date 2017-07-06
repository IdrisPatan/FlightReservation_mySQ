/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package flightreserv;

import java.sql.*;
import java.util.Scanner;

/**
 *-- Class: CSE 3330
-- Semester: Spring 2015
-- Student Name: your name (Patan, Idris)
-- Student ID: your id
-- Assignment: project #3
 * @author Idris Patan
 */
public class CancellationController 
{
    Scanner scanner = new Scanner (System.in); // Scan for Input // Scanner Object
    
    // Static Variables for user and password 
    public static final String user= "root";
    public static final String pass= "Helay@2005";
    
    public void simpleMessage ()
    {
        System.out.println("Welcome to Cancellation Page");
    }
    
    public void cancellationList()
    {
        System.out.println("Please Enter Your ID To Check Your Reservations\t");
        int ReservationID = scanner.nextInt();
        
        //Variables for connection Set 
        Connection myConn = null; // my connection
        Statement myStmt = null; // my statment 
        ResultSet rs = null;    // result 
        
        
        System.out.println("These Are Your Non Cancelled Reservation");
        try
        {
            // 1. Get a connection ot database 
            myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mip3778_mydbcreate",user, pass);
            
            // 2. Create a Statement 
            myStmt = myConn.createStatement();
            
             // 3. Execute SQL Querry 
            rs= myStmt.executeQuery("select * from reservation");
            System.out.println(" __________________________________________________________________________________________");
            System.out.println("|Resv Seq | Flight No. |    Date     |   Departure Airport  | Arrival Airport | Seat Class |");
            System.out.println("|_________|____________|_____________|______________________|_________________|____________|");
            
            // 4. Process the rs set 
            int resvSeq=1;
            while (rs.next()) 
            {
                int passengerId = rs.getInt("passId");
                if (ReservationID == passengerId) 
                {
                    int FlightNumber = rs.getInt("FLNO");
                    Date FlightDate = rs.getDate("FDate");
                    String DepartureApt = rs.getString("FromA");
                    String ArrivalApt = rs.getString("ToA");
                    String SeatClass = rs.getString("SeatClass");
                    System.out.println("\t" + resvSeq +"\t"+ FlightNumber  +"\t"+  FlightDate +"\t\t"+ DepartureApt +"\t\t"+ ArrivalApt +"\t\t"+ SeatClass );
                    resvSeq++;
                }
            }
        }
        catch (Exception exc)
        {
        exc.printStackTrace();
        }
        System.out.println("---------------------------------------------------------------------------");
        System.out.println("--------------    Enter '1' To Cancel Reservation    ----------------------");
        System.out.println("--------------    Enter '2' Main Menue               ----------------------");   
        System.out.println("---------------------------------------------------------------------------");
        int cancelChoice = scanner.nextInt();
        if (cancelChoice == 1)
        {
            try
            {
            myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mip3778_mydbcreate",user, pass);
            
            // 2. Create a Statement 
            myStmt = myConn.createStatement();
            

            System.out.println("Enter The Flight Number You Wish To Cancel");
            int cancelFlightNumber = scanner.nextInt();
            String sql = ("update reservation\n" +
                    "set DateCancelled= '2002-09-28'\n" +
                    "where FLNO =" + cancelFlightNumber );
            myStmt.executeUpdate(sql);

            }
            
            catch (Exception exc)
            {
            exc.printStackTrace();
            }
            MainMenu menu = new MainMenu();
            menu.Run();
            
        }
        
        else if(cancelChoice==2)
        {
            MainMenu menu = new MainMenu();
            menu.Run();
        }
        else{
            System.out.println("Wrong Input");
        }
    }
    
}
