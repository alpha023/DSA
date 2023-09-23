import java.util.*;
public class DeterminantOfNthOrderMatrix {
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter Order Of Matrix:");
        int n=sc.nextInt();

        //Input Matrix
        System.out.println("Enter Matrix:");
        int[][] A=new int[n][n];

        for(int i=0;i<n;i++){
            System.out.println("Enter Row"+(i+1));

            for(int j=0;j<n;j++){
                A[i][j]=sc.nextInt();



            }

        }
        int d=Determinant(A);
        System.out.println("Determinant Of Your Matrix Is = "+d);

    }
    public static int Determinant(int[][] A){
        int n=A.length;
        if(n==2){
            return A[0][0]*A[1][1]-A[0][1]*A[1][0];
        }
        else{
            int Det=0;
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    int[][] SubMatrix=new int[n-1][n-1];
                    int SubMatrixRow=0;
                    
                    for(int k=1;k<n;k++){
                        int SubMatrixCol=0;
                        for(int l=0;l<n;l++){
                            if(l!=j){
                                SubMatrix[SubMatrixRow][SubMatrixCol]=A[k][l];
                                SubMatrixCol++;
                            }
                            

                        }
                        SubMatrixRow++;
                    }
                    Det+=power(-1,i+j)*A[i][j]*Determinant(SubMatrix);
                }
            }
            return Det;
        }
    }
    public static int power(int x,int y){
        int result=1;
        for(int i=0;i<y;i++){
            result*=x;
        }
        return result;
    }
    
}
