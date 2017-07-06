/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package flightreserv;

import java.sql.*;


/**
 *-- Class: CSE 3330
-- Semester: Spring 2015
-- Student Name: your name (Patan, Idris)
-- Student ID: your id
-- Assignment: project #3
 * @author Idris Patan
 */
public class ReportController {
    
     // Static Variables for user and password 
    public static final String user= "root";
    public static final String pass= "Helay@2005";
    
    public void simpleMessage ()
    {
        System.out.println("Welcome to Report Page \t");
    }
    public void ReportPage()
    {
        System.out.println("List of all Planes \t");
        
        //Variables for connection Set 
        Connection myConn = null; // my connection
        Statement myStmt = null; // my statment 
        ResultSet rs = null;    // result 
        
        // user nameand password variables 
        String user = "root";
        String pass = "Helay@2005";
        
        try
        {
            // 1. Get a connection ot database 
            myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mip3778_mydbcreate",user, pass);
            
            // 2. Create a Statement 
            myStmt = myConn.createStatement();
            
            // 3. Execute SQL Querry 
            rs= myStmt.executeQuery("select * from plane");
            System.out.println("____________________________");
            System.out.println("|ID  |   Maker  |     Model |");
            System.out.println("|____|__________|___________|");
            // 4. Process the rs set 
            while (rs.next()) 
            {
                String ID = rs.getString("ID");
                String Maker = rs.getString("Maker");
                String Model = rs.getString("Model");
                System.out.println(ID +",\t"+  Maker  +",\t\t"+  Model);
            }
         } catch (Exception exc)
            {
            exc.printStackTrace();
            } 
         try
        {
            // 1. Get a connection ot database 
            myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mip3778_mydbcreate",user, pass);
            
            // 2. Create a Statement 
            myStmt = myConn.createStatement();
            
            // 3. Execute SQL Querry 
            rs= myStmt.executeQuery("select * from pilot");
            System.out.println(" ________________");
            System.out.println("| ID  |  Name   |");
            System.out.println("|____|__________|");
            // 4. Process the rs set 
            while (rs.next()) 
            {
                //System.out.println(rs.getArray("PassId:") + ". " + rs.getString("FLNO:"));
                String ID = rs.getString("ID");
                String Name = rs.getString("Name");
                System.out.println(ID +",\t"+  Name );
            }
            myConn.close();
         } catch (Exception exc)
            {
            exc.printStackTrace();
            } 
        MainMenu menu = new MainMenu();
        menu.Run();
    }
    
}
