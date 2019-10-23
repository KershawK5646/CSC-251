/*
 * Ask for name
 *Ask for classes (CSC-251) (Class name)
 *Output:
 *Users name
 *Users class
 *How many days you can miss


 * Start with basic I/O then port to JOption.
 */
package inclass_02_kershawkyler;

import java.util.Scanner;

public class InClass_02_KershawKyler {
    
    public static void main(String[] args) {
        // Veriables
        String userName;
        String className;
        String classNumber;
        String repeatAnswer = "Filler";
        String daysMiss = "0";
        
        Integer daysInClass;
        Double missablePercent;
        
        boolean repeatMenu = true;
        
        // Create scanner object
        Scanner keyboard = new Scanner(System.in);
        
        // While loop to ask user if they want to go again
        while(repeatMenu)
            {
                // Testing the loop
                //System.out.print("In the loop \n");
                

                // Prompt user for their name
                System.out.print("Enter your name: \n");
                userName = keyboard.nextLine();
                
                // Prompt the user for their course number
                System.out.print("Enter your course number: \n");
                classNumber = keyboard.nextLine();
                
                // Prompt user for their class name
                System.out.print("Enter your class name: \n");
                className = keyboard.next();
                
                // Ask the user how many days they're in class
                System.out.print("How many days are you in class: \n");
                daysInClass = Integer.parseInt(keyboard.next());
                
                // Ask the user what the syllabus says in a % they can miss
                System.out.print("Looking at your syllabus, what percentage of class are you allowed to miss? \n");
                System.out.print("Enter 5 for 5%, 10 for 10% and so on: \n");
                missablePercent = Double.parseDouble(keyboard.next());
                
                //Process the missable percent from int to percentage
                missablePercent = (missablePercent/100);
                
                //TODO finish calculation of days they can miss
                
                // Output name. class info, # of days you can miss to user.
                output(userName, classNumber, className, daysMiss);
                
                // TODO Ask user if they want to go again for another class
                repeatMenu = false;
        
            }
        //Out of the while loop.
        //System.out.print("Out  the loop");
        
    }
    
    // Output function to display the data
    public static void output(String userName, String classNumber, String className, String daysMiss){
        //TODO add output
        System.out.print("Name: " + userName + "\n");
        System.out.print("Course Num: " + classNumber + "\n");
        System.out.print("Class Name: " + className + "\n");
        System.out.print("Days you can miss: " + daysMiss + "\n");
    }
    
}
