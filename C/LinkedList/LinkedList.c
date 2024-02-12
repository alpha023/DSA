#include <stdio.h>
#include <stdlib.h>
struct Node
{
    int data;
    struct Node *next;
};
struct Node *insert(struct Node *, int, int);
void traversal(struct Node *);
int seekLast(struct Node *);
struct Node *insertAtFirst(struct Node *, int);
struct Node *insertAtLast(struct Node *, int);
int length(struct Node *);
struct Node *createNode(int);
struct Node *reverse(struct Node *);
struct Node *mergeLists(struct Node*,struct Node*); 
struct Node *mergeThreeLists(struct Node*,struct Node*,struct Node*);
struct Node* deleteFirst(struct Node*);
struct Node* deleteLast(struct Node*);
struct Node* deleteAt(struct Node*,int);
int detectLoop(struct Node*);
int isContain(struct Node *,int);

struct Node* toBinary(int);
void main()
{

    // struct Node *ROOT1 = NULL, *ROOT2 = NULL,*ROOT=NULL,*ROOT3=NULL;

    // ROOT1 = insertAtLast(ROOT1, 5);
    // ROOT1 = insertAtLast(ROOT1, 8);
    // ROOT1 = insertAtLast(ROOT1, 12);
    // ROOT1 = insertAtLast(ROOT1, 19);
    // ROOT1 = insertAtLast(ROOT1, 56);
    // ROOT1 = insertAtLast(ROOT1, 61);
    // ROOT1 = insertAtLast(ROOT1, 65);

    // ROOT2 = insertAtLast(ROOT2, 15);
    // ROOT2 = insertAtLast(ROOT2, 20);
    // ROOT2 = insertAtLast(ROOT2, 21);
    // ROOT2 = insertAtLast(ROOT2, 47);


    // ROOT3 = insertAtLast(ROOT3, 1);
    // ROOT3 = insertAtLast(ROOT3, 3);
    // ROOT3 = insertAtLast(ROOT3, 4);
    // ROOT3 = insertAtLast(ROOT3, 5);

    // int key=51;
    // int res=isContain(ROOT2,key);
    // if(res==-1)printf("ELEMENT %d Is Not Present !!!!\n");
    // else printf("ELEMENT %d is Present At Index = %d \n",key,res);

    // struct Node *root=createNode(52);
    // struct Node *node1=createNode(25);
    // struct Node *node2=createNode(250);
    // root->next=node1;
    // node1->next=node2;
    // node2->next=node1;

    // printf("%d ",detectLoop(root));


   
    // traversal(ROOT1);
    // // ROOT1=deleteFirst(ROOT1);
    // // ROOT1=deleteLast(ROOT1);
    // //ROOT1=deleteAt(ROOT1,3);
    // printf("\n");
    // traversal(ROOT1);
    struct Node *ptr=toBinary(17);
    traversal(reverse(ptr));


    

}

//insert Node at Specific Index
struct Node *insert(struct Node *root, int key, int pos)
{

    struct Node *temp = createNode(key);
    if (pos == 0)
        return insertAtFirst(root, key);

    struct Node *ptr = root;
    for (int i = 0; i < pos; i++)
    {

        ptr = ptr->next;
    }

    struct Node *t = ptr->next;
    ptr->next = temp;
    temp->next = t;
    return root;
}

//Print All Elements Of Linked List
void traversal(struct Node *root)
{
    if (root == NULL)
        return;
    printf("%d -> ", root->data);
    traversal(root->next);
    // struct Node *ptr=root;
    // while(ptr!=NULL){
    //     printf("%d -> ",ptr->data);
    //     ptr=ptr->next;
    // }
}

// Insert Key At Front Of Linked List
struct Node *insertAtFirst(struct Node *root, int key)
{
    struct Node *ptr = createNode(key);
    if (root == NULL)
        return ptr;
    ptr->next = root;
    return ptr;
}

// Insert Key At The End Of Linked List
struct Node *insertAtLast(struct Node *root, int key)
{

    struct Node *ptr = createNode(key);
    if (root == NULL)
        return ptr;

    struct Node *temp = root;
    while (temp->next != NULL)
        temp = temp->next;

    temp->next = ptr;
    return root;
}

// Return Last Element
int seekLast(struct Node *root)
{
    if (root == NULL)
        return -1;
    else if (root->next == NULL)
        return root->data;
    struct Node *ptr = root;
    while (ptr->next != NULL)
        ptr = ptr->next;
    return ptr->data;
}

