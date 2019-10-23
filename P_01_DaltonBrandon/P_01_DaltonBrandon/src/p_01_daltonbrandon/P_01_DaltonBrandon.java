/* Brandon Dalton
 * 8/28/2019
 * This program creates a temperature table Celsius to Fahrenheit
 * (Copy of CelsiusFahrenheitFahrenheitCelsius)
*/
package p_01_daltonbrandon;
import javax.swing.JOptionPane;
import java.text.DecimalFormat;
import java.io.*;
public class P_01_DaltonBrandon
{   
   public static void main(String[] args) throws IOException
   {
       int choice;
       helloMessage();
       do
       {
       choice = getOption();
       switch (choice)
       {
           case 0:
               celsiusToFahrenheit();
               break;
           case 1:
               fahrenheitToCelsius();
               break;
           case 2:
               celsiusToFahrenheitRange();
               break;
           case 3:
               fahrenheitToCelsiusRange();
               break;
           case 4:
               celsiusToFahrenheitAndFahrenheitToCelsius();
               break;           
       }
       }while(choice!=5);
   }
   public static void helloMessage()
   {
       String name;
       name = JOptionPane.showInputDialog("What is your name? ");
       JOptionPane.showMessageDialog(null, "Welcome "+name+" this program will"
               + " convert Celsius to Farhenheit and vice versa.");
       
   }
   public static int getOption()
   {
       String[] options = {"0-100 C° to F°", "32-212 F° to C°", "Specific C° to F°", 
           "Specific F° to C°", "0-100 C° to F° & 32-212 F° to C°","Exit Program"};
       int choice = JOptionPane.showOptionDialog(null, "Please choose an "
               + "option for your temperature.", "Choose an option", 
               JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, 
               null, options, options[0]);

       return choice;
   }
   public static void celsiusToFahrenheit() throws IOException
   {
      double fahrenheit;   // The Fahrenheit temperature
      double celsius;      // The Celsius temperature
      String fileName;
      // Create a DecimalFormat class to format output.
      DecimalFormat fmt = new DecimalFormat(" 0.0");
      fileName=JOptionPane.showInputDialog("Your output will be written to a"
              + " file.\nWhat would you like to name it?");       
      // Display the table headings.
      System.out.println("Celsius\t\tFahrenheit");
      System.out.println("------------------------------");
      PrintWriter outputfile = new PrintWriter(fileName+".txt");
      outputfile.println("Celsius\t\tFahrenheit");
      outputfile.println("------------------------------");
      outputfile.close();
      // Display the table.
      for (celsius = 0; celsius <= 100; celsius++)
      {
         fahrenheit = (9.0 / 5.0) * celsius + 32;
         System.out.println(fmt.format(celsius) +
                            "\t\t" + 
                            fmt.format(fahrenheit));
         FileWriter fwriter = new FileWriter (fileName+".txt",true);
         PrintWriter apendFile = new PrintWriter(fwriter);
         apendFile.println(fmt.format(celsius) +
                            "\t\t" + 
                            fmt.format(fahrenheit));
         apendFile.close();
      }      
      
   }
   public static void fahrenheitToCelsius() throws IOException
   {
      double fahrenheit;   // The Fahrenheit temperature
      double celsius;      // The Celsius temperature
      String fileName;
      // Create a DecimalFormat class to format output.
      DecimalFormat fmt = new DecimalFormat(" 0.0");
      fileName=JOptionPane.showInputDialog("Your output will be written to a"
              + " file.\nWhat would you like to name it?");       
      // Display the table headings.
      System.out.println("Fahrenheit\t\tCelsius");
      System.out.println("----------------------------------");
      PrintWriter outputfile = new PrintWriter(fileName+".txt");
      outputfile.println("Fahrenheit\t\tCelsius");
      outputfile.println("----------------------------------");
      outputfile.close();
      // Display the table.
      for (fahrenheit = 32; fahrenheit <= 212; fahrenheit++)
      {
         celsius = (5.0/9.0)*(fahrenheit-32);
         System.out.println(fmt.format(fahrenheit) +
                            "\t\t\t" + 
                            fmt.format(celsius));
         FileWriter fwriter = new FileWriter (fileName+".txt",true);
         PrintWriter apendFile = new PrintWriter(fwriter);
         apendFile.println(fmt.format(fahrenheit) +
                            "\t\t\t" + 
                            fmt.format(celsius));
         apendFile.close();
      }       
   }
   public static void celsiusToFahrenheitRange() throws IOException
   {
      String input=null,fileName;              // Holds input to be parsed
      double fahrenheit;         // The Fahrenheit temperature
      double celsius;            // The Celsius temperature
      double celsiusStartRange=0;  // The Celsius start range
      double celsiusEndRange=0;    //The Celsius end range
            
      // Create a DecimalFormat class to format output
      DecimalFormat fmt = new DecimalFormat("0.0");
      fileName=JOptionPane.showInputDialog("Your output will be written to a"
              + " file.\nWhat would you like to name it?");
      
      // Grab user input for the range of temperature
      // Input validation to make sure a number was entered
      while(input==null)
      {
      try
      {
      input = JOptionPane.showInputDialog("Enter your starting temperature for"
              + " the range: ");
      celsiusStartRange = Double.parseDouble(input);      
      }
      catch (NumberFormatException e)
      {
          JOptionPane.showMessageDialog(null, "Error! Please enter a number.");
          input=null;
      }
      }      
      
      // Grab user input for the end range of temperature
      // Input validation to make sure a number was enetered
      input=null;
      while(input==null)
      {
      try
      {
      input = JOptionPane.showInputDialog("Enter your ending temperature for"
              + " the range: ");
      celsiusEndRange = Double.parseDouble(input);
      }
      catch (NumberFormatException e)
      {
          JOptionPane.showMessageDialog(null, "Error! Please enter a number.");
          input=null;
      }
      }      
      // Display the table headings
      System.out.println("================================================="
              + "====");
      System.out.println("Starting temperature: "+celsiusStartRange+"\t"
              + "Ending Range: "+celsiusEndRange);
      System.out.println("================================================="
              + "====");
      System.out.println("Celsius\t\tFahrenheit");
      System.out.println("------------------------------");
      PrintWriter outputfile = new PrintWriter(fileName+".txt");
      outputfile.println("================================================="
              + "====");
      outputfile.println("Starting temperature: "+celsiusStartRange+"\tEnding"
              + " Range: "+celsiusEndRange);
      outputfile.println("=================================================="
              + "===");
      outputfile.println("Celsius\t\tFahrenheit");
      outputfile.println("------------------------------");
      outputfile.close();
      
      // Display the table
      for (celsius=celsiusStartRange;celsius<=celsiusEndRange;celsius++)
      {
         fahrenheit = (9.0 / 5.0) * celsius + 32;
         System.out.println(fmt.format(celsius) +
                            "\t\t" +
                            fmt.format(fahrenheit));
         FileWriter fwriter = new FileWriter(fileName+".txt",true);
         PrintWriter apendFile = new PrintWriter(fwriter);
         apendFile.println(fmt.format(celsius) +
                            "\t\t" +
                            fmt.format(fahrenheit));
         apendFile.close();
         
      }
      
   }
   public static void fahrenheitToCelsiusRange() throws IOException
   {
      String input=null,fileName;                 // Holds input to be parsed
      double fahrenheit;            // The Fahrenheit temperature
      double celsius;               // The Celsius temperature
      double fahrenheitStartRange=0;  // The Celsius start range
      double fahrenheitEndRange=0;    //The Celsius end range
      
      
      // Create a DecimalFormat class to format output
      DecimalFormat fmt = new DecimalFormat("0.0");
      fileName=JOptionPane.showInputDialog("Your output will be written to a"
              + " file.\nWhat would you like to name it?");
      
      // Grab user input for the range of temperature
      // Input validation to make sure a number was entered
      while(input==null)
      {
      try
      {
      input = JOptionPane.showInputDialog("Enter your starting temperature for"
              + " the range: ");
      fahrenheitStartRange = Double.parseDouble(input);
      }
      catch (NumberFormatException e)
      {
          JOptionPane.showMessageDialog(null, "Error! Please enter a number.");
          input=null;
      }
      }
      
      // Grab user input for the end range of temperature
      // Input validation to make sure a number was entered
       input=null;
      while(input==null)
      {
      try
      {
      input = JOptionPane.showInputDialog("Enter your ending temperature for"
              + " the range: ");
      fahrenheitEndRange = Double.parseDouble(input);
      }
      catch (NumberFormatException e)
      {
          JOptionPane.showMessageDialog(null, "Error! Please enter a number.");
          input=null;
      }
      }
      
      
      // Display the table headings.
       System.out.println("================================================"
               + "=====");
       System.out.println("Starting temperature: "+fahrenheitStartRange+"\t"
               + "Ending temperature: "+fahrenheitEndRange);
       System.out.println("================================================"
               + "=====");
       System.out.println("Fahrenheit\t\tCelsius");
       System.out.println("----------------------------------");
       PrintWriter outputfile = new PrintWriter(fileName+".txt");
       outputfile.println("================================================"
               + "=====");
       outputfile.println("Starting temperature: "+fahrenheitStartRange+"\t"
               + "Ending temperature: "+fahrenheitEndRange);
       outputfile.println("================================================"
               + "=====");
       outputfile.println("Fahrenheit\t\tCelsius");
       outputfile.println("----------------------------------");
       outputfile.close();
      
      // Display the table.
      for (fahrenheit = fahrenheitStartRange; fahrenheit <= fahrenheitEndRange;
              fahrenheit++)
      {
         celsius = (5.0/9.0)*(fahrenheit-32);
         System.out.println(fmt.format(fahrenheit) +
                            "\t\t\t" + 
                            fmt.format(celsius));
         FileWriter fwriter = new FileWriter(fileName+".txt",true);
         PrintWriter apendFile = new PrintWriter(fwriter);
          apendFile.println(fmt.format(fahrenheit) +
                  "\t\t\t" +
                  fmt.format(celsius));
          apendFile.close();
      }
   }
   public static void celsiusToFahrenheitAndFahrenheitToCelsius() throws 
        IOException
   {
   double fahrenheit;   // The Fahrenheit temperature
      double celsius;      // The Celsius temperature
      String fileName;
      // Create a DecimalFormat class to format output.
      DecimalFormat fmt = new DecimalFormat(" 0.0");
      fileName=JOptionPane.showInputDialog("Your output will be written to a"
              + " file.\nWhat would you like to name it?");       
      // Display the table headings.
      System.out.println("Celsius\t\tFahrenheit");
      System.out.println("------------------------------");
      PrintWriter outputfile = new PrintWriter(fileName+".txt");
      outputfile.println("Celsius\t\tFahrenheit");
      outputfile.println("------------------------------");
      outputfile.close();
      // Display the table.
      for (celsius = 0; celsius <= 100; celsius++)
      {
         fahrenheit = (9.0 / 5.0) * celsius + 32;
         System.out.println(fmt.format(celsius) +
                            "\t\t" + 
                            fmt.format(fahrenheit));
         FileWriter fwriter = new FileWriter (fileName+".txt",true);
         PrintWriter apendFile = new PrintWriter(fwriter);
         apendFile.println(fmt.format(celsius) +
                            "\t\t" + 
                            fmt.format(fahrenheit));
         apendFile.close();
      }
      System.out.println("Fahrenheit\t\tCelsius");
      System.out.println("----------------------------------");
      FileWriter fwriter = new FileWriter (fileName+".txt",true);
      PrintWriter apendFile = new PrintWriter(fwriter);      
      apendFile.println("Fahrenheit\t\tCelsius");
      apendFile.println("----------------------------------");
      apendFile.close();
      // Display the table.
      for (fahrenheit = 32; fahrenheit <= 212; fahrenheit++)
      {
         celsius = (5.0/9.0)*(fahrenheit-32);
         System.out.println(fmt.format(fahrenheit) +
                            "\t\t\t" + 
                            fmt.format(celsius));
         FileWriter fwriter2 = new FileWriter (fileName+".txt",true);
         PrintWriter apendFile2 = new PrintWriter(fwriter2);
         apendFile2.println(fmt.format(fahrenheit) +
                            "\t\t\t" + 
                            fmt.format(celsius));
         apendFile2.close();
      }
}
   
}
