/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package flightreserv;

import java.sql.*;
import java.util.*;
import java.sql.Date;


/**
 *-- Class: CSE 3330
-- Semester: Spring 2015
-- Student Name: your name (Patan, Idris)
-- Student ID: your id
-- Assignment: project #3
 * @author Idris Patan
 */
public class ReservationController 
{
    //Inst Object of ReservationTest
    ReservationTest reserv = new ReservationTest();
    // Scan for Input // Scanner Object
    Scanner scanner = new Scanner (System.in); 
    
    // Static Variables for user and password 
    public static final String user= "root";
    public static final String pass= "Helay@2005";
    
    public void simpleMessage ()
    {
        System.out.println("Welcome to Resrvation Page");
    }
    
    public void UserAuthenticate()
        {
         //Variables for connection Set 
        Connection myConn = null; // my connection
        Statement myStmt = null; // my statment 
        ResultSet rs = null;    // result 
                
        //System.out.println("Enter Flight Number:");
        //int inputFlightNumber = scanner.nextInt();
        System.out.println("Please Enter Your Customer ID:");
        int custID = scanner.nextInt();
        //userExist(custID); // Calling userExist Function to check user exist
       try
        {
            // 1. Get a connection ot database 
            myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mip3778_mydbcreate",user, pass);
            
            // 2. Create a Statement 
            myStmt = myConn.createStatement();
            
            // 3. Execute SQL Querry 
            rs= myStmt.executeQuery("select * from passenger");
            System.out.println(" ________________");
            System.out.println("| ID  |  Name   |");
            System.out.println("|____|__________|");
            // 4. Process the rs set 
            while (rs.next()) 
            {
                int ID = rs.getInt("ID");
                if (custID == ID)
                {
                    String Name = rs.getString("Name");
                    System.out.println(  ID +",\t"+  Name);
                    break;
                }
                else
                {
                    System.out.println("Costomer Does Not ");
                }
            }
            myConn.close();
         } catch (Exception exc)
            {
            exc.printStackTrace();
            } 
       ReservationList();
        }
        
    public void ReservationList()
    {
          //Variables for connection Set 
        Connection myConn = null; // my connection
        Statement myStmt = null; // my statment 
        ResultSet rs = null;    // result 
        

        /*System.out.println("Departure Airptort(code)"); // Departure Airport 
        int dptAirport = scanner.nextInt();             // Airport input 
        System.out.println("Arrival Airport");          // Departure Airport
        int arrAirport = scanner.nextInt();             // input Dept 
        System.out.println("Enter Flight Date");        //
        int fDate = scanner.nextInt();
         */       
       
        
        System.out.println("Flight Leg Instances");
        try
        {
            // 1. Get a connection ot database 
            myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mip3778_mydbcreate",user, pass);
            
            // 2. Create a Statement 
            myStmt = myConn.createStatement();
            
             // 3. Execute SQL Querry 
            rs= myStmt.executeQuery("SELECT * FROM  FlightLeg  GROUP BY FLNO	HAVING	count(FLNO)<=2;");
            System.out.println(" _________________________________________________________________________________________________________");
            System.out.println("| Option# | Leg Sequnce | Dpt Airport |   Departure Time  | Arrival Airport | Arrival time | FlightNumber |");
            System.out.println("|_________|_____________|_____________|___________________|_________________|______________|______________|");
            
            // 4. Process the rs set 
            int optionNum=1;
            while (rs.next()) 
            {
                int FlightNumber = rs.getInt("FLNO");
                int LegSequence = rs.getInt("Seq");
                String DepartureApt = rs.getString("FromA");
                Date DepTime;
                DepTime = rs.getDate("DepTime");
                String ArrivalApt = rs.getString("ToA");
                Date ArrTime = rs.getDate("ArrTime");
                
                
                //String SeatClass = rs.getString("SeatClass");
                System.out.println("\t" + optionNum +"\t"+ LegSequence +"\t\t"+ DepartureApt +"\t"+ DepTime +"\t\t" + ArrivalApt +"\t\t"+ ArrTime +"\t"+ FlightNumber );
                optionNum++;
                
            }
        }
        catch (Exception exc)
        {
        exc.printStackTrace();
        }
        System.out.println("---------------------------------------------------------------------------");
        System.out.println("--------------    Enter '1' Reservation    ----------------------");
        System.out.println("--------------    Enter '2' Main Menue               ----------------------");   
        System.out.println("---------------------------------------------------------------------------");
        int cancelChoice = scanner.nextInt();
        if (cancelChoice == 1)
        {
            System.out.println("Needs to Implement This ");
        }
        else if(cancelChoice==2)
        {
            MainMenu menu = new MainMenu();
            menu.Run();
        }
        else{
            System.out.println("Wrong Input");
        }
    }// End of ReservationList
    
    public boolean userExist(int userId)
    {
        //Variables for connection Set 
        Connection myConn = null; // my connection
        Statement myStmt = null; // my statment 
        ResultSet rs = null;    // result 
        

     try
        {
            // 1. Get a connection ot database 
            myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mip3778_mydbcreate",user, pass);
            
            // 2. Create a Statement 
            myStmt = myConn.createStatement();
            
            // 3. Execute SQL Querry 
            rs= myStmt.executeQuery("select * from passenger");
            System.out.println(" ________________");
            System.out.println("| ID  |  Name   |");
            System.out.println("|____|__________|");
            // 4. Process the rs set 
            while (rs.next()) 
            {
                //System.out.println(rs.getArray("PassId:") + ". " + rs.getString("FLNO:"));
                String ID = rs.getString("ID");
                String Name = rs.getString("Name");
                System.out.println(ID +",\t"+  Name);
                System.out.println("\t Welcome"+ Name);
            }
            myConn.close();
            return true;
         } catch (Exception exc)
            {
            exc.printStackTrace();
            } 
     return false;
    }// End of userExist 
    
}
