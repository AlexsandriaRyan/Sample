/* 
---Alexsandria Ryan
---Mini Assignment #3
---Submitted: February 16, 2022
---Grade received: 100%

---Assignment description:
You must use brute force – nothing clever.
Solve: ABCDE x A = EEEEEE
Must...
- break numbers down into individual variables
- comparison to make sure all digits are unique
- implements brute force
- interface and approach are clean and functional
*/

import java.util.Scanner;
public class ABCDE_Portfolio{
    public static void main(String []args) {
        //declarations
        int a; //ten thousands
        int b; //thousands
        int c; //hundreds
        int d; //tens
        int e; //ones
        int abcde; //total
        int eeeeee; //e*111111

        Scanner sc= new Scanner(System.in);

        System.out.println("Solving ABCDE x A = EEEEEE");
        System.out.println("");
        System.out.println("Starting point: ABCDE = 12345");
        System.out.println("Press any key to start the program...");
        sc.nextLine();

        //calculations
        abcde = 12345;
        e = abcde%10;
        d = (abcde/10)%10;
        c = (abcde/100)%10;
        b = (abcde/1000)%10;
        a = (abcde/10000)%10;
        eeeeee = e*111111;
        
        //there is likely an easier way to do this; at the time, 
        //I simply wrote out each comparison separately for A, B, C, D and E.
        while((a != b || a != c || a != d || a != e) && 
        (b != a || b != c || b != d || b != e) && 
        (c != a || c != b || c != d || c != e) && 
        (d != a || d != b || d != c || d != e) && 
        (e != a || e != b || e != c || e != d)){

            while (abcde * a != eeeeee){
                abcde++;  
                e = abcde%10;
                d = (abcde/10)%10;
                c = (abcde/100)%10;
                b = (abcde/1000)%10;
                a = (abcde/10000)%10;
                eeeeee = e*111111;
            }

            if (abcde * a == (eeeeee)){
                System.out.println("Finished solving for ABCDE.");
                System.out.println("Press any key to see the results...");
                sc.nextLine();
                System.out.println("ABCDE = " + abcde);
                System.out.println("A = " + a);
                System.out.println("EEEEEE = " + (eeeeee));
                System.out.println("Therefore " + abcde + " multiplied by " + a + " equals " + (e*1111111));
            }
        break;
        }           
    }
}