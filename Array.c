#include <stdio.h>

void create_arr(int arr[],int size){
    for(int i=0;i<size;i++){
        printf("Enter element %d:", i+1);
        scanf("%d", &arr[i]);
    }
}
void add_element(int arr[], int *size){
    printf("\nEnter the element to be added:");
    int element;
    scanf("%d", &element);
    //adding at the end of the array
    arr[*size]=element;
    (*size)++;//updating the size of the array
    return;
}
void insert_element(int arr[],int *size, int index, int element){
    for(int i=*size;i>index;i--){
        arr[i]=arr[i-1];
    }
    arr[index] = element;
    (*size)++;//updating size of the list
    return;
}
void del_element(int arr[], int *size){
    printf("\nEnter the element to be deleted:");
    int element;
    scanf("%d", &element);
    for(int i=0;i<*size;i++){
        if (arr[i] == element){
            for(int j=i;j<*size-1;j++){
                arr[j] = arr[j+1];
            }
        }
    }
    (*size)--;//updating the size of the array
    return;
}
void find_element(int arr[], int size){
    printf("\nEnter the element to be found:");
    int element;
    scanf("%d", &element);
    for(int i=0;i<size;i++){
        if (arr[i]==element){
            printf("Element found at position %d", i+1);
        }
    }
    return;
}
void display_arr(int arr[], int size){
    for(int i=0;i<size;i++){
        printf("%d ", arr[i]);
    }
    return ;
}

int main(){
    //Getting the array size from the user
    int size;
    printf("Enter the number of elements in your array:");
    scanf("%d", &size);
    int arr[100];
    create_arr(arr, size);
    
    del_element(arr, &size);
    display_arr(arr, size);
    find_element(arr, size);
    del_element(arr, &size);
    display_arr(arr, size);
    add_element(arr, &size);
    display_arr(arr, size);
    insert_element(arr, &size, 2, 10);
    display_arr(arr, size);

    
    return 0;
}
