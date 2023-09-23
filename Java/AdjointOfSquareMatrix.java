import java.util.Scanner;

public class AdjointOfSquareMatrix {
    public static void main(String[] args){
        Scanner sc= new Scanner(System.in);
        System.out.println("Enter Order Of Matrix : ");
        int n= sc.nextInt();
        System.out.println("-----Enter Matrix Below------");
        int[][] M=new int[n][n];
        for (int i=0;i<n;i++){
            System.out.println("Enter Row "+(i+1));
            for(int j=0;j<n;j++){
                M[i][j]=sc.nextInt();

            }

        }
        System.out.println("-----------Details Of The MAtrix----------");
        System.out.println("Determinant = "+determinant(M));
        System.out.println("Adjoint Matrix:");
        int[][] adjoint=adjoint(M);
        for(int i=0;i<n;i++){
            for (int j=0;j<n;j++){
                System.out.print(adjoint[i][j]+"    ");
            }
            System.out.println();
        }



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
    public static int[][] adjoint(int[][] matrix){
        int order=matrix.length;
        int[][] adj=new int[order][order];
        for(int i=0;i<order;i++){
            for(int j=0;j<order;j++){
                int[][] subMatrix=new int[order-1][order-1];
                int subMatrixRow=0;
                for(int m=0;m<order;m++){
                    if(m==i){
                        continue;
                    }
                    int subMatrixCol=0;
                    for(int n=0;n<order;n++){
                        
                        
                        if(m!=i && n!=j){
                            subMatrix[subMatrixRow][subMatrixCol]=matrix[m][n];
                            subMatrixCol++;
                        }
                    }
                    subMatrixRow++;
                  
                }
                int power= (i+j)%2==0 ? 1:-1;
                adj[j][i]=power*determinant(subMatrix);
            }
        }
        return adj;
    }
}
