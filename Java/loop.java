import java.util.*;     
public class loop {
    public static void main(String args[]){
        Scanner sc= new Scanner(System.in);
        System.out.print("Enter A Number:");
        int n1 = sc.nextInt();
        int fact=1;
        for(int i=n1;i>=1;i=i-1){
            fact=fact*i;

        }
        System.out.println("Factorial="+fact);
    }
}
