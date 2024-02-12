#include<stdio.h>
void pat1(int);
void pat2(int);
void pat3(int);
void diamond(int);
void main(){
    //pat1(9);
    //printf("\nNext Pattern\n");

    diamond(15);

}

void pat1(int n){
    for(int i=1;i<=n;i++){
        for(int j=1;j<=i;j++){
            printf("* ");
        }
        printf("\n");
    }
}
void pat2(int n){
    int i,j,sp;
    for(i=1;i<=n;i++){
        for(sp=n-i;sp>0;sp--){
            printf("  ");
        }
        for(j=1;j<=i;j++){
            printf("* ");
        }
        printf("\n");
    }
}

void pat3(int n){
    int i,j1,j2,sp;
    for(i=n;i>0;i--){

        for(j1=i;j1>0;j1--){
            printf("* ");
        }
        for(sp=(2*(n-i)+1);sp>0;sp--)printf("  ");
        for(j2=i;j2>0;j2--)printf("* ");
        printf("\n");

    }
    for(i=1;i<=n;i++){

        for(j1=i;j1>0;j1--){
            printf("* ");
        }
        for(sp=(2*(n-i)+1);sp>0;sp--)printf("  ");
        for(j2=i;j2>0;j2--)printf("* ");
        printf("\n");

    }
}
void diamond(int n){
    int i,j1,j2,sp;
    for(i=n;i>0;i--){

        for(j1=i;j1>0;j1--){
            printf("  ");
        }
        for(sp=(2*(n-i)+1);sp>0;sp--)printf("* ");
        for(j2=i;j2>0;j2--)printf("  ");
        printf("\n");

    }
    for(i=1;i<=n-1;i++){

        for(j1=i;j1>0;j1--){
            printf("  ");
        }
        for(sp=(2*(n-i)+1);sp>0;sp--)printf("* ");
        for(j2=i;j2>0;j2--)printf("  ");
        printf("\n");

    }
}