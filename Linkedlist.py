class Linked_list:
    def __init__(self, data):
        self.data = data
        self.next = None

def create_LinkedList(data):
    newnode = Linked_list(data)
    newnode.data = data
    newnode.next = None
    return newnode
#adding element at the beginning
def add_beg(head, temp):
    temp.next = head
    head = temp
    return head
#adding element at the end
def insert_end(head, temp):
    if(head == None):
        head = temp
        return head
    #ptr is the pointer used to transverse the list upto the end
    ptr = head
    while(ptr.next != None):
        ptr = ptr.next
    ptr.next = temp
    return head
#inserting element at a given position
def insert_pos(head, temp, pos):
    ptr = head
    #pos = pos-1
    #this while loop transverses the list upto the position where we want to insert the new node
    while(pos != 2):
        ptr = ptr.next
        pos -= 1
    temp.next = ptr.next
    ptr.next = temp
    return head
#Function to delete a node at a given position
def del_node(head, pos):
    ptr = head
    preptr = head 
    if head == None:
        print("List is empty")
    if (pos == 1):
        head = ptr.next
        ptr = None
        return head
    i = 1
    for i in range(pos-1):
        preptr = ptr
        ptr = ptr.next

        if ptr is None:
            print("Position out of bounds")
            return head
    preptr.next = ptr.next
    ptr = None
    return head
#function to search for an element
def search_element(head):
    element = int(input("Enter the element to search: "))
    ptr = head
    while(ptr != None):
        if(ptr.data == element):
            print("Element found!")
            return
        ptr = ptr.next
    print("Element not found!")
    return
#function to display the linked list
def display(head):
    ptr = head
    while(ptr != None):
        print(ptr.data, end="->")
        ptr = ptr.next
    print("None")


head = create_LinkedList(10)
head.next = create_LinkedList(40)
head.next.next = create_LinkedList(70)
head.next.next.next = create_LinkedList(450)

display(head)
print("After adding 5 to the beginning:")
head = add_beg(head, temp=create_LinkedList(5))
display(head)
print("After adding 90 to the end:")
head = insert_end(head, temp=create_LinkedList(90))
display(head)
print("After inserting 25 at position 3:")
head = insert_pos(head, temp=create_LinkedList(25), pos=3)
display(head)
print("After deleting node at position 3:")
head = del_node(head, pos=3)
display(head)
search_element(head)