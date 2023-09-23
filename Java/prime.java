import java.util.*;
public class prime {
    public static void main(String args[]){
    Scanner sc= new Scanner(System.in);
    int fact=0, num;
    System.out.println("Enter A Number:");
    num=sc.nextInt();
    for(int i=1;i<=num;i++){
        if (num%i==0){
            System.out.println(i);
            fact++;

        }
    }
    if (fact==2){
        System.out.println(num+" Is A Prime Number");

        
    }
    else{
        System.out.println(num+" Is Not A Prime Number");
    }
}
}
