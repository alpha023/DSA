#include <stdio.h>
#include <stdlib.h>

static int preorder[9] = {1, 2, 4, 5, 6, 3, 7, 8, 9};
static int inorder[9] = {4, 2, 6, 5, 1, 3, 8, 7, 9};
static int k = -1;

struct Node
{
    int data;
    struct Node *left;
    struct Node *right;
};
void constructTree(int, int, struct Node **);
void inorderTraversal(struct Node *);
void preorderTraversal(struct Node *);
void postorderTraversal(struct Node *);
void main()
{

    struct Node *ROOT;
    constructTree(0, 8, &ROOT);

    // inorderTraversal(ROOT);
    // printf("\n");
    // preorderTraversal(ROOT);
    // printf("\n");
    postorderTraversal(ROOT);
}

void constructTree(int i, int j, struct Node **put)
{

    if (i > j)
    {
        (*put) = NULL;
        return;
    }
    else if (i == j)
    {
        k++;
        struct Node *temp = malloc(sizeof(struct Node));
        temp->data = inorder[i];
        temp->left=NULL;
        temp->right=NULL;
        (*put) = temp;
    }
    else
    {
        k++;
        struct Node *L, *R;
        for (int z = i; z <= j; z++)
        {
            if (inorder[z] == preorder[k])
            {
                constructTree(i, z - 1, &L);
                constructTree(z + 1, j, &R);

                struct Node *ptr = malloc(sizeof(struct Node));
                ptr->data = inorder[z];
                ptr->left = L;
                ptr->right = R;
               
                

                (*put) = ptr;

                break;
            }
        }
    }
}

void inorderTraversal(struct Node *root)
{
    // printf("InOrder => \n");
    if (root==NULL)
    {
        return;
    }
    inorderTraversal(root->left);
    printf("%d -> ", root->data);
    inorderTraversal(root->right);

}
void preorderTraversal(struct Node *root)
{
    //  printf("PreOrder => \n");
    if (root==NULL)
    {
        return;
    }
    printf("%d -> ", root->data);
    preorderTraversal(root->left);
    preorderTraversal(root->right);

}

void postorderTraversal(struct Node *root)
{
    //  printf("Post Order => \n");
    if (root==NULL)
    {
        return;
    }
   
    postorderTraversal(root->left);
    postorderTraversal(root->right);
    printf("%d -> ", root->data);

}