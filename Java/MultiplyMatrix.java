import java.util.Scanner;

public class MultiplyMatrix {
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        // Taking Input Of Matrix A
        System.out.println("Enter Order Of Matrix A:");
        System.out.println("Rows:");
        int aRow=sc.nextInt();
        System.out.println("Columns:");
        int aCol=sc.nextInt();

        // Taking Input Of Matrix B
        System.out.println("Enter Order Of Matrix B:");
        System.out.println("Rows:");
        int bRow=sc.nextInt();
        System.out.println("Columns:");
        int bCol=sc.nextInt();
        
        //Taking Elements Of MAtrix A
        if (aCol==bRow){
            int[][] A=new int[aRow][aCol];
            int[][] B=new int[bRow][bCol];
            System.out.println("Enter Matrix A:");
            for(int i=0;i<aRow;i++){
                System.out.println("Enter Row"+i+1);
                for (int j=0;j<aCol;j++){
                    A[i][j]=sc.nextInt();       //Input Elements
                }
            }
        
            //Taking Elements Of MAtrix B
            System.out.println("Enter MAtrix B:");
            for(int i=0;i<bRow;i++){
                System.out.println("Enter Row"+i+1);
                for (int j=0;j<bCol;j++){
                    B[i][j]=sc.nextInt();
                }
            }
            int[][] AB=new int[aRow][bCol]; //Multiplication MAtrix
            for(int i=0;i<aRow;i++){
                for(int j=0;j<bCol;j++){
                    int result=0;
                    for (int k=0; k<aCol;k++ ){
                        result+=A[i][k]*B[k][j];  //*****Alpha Concept******
                    }
                    AB[i][j]=result;
                }
            }

            System.out.println("Matrix A Is:");
            for(int i=0;i<aRow;i++){
                for(int j=0;j<aCol;j++){
                    System.out.print(A[i][j]+"  ");
                }
                System.out.println();
            }
            System.out.println("Matrix B Is:");
            for(int i=0;i<bRow;i++){
                for(int j=0;j<bCol;j++){
                    System.out.print(B[i][j]+"  ");
                }
                System.out.println();
            }
            System.out.println("Multiplication Matrix AB Is:");
            for(int i=0;i<aRow;i++){
                for(int j=0;j<bCol;j++){
                    System.out.print(AB[i][j]+"  ");
                }
                System.out.println();
            }


        }
        else{
            System.out.println("Matrix Multiplication Not Possible Invalid Orders");

        }
      
    }
    
}
