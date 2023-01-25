//This program was made by Alenna for the CTE course "Software & Programming Development 2" instructed by Mr. Gross
//Email - alenna.castaneda@oneidaihla.org

//Importing required classes
import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;

public class Student {
    //creating class attributes
    static String namef;
    static String namel;
    static String grade;
    static String schoolName;

    //constructor
    public Student() {
        namef = null;
        namel = null;
        grade = null;
        schoolName = null;
    }

    //Driver
    public static void main(String[] args) {
        //creating scanner object that reads from System.in
        Scanner scan = new Scanner(System.in);
        //creating FileWriter and FileReader objects
        FileWriter outputFile = null;

        try {
            //creating new file
            outputFile = new FileWriter("student.txt");

            System.out.println("Please enter the following information to register");
            System.out.println("\nFirst Name");
            //reading next user input for "namef"
            namef = scan.nextLine();

            System.out.println("\nLast Name");
            //reading next user input for "namel"
            namel = scan.nextLine();

            System.out.println("\nGrade");
            //reading next user input for "grade"
            grade = scan.nextLine();

            System.out.println("\nSchool Name");
            //reading next user input for "schoolName"
            schoolName = scan.nextLine();

            //writing student name in file
            outputFile.write("Student: "+namef+" "+namel);

            char c = grade.charAt(grade.length()-1);
            //if grade is "9"
            if (c == '9') {
                grade = grade+"th";
                //writing grade in file
                outputFile.write("\nGrade: "+grade);

                //if grade string is 2 characters long
            } else if (grade.length() == 2) {
                char c2 = grade.charAt(grade.length()-2);
                
                //if grade is "10", "11", or "12"
                if (c2 == '1' && c == '0' || c == '1' || c == '2') {
                    grade = grade+"th";
                    //writing grade in file
                    outputFile.write("\nGrade: "+grade);
                }

                //if grade is not "9", "10", "11", or "12"
            } else {
                outputFile.write("\nGrade: "+grade);
            }

            //writing school name in file
            outputFile.write("\nSchool: "+schoolName);
            System.out.println("\nStudent file creation was successful. Thank you for your participation!");

            //catching IOException
        } catch (IOException i) {
            System.out.println("System error occured. Please restart the program");
        } finally {
            try {
                //closing file
                outputFile.close();
                //catching IOException
            } catch (IOException i) {
                System.out.println("System error occured. Please restart the program");
            }
            //closing scanner
            scan.close();
        }
    }
    
}