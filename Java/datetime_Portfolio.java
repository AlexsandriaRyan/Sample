/* 
---Alexsandria Ryan
---Mini-Assignment #5
---Submitted: April 7, 2022
---Grade received: 100%

---Assignment description:
1. The only resource you are allowed for this assignment is: Oracle JavaDoc and Me. 
Please do not Google or share your answers.
2. You need to make a console app - it will ask the user for at least three things:
a) A time zone they are curious about (give them multiple options).
b) The datetime format they prefer (give at least three options).
c) A date and time value (if they supply nothing it will use the current time -
how you decide they supply nothing can be up to you). - Assume they are in the 
Atlantic timezone.
3. You will then present them the datetime for that timezone in the selected 
format as well as our preferred yyyy-mm-dd HH:MM:SS "timezone" format.

Rules:
1. You must get the current datetime using LocalDateTime.
2. You must convert to a ZonedDateTime by providing the appropriate ZoneID.
3. You must use DateTimeFormatter for formatting the date for printing and parsing.
4. The user experience must present them with selections but you do not need to handle errors.
*/


import java.util.Scanner;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class datetime_Portfolio {
    public static void main (String[] args){
        System.out.println("||| Date Time Formatter |||");

//------------------------------ INPUT ------------------------------
        String city = findCity();
        ZoneId zone = findZone(city);
        DateTimeFormatter format = findFormat();
        DateTimeFormatter standardFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime ldt = LocalDateTime.now();
        String formatLdt = ldt.format(standardFormat);
        ZonedDateTime date = findDate(ldt, zone);

//------------------------------ OUTPUT ------------------------------
        System.out.println("\nCurrent Local Time: " + formatLdt);
        System.out.println("Your selected city is " + city + ". The timezone for " + city + " is " + zone + ".");
        System.out.println("Your selected date/time format is " + ldt.format(format) + ".");
        System.out.println("Your formatted date/time is: " + date.format(format) + ".");
    }

    public static String findCity(){
        Scanner scan = new Scanner(System.in);

        System.out.println("Pick a city to see what time it is there...");
        System.out.println("1. Halifax");
        System.out.println("2. New York");
        System.out.println("3. London");
        System.out.println("4. Dublin");
        System.out.println("5. Tokyo");
        String input = scan.nextLine();
        input = input.toLowerCase();

        while(!input.matches("halifax|new york|london|dublin|tokyo|1|2|3|4|5")){
            System.out.println("\nWhat you entered is not a city available in the list above. Pick a city to see what time it is there...");
            input = scan.nextLine();
            input = input.toLowerCase();
        }
        if (input.equals("halifax") || input.equals("1")){
            return "Halifax";
        }
        else if (input.equals("new york") || input.equals("2")){
            return "New York";
        }
        else if (input.equals("london") || input.equals("3")){
            return "London";
        }
        else if (input.equals("dublin") || input.equals("4")){
            return "Dublin";
        }
        else if (input.equals("tokyo") || input.equals("5")){
            return "Tokyo";
        }
        else{
            return null;
        }
    }

    public static ZoneId findZone (String city){
        if (city.equals("Halifax")){
            return ZoneId.of("America/Halifax");
        }
        else if (city.equals("New York")){
            return ZoneId.of("America/New_York");
        }
        else if (city.equals("London")){
            return ZoneId.of("Europe/London");
        }
        else if (city.equals("Dublin")){
            return ZoneId.of("Europe/Dublin");
        }
        else if (city.equals("Tokyo")){
            return ZoneId.of("Asia/Tokyo");
        }
        else{
            return null;
        }
    }  

    public static DateTimeFormatter findFormat(){
        Scanner scan = new Scanner(System.in);
        System.out.println("\nPick a date/time format...");
        System.out.println("1. DD/MM/YYYY\tHH:MM:SS");
        System.out.println("2. DD/MMM/YYYY\tHH:MM:SS");
        System.out.println("3. MM/DD/YYYY\tHH:MM:SS");
        String input = scan.next();

        while(!input.matches("1|2|3")){
            System.out.println("\nWhat you entered is not an acceptable date/time format. Pick a format from the list above...");
            input = scan.nextLine();
            input = input.toUpperCase();
        }
        if (input.equals("1")){
            return DateTimeFormatter.ofPattern("dd MM yyyy  HH:mm:ss");
        }
        else if (input.equals("2")){
            return DateTimeFormatter.ofPattern("dd MMM yyyy  HH:mm:ss");
        }
        else if (input.equals("3")){
            return DateTimeFormatter.ofPattern("MM dd yyyy  HH:mm:ss");
        }
        else{
            return null;
        }
    }

    public static ZonedDateTime findDate(LocalDateTime ldt, ZoneId zone){
        Scanner scan = new Scanner(System.in);
        System.out.println("\nEnter a date/time value matching the following format: YYYYMMDD HH:MM:SS.\n(Hitting 'Enter' or invalid input will select the default local date/time value)...");
        String input = scan.nextLine();
        DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyyMMdd HH:mm:ss");

        if (input.matches(".*[0-9].*")){
            LocalDateTime localDate = LocalDateTime.parse(input, format);
            return localDate.atZone(zone);
        }

        else if (input.matches("\\s")){
            return ldt.atZone(zone);
        }

        else{
            return ldt.atZone(zone);
        }
    }
}