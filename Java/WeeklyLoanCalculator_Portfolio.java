/* 
---Alexsandria Ryan
---Assignment #1, Program 3 of 3
---Submitted: February 14, 2022
---Grade received: 100%

---Assignment description:
Develop a short-term loan calculator program as a console application with the 
following specifications. 
Begin by designing your solution to this problem in pseudocode, which will be 
submitted along with the program.

If A dollars are borrowed at r% interest compounded weekly to purchase something 
with weekly payments for n years, 
then the weekly payment is given by the formula: i = r/5200

Then calculate the weekly payment as:
weekly payment  = (i / 1-(1+i)^-52n) * A

Write a console application that calculates the weekly payment after the user 
gives the amount of the loan, interest rate, and the number of years.
*/

import java.util.Scanner;
import java.text.NumberFormat;
import java.util.Locale;

public class WeeklyLoanCalculator_Portfolio{
    public static void main(String []args) {
        //declarations
        double loan;
        double rate;
        int years;
        int weeks = 52;
        double compound;
        double weeklyPayment;

        Scanner sc= new Scanner(System.in);
        NumberFormat cad = NumberFormat.getCurrencyInstance(Locale.CANADA);

        System.out.println("Weekly Loan Calculator");
        System.out.println("");

        //input
        System.out.print("Enter the amount of the loan: ");
        loan = sc.nextDouble();

        System.out.print("Enter the interest rate (%): ");
        rate = sc.nextDouble();
        
        System.out.print("Enter the number of years: ");
        years = sc.nextInt();

        //pre-calculations
        rate = Math.round(rate*1e2)/1e2;
        compound = rate / 5200;

        //find weekly payment
        weeklyPayment = (compound / (1 - Math.pow((1 + compound), (-weeks * years)))) * loan;

        //output
        System.out.println("");
        System.out.println("Your weekly payment will be: " + (cad.format(weeklyPayment)));
    }
}