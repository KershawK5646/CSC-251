/*
 * Brandon Dalton
 * 8/21/2019
 * program asks user for name and classes, also calculates how many days can be
 * missed
 */
package hw_01_daltonbrandon;
import javax.swing.JOptionPane;
public class HW_01_DaltonBrandon 
{
    public static void main(String[] args) 
    {
     //declaring variables
     String input, name, courseName, courseNumber, prompt;
     int numberOfClasses = 0;
     int courseHours = 0,courseDaysPerWeek = 0,courseWeeks = 0,contactHours = 0;     
     double absentPercent = .2;
     double hoursCanMiss, daysCanMiss, daysCanMissRounded;
     
     do
     {
     //get user name
     name = JOptionPane.showInputDialog("What is your name? ");     
     
     JOptionPane.showMessageDialog(null, "Welcome " + name + " this program "
             + "will show you how many hours and days you can miss per class.");
     
     //get number of classes
     numberOfClasses = 0; //resets the value after loop
     //makes a loop to validate input to make sure an integer is entered
     while(numberOfClasses <= 0)
     {
        try
        {
            input = JOptionPane.showInputDialog("How many classes are you "
                    + "taking? ");
            numberOfClasses = Integer.parseInt(input);
            //redundant loop to give error message if number is less than 0
            while (numberOfClasses <= 0)
            {
                input = JOptionPane.showInputDialog("Please enter a number "
                        + "greater than 0.\nHow many classes are you taking?");
                numberOfClasses = Integer.parseInt(input);
            }
        }
        catch(NumberFormatException e)
        {
          JOptionPane.showMessageDialog(null, "Please enter a number.");  
        }
         
     }
     
     
     //set loop for classes
    for(int i=0; i<numberOfClasses; i++ )
     {
       courseNumber = JOptionPane.showInputDialog("What is the course number "
               + "and section number of class "+(i+1)+"? "
                       + "\nExample: CSC-251-0001 ");
      
       courseName = JOptionPane.showInputDialog("What is the name of the "
               + "class "+(i+1)+"? \nExample: Advanced Java Porgramming ");
       courseWeeks = 0; //resets value for loop
       //makes a loop to validate input to make sure an integer is entered
       while (courseWeeks <= 0)
       {       
       try
       {
          input = JOptionPane.showInputDialog("How many weeks is your class"
               + " "+(i+1)+"? ");
          courseWeeks = Integer.parseInt(input);
          //redundant loop to give error message if number is less than 0
          while (courseWeeks <0)
          {
             input = JOptionPane.showInputDialog("Pleae enter a number greater"
               + " than 0.\nHow many weeks is your class"+(i+1)+"? ");
          courseWeeks = Integer.parseInt(input); 
          }
       }
       catch(NumberFormatException e)
       {
         JOptionPane.showMessageDialog(null, "Please enter a number.");  
       }
       }
       
       courseDaysPerWeek = 0; //resets value for loop
       //makes a loop to validate input to make sure an integer is entered
       while (courseDaysPerWeek <= 0)
       {
           try
           {
               input = JOptionPane.showInputDialog("How many days a week do "
               + "you meet for class "+(i+1)+"? ");
               courseDaysPerWeek = Integer.parseInt(input);
               //redundant loop to give error message if number is less than 0
               while(courseDaysPerWeek <= 0)
               {
                   input = JOptionPane.showInputDialog("Please enter a number "                   
                   + "greather than 0.\nHow many days a week do you meet for "
                           + "class "+(i+1)+"? ");
               courseDaysPerWeek = Integer.parseInt(input);
               }
           }
           catch (NumberFormatException e)
           {
              JOptionPane.showMessageDialog(null, "Please enter a number."); 
           }
       }
       courseHours = 0;  //resets value for loop
       //makes a loop to validate input to make sure an integer is entered
       while (courseHours <= 0)
       {
           try
           {
            input = JOptionPane.showInputDialog("How many hours do you meet "             
               + "per day for class "+(i+1)+"?(Including lab hours) ");
            courseHours = Integer.parseInt(input);
            //redundant loop to give error message if number is less than 0
            while(courseHours <= 0)
            {
               input = JOptionPane.showInputDialog("Please enter a number"             
               + " greater than 0.\nHow many hours do you meet per day for "
                       + "class "+(i+1)+"?(Including lab hours) ");
               courseHours = Integer.parseInt(input);
            }
           }
           catch (NumberFormatException e)
           {
               JOptionPane.showMessageDialog(null, "Please enter a number.");
           }
       }
       
       
       contactHours = courseWeeks * courseDaysPerWeek * courseHours;
       hoursCanMiss = contactHours * absentPercent;
       daysCanMiss = hoursCanMiss / courseHours;
       daysCanMissRounded = Math.ceil(daysCanMiss);
       int daysCanMissInt = (int) daysCanMissRounded;
       
       String output = name + "'s class " + (i+1)
               + "\nCourse and section number: " + courseNumber
               + "\nCourse name: " + courseName  
               + "\nContact hours: " + contactHours
               + "\nHours available to miss: " + hoursCanMiss
               + "\nDays available to miss: " + daysCanMissInt;
       
       JOptionPane.showMessageDialog(null, output);              
     }
    prompt = JOptionPane.showInputDialog("Would you like to run this program "
            + "again?");
    //prompt for loop to run program again
    while (!(prompt.equalsIgnoreCase("yes") || prompt.equalsIgnoreCase("no")))
    {
        prompt = JOptionPane.showInputDialog("Error. Please enter Yes or No.");
    }
     }while (prompt.equalsIgnoreCase("yes"));
          
    }    
}



