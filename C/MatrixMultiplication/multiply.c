#include<stdio.h>
 void Combine(int (*)[][4],int,int,int,int,int (*)[][2],int);
void main(){

    int A[4][4]={0};
    int B[2][2]={
        {1,5},
        {8,9}
    };
    Combine(&A,0,1,2,3,&B,2);
    for(int i=0;i<4;i++){
        for(int j=0;j<4;j++){
            printf("%d  ",A[i][j]);
        }
        printf("\n");
    }

    // int (*p)[2][2]=&B;
    // printf("%d",(*p)[0][1]);



}

void Combine(int (*p)[][4],int rowStart,int rowEnd,int colStart,int colEnd,int (*q)[][2],int r){

    for(int i=0;i<r;i++){
        for(int j=0;j<r;j++){
            (*p)[i+rowStart][j+colStart]=(*q)[i][j];
        }
    }

}
