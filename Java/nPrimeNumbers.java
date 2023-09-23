import java.util.*;
public class nPrimeNumbers{
    public static boolean isprime(int n){
        int fact=0;
        for(int i=1;i<=n;i++){
            if(n%i==0){
                fact++;
            }

        }
        if(fact==2){
            return true;
        }
        else{
            return false;
        }
    }
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        System.out.println("How Many Prime Number You Want:");
        int num=sc.nextInt();
        int prm=2;
        for(int i=0;i<num;i++){
            while(true){
                if (isprime(prm)){
                    System.out.print(prm+" ");
                    prm++;
                    break;
                }
                prm++;
            }
            
        }

    }
}