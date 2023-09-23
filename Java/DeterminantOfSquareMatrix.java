import java.util.*;
public class DeterminantOfSquareMatrix {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter Order Of MAtrix:");
        int n=sc.nextInt();
        System.out.println("------------Enter Your Matrix Below----------");
        int[][] M=new int[n][n];
        for(int i=0;i<n;i++){
            System.out.println("Enter Row "+(i+1));
            for(int j=0;j<n;j++){
                M[i][j]=sc.nextInt();
            }
        }
        System.out.println("Determinant = "+determinant(M));


    }
    public static int determinant(int[][] matrix){
        int order=matrix.length;
        if(order==2){
            return matrix[0][0]*matrix[1][1]-matrix[0][1]*matrix[1][0];
        }
        else{
            int d=0;
            for(int i=0;i<order;i++){
                int[][] subMatrix=new int[order-1][order-1];
                int subMatrixRow=0;
                for(int j=1;j<order;j++){
                    int subMatrixCol=0;
                    for(int k=0;k<order;k++){
                        if(i!=k){
                            subMatrix[subMatrixRow][subMatrixCol]=matrix[j][k];
                            subMatrixCol++;
                        }
                    }
                    subMatrixRow++;
                }
                int power=i%2==0 ? 1:-1;
               
                d+=matrix[0][i]*determinant(subMatrix)*power;
            }
            return d;
        }
    }
}
