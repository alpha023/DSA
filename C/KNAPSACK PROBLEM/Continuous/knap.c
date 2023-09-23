#include <stdio.h>
#include <stdlib.h>
struct Knap
{
    int sr;
    int weight;
    int profit;
    float pwratio;
};

struct Knap items[11] = {
    {0, 5, 80},
    {1, 6, 25},
    {2, 2, 30},
    {3, 8, 14},
    {4, 9, 78},
    {5, 1, 55},
    {6, 3, 60},
    {7, 7, 75},
    {8, 11, 45},
    {9, 12, 40},
    {10, 0, 9999}};
int solution[10] = {0};

int sumArray(int[], int);
void QuickSort(struct Knap (*)[11], int, int);
int PartitionElement(struct Knap (*)[11], int, int);
void Swap(struct Knap *, struct Knap *);
void ProfitByWeightRatio(struct Knap (*)[11], int);
int *GreedyByProfit(struct Knap (*)[11], int, int);
void main()
{
    int n = 10;

    QuickSort(&items, 0, 9);
    // ProfitByWeightRatio(&items,10);

    int *ptr = GreedyByProfit(&items, 10, 20);
    int profit=calcProfit(&items,ptr,10);

    printf("\n");
    for (int i = 0; i < 10; i++)
        printf("%d-> ", ptr[i]);
        printf("\n");
        printf("Total Profit = %d ",profit);
}

void Swap(struct Knap *p, struct Knap *q)
{
    struct Knap temp = *p;
    *p = *q;
    *q = temp;
}

int sumArray(int a[], int n)
{
    int sum = 0;
    for (int i = 0; i < n; i++)
        sum += a[i];
    return sum;
}

int PartitionElement(struct Knap (*item)[11], int i, int j)
{
    int low = i;
    int high = j + 1;
    while (low <= high)
    {

        while ((*item)[low].profit <= (*item)[i].profit)
            low++;
        while ((*item)[high].profit > (*item)[i].profit)
            high--;

        if (low < high)
            Swap((*item) + low, (*item) + high);
    }

    Swap((*item) + i, (*item) + high);

    return high;
}

void QuickSort(struct Knap (*item)[11], int i, int j)
{
    if (i < j)
    {

        int p = PartitionElement(item, i, j);

        QuickSort(item, i, p - 1);
        QuickSort(item, p + 1, j);
    }
}

void ProfitByWeightRatio(struct Knap (*ptr)[11], int n)
{

    for (int i = 0; i < n; i++)
    {
        ((*ptr)[i]).pwratio = ((float)((*ptr[i]).profit) / (float)((*ptr[i]).weight));
    }
}

int *GreedyByProfit(struct Knap (*item)[11], int N, int M)
{

    int *sol = calloc(N, sizeof(int));

    int capacity = M;
    int i, pos;
    for (i = N-1; i >= 0; i--)
    {
        if ((*item)[i].weight <= capacity)
        {

            pos = (*item)[i].sr;
            sol[pos] = 1;
            capacity = capacity - (*item)[i].weight;
        }
       
    }

    return sol;
}
int calcProfit(struct Knap *item,int *sol,int n){
    int p=0;
    for(int i=0;i<n;i++){

        p+=item[i].profit * sol[item[i].sr];
        
    }
    return p;
}
