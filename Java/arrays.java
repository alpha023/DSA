public class  arrays{
    public static void main(String args[]) {
        // int[] ar1=new int[5];
        int[] ar1;
        ar1= new int[5];
        for(int i=0;i<ar1.length;i++){
            ar1[i]=i;
        }
        // int ar2[]=new int[5];

        // int ar2[];
        // ar2=new int[5];

        // int[] ar2;
        // ar2 = new int[5];

        int[] ar2;
        ar2=new int[5];
        for(int i=0;i<ar1.length;i++){
            ar2[i]=i+1;
        }
        System.out.println(ar1[2]);
        System.out.println(ar2[2]);
    }
}