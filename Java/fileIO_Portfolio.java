/* 
---Alexsandria Ryan
---Mini-Assignment 6
---Submitted: April 11, 2022
---Grade received: 100%

---Assignment description:
1. Allowed resources:
    a) The W3 Schools Tutorial on Java Files: 
    https://www.w3schools.com/java/java_files.asp
    b) As always - the Oracle JavaDoc, eg: 
    https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/io/class-use/File.html
c) Check out the contains and replaceAll methods for Java Strings
2. Program 1: Create a csv (comma separated file - save as a ".csv") by prompting 
the user for inputs
3. Write a comma separated file, with headers, based on my terminal input. You will 
prompt the user for:
    a) The number of columns in the file.
    b) The the number of rows.
    c) Prompt them for the header row, one by one.
    d) Then prompt for the fields one at a time.
4. You must handle two of the escape characters (there are more, but this is enough)
    a) If the input string has a comma or a double quote in it, that section must be 
    enclosed in double quotes.
    b) Double quotes are escaped by ""doubling them""
5. Program 2: Expand program 1 to get its input from a file optionally. I will test 
it with the attached file.
*/




import java.util.Scanner;
import java.util.Arrays;
import java.util.ArrayList;
import java.io.File;
import java.io.FileWriter;
import java.io.FileNotFoundException;
import java.io.IOException;

public class fileIO_Portfolio {
    public static void main (String[] args) throws IOException{
        Scanner scan = new Scanner(System.in);

        System.out.println("||| Files |||");
        System.out.println("\n Confirm which program you would like to run:");
        System.out.println("1. File IO (Input Data)");
        System.out.println("2. File Reader (Read Existing Data)");
        System.out.println("3. Exit System");
        int choice = scan.nextInt();

        while ((choice < 1) || (choice > 3)){
            System.out.println("\nSorry -- What you entered is not a valid input.");
            System.out.println("\nPlease confirm which program you would like to run:");
            System.out.println("1. File IO (Input Data)");
            System.out.println("2. File Reader (Read Existing Data)");
            System.out.println("3. Exit System");
            choice = scan.nextInt();
        }

        if(choice == 1){
            fileOutput();
            return;
        }

        else if(choice == 2){
            fileReader();
            return;
        }

        else if(choice == 3){
            System.out.println("Thank you -- Goodbye.");
            System.exit(0);
        }
    }



//------------------------------PART 1------------------------------  



    public static void fileOutput() throws IOException{
//------------------------------INPUT------------------------------
        File file = new File("output1.csv");
        FileWriter myFile = new FileWriter(file);
        String path = file.getAbsolutePath();
        Scanner scanInt = new Scanner(System.in);
        Scanner scanString = new Scanner(System.in);

        System.out.print("Number of columns:\t");
        int columns = scanInt.nextInt();
        System.out.print("Number of rows:\t\t");
        int rows = scanInt.nextInt();

//------------------------------CALCULATIONS------------------------------
        String[] headers = new String[columns];
        String[] names = new String[rows]; 
        String[] phrases = new String[rows];
        writingHeaders(columns, headers, myFile);
        myFile.write("\n");

        for(int i = 0; i < (rows-1); i++){
            System.out.print("\nPlease enter Name " + (i+1) +": ");
            String name1 = scanString.nextLine();
            System.out.print("Please enter " + name1 +"'s Catch Phrase: ");
            String phrase1 = scanString.nextLine();

            names[i] = name1.replaceAll("\"", "\"\"");
            phrases[i] = phrase1.replaceAll("\"", "\"\"");

            if (names[i].contains(",") || names[i].contains("\"")){
                String name2 = "\"" + names[i] + "\"";
                names[i] = name2;
            }

            if (phrases[i].contains(",") || phrases[i].contains("\"")){
                String phrase2 = "\"" + phrases[i] + "\"";
                phrases[i] = phrase2;
            }

            myFile.write(names[i]+","); 
            myFile.write(phrases[i]+"\n");
        } 

//------------------------------OUTPUT------------------------------   
        myFile.flush(); //pushes everything to print
        myFile.close(); //closes writer
        System.out.print("\nData has been compiled to " + path +".");
    }

//------------------------------OTHER METHODS------------------------------   

    public static String[] writingHeaders(int columns, String[] headers, FileWriter myFile) throws IOException{
        for (int i = 0; i < columns; i++){
            Scanner scanString = new Scanner(System.in);
            System.out.print("\nPlease enter Header " + (i+1) + ": ");
            String header = scanString.nextLine();
            headers[i] = header.replaceAll("\"", "\"\"");
            if (headers[i].contains(",")){
                headers[i] = "\"" + headers[i] + "\"";
            }
            if (i < headers.length-1){
                myFile.write(headers[i]+",");
            } else{
                myFile.write(headers[i]);
            }
        }
        return headers;
    }


//------------------------------PART 2------------------------------  


    public static void fileReader() throws IOException{
//------------------------------INPUT------------------------------

        File inputFile = new File("InputFile_v1.txt");
        File file = new File("output2.csv");
        FileWriter myFile = new FileWriter(file);
        String path = file.getAbsolutePath();
        Scanner scanFile = new Scanner(inputFile);

//------------------------------CALCULATIONS------------------------------ 

        ArrayList<String> data = findData(scanFile);
        int columns = findColumns(data);
        int rows = (data.size() / columns);
        String[] headers = new String[columns];
        String[] names = new String[rows];
        String[] phrases = new String[rows];

        writingHeaders2(columns, headers, data, myFile);
        myFile.write("\n");

        for(int i = 0; i < (rows-1); i++){
            String name1 = data.get(0);
            data.remove(0);
            String phrase1 = data.get(0);
            data.remove(0);

            names[i] = name1.replaceAll("\"", "\"\"");
            phrases[i] = phrase1.replaceAll("\"", "\"\"");

            if (names[i].contains(",") || names[i].contains("\"")){
                String name2 = "\"" + names[i] + "\"";
                names[i] = name2;
            }

            if (phrases[i].contains(",") || phrases[i].contains("\"")){
                String phrase2 = "\"" + phrases[i] + "\"";
                phrases[i] = phrase2;
            }

            myFile.write(names[i]+",");
            myFile.write(phrases[i] + "\n");
        } 

//------------------------------OUTPUT------------------------------        
        myFile.flush(); //pushes everything to print
        myFile.close(); //closes writer
        System.out.print("\n" + inputFile + " has been read and compiled to " + path +".");
    }

//------------------------------OTHER METHODS------------------------------
    public static ArrayList<String> findData(Scanner scanFile){
        ArrayList<String> data = new ArrayList<String>();
        int counter = 0;
        while (scanFile.hasNext()) {
            while (scanFile.hasNextLine()){
                String input = scanFile.nextLine();
                data.add(input);
                counter++;
            }
        }
        return data;
    }

    public static int findColumns(ArrayList<String> data){
        String col = data.get(0);
        data.remove(0);
        String cols = col.replaceAll("[\\D}]", "");
        int columns = Integer.parseInt(cols);
        return columns;
    }

    public static String[] writingHeaders2(int columns, String[] headers, ArrayList<String> data, FileWriter myFile) throws IOException{
        for (int i = 0; i < columns; i++){
            String header = data.get(0);
            data.remove(0);
            headers[i] = header.replaceAll("\"", "\"\"");
                if (headers[i].contains(",")){
                    headers[i] = "\"" + headers[i] + "\"";
                }
                if (i < headers.length-1){
                    myFile.write(headers[i]+",");
                } else{
                    myFile.write(headers[i]);
                }
        }
        return headers;
    }
}