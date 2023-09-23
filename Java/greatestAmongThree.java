import java.util.*;

public class greatestAmongThree {
    public static void main(String args[]){
        Scanner sc= new Scanner(System.in);
        System.out.println("Enter Number 1:");
        int a=sc.nextInt();
        System.out.println("Enter Number 2:");
        int b=sc.nextInt();
        System.out.println("Enter Number 3:");
        int c=sc.nextInt();
        if (a>b){
            if (a>c){
                System.out.println("Largest="+a);
                if (b>c){
                    System.out.println("Smallest="+c);
                    System.out.println("Middle="+b);
                }
                else{
                    System.out.println("Smallest="+b);
                    System.out.println("Middle="+c);
                }
            }
            else{
                System.out.println("Largest="+c);
                if(a>b){
                    System.out.println("Smallest="+b);
                    System.out.println("Middle="+a);
                }
                else{
                    System.out.println("Smallest="+a);
                    System.out.println("Middle="+b);
                }
            }
        }
        else{
            if(b>c){
                System.out.println("Largest="+b);
                if(a>c){
                    System.out.println("Smallest="+c);
                    System.out.println("Middle="+a);

                }
                else{
                    System.out.println("Smallest="+a);
                    System.out.println("Middle="+c);
                }
            }
            else{
                System.out.println("Largest="+c);
                if(a>b){
                    System.out.println("Smallest="+b);
                    System.out.println("Middle="+a);

                }
                else{
                    System.out.println("Smallest="+a);
                    System.out.println("Middle="+b);

                }
            }
        }
    
}
}