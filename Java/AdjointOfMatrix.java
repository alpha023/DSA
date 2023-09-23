import java.util.*;

public class AdjointOfMatrix {
    public static int power(int x,int y){
        int result=1;
        for(int i=0;i<y;i++){
            result*=x;
        }
        return result;
    }
    public static void PrintArray(int[][] arr){
        int n=arr.length;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                System.out.print(arr[i][j]+"    ");
            }
            System.out.println();
        }
    }
    public static void main(String args[]){
        Scanner sc= new Scanner(System.in);
        System.out.println("Enter Order Of Matrix:");
        int n=sc.nextInt();

        System.out.println("Enter Your Matrix:");

        //Taking Input Of Matrix
        int[][] A=new int[n][n];
        for (int i=0;i<n;i++){
            System.out.println("Enter Row : "+(i+1));
            for(int j=0;j<n;j++){
                A[i][j]=sc.nextInt();

            }

        }
        int[][] adjA=new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                adjA[i][j]=(Adjoint(A))[i][j];
            }
        }

        PrintArray(A);
        System.out.println();
        PrintArray(Adjoint(A));
    //Print Adjoint Of The Input Matrix
   
}

    public static int[][] Adjoint(int[][] A) {
        int n = A.length;
        int[][] Adj = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int[][] SubMatrix = new int[n - 1][n - 1];
                int SubMatrixRow = 0;
                for (int k = 0; k < n; k++) {
                    int SubMatrixCol = 0;
                    for (int l = 0; l < n; l++) {
                        if (i != k && j != l) {
                            SubMatrix[SubMatrixRow][SubMatrixCol] = A[k][l];
                            SubMatrixCol++;
                            
                        }

                    }
                    if (i != k) {
                        SubMatrixRow++;
                    }

                }
                
                Adj[i][j] = power(-1, i + j) * Determinant(SubMatrix);
            }
        }
        return  Adj;
    }

    public static int Determinant(int[][] A) {
        int n = A.length;
        if (n == 2) {
            return A[0][0] * A[1][1] - A[0][1] * A[1][0];
        } else {
            int Det = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    int[][] SubMatrix = new int[n - 1][n - 1];
                    int SubMatrixRow = 0;

                    for (int k = 1; k < n; k++) {
                        int SubMatrixCol = 0;
                        for (int l = 0; l < n; l++) {
                            if (l != j) {
                                SubMatrix[SubMatrixRow][SubMatrixCol] = A[k][l];
                                SubMatrixCol++;
                            }

                        }
                        SubMatrixRow++;
                    }
                    Det += power(-1, i + j) * A[i][j] * Determinant(SubMatrix);
                }
            }
            return Det;
        }
    }

}