public class Linkedlist {
    public static void main(String[] args) {
        System.out.println("Hello, Linked List!");
        Node head = new Node(10);
        head.next = new Node(20);
        head.next.next = new Node(30);
        print_list pobj = new print_list();
        pobj.print_linkelist(head);
        //Adding 56 at the beginning
        System.out.print("Adding 56 at the beginning\n");
        Add_beginning bobj = new Add_beginning();
        head = bobj.add_at_beg(head, 56);
        pobj.print_linkelist(head);
        //adding 67 at the end
        Add_End eobj = new Add_End();
        head = eobj.add_at_end(head, 67);
        System.out.print("After adding 67 at the end\n");
        pobj.print_linkelist(head);
        // Adding 99 at position 2
        insert_pos insobj = new insert_pos();
        head = insobj.insert_at_pos(head, 99, 2);
        System.out.print("After inserting 99 at position 2\n");
        pobj.print_linkelist(head);
        // Deleting element at position 1
        delete_element delobj = new delete_element();
        head = delobj.delete_element_at_pos(head, 1);   
        System.out.print("After deleting element at position 1\n");
        pobj.print_linkelist(head);
        //Searching for element 20
        search sobj = new search();
        System.out.print("Searching for element 20....\n");
        sobj.search_element(head, 20);

    }
}
class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}
class Add_beginning {
    Node add_at_beg(Node head, int data) {
        Node newnode = new Node(data);
        newnode.next = head;
        head = newnode;
        return head;
    }
}
class Add_End {
    Node add_at_end(Node head, int data) {
        Node temp = head;
        //Adding to an empty list
        if (temp == null) {
            head = new Node(data);
            return head;
        }
        //If temp is not empty
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = new Node(data);
        return head;
    }
}
class insert_pos {
    Node insert_at_pos(Node head, int data, int position) {
        Node newnode = new Node(data);
        Node ptr = head;
        int counter = 1;
        while(counter != position-1) {
            ptr = ptr.next;
            counter++;
        }
        newnode.next = ptr.next;
        ptr.next = newnode;
        return head;
    } 
}
class delete_element {
    Node delete_element_at_pos(Node head, int position) {
        //if list is empty
        if (head == null) {
            System.out.print("List is empty");
            return head;
        }
        //deleting the first node
        if (position == 1) {
            head = head.next;
            return head;
        }
        Node ptr = head;
        Node preptr = null;

        for(int i=1;i<position;i++) {
            if(ptr == null) {
                System.out.print("Position out of bounds");
                return head;
            }
            preptr = ptr;
            ptr = ptr.next;
        }
        preptr.next = ptr.next;
        return head;
    }
}
class search {
    Node search_element(Node head,  int data) {
        Node ptr = head;
        while (ptr !=null) {
            if (ptr.data == data) {
                System.out.print("Element found");
                return ptr;
            }
            ptr = ptr.next;
        }
        System.out.print("Element not found");
        return null;
    }
}
class print_list {
    void print_linkelist(Node head) {
        Node current = head;
        while (current != null) {
            System.out.println(current.data);
            current = current.next;
        }
    }
}

