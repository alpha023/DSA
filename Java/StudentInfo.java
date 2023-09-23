import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Scanner;

public class StudentInfo{
    public static void main(String[] args){
        Student st1=new Student();
        Student st2= new Student(1995);
        Student st3=new Student(2003,"Rakesh Yadav");
        st1.getDescription();
        st2.getDescription();
        st3.getDescription();

    }
    static class Student{
        Scanner sc=new Scanner(System.in);
        String name,address,fName,mName,dob;
        int roll,std,srno,marks;
        BigInteger contact;
        

        Student(){
            System.out.println("Student Record Instantiated:");
            System.out.println("Enter The Details:");
            System.out.println("Name:");
            this.name=sc.nextLine();
            System.out.println("Class:");
            this.std=sc.nextInt();
            System.out.println("Address:");
            this.address=sc.nextLine();
            this.address=sc.nextLine();
            
            System.out.println("Father's Name:");
            this.fName=sc.nextLine();

            System.out.println("Mother's Name:");
            this.mName=sc.nextLine();

            System.out.println("Date Of Birth:");
            this.dob=sc.nextLine();

            System.out.println("Roll No:");
            this.roll=sc.nextInt();

            System.out.println("Contact:");
            this.contact=sc.nextBigInteger();

            System.out.println("Sr. No:");
            this.srno=sc.nextInt();
            

            System.out.println("Marks:");
            this.marks=sc.nextInt();




        }
        public void getDescription(){
            System.out.println("Details Of "+this.name+" Roll No. "+this.roll);
            System.out.println("Name:"+this.name);
            System.out.println("Sr No.:"+this.srno);
            System.out.println("Roll No:"+this.roll);
            System.out.println("Mather's Name : "+this.mName);
            System.out.println("Father's Name : "+this.fName);
            System.out.println("Contact : "+this.contact);
            System.out.println("Address : "+this.address);
            System.out.println("Marks : "+this.marks);


            
        }
        Student(int sr){
            this.srno=sr;
            System.out.println("Student Record Instantiated:");
            System.out.println("Enter The Details:");
            System.out.println("Name:");
            this.name=sc.nextLine();
            System.out.println("Class:");
            this.std=sc.nextInt();
            System.out.println("Address:");
            this.address=sc.nextLine();
            this.address=sc.nextLine();
            
            System.out.println("Father's Name:");
            this.fName=sc.nextLine();

            System.out.println("Mother's Name:");
            this.mName=sc.nextLine();

            System.out.println("Date Of Birth:");
            this.dob=sc.nextLine();

            System.out.println("Roll No:");
            this.roll=sc.nextInt();

            

            System.out.println("Sr. No:");
            this.srno=sc.nextInt();
            

            System.out.println("Marks:");
            this.marks=sc.nextInt();




        }
        Student(int sr, String name){
            this.srno=sr;
            this.name=name;
            
            System.out.println("Student Record Instantiated:");
            System.out.println("Enter The Details:");
            
            System.out.println("Class:");
            this.std=sc.nextInt();

            System.out.println("Address:");
            this.address=sc.nextLine();
            this.address=sc.nextLine();
            
            System.out.println("Father's Name:");
            this.fName=sc.nextLine();

            System.out.println("Mother's Name:");
            this.mName=sc.nextLine();

            System.out.println("Date Of Birth:");
            this.dob=sc.nextLine();

            System.out.println("Roll No:");
            this.roll=sc.nextInt();

            

            

            System.out.println("Marks:");
            this.marks=sc.nextInt();




        }
        
    }
}