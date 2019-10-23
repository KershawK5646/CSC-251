/*
 * Kyler Kershaw
 * 8/26/2019
 * 8/28/2019
 *
 * Roadmap:
 * Build_1: Basic I/O using console
 *
 * Build_2: Input validation:
 *      Kill null input
 *      Kill letter inputs
 *      Kill out of range input
 *  Build_2: Build menu loop
 *
 * Build_03: Convert to JOptionPane
 */

/*
 * Ask for name
 *Ask for classes (CSC-251) (Class name)
 *Output:
 *Users name
 *Users class
 *How many days you can miss
 *
 * 20% of hours in class
 *
 * Start with basic I/O then port to JOption.
 */
package HW_01_KershawKyler;

import java.util.Scanner;

public class HW_01_KershawKyler {
    
    public static void main(String[] args) {
        // Veriables
        String userName;
        String className;
        String classNumber;
        String repeatAnswer = "Filler";
        Integer totalTimeInClass = 0;
        Integer hoursInClass = 0;
        Integer daysMeet = 0;
        Integer numOfWeeks = 0;
        Double roundedDaysCanMiss = 0.0;
        Double hoursMiss = 0.0;
        Double missablePercent = 0.0;
        Double daysCanMiss = 0.0;
        boolean repeatMenu = true;
        
        // Create scanner object
        Scanner keyboard = new Scanner(System.in);
        
        // While loop to ask user if they want to go again
        while(repeatMenu)
            {
                // Prompt user for their name
                System.out.print("Enter your name: \n");
                userName = keyboard.nextLine();
                
                // Prompt the user for their course number
                System.out.print("Enter your course number: \n");
                classNumber = keyboard.nextLine();
                
                // Prompt user for their class name
                System.out.print("Enter your class name: \n");
                className = keyboard.nextLine();
              
                // Ask the user how many hours they're in class
                while (hoursInClass <= 0 ){
                    try{
                        System.out.print("How many hours at a time does your "
                                + "class meet: \n");
                        System.out.print("Enter a number greater than 0");
                        hoursInClass = Integer.parseInt(keyboard.nextLine());
                        }
                    catch(NumberFormatException e){
                        System.out.print("Please enter a number.");
                    }
                }
                
                // Ask the user how many days they're in class
                while (daysMeet <= 0 ){
                    try{
                        System.out.print("How many days a week does your class "
                                + "meet: \n");
                        System.out.print("Enter a number greater than 0");
                        daysMeet = Integer.parseInt(keyboard.nextLine());
                        }
                    catch(NumberFormatException e){
                        System.out.print("Please enter a number.");
                    }
                }
                
                // Ask the user how many weeks they're in class
                while (numOfWeeks <= 0 ){
                    try{
                        System.out.print("How many weeks does your class "
                                + "meet: \n");
                        System.out.print("Enter a number greater than 0");
                        numOfWeeks = Integer.parseInt(keyboard.nextLine());
                        }
                    catch(NumberFormatException e){
                        System.out.print("Please enter a number.");
                    }
                }
                
                // Calculate the toal hours the user is in class.
                totalTimeInClass = hoursInClass*daysMeet*numOfWeeks;
             
                // Ask the user what the syllabus says in a % they can miss
                System.out.print("Looking at your syllabus, what percentage of "
                        + "class are you allowed to miss? \n");
                System.out.print("Enter 5 for 5%, 10 for 10% and so on: \n");
                
                // Parse input for math use.
                missablePercent = Double.parseDouble(keyboard.nextLine());
                
                // Calculate the number of hours a user can miss
                //// Uses the calulateDaysCanMiss function below.
                hoursMiss = calculateDaysCanMiss(missablePercent,
                        totalTimeInClass);
              
                
                // Calculate the days that can be missed and 
                // round up to the nearest whole day.
                roundedDaysCanMiss = Math.ceil(hoursMiss/hoursInClass);
                System.out.print(roundedDaysCanMiss);
                
                
                // Output name. class info, # of days you can miss to user.
                output(userName, classNumber, className, totalTimeInClass,
                        hoursMiss, roundedDaysCanMiss);
                
                // TODO Ask user if they want to go again for another class
                repeatMenu = false;
        
            }
        //Out of the while loop.
        
    }
    
    // This function displays the user input and calulated data to the user.
    public static void output(String userName, String classNumber, 
            String className, Integer timeInClass, Double hoursMiss,
            Double daysCanMiss){
        System.out.print("Name: " + userName + "\n");
        System.out.print("Course Num: " + classNumber + "\n");
        System.out.print("Class Name: " + className + "\n");
        System.out.print("Hours in class: " + timeInClass + "\n");
        System.out.print("Hours you can miss: " + hoursMiss + "\n");
        System.out.print("Days you can miss: " + daysCanMiss + "\n");
    }
    
    
    // This function uses the user entered variables to find the number of hours
    // they are permitted to miss.
    public static Double calculateDaysCanMiss(Double missablePercent,
             Integer totalTimeInClass){
        Double hoursMiss;
        
        //Process the missable percent from int to percentage
        missablePercent = (missablePercent/100);
        //TODO finish calculation of days they can miss
        hoursMiss = totalTimeInClass * missablePercent;
        return hoursMiss;
    }
    
}
