def create_arr(arr, size):
    for i in range(size):
        i = int(input("Enter element: "))
        arr.append(i)
def add_element(arr, element):
    element = int(input("\nEnter the element to be added: "))
    arr.append(element)
    return
def insert_element(arr, index, element):
    print("\nInserting element...")
    arr.insert(index, element)
    return arr
def del_element(arr, index):
    new_arr = []
    for i in range(get_size(arr)):
        if i != index:
            new_arr.append(arr[i])
    return new_arr

def find_element(arr, element):
    print("\nfinding element...\n")
    for i in arr:
        if i==element :
            print("Element found!")
    else:
        print("Element not found!")
    return

def display(arr):
    for i in arr:
        print(i, end=" ")
def get_size(arr):
    return len(arr)
    
size = int(input("Enter the size of the array:"))
arr = []
create_arr(arr, size)
display(arr)
add_element(arr, 7)
display(arr)
insert_element(arr, 2, 10)
display(arr)
find_element(arr, 8)

