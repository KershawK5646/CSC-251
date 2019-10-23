/**
 * Name: Kyler Kershaw
 * Start:  08/28/2019
 * Finish: 09/09/2019
 */

/**
 * 
 * This program creates a temperature table Celsius to Fahrenheit
 * Assignment:
 * Convert Fahrenheit to Celsius from freezing to boiling (-32, 212)
 * Convert Celsius to Fahrenheit from freezing to boiling (0, 100)
 * Allow for a user input range of temps
 * Each call in its own method
 * 
 *  TODO:
 *  Link both CTF & FTC together in one file and output it.
*/

package P01_KershawKyler;
// Imports
import java.text.DecimalFormat;
import java.util.Scanner;
import java.io.*;


public class P01_KershawKyler
{
   public static void main(String[] args) throws IOException{
       // Needed Variables
       boolean menuLoop = true;
       Integer userMenuSelection = 0;
       String filename = "null";
       
       // Needed objects
       Scanner kb = new Scanner(System.in);
       
       // Program Start
       
       while(menuLoop == true){
           // Call the menu
           menu();
           userMenuSelection = 0;
           // Loop to validate input
           while(userMenuSelection >5 || userMenuSelection <=0){
               try{
                    userMenuSelection = Integer.parseInt(kb.nextLine());
                    }
                    catch(NumberFormatException e){
                        System.out.print("INVALID ENTRY: Please enter a number \n");
                    }
           }
           
           switch(userMenuSelection){
               case 1:
                   celsiusToFahrenheit();
                   // Ask to run again
                   menuLoop = goAgain();
                   break;
               case 2:
                   fahrenheitToCelsius();
                   menuLoop = goAgain();
                   break;
               case 3:
                   customChoice();
                   menuLoop = goAgain();
                   break;
               case 4:
                   doubleFile();
                   break;
                   
               case 5:
                   System.out.print("Goodbye!");
                   menuLoop = false;
                   
           }
       }
       
      
   }
   
   public static void menu(){
       System.out.print("This program will show and convert a range of "
               + "temperatures in both Fahrenheit and Celsius. \n");
       System.out.print("Please make a selection from the menu below: \n");
       System.out.print("------------------------------\n");
       System.out.print("1. Celsius to Fahrenheit\n"
               + "2. Fahrenheit to Celsius\n"
               + "3. Custom Table \n"
               + "4. Freezing to Boiling, Both"
               + "5. Quit. \n");
   }
   
   
   // goAgain function asks the user if they want to make another calculation
   // and validates that input.
   public static boolean goAgain(){
       boolean goAgain;
       Integer goAgainSelect = 0;
       Scanner kb = new Scanner(System.in);
       
       while (goAgainSelect >2 || goAgainSelect <= 0){
           
           try{
               System.out.print("Would you like to go back to the main menu? \n"
                    + "1. Yes \n"
                    + "2. No \n");
               goAgainSelect = Integer.parseInt(kb.nextLine());
           }
           catch(NumberFormatException e){
               System.out.print("INVALID ENTRY: Please enter 1 for yes "
                       + "or 2 for no. \n");
           }
       }
       
       if (goAgainSelect == 1){ 
           goAgain = true;
           return goAgain;
       }
       else{
           goAgain = false;
           System.out.print("Goodbye \n");
           return goAgain;
       }
   }
   
   // Celsius to Fahrenheit
   public static void celsiusToFahrenheit()throws IOException{
       /* This function calculates temps from celsius to fahrenheit
        * from freezing to boiling.
       */
       
        double fahrenheit;   // The Fahrenheit temperature
        double celsius;      // The Celsius temperature
        String fileName = "null";
        String fileData;
        
        // Create a printwriter object and file.
       fileName = "Celsius to Fahrenheit";
       PrintWriter outFile = new PrintWriter(fileName+".txt");
       
        // Create a DecimalFormat class to format output.
        DecimalFormat fmt = new DecimalFormat(" 0.0");
        // Display the table headings.
        System.out.println("Celsius\t\tFahrenheit");
        System.out.println("------------------------------");
        fileData = "Celsius\t\tFahrenheit\n------------------------------\n";
        // Display the table.
        for (celsius = 0; celsius <= 100; celsius++)
        {
            fahrenheit = (9.0 / 5.0) * celsius + 32;
            System.out.println(fmt.format(celsius) +
                    "\t\t" + 
                    fmt.format(fahrenheit));
            fileData = fileData+fmt.format(celsius) + 
                    "\t\t" + fmt.format(fahrenheit)+"\n";
          }
        outFile.print(fileData);
        // Close the 
        outFile.close();
    }
   
