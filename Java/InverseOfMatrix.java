import java.util.Scanner;

public class InverseOfMatrix {
    public static void main(String args[]){
        //Main Function
        Scanner sc= new Scanner(System.in);
        float[][] A=InputArray();

        System.out.println();
        float[][] InverseA=Inverse(A);
        System.out.println("---------Matrix A-------");
        PrintArray(A);
        System.out.println();
        System.out.println("---------Inverse Of A-------");
        PrintArray(InverseA);
        System.out.println();
        System.out.println("Checking:::::::");

        
        float[][] mul=MultiplyMatrixAB(InverseA,A);
        PrintArray(mul);
        System.out.println("------Adjoint----");
        PrintArray(Adjoint(A));
        System.out.println();
        System.out.println(Determinant(A)+" = Determinant");
    }
    public static float[][] InputArray(){
        System.out.println("Enter The Order Of Matrix:");
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        float[][] A=new float[n][n];
        System.out.println("Enter Your Matrix:");
        for(int i=0;i<n;i++){
            System.out.println("Enter Row: "+(i+1));
            for(int j=0;j<n;j++){
                A[i][j]=sc.nextFloat();
             }

        }
        return A;
    }
    public static void PrintArray(float[][] A){
        int n=A.length;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                System.out.print(A[i][j]+"  ");
            }
            System.out.println();
        }
    }
    public static float[][] Inverse(float[][] A){
        int n=A.length;
        float[][] AdjA=Adjoint(A);
        float d=Determinant(A);
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                AdjA[i][j]=AdjA[i][j]/d;
            }
        }
        return AdjA;
    }
    public static float Determinant(float[][] A){
        int n=A.length;
        if(n==2){
            return A[0][0]*A[1][1]-A[0][1]*A[1][0];
        }
        else{
            float Det=0;
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    float[][] SubMatrix=new float[n-1][n-1];
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
    public static float power(float x,float y){
        int result=1;
        for(int i=0;i<y;i++){
            result*=x;
        }
        return result;
    }
    public static float[][] Adjoint(float[][] A) {
        int n = A.length;
        float[][] Adj = new float[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                float[][] SubMatrix = new float[n - 1][n - 1];
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
               

                
                Adj[j][i] = power(-1, i + j) * Determinant(SubMatrix);
            }
        }
        return  Adj;
    }
    public static float[][] MultiplyMatrixAB(float[][] A,float[][] B){
        int aRow=A.length;
        int aCol=A[0].length;
        int bRow=B.length;
        int bCol=B[0].length;
        float[][] AB=new float[aRow][bCol]; //Multiplication MAtrix
            for(int i=0;i<aRow;i++){
                for(int j=0;j<bCol;j++){
                    float result=0;
                    for (int k=0; k<aCol;k++ ){
                        result+=A[i][k]*B[k][j];  //*****Alpha Concept******
                    }
                    AB[i][j]=result;
                }
            }
            return AB;
    }
}
