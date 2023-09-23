import java.util.*;
public class diamond {
    public static void main(String args[]){
        Scanner sc= new Scanner(System.in);
        System.out.println("Enter A Number:");
        int n=sc.nextInt();
        if(n%2==0){
            n=n+1;

        }
        int nh=(n+1)/2;
        for(int i=0;i<nh;i++){
            for(int sp=nh-i;sp>1;sp--){
                System.out.print(" ");


            }
            for(int j=0;j<(2*i)+1;j++){
                System.out.print("*");
            }
            System.out.println();
        }
        for(int i=0;i<nh-1;i++){
            for(int sp=i+1;sp>0;sp--){
                System.out.print(" ");

            }
            for(int j=((nh-1)*2-(2*i+1));j>0;j--){
                System.out.print("*");

            }
            System.out.println();
        }
    }
}
