/* 
---Alexsandria Ryan
---Mini Assignment #1
---Submitted: January 20, 2022
---Grade received: 100%

---Assignment description:
Must...
- compile
- do something different than we did in class
- have some type of output
*/

import java.util.Scanner;
public class ZodiacSign_Portfolio {
	 public static void main(String []args) {
		 int a;
		 int b;
		{
		Scanner sc= new Scanner(System.in);
		System.out.println("What is your birth month? (01 - 12)");
		a= sc.nextInt();
			while(a<1 || a>12){
			System.out.println("Please enter a valid birth month between 01 - 12.");
			a= sc.nextInt();
			}
			
			if(a<=12){
			System.out.println("What is your day of birth? (01 - 31)");
			b= sc.nextInt();
			
			while(b<1 || b>31){
			System.out.println("Please enter a valid birth day between 01 - 31.");
			b= sc.nextInt();
			}
			
			while((a==02) &&(b>=30)){ //if birthday is february 30 or 31
			System.out.println("You have selected the month of February. February does not have any days beyond 29. Please enter a birth day between 01 - 29.");
			b= sc.nextInt();
			}
			
			if((a<=12 && b<=31) &&(a==02 &&b<=29)){					
			}
				// capricorn
				if((a==01) &&(b<=19) || (a==12) &&(b>=22)){
				System.out.println("You are a Capricorn!");
				}

				//aquarius
				if((a==1) &&(b>=20) || (a==2) &&(b<=18)){
				System.out.println("You are an Aquarius!");
				}

				//pisces
				if((a==2) &&(b>=19) || (a==3) &&(b<=20)){
				System.out.println("You are a Pisces!");
				}

				//aries
				if((a==3) &&(b>=21) || (a==4) &&(b<=19)){
				System.out.println("You are an Aries!");
				}

				//taurus
				if((a==4) &&(b>=20) || (a==5) &&(b<=21)){
				System.out.println("You are a Taurus!");
				}

				//gemini
				if((a==5) &&(b>=21) || (a==6) &&(b<=20)){
				System.out.println("You are a Gemini!");
				}

				//cancer
				if((a==6) &&(b>=21) || (a==7) &&(b<=22)){
				System.out.println("You are a Cancer!");
				}

				//leo
				if((a==7) &&(b>=23) || (a==8) &&(b<=22)){
				System.out.println("You are a Leo!");
				}

				//virgo
				if((a==8) &&(b>=23) || (a==9) &&(b<=22)){
				System.out.println("You are a Virgo!");
				}

				//libra
				if((a==9) &&(b>=23) || (a==10) &&(b<=22)){
				System.out.println("You are a Libra!");
				}

				//scorpio
				if((a==10) &&(b>=23) || (a==11) &&(b<=21)){
				System.out.println("You are a Scorpio!");
				}

				//sagittarius
				if((a==11) &&(b>=22) || (a==12) &&(b<=21)){
				System.out.println("You are a Sagittarius!");
				}
			}
		}
	}
 }