import java.util.*;
public class factorial {
    public static int factorial(int n){
        int f=1;
        for(int i=1;i<=n;i++){
            f*=i;
        }
        return f;
    }
    public static int power(int x,int y){
        if (y==0){
            return 1;
        }
        else{
            for(int i=2; i<=y;i++){
                x=x*x;
            }
            return x;

        }
        
    }
    public static void main(String args[]){
    Scanner sc=new Scanner(System.in);
    System.out.println("Enter A Number:");
    int n=sc.nextInt();
    double ans=0;
    for(int i=0;i<=3;i++){
        ans=ans+(power(n,i)/factorial(i));
        System.out.println("Answer="+ans);
    }
    System.out.println("Answer="+ans);

    }
}
