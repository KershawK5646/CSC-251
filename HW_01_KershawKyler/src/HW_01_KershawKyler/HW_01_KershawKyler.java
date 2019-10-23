/*
 * Kyler Kershaw
 * Start: 8/26/2019
 * Finished: 9/16/2019
 */

/*
 * This program will ask the user for input about their schedule
 * and calculate how many hours and days they can miss while still
 * passing the class.
 */
package HW_01_KershawKyler;

import javax.swing.JOptionPane;

public class HW_01_KershawKyler {
    
    public static void main(String[] args) {
        // Veriables
        String userName;
        String className;
        String classNumber;
        String repeatAnswer = "Filler";
        Integer totalTimeInClass;
        Integer hoursInClass;
        Integer daysMeet;
        Integer numOfWeeks;
        Integer menuController;
        Double roundedDaysCanMiss;
        Double hoursMiss;
        Double missablePercent;
        Double daysCanMiss;
        boolean repeatMenu = true;
        
        
        //TODO: Introduce the program
        JOptionPane.showMessageDialog(null, "This program will "
                + "calculate how many days you can miss for a given class");
        
        // Prompt user for their name
        userName = JOptionPane.showInputDialog("Enter your name: ");
        
        // While loop to ask user if they want to go again
        while(repeatMenu == true){
                // Initialize all values for each run through the loop
                totalTimeInClass = 0;
                hoursInClass = 0;
                daysMeet = 0;
                numOfWeeks = 0;
                menuController = 0;
                roundedDaysCanMiss=0.0;
                hoursMiss=0.0;
                missablePercent =0.0;
                daysCanMiss =0.0;
                
                // Prompt the user for their course number
                classNumber = JOptionPane.showInputDialog("Enter your course "
                        + "number:");
                
                // Prompt user for their class name
                className = JOptionPane.showInputDialog("Enter your class "
                        + "name:");
              
                // Ask the user how many hours they're in class
                
                while (hoursInClass <= 0 ){
                    try{
                        hoursInClass = Integer.parseInt(JOptionPane.showInputDialog(""
                                + "How many hours at a time does your " 
                                + "class meet: Enter a number greater than "
                                + "0."));
                        }
                    catch(NumberFormatException e){
                        JOptionPane.showMessageDialog(null, "INVALID ENTRY: "
                                + "Please enter a number!");
                    }
                }
                
                // Ask the user how many days they're in class
                while (daysMeet <= 0 ){
                    try{
                        daysMeet = Integer.parseInt(JOptionPane.showInputDialog(""
                                + "How many days a week does your class " 
                                + "meet: Enter a number greater than 0."));
                        }
                    catch(NumberFormatException e){
                        JOptionPane.showMessageDialog(null, "INVALID ENTRY: "
                                + "Please enter a number!");
                    }
                }
                
                // Ask the user how many weeks they're in class
                while (numOfWeeks <= 0 ){
                    try{
                        numOfWeeks = Integer.parseInt(JOptionPane.showInputDialog(""
                                + "How many weeks does "
                                + "your class " 
                                + "meet: Enter a number greater than 0."));
                        }
                    catch(NumberFormatException e){
                        JOptionPane.showMessageDialog(null, "INVALID ENTRY: "
                                + "Please enter a number!");
                    }
                }
                
                // Calculate the toal hours the user is in class.
                totalTimeInClass = hoursInClass*daysMeet*numOfWeeks;
                
             
                // Ask the user what the syllabus says in a % they can miss
                while (missablePercent <= 0 ){
                    try{
                        missablePercent = Double.parseDouble(JOptionPane.showInputDialog(""
                                + "Looking at your syllabus, "
                                + "what percentage of "
                                + "class are you allowed to miss? Enter 5 "
                                + "for 5%, 10 for 10% and so on:"));
                        }
                    catch(NumberFormatException e){
                        JOptionPane.showMessageDialog(null, "INVALID ENTRY: "
                                + "Please enter a number!");
                    }
                }
               
                
                // Calculate the number of hours a user can miss
                //// Uses the calulateDaysCanMiss function below.
                hoursMiss = calculateDaysCanMiss(missablePercent,
                        totalTimeInClass);
              
                
                // Calculate the days that can be missed and 
                // round up to the nearest whole day.
                roundedDaysCanMiss = Math.ceil(hoursMiss/hoursInClass);
                
                
                // Output name. class info, # of days you can miss to user.
                output(userName, classNumber, className, totalTimeInClass,
                        hoursMiss, roundedDaysCanMiss);
                
                // WorkZone
                while (menuController <= 0 ){
                    try{
                        menuController = Integer.parseInt(JOptionPane.showInputDialog(""
                                + "Would you like to enter another class? "
                                + "Enter 1 for yes or 2 to exit the program:"));
                        
                        if(menuController == 1){
                            repeatMenu = true;}
                        
                        else if(menuController >= 3){
                            JOptionPane.showMessageDialog(null, "INVALID ENTRY: "
                                    + "Please enter either 1 for yes "
                                    + "or 2 for no.");
                            menuController = 0;}
                        
                        else{
                            JOptionPane.showMessageDialog(null, "\nGoodbye!");
                            repeatMenu = false;}
                        }
                    catch(NumberFormatException e){
                        JOptionPane.showMessageDialog(null, "INVALID ENTRY: "
                                + "Please enter a number!");
                    }
                    
                }
            }
        //Out of the while loop.
        
    }
    
    // This function displays the user input and calulated data to the user.
    public static void output(String userName, String classNumber, 
            String className, Integer timeInClass, Double hoursMiss,
            Double daysCanMiss){
        
        JOptionPane.showMessageDialog(null, ""
                + "Name: " + userName + "\n"
                + "Class Name: " + className + "\n"
                + "Hours in class: " + timeInClass + "\n"
                + "Hours you can miss: " + hoursMiss + "\n"
                + "Days you can miss: " + daysCanMiss);
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
