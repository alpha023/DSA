#include<stdio.h>
static int A[10]={1,7,5,3,2,-5,34,11,78,111};
static int B[20]={0};

void MergeSort(int,int);
void Merge(int,int,int);
void main(){

     MergeSort(0,9);

    int n=10;
    for(int i=0;i<n;i++){
        printf("%d -> ",A[i]);
    }
    // int l=sizeof(&A)/sizeof(A[0]);
    // printf("Length = %d",sizeof(A));
}

void MergeSort(int i,int j){
    if(i<j){
        int mid=(i+j)/2;
        
        MergeSort(i,mid);
        MergeSort(mid+1,j);

        Merge(i,mid,j);
    }
}

void Merge(int i,int mid,int j){
    int low=i;
    int high=mid+1;
    int start=i;
    while(low<=mid && high<=j){
        if(A[low]<A[high]){

            B[start]=A[low];
            low++;

        }else{
            B[start]=A[high];
            high++;
        }
        start++;
    }
    if(low>mid){
        for(int x=high;x<=j;x++){
            B[start]=A[x];
            start++;
        }
    }else{
        for(int y=low;y<=mid;y++){
            B[start]=A[y];
            start++;
        }
    }

    for(int z=i;z<=j;z++){
        A[z]=B[z];
    }
}
