/*
* Nicholas Krzysiak
* SP24-CPSC-24500-001
* 02/10/2024
*
* The following program takes the name and income of the user
* and calculates the income tax they need to pay based on
* a set of parameters given in the instructions
*
* a.	An employee has J$4000 of salary tax-free.
    b.	The next J$1500 is taxed at 10%.
    c.	The next J$28000 after that is taxed at 20%.
    d.	Any further amount is taxed at 40%.
*
 */



import java.util.Scanner;

public class TaxCalc {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter you name: ");
        String name = scan.nextLine();
        System.out.print("Enter your income: ");
        double income = scan.nextDouble();

// Displays error code if user input is invalid (not zero or pos num)
        if (income < 0) {
            System.out.println("Invalid input, income should be zero or more");
            return;
        }


        double tax = calculateTax(income);

        //Displays final output
        System.out.println("Name: " + name);
        System.out.println("Income: J$" + income);
        System.out.println("Income Tax: J$" + tax);
    }


    //This method calculates the income tax, each if statement represents one of the increasing tax percentages
    public static double calculateTax(double income) {
        double tax = 0;

        if (income > 4000) {
            tax += (Math.min(income, 5500) - 4000) * 0.1;
        }
        if (income > 5500) {
            tax += (Math.min(income, 33500) - 5500) * 0.2;
        }
        if (income > 33500) {
            tax += (income - 33500) * 0.4;
        }
        return tax;


    }
}