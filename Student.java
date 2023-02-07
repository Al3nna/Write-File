//This program was made by Alenna for the CTE course "Software & Programming Development 2" instructed by Mr. Gross
//Email - alenna.castaneda@oneidaihla.org

//Importing required classes
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

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
        //creating new File
        File studentFile = new File("student.txt");
        
        try {
            //creating scanner object that reads from studentFile
            Scanner fileScan = new Scanner(studentFile);
            //creating new PrintWriter
            PrintWriter write = new PrintWriter(new FileWriter(studentFile));

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

            //closing system input scanner
            scan.close();

            //writing student name in file
            write.write("Student: "+namef+" "+namel);

            //if grade string is at least 1 char long
            if (grade.length() >= 1) {
                char c = grade.charAt(grade.length()-1);

                //if grade is "9"
                if (c == '9') {
                    grade = grade+"th";

                //if grade string is at least 2 chars long
                } if (grade.length() >= 2) {
                    char c2 = grade.charAt(grade.length()-2);
                        //if grade string is 2 characters long
                        if (grade.length() == 2) {

                        //if grade is "10", "11", or "12"
                        if (c2 == '1' && c == '0' || c == '1' || c == '2') {
                            grade = grade+"th";
                        }
                    }
                }
            }
            //writing grade in file
            write.write("\nGrade: "+grade);

            //writing school name in file
            write.write("\nSchool: "+schoolName);

            //closing PrintWriter
            write.close();

            System.out.println("\nStudent file creation was successful. Thank you for your participation!");

            System.out.println();
            System.out.println("Student File:");

            //while student file has another line
            while (fileScan.hasNextLine()) {
                //temporarily storing data
                String data = fileScan.nextLine();
                //printing data
                System.out.println(data);
            }

            //closing file scanner
            fileScan.close();
            //catching FileNotFoundException
        } catch (FileNotFoundException f) {
            System.out.println("System error occured. Please restart the program");
            System.out.println(f);
        } catch (IOException i) {
            System.out.println("System error occured. Please restart the program");
            System.out.println(i);
        }
    }
}