   public static void doubleFile() throws IOException{
       double fahrenheit;   // The Fahrenheit temperature
        double celsius;      // The Celsius temperature
        String fileName;
        String fileData;
        
        // Create a printwriter object and file.
       fileName = "DoubleFile";
       PrintWriter outFile = new PrintWriter(fileName+".txt");
       
        // Create a DecimalFormat class to format output.
        DecimalFormat fmt = new DecimalFormat(" 0.0");
        // Display the table headings.
        System.out.println("Celsius\t\tFahrenheit");
        System.out.println("------------------------------");
        fileData = "Celsius\t\tFahrenheit\n------------------------------\n";
        // Display the table.
        for (celsius = 0; celsius <= 100; celsius++)
        {
            fahrenheit = (9.0 / 5.0) * celsius + 32;
            System.out.println(fmt.format(celsius) +
                    "\t\t" + 
                    fmt.format(fahrenheit));
            fileData = fileData+fmt.format(celsius) + 
                    "\t\t" + fmt.format(fahrenheit)+"\n";
          }          
        // Display the table headings.
        System.out.println("Fahrenheit\t\tCelsius");
        System.out.println("------------------------------");
        fileData = fileData + "Fahrenheit\t\tCelsius\n"
                + "------------------------------\n";

        // Display the table.
        for (fahrenheit = 32; fahrenheit <= 212; fahrenheit++)
        {
            celsius = (fahrenheit - 32)/(9.0/5.0);
            System.out.println(fmt.format(fahrenheit) +
                    "\t\t" + 
                    fmt.format(celsius));
            fileData = fileData + fmt.format(fahrenheit) +
                    "\t\t" + fmt.format(celsius) + "\n";
          }
        outFile.print(fileData);
        // Close the 
        outFile.close();
        
        
   }
   
   // Fahrenheit to Celsius
   public static void fahrenheitToCelsius()throws IOException{
       /* This function calculates temps from fahrenheit to celsius
        * from freezing to boiling.
       */
       
        double fahrenheit;   // The Fahrenheit temperature
        double celsius;      // The Celsius temperature
        String fileName = "null";
        String fileData;
        
        // Create a printwriter object and file.
       fileName = "Fahrenheit to Celsius";
       PrintWriter outFile = new PrintWriter(fileName+".txt");
       
        // Create a DecimalFormat class to format output.
        DecimalFormat fmt = new DecimalFormat(" 0.0");             
        // Display the table headings.
        System.out.println("Fahrenheit\t\tCelsius");
        System.out.println("------------------------------");
        fileData = "Fahrenheit\t\tCelsius\n------------------------------\n";

        // Display the table.
        for (fahrenheit = 32; fahrenheit <= 212; fahrenheit++)
        {
            celsius = (fahrenheit - 32)/(9.0/5.0);
            System.out.println(fmt.format(fahrenheit) +
                    "\t\t" + 
                    fmt.format(celsius));
            fileData = fileData + fmt.format(fahrenheit) +
                    "\t\t" + fmt.format(celsius) + "\n";
          }
        outFile.print(fileData);
        // Close the 
        outFile.close();
   }
   
   // Custom choice
   public static void customChoice()throws IOException{
       // This function calculates temperaturs across a custom range of numbers.
       Integer selection =0;
       
       Scanner kb = new Scanner(System.in);
       
       System.out.print("Custom Temperatures: \n");
       
       while (selection >2 || selection <= 0){
           
           try{
               System.out.print("Please select an option for custom temperatures: \n"
               + "1. Celsius to Fahrenheit \n"
               + "2. Fahrenheit to Celsius \n");
               selection = Integer.parseInt(kb.nextLine());
           }
           catch(NumberFormatException e){
               System.out.print("INVALID ENTRY: Please enter 1 or 2. \n ");
           }
       }
       
       if (selection == 1){
           customCelsiusToFahrenheit();
       }
       else{
           customFahrenheitToCelsius();
       }
       
   }

