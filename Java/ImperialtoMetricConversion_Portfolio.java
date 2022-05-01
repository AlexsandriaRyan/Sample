/* 
---Alexsandria Ryan
---Assignment #1, Program 3 of 3
---Submitted: February 14, 2022
---Grade received: 100%

---Assignment description:
Write a console program that converts a weight given in tons (imperial), stones, 
pounds, and ounces to the metric 
equivalent in metric tons, kilograms, and grams. After the numbers of tons, stones, 
pounds, and ounces are input by the user:
- the weight should be converted entirely into ounces (the lowest common denominator)
- then divided by 35.274 to obtain the value in kilos.
- The total number of kilos into a whole number of metric tons and kilos.
- The number of grams should be displayed to one decimal place.

Required formulas:
- total ounces = 35840 * tons + 224 * stone + 16 * pounds + ounces
- total kilos = total ounces / 35.274
- metric tons = (kilos/1000)
*/

import java.util.Scanner;

public class ImperialtoMetricConversion_Portfolio{
    public static void main(String []args) {
        //declarations
        double tons;
        double stone;
        double pounds;
        double ounces;
        double totalOunces;
        double metricTons;
        double wholeMetricTons;
        double kilos;
        double wholeKilos;
        double grams;

        Scanner sc= new Scanner(System.in);

        System.out.println("Imperial To Metric Conversion");
        System.out.println("");

        //input
        System.out.print("Enter the number of tons: ");
        tons = sc.nextDouble();
 
        System.out.print("Enter the number of stone: ");
        stone = sc.nextDouble();
         
        System.out.print("Enter the number of pounds: ");
        pounds = sc.nextInt();

        System.out.print("Enter the number of ounces: ");
        ounces = sc.nextInt();

        //calculations
        totalOunces = (35840 * tons) + (224 * stone) + (16 * pounds) + ounces;
        kilos = totalOunces / 35.274;
        metricTons = kilos/1000;
        wholeMetricTons = Math.floor(metricTons);
        kilos = (metricTons - wholeMetricTons) * 1000;
        wholeKilos = Math.floor(kilos);
        grams = (kilos - wholeKilos) * 1000;

        //output
        System.out.println("");
        System.out.printf("The metric weight is %.0f metric tons, %.0f kilos, and %.1f grams.", (Math.floor(metricTons)), (Math.floor(kilos)), grams);
    }
}