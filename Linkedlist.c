#include <stdio.h>
#include <stdlib.h>

struct Node {
    int data;
    struct Node* next;
};
//Creatting a linked list node
struct Node* create_linkedlist(int data) {
    struct Node *newnode = malloc(sizeof(struct Node));
    newnode->data = data;
    newnode->next = NULL;
    return newnode;
}
//Adding an element at the beginning
void add_beg(struct Node **head, int data) {
    struct Node* temp = create_linkedlist(data);
    temp->next = *head;
    *head = temp;
}
void insert_end(struct Node *head, int data) {
    struct Node *temp = create_linkedlist(data);
    //if head is null
    if (head == NULL) {
        head = temp;
    }
    //ptr is used to transverse the list
    struct Node *ptr = head;
    while (ptr->next != NULL) {
        ptr = ptr->next;
    }
    ptr->next = temp;
}
//inserting a node at a position
void insert_pos(struct Node *head, int data, int pos) {
    struct Node *temp = create_linkedlist(data);
    struct Node *ptr = head;
    while (pos != 2) {
        ptr = ptr->next;
        pos--;
    }
    temp->next = ptr->next;
    ptr->next = temp;
}
void del_node(struct Node **head, int pos) {
    struct Node *ptr = *head;
    struct Node *preptr = NULL;
    if (*head == NULL) {
        printf("List is empty\n");
        return;
    }
    //Deleting the first node
    if (pos == 1) {
        *head = ptr->next;
        free(ptr);
        return;
    }
    for(int i=1;i<pos;i++) {
        if(ptr == NULL) {
            printf("Position out of bounds\n");
            return;
        }
        preptr = ptr;
        ptr = ptr->next;
    }
    preptr->next = ptr->next;
    free(ptr);
    return;
}
int search_element(struct Node *head) {
    int element;
    printf("Enter the element to search: \n");
    scanf("%d", &element);
    struct Node *ptr = head;
    //searching for the element
    while (ptr != NULL) {
        if ( ptr->data == element) {
            printf("Element found!\n");
            return 1;
        }
        ptr = ptr->next;
    }
    printf("Element not found!\n"); 
    return 0;
}
//Displaying the linked list
void display_list(struct Node *head) {
    struct Node *ptr = head;
    while(ptr != NULL) {
        printf("%d -> ", ptr->data);
        ptr = ptr->next;
    }
    printf("NULL\n");
}

int main(){
    struct Node *head = create_linkedlist(10);
    insert_end(head, 20);
    printf("After adding 20 to the end:\n");
    display_list(head);
    add_beg(&head, 23);
    printf("After adding 23 to the beginning:\n");
    display_list(head);
    insert_pos(head, 15, 2);
    printf("After inserting 15 at position 2:\n");
    display_list(head);
    del_node(&head, 2);
    printf("After deleting node at position 2:\n");
    display_list(head);
    search_element(head);
    return 0;
}
