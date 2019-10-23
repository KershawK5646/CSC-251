/* Homework 2 Kyler Kershaw
 * 09/09/2019
 * Create a program that uses a switch to call different functions
 * that demonstrate how a loop works.
 */

/* Menu displays 1, 2, 3, 4
 * Get user input and use that to select switch of the following:
 * 
 * Selection 1, While loop
 * Selection 2, Do while loop
 * Selection 3, For loop
 * Selection 4, Exit the program
*/
package hw_02_kershawkyler;
import javax.swing.JOptionPane;
import java.util.Scanner;

public class HW_02_KershawKyler {
    
    public static void switchFunction(Integer menuSelection){
        // This function takes an integer and uses it to select
        // which function the user wants to run.
        
        switch(menuSelection){
            case 1: whileLoop();
                    break;
            
            case 2: doWhileLoop();
                    break;
            
            case 3: forLoop();
                    break;
        }
    }
    
    public static boolean goAgain(){
        // This function will as the user if they want to use the program again.
        Integer userGoAgainInput = 0;
        Boolean goAgain;
        String questionString;
        
        
        // Ask the user if they want to repeat and get proper input
        while (userGoAgainInput <=0 || userGoAgainInput >2){
            questionString = "Would you like to repeat the program? \n"
                    + "1. Yes \n2. No";
            userGoAgainInput = getNumberFromUser(questionString);
        }
        // Assign their input to the proper selection.
        if (userGoAgainInput == 1){
            goAgain = true;
        }
        else{
            goAgain = false;
        }
        // Return the bool selection.
        return goAgain;
    }
    
    public static Integer getNumberFromUser(String questionString){
        // This function will prompt the user for input and convert it 
        // to an Integer. It will also validate the input to make sure it is a
        // number.
        
        // Variables
        Integer userSelection;
        Scanner keyboard = new Scanner(System.in);
        
        while (true){
            try{
                userSelection = Integer.parseInt(JOptionPane.showInputDialog(
                        questionString));
                break;
            }
            catch(NumberFormatException e){
                JOptionPane.showMessageDialog(null, "Invalid input. \n");
            }
        }
        
        return userSelection;
        
    }
    
    public static void whileLoop(){
        // The while loop demo goes here
        Integer counter = 1;
        Integer userController = 1;
        String questionString;
        
        while (userController == 1){
            questionString = "WHILE LOOP\n"
                    + "Loop number: " + counter +" \nWould you like to "
                    + "loop again?\n1. Yes\n2. No";
            userController = getNumberFromUser(questionString);
            while (userController > 2 || userController < 1){
                JOptionPane.showMessageDialog(null, "Entry out of range. "
                        + "\nPlease enter either 1 for"
                        + " yes or 2 for no.\n");
                questionString = "Would you like to loop again?\n1. Yes\n2. "
                        + "No\n";
                userController = getNumberFromUser(questionString);
            }
            counter = counter + 1;
        }
    }
    
    public static void doWhileLoop(){
        // The while loop demo goes here
        Integer counter = 1;
        Integer userController = 1;
        String questionString;
        
        do {
            questionString = "DO WHILE LOOP\n"
                    + "Number of Loops: " + counter + "\nWould you like "
                    + "to loop again?\n1. Yes\n2. No\n";
            userController = getNumberFromUser(questionString);
            counter = counter + 1;
            while (userController > 2 || userController < 1){
                JOptionPane.showMessageDialog(null, "Entry out of range. "
                        + "\nPlease enter either 1 for"
                        + " yes or 2 for no.\n");
                questionString = "Would you like to loop again?\n1. Yes\n2. "
                        + "No\n";
                userController = getNumberFromUser(questionString);
            }
        } while (userController == 1);
    }
    
    public static void forLoop(){
        // For loop demo goes here
        Integer numberOfLoops =0;
        Integer counter;
        String questionString;
        
        
        // Get input from user and validate.
        while (numberOfLoops <= 0){
            // Get user input for number of loops.
            questionString = "FOR LOOP\n"
                    + "Enter a number of times you want the loop "
                    + "to run: ";
            numberOfLoops = getNumberFromUser(questionString);
        }
        
        // For loop using user input as controller
        for (counter=1; counter<numberOfLoops+1; counter++){
            JOptionPane.showMessageDialog(null,"\nCurrent count value: "
                    + counter);
        }
    }
    
    public static void main(String[] args) {
        // Variables
        Integer menuSelection=0;
        Boolean goAgainBool = true;
        String questionString;
        
        while (goAgainBool == true){
            // Call the menu.
            questionString = "This program will run through a "
                + "series of different loops. "
                + "\nPlease select which loop you'd like to use: \n"
                + "1. While loop \n"
                + "2. Do while loop\n"
                + "3. For loop\n" ;
            // Get the users selection.
            menuSelection = 0;
            while(menuSelection >3 || menuSelection <1){
                menuSelection = getNumberFromUser(questionString);
            }
            // Pass selection to switch.
            switchFunction(menuSelection);
            
            // Ask if the user wants to go again.
            goAgainBool = goAgain();
        }
    }
}
