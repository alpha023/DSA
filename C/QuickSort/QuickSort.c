#include<stdio.h>
static int A[11]={233,-67,12,45,90,67,14,88,10,51,9999};
void QuickSort(int,int);
int Partition(int,int);
void Swap(int*,int*);
void main(){

    QuickSort(0,9);

    int n=10;
    for(int i=-1;(++i)<n;){
        printf("%d -> ",*(A+i));
    }

}

void QuickSort(int i,int j){
    if(i<j){
        int p=Partition(i,j);

        QuickSort(i,p-1);
        QuickSort(p+1,j);
    }
}

int Partition(int i,int j){
    int low=i;
    int high=j+1;
    while(low<=high){
        while(A[low]<=A[i]) low++;

        while(A[high]>=A[i]) high--;

        if(low<high)Swap(A+low,A+high);
        
    }

    Swap(A+i,A+high);
    return high;
}

void Swap(int *p,int *q){
    (*p)=(*p+*q)-(*q=*p);
}