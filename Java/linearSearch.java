public class linearSearch {
    public static void main(String[] atgs){
        int[] arr={1,6,8,3,61,0};
        int x=80;
        int n=arr.length;
        int result=linSearch(arr,n-1,x);
        if(result==-1){
            System.out.println("Element Not Found!!!!!!!");

        }
        else{
            System.out.println("Element Found At Index= "+result);
        }
    }
    public static int linSearch(int[] arr, int n, int x){
        if(n<0){
            return -1;
        }
        else if(arr[n]==x){
            return n;
        }
        else{
            return linSearch(arr,n-1,x);
        }
            
    }
}

