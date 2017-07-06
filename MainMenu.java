/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package flightreserv;

//import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *-- Class: CSE 3330
-- Semester: Spring 2015
-- Student Name: your name (Patan, Idris)
-- Student ID: your id
-- Assignment: project #3
 * @author Idris Patan
 */
public class MainMenu 
{
    // Instantiation of Other classes
    int choice=0; // Menu Selection Choice Variable 
    Scanner scanner = new Scanner (System.in); // Scan for Input // Scanner Object
    boolean continueLoop = true; // determines if more input is needed 
    ReservationController reservInst = new ReservationController(); //ReservationController Object
    ReportController rpt = new ReportController(); 
    CancellationController cctr = new CancellationController ();
    
     public void simpleMessage ()
        {
            System.out.println("Welcome to Main Menu Page");
        }
    
    public int displayMainMenu()
    {
        System.out.println("-------------------------------------------------------------------------------------");
        System.out.println("--------------------- Please select from the following options ----------------------");
        System.out.println("--------------        Enter '1' For Reservation                ----------------------");
        System.out.println("--------------        Enter '2' For Cancellation               ----------------------");
        System.out.println("--------------        Enter '3' For Report                     ----------------------");
        System.out.println("-------------------------------------------------------------------------------------");
        System.out.print("PLEASE ENTER YOUR CHOICE :");
        return choice = scanner.nextInt();
    }
    public void Run() //throws IOException
    {
        do 
        { 
            System.out.println("Welcome");
            int recievedChoice = displayMainMenu();
            //if (selection == 0)
            //{
            //try
              // {

                //Choice = stdin.readLine();
                //sCase = Integer.parseInt(Choice); 
            //}

                    switch(recievedChoice)
                    {
                        case 1: System.out.println("You have Selected Reservation Menue");
                                reservInst.simpleMessage();
                                reservInst.UserAuthenticate();
                                break;

                        case 2: System.out.println("You have Selected Cancellation Menue");
                                cctr.simpleMessage();
                                cctr.cancellationList();
                                break;
                        case 3: System.out.println("You have Selected Report Menue");
                                rpt.simpleMessage();
                                rpt.ReportPage();
                                break;
                        default: System.out.println("Invalid Entry");
                                break;
                    }
                    continueLoop = false; //input successful, end looping 
             /*   }// end try 
           catch (InputMismatchException misMatch )
            {
                System.out.println("\nException: %s\n",misMatch);
                scanner.nextLine(); // discard input so user can try again
                System.out.println("You Must Enter Integers. Please Try Again.\n");
            }//end catch*/
        }while (continueLoop); // end do while 
     }
    
    
}
