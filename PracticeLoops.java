/**
 * Name: Jack Allen (allen)
 * Course: CSCI 241 - Computer Science I
 * Section: 002
 * Assignment: 5
 *
 * Project/Class Description:
 * This project serves to practice each of the 3 loops: the do-while loop, for loop, and while loop, in 
 * various examples. It also serves to practice formatting text/numbers/strings using the "printf" statement.
 * Each section is broken up into its own method so that each section can be called individually, but the main
 * method will run them all sequentially.  
 *
 * Known bugs:
 * (none, but I ran into problems with the tab spacing being inconsistent when using \t in the printf 
 * statements, so in some places I replaced the flags with %-(number)s and added an empty string in the 
 * arguments so that the spacing would match the examples' spacing.)
 */

import java.util.*;

public class PracticeLoops
{
    // Note: I split each section into its own method so that I could run each section separately

    public static void sectionA() {
        // Info card for Section A
        System.out.printf("%-10s------ Section A ------%n","");
        System.out.printf("(do-while) User enters a number between 2 and 10, inclusive.%n");
        System.out.printf("(while) Loop runs to place that many spaces between \"Hello\" and \"Goodbye\".%n");
        System.out.printf("(for) Loop runs to find that number's factorial value.%n");
        System.out.printf("========================================================================%n");

        // Loop practice for Section A
        Scanner input = new Scanner(System.in); // Declares scanner variable 'input'
        int num = 0; // Initializes 'num' to later be used as the user's inputted integer
        do {
            System.out.printf("Enter a number to use for factorial: ");
            num = input.nextInt();
            if(num < 2 || num > 10)
                System.out.printf("Error: factorial number must be between 2 and 10, inclusive.%n");
        } while(num < 2 || num > 10);

        // Puts the (valid) inputted number of spaces in between 'Hello' and 'Goodbye'
        System.out.printf("Hello");
        int temp = num; // Stores the value of 'num' in temp so that the value of 'num' isn't changed
        while(temp > 0){
            System.out.printf(" ");
            temp--;
        }
        System.out.printf("Goodbye%n");

        // Calculates the factorial of the (valid) inputted number and prints it out
        int factorial = 1;
        for(int i = 1; i <= num; i++) {
            factorial *= i;
        }
        System.out.printf(" %d! = %,d%n________________________________________________________________________%n", num,factorial);
    }

    public static void sectionB() {
        // Info card for Section B
        System.out.printf("%-10s------ Section B ------%n","");
        System.out.printf("(while) Loop prints powers of 2 between 1 and 50, inclusive.%n");
        System.out.printf("========================================================================%n");

        // Prints each power of two from 0 to 50 (inclusive)
        long power = 0; // Initializes 'power'; has to be long since 2^50 is over the max int-value 
        while(power <= 50) {
            System.out.printf("2 to the %d power = %d%n", power, (long) Math.pow(2.0, power * 1.0));
            power++;
        }
        System.out.printf("________________________________________________________________________%n");
    }

    public static void sectionC() {
        //Info card for Section C
        System.out.printf("%-10s------ Section C ------%n","");
        System.out.printf("(do-while) User enters number (n): must be multiple of 3, between 3 and 24.%n");
        System.out.printf("(for) Loop prints values n->0, separated by tabs, by 3's.%n");
        System.out.printf("========================================================================%n");

        Scanner input = new Scanner (System.in);
        int num = 0;
        // Asks the user to input a multiple of 3 that's between 3 and 24 and iterates until they do
        do {
            System.out.printf("Enter a multiple of 3: ");
            num = input.nextInt();
            if(num % 3 != 0 || (num < 3 || num > 24))
                System.out.printf("Error: Enter a multiple of 3 between 3 and 24, inclusive.%n");
            else
                break;
        } while(true);
        
        // Prints each multiple of 3 that's less than the inputted number
        for(int i = num; i >= 0; i-=3){
            System.out.printf("%d    ",num);
            num -= 3;
        }
        
        // Closes the section's output with underscores
        System.out.printf("%n________________________________________________________________________%n");
    }

    public static void sectionD() {
        //Info card for Section D
        System.out.printf("%-10s------ Section D ------%n","");
        System.out.printf("(for) Loop shows range of dinner prices from $10.00-> $15.00%n");
        System.out.println("and using .75 increments, calculates 20% tip, total, and prints a table.");
        System.out.printf("========================================================================%n");

        // Table Setup
        System.out.println("  Dinner Price\t\t20% tip\t\tTotal");
        System.out.printf("----------------------------------------------------%n");

        // This loop calculates the data and formats it to be in the table evenly
        for(double price = 10.00; price <= 15.00; price +=0.75) {
            double tip = 0.20 * price;
            System.out.printf("%-5s $%.2f %-10s $%5.2f %-10s $%.2f%n","",price,"",tip,"",price + tip);
        }

        // Closes section with underscores
        System.out.printf("________________________________________________________________________%n");
    }

    public static void sectionE() {
        //Info card for Section E
        System.out.printf("%-10s------ Section E ------%n","");
        System.out.printf("2 different sums will be calculated.%n");
        System.out.printf("(while) Loop: User enters unknown number of integer numbers.%n");
        System.out.printf("First value will be added to sum#1, second value added to sum #2.%n");
        System.out.printf("Actions will be repeated as long as user enters positive numbers.%n");
        System.out.printf("========================================================================%n");

        // Initalizes a scanner 'input'
        Scanner input = new Scanner(System.in);
        // Variables used in the loop
        int num = 1; // Initalized to 1 to let the loop run at least once
        int sum1 = 0; // Sum of only the first inputted numbers
        int sum2 = 0; // Sum of only the second inputted numbers

        // Asks the user for input until they enter a non-integer and/or negative number
        while(num > 0) {
            System.out.printf("Enter a number to add to first sum: ");
            num = input.nextInt();
            sum1 += num;
            if(num == 0) // This is added to make the loop end when the first number is zero, but still use 1 loop
                break;
            System.out.printf("Enter a number to add to second sum: ");
            num = input.nextInt();
            sum2 += num;
        }

        // Outputs the formatted sums and adds underscores to end the section
        System.out.printf("%nFirst Sum: %d%-11s Second Sum: %d%n",sum1,"",sum2);
        System.out.printf("________________________________________________________________________");
    }

    public static void main(String [] args) {
        // The main method will run all parts of the program in order
        sectionA();
        sectionB();
        sectionC();
        sectionD();
        sectionE();
    }
}
