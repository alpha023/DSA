public class MutabilityOfArray {
    public static void main(String args[]){
        int[] arr1={1,2,3,4,5,6};
        int[] arr2=arr1;
        System.out.println("-------Initially---------");
        System.out.println("Arr1-----");
        PrintArray(arr1);
        System.out.println("Arr2-----");
        PrintArray(arr2);
        arr1[2]=35;
        arr2[3]=100;
        System.out.println("--------After Change------");
        System.out.println("-----arr1[2]=35;\narr2[3]=100;----");
        System.out.println("Arr1-----");
        PrintArray(arr1);
        System.out.println("Arr2-----");
        PrintArray(arr2);





    }
    public static void PrintArray(int[] A){
        int n=A.length;
        for(int i=0;i<n;i++){
            
            System.out.print(A[i]+"  ");
            
           
        }
    }
}