   // Custom CTF calculation
    private static void customCelsiusToFahrenheit()throws IOException{
        /* This function calculates temps from celsius to fahrenheit
         * Across a custom range.
        */
        Integer userStartRange;
        Integer userEndRange;
        String fileName = "null";
        String fileData;

         // Create a printwriter object and file.
        fileName = getFileNameFromUser();
        PrintWriter outFile = new PrintWriter(fileName+".txt");
        
        Scanner kb = new Scanner(System.in);
       
        double fahrenheit;   // The Fahrenheit temperature
        double celsius;      // The Celsius temperature
        
        userStartRange = getRangeStart();
        userEndRange = getRangeEnd();
        
        while (userStartRange > userEndRange){
            System.out.print("Start of the range cannot be higher than "
                    + "or equal to the end of the range.");
            System.out.print("Enter a new start to your range: \n");
            userStartRange = getRangeStart();
            
            System.out.print("Enter a new end to your range: \n");
            userEndRange = getRangeEnd();
            
        }

        // Create a DecimalFormat class to format output.
        DecimalFormat fmt = new DecimalFormat(" 0.0");             
        // Display the table headings.
        System.out.println("Celsius\t\tFahrenheit");
        System.out.println("------------------------------");
        fileData = "Celsius\t\tFahrenheit\n------------------------------\n";

        // Display the table.
        for (celsius = userStartRange; celsius <= userEndRange; celsius++)
        {
            fahrenheit = (9.0 / 5.0) * celsius + 32;
            System.out.println(fmt.format(celsius) +
                    "\t\t" + 
                    fmt.format(fahrenheit));
            fileData = fileData + fmt.format(celsius) +
                    "\t\t" + fmt.format(fahrenheit)+"\n";
          }
        outFile.print(fileData);
        // Close the 
        outFile.close();
    }
    
    
    // Custom FTC calculation
    private static void customFahrenheitToCelsius()throws IOException {
        /* This function calculates temps from fahrenheit to celsius
         * Across a custom range.
        */
        Integer userStartRange;
        Integer userEndRange;
        String fileName = "null";
        String fileData;

         // Create a printwriter object and file.
        fileName = getFileNameFromUser();
        PrintWriter outFile = new PrintWriter(fileName+".txt");
       
        Scanner kb = new Scanner(System.in);
       
        double fahrenheit;   // The Fahrenheit temperature
        double celsius;      // The Celsius temperature
        
        
        userStartRange = getRangeStart();
        userEndRange = getRangeEnd();
        
        while (userStartRange > userEndRange){
            System.out.print("Start of the range cannot be higher than "
                    + "or equal to the end of the range.");
            userStartRange = getRangeStart();
            userEndRange = getRangeEnd();
            
        }
        
        // Create a DecimalFormat class to format output.
        DecimalFormat fmt = new DecimalFormat(" 0.0");             
        // Display the table headings.
        System.out.println("Fahrenheit\t\tCelsius");
        System.out.println("------------------------------");
        fileData = "Fahrenheit\t\tCelsius\n------------------------------\n";

        // Display the table.
        for (fahrenheit = userStartRange; fahrenheit <= userEndRange; fahrenheit++)
        {
            celsius = (fahrenheit - 32)/(9.0/5.0);
            System.out.println(fmt.format(fahrenheit) +
                    "\t\t" + 
                    fmt.format(celsius));
            fileData = fileData + fmt.format(fahrenheit) +
                    "\t\t" + fmt.format(celsius)+"\n";
          }
        outFile.print(fileData);
        // Close the 
        outFile.close();
    }
    
    // Get start of custom range
    private static Integer getRangeStart(){
        Integer userStartRange;
        Scanner kb = new Scanner(System.in);
        // Get user input for lowest number in range.
        while(1<2){
            try{
                System.out.print("Enter the lowest number in your range: \n");
                userStartRange = Integer.parseInt(kb.nextLine());
                break;
            }
            catch(NumberFormatException e){
                System.out.print("INVALID ENTRY: Please enter a number \n");
            }
            
        }
        return userStartRange;
    }
    
    private static Integer getRangeEnd(){
        Integer userEndRange;
        Scanner kb = new Scanner(System.in);
        // Get user input for highest number in range
        while(1<2){
            try{
                System.out.print("Enter the highest number in your range: \n");
                userEndRange = Integer.parseInt(kb.nextLine());
                break;
            }
            catch(NumberFormatException e){
                System.out.print("INVALID ENTRY: Please enter a number \n");
            }
            
        }
        return userEndRange;
    }
    public static String getFileNameFromUser(){
        String fileName;
        Scanner kb = new Scanner(System.in);
        
        System.out.print("Enter a name for your file: \n");
        fileName = kb.nextLine();
        
        return fileName;
    }

}
