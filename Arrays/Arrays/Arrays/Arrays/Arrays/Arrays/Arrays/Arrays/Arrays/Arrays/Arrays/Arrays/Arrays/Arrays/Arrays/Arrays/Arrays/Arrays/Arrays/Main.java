import java.util.Scanner;//scanner is used to take input from the user

public class Main {
    public static void main(String[] arg) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Hello world");
        System.out.println("Enter the size of the array: ");
        int size = sc.nextInt();
        int arr[] = new int[100];
        create_arr obj = new create_arr();
        obj.create(arr, size);
        display_arr dobj = new display_arr();
        dobj.display_array(arr, size);
        add_element aobj = new add_element();
        size = aobj.add_elem(arr, size);
        dobj.display_array(arr, size);
        insert_element iobj = new insert_element();
        size = iobj.insert_elem(arr, size);
        dobj.display_array(arr, size);
        del_element dobj2 = new del_element();
        size = dobj2.del_elem(arr, size);
        dobj.display_array(arr, size);
        find_element fobj = new find_element();
        fobj.find_elem(arr, size);
        sc.close();
        
    }
}
class create_arr {
    public void create(int arr[], int size){
    Scanner sc = new Scanner(System.in);
    for(int i=0;i<size;i++){
        System.out.println("Enter element "+(i+1)+":");
        arr[i] = sc.nextInt();
    }
    }
}
class add_element {
    int add_elem(int arr[], int size) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the element to be added: ");
        int element = sc.nextInt();
        arr[size] = element;
        size++;
        return size;
    }

}
class insert_element {
    int insert_elem(int arr[], int size) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the element to add: ");
        int element = sc.nextInt();
        System.out.print("Enter index you want the element to be added:");
        int index = sc.nextInt();
        for(int i=size;i>index;i--){
            arr[i] = arr[i-1];
        }
        arr[index] = element;
        size++;
        return size;
    }

}
class del_element {
    int del_elem(int arr[], int size) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the element to delete: ");
        int element = sc.nextInt();
        for(int i=0;i<size;i++){
            if (arr[i] == element){
                for(int j=i;j<size-1;j++){
                    arr[j] = arr[j+1];
                }
            }
        }
        size--;
        return size;
    }

}
class find_element {
    void find_elem(int arr[], int size) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the element to find: ");
        int element = sc.nextInt();

        for(int i=0;i<size;i++){
            if (arr[i] == element){
                System.out.print("ELement found at index:" + i);
            }
        }
    }

}
class display_arr {
    void display_array(int arr[], int size){
    for(int i=0;i<size;i++){
        System.out.println("Element "+(i+1)+": "+arr[i]);
        }
    }
}