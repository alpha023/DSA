#include <stdio.h>
#include <stdlib.h>
struct Node
{
    int data;
    struct Node *next;
    struct Node *prev;
};

struct Node *insertAtFirst(struct Node *, int);
struct Node *insertAtLast(struct Node *, int);
struct Node *insertAt(struct Node *, int, int);
struct Node *createNode(int);

void traversal(struct Node *);
void reverseTraversal(struct Node *);

struct Node* deleteFirst(struct Node*);
struct Node* deleteLast(struct Node*);
struct Node* deleteAt(struct Node *root,int);
void main()
{
    struct Node *ROOT = NULL;
    ROOT = insertAtFirst(ROOT, 56);
    ROOT = insertAtFirst(ROOT, 98);
    ROOT = insertAtFirst(ROOT, 115);
    ROOT = insertAtFirst(ROOT, 89);
    ROOT = insertAtFirst(ROOT, 78);
    ROOT = insertAtFirst(ROOT, 44);
    ROOT = insertAtFirst(ROOT, 10);

    traversal(ROOT);
    // ROOT = insertAt(ROOT, 23, 2);
    // reverseTraversal(ROOT);
     printf("\n");
    ROOT=deleteAt(ROOT,3);
    reverseTraversal(ROOT);


}

// INSERT OPERATIONS:

// Insert At Front Of Linked List
struct Node *insertAtFirst(struct Node *root, int key)
{

    struct Node *ptr = createNode(key);
    if (root == NULL)
        return ptr;

    root->prev = ptr;
    ptr->next = root;
    root = ptr;
    return root;
}

// Insert At Last Of Linked List
struct Node *insertAtLast(struct Node *root, int key)
{

    struct Node *ptr = createNode(key);
    if (root == NULL)
        return ptr;
    struct Node *temp = root;
    while (temp->next != NULL)
    {

        temp = temp->next;
    }

    ptr->prev = temp;
    temp->next = ptr;
    return root;
}

// INSERT KEY AT SPECIFIC INDEX
struct Node *insertAt(struct Node *root, int key, int pos)
{
    struct Node *ptr = createNode(key);
    if (root == NULL)
        return ptr;
    struct Node *temp = root;
    for (int i = 0; i < pos - 1; i++)
    {

        temp = temp->next;
    }

    struct Node *n = NULL;
    n = temp->next;
    temp->next = ptr;
    ptr->prev = temp;

    n->prev = ptr;
    ptr->next = n;
    return root;
}
// CREATE A NEW NODE
struct Node *createNode(int key)
{
    struct Node *ptr = malloc(sizeof(struct Node));
    ptr->data = key;
    ptr->next = NULL;
    ptr->prev = NULL;
    return ptr;
}

// Traverse Complete Linked List
void traversal(struct Node *root)
{
    if (root == NULL)
        return;

    struct Node *ptr = root;
    while (ptr != NULL)
    {
        printf("%d -> ", ptr->data);
        ptr = ptr->next;
    }
}

// Traverse List In Reverse
void reverseTraversal(struct Node *root)
{
    if (root == NULL)
        return;

    struct Node *ptr = root;
    while (ptr->next != NULL)
        ptr = ptr->next;

    while (ptr != NULL)
    {
        printf("%d -> ", ptr->data);
        ptr = ptr->prev;
    }
}

// DELETE OPERATION

// Delete First Node
struct Node *deleteFirst(struct Node *root)
{
    if (root == NULL)
        return NULL;
    if (root->next == NULL)
        return NULL;

    struct Node *temp = NULL, *ptr = root;
    temp = root->next;
    temp->prev = NULL;
    root=temp;

    free(ptr);
    return root;
}

//Delete Last Node
struct Node* deleteLast(struct Node *root){
    if(root==NULL)return NULL;
    struct Node *ptr=root,*temp=NULL;
    while(ptr->next !=NULL)ptr=ptr->next;

    temp=ptr->next;
    temp->prev=NULL;
    ptr->next=NULL;
    free(temp);

    return root;


}

//Delete At POS
struct Node* deleteAt(struct Node *root,int pos){
    if(root==NULL)return NULL;
    struct Node *ptr=root;
    for(int i=0;i<pos-1;i++)ptr=ptr->next;

    struct Node *temp=ptr->next->next,*n=ptr->next;
    temp->prev=ptr;
    ptr->next=temp;
    free(n);
    return root;

    


}