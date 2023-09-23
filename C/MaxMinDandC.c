#include<stdio.h>
static int A[10]={1,6,4,-3,8,2,6,4,5,1};

void MaxMin(int,int,int*,int*);
void main(){

    int max,min;
    MaxMin(0,9,&max,&min);

    printf("Maximum = %d , Minimum = %d ",max,min);

}
void MaxMin(int i,int j, int* bada , int* chota){

    int m,m1,M,M1;
    m=m1=M=M1=A[i];
    if(i==j){
        *bada=*chota=A[i];
    }else if(i==(j-1)){
        if(A[i]>A[j]){
            *chota=A[j];
            *bada=A[i];
        }else{
            *chota=A[i];
            *bada=A[j];
        }
    }else{
        int mid=(i+j)/2;
        MaxMin(i,mid,&M,&m);
        MaxMin(mid+1,j,&M1,&m1);

        (*bada)=(M>M1?M:M1);
        (*chota)=(m>m1?m1:m);
    }

}