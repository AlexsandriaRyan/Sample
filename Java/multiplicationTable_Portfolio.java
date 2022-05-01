/* 
---Alexsandria Ryan
---Mini Assignment #4 Part 3
---Submitted: March 14, 2022
---Grade received: 100%

---Assignment description:
Create a multiplication table with a 2D array.
Must be sized by user input.
Skip 0.
First row and column should be labels.
*/

import java.util.Scanner;

public class multiplicationTable_Portfolio {
    
    public static void main(String[] args){

        int row;
        int column;
        Scanner scan = new Scanner(System.in);

        System.out.println("How many rows would you like in the multiplication chart?");
        row = scan.nextInt();

        System.out.println("\nHow many columns would you like in the multiplication chart?");
        column = scan.nextInt();

        System.out.println("\n----- Your " + row + " x " + column + " Multiplication Table -----");
        System.out.println();

        int[][] table = new int[row+1][column+1];

        for (int i = 0; i < table.length; i++){
            for (int j = 0; j < table[i].length; j++){
                if (j == 0){
                    System.out.printf("%3d ", (i), table[i][j]);
                }
                
                if (i == 0 && j < column){
                    System.out.printf("%3d ", (j+1), table[i][j]);
                }

                if ( i > 0 && j > 0){
                table[i][j] = (i) * (j);
                System.out.printf("%3d ", table[i][j]);
                }                                            
            } 
            System.out.println();
        }
    }
}