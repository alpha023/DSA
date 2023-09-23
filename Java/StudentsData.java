import java.math.BigInteger;
import java.util.Scanner;

public class StudentsData {
        public static void main(String args[]){
            Student st1=new Student();
            Student st2=new Student();
            System.out.println("---------Entered Studdent Details----------");
            st1.description();
            st2.description();

        }
}
class Student{
    String name,dob,address;
    int roll,std;
    BigInteger contact;
    Scanner sc=new Scanner(System.in);
    Student(){
        System.out.println("------Enter Student Details------");
        System.out.println("Name:");
        this.name=sc.nextLine();
        System.out.println("Class:");
        this.std=sc.nextInt();
        System.out.println("Roll Number:");
        this.roll=sc.nextInt();
        System.out.println("Contact Number:");
        this.contact=sc.nextBigInteger();
        System.out.println("Enter The Address Of Student: ");
        this.address=sc.nextLine();
        this.address=sc.nextLine();

    }
    public void description(){
        System.out.println("--------Details Of Student whose Name is "+this.name);
        System.out.println("Name: "+this.name);
        System.out.println("Class: "+this.std);
        System.out.println("Roll Number: "+this.roll);
        System.out.println("Contact: "+this.contact);
        System.out.println("Address: "+this.address);

    }
}