// Return First Element
int seekFirst(struct Node *root)
{
    if (root == NULL)
        return (int)NULL;
    return root->data;
}

// Length Of Linked List
int length(struct Node *root)
{
    if (root == NULL)
        return 0;
    struct Node *temp = root;
    int count = 0;
    while (temp != NULL)
    {
        count++;
        temp = temp->next;
    }
    return count;
}

// Reverse The Linked List
struct Node *reverse(struct Node *root)
{
    if (root == NULL)
        return NULL;

    struct Node *prev = NULL, *next = root, *ptr;

    while (ptr != NULL)
    {
        ptr = next->next;
        next->next = prev;
        prev = next;
        next = ptr;
    }
    return prev;
}

// Create A Node
struct Node *createNode(int key)
{
    struct Node *ptr = malloc(sizeof(struct Node));
    ptr->data = key;
    ptr->next = NULL;

    return ptr;
}

//Merge Two Sorted Linked List
struct Node *mergeLists(struct Node *root1, struct Node *root2)
{
    if (root1 == NULL)
        return root2;
    else if (root2 == NULL)
        return root1;

    struct Node *ptr1 = root1, *ptr2 = root2, *root=NULL;
    while ((ptr1 != NULL) && (ptr2 != NULL))
    {

        if ((ptr1->data) < (ptr2->data))
        {
            root = insertAtLast(root, ptr1->data);
            ptr1 = ptr1->next;
        }
        else
        {
            root = insertAtLast(root, ptr2->data);
            ptr2 = ptr2->next;
        }
    }

    if (ptr1 == NULL)
    {
        while (ptr2 != NULL)
        {
            root = insertAtLast(root, ptr2->data);
            ptr2 = ptr2->next;
        }
    }
    else
    {

        while (ptr1 != NULL)
        {
            root = insertAtLast(root, ptr1->data);
            ptr1 = ptr1->next;
        }
    }
    return root;
}

//merge Three Sorted Lists
struct Node* mergeThreeLists(struct Node *root1,struct Node *root2,struct Node *root3){
    struct Node *root12=mergeLists(root1,root2);
    struct Node *root123=mergeLists(root12,root3);

    return root123;
}

//Delete Operations

//DELETE LAST ELEMENT
struct Node* deleteLast(struct Node *root){
    if(root==NULL)return NULL;
    else if(root->next == NULL)return NULL;
    
    struct Node *ptr=root;
    while((ptr->next)->next != NULL){
        ptr=ptr->next;
    }

    struct Node *temp;
    ptr->next=temp;
    ptr->next=NULL;
    free(temp);
    return root;
}

//DELETE FIRST ELEMENT
struct Node* deleteFirst(struct Node *root){
    if(root==NULL)return NULL;
    else if(root->next==NULL) return NULL;

    struct Node *ptr=root;
    root=root->next;
    ptr->next=NULL;
    free(ptr);
    return root;

}

//DELETE ELEMENT AT INDEX=POS
struct Node* deleteAt(struct Node *root,int pos){
    if(root==NULL)return NULL;
    struct Node *ptr=root;
    for(int i=0;i<(pos-1);i++)ptr=ptr->next;
    struct Node *temp=ptr->next;
    ptr->next=(ptr->next)->next;

    free(temp);
    return root;


}

//DETECT LOOP IN LINKED LIST
int detectLoop(struct Node *root){
    if(root==NULL || root->next==NULL) return 0;
    struct Node *slow=root,*fast=root;
    while(fast!=NULL && fast->next != NULL){
        fast=(fast->next)->next;
        slow=slow->next;
        if(fast==slow)return 1;
    }
    return 0;
}

//RETURN -1 if Key Not Present otherwise RETURN INDEX OF KEY
int isContain(struct Node *root,int key){
    if(root==NULL)return -1;
    else if(root->next == NULL) return (root->data == key ? 0:-1);
    int i=0;
    struct Node *ptr=root;
    while(ptr!=NULL){
        if(ptr->data == key)return i;
        i++;
        ptr=ptr->next;
    }
    return -1;
}

//CONVERT DECIMAL TO BINARY
struct Node* toBinary(int num){
    struct Node *ptr=malloc(sizeof(struct Node));

    if(num==1){
        ptr->data=1;
        ptr->next=NULL;
        return ptr;
    }else if(num==0){
        ptr->data=0;
        ptr->next=NULL;
        return ptr;
    }else{
        ptr->next=toBinary(num/2);
        ptr->data=num%2;
        return ptr;
        
    }

}