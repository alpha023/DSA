#include<stdio.h>
int isPrime(int);
void main(){

    int n=25,k=2;
    int prime[n];
    for(int i=0;i<n;i++)prime[i]=0;

    for(int j=0;j<n;j++){
        while(1){
            if(isPrime(k)){
                prime[j]=k;
                k++;
                break;
            }
            k++;
        }
    }

    for(int i=0;i<n;i++)printf("%d ,",prime[i]);
    
}

int isPrime(int n){
    if(n==2)return 1;
    else{
        for(int i=2;i*i<=n;i++){
            if(n%i==0)return 0;
        }
        return 1;
    }
}