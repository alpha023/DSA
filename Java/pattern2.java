import java.util.Scanner;
public class pattern2{
    public static void main(String args[]){
        Scanner sc= new Scanner(System.in);
        System.out.println("Enter Rows:");
        int n=sc.nextInt();
        for(int i=0;i<n;i++){
            for (int sp=n-i-1;sp>0;sp--){
                System.out.print("  ");


            }
            for(int j=0;j<=i;j++){
                System.out.print("* ");

        }
        System.out.println();
    }
        for (int i=0;i<n-1;i++){
            for(int sp=0;sp<=i;sp++){
                System.out.print("  ");

            }
            for(int j=n-1-i;j>0;j--){
                System.out.print("* ");
            }
            System.out.println();
        }
    
}
}