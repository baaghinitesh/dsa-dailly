import java.util.Scanner;
public class linkList {
    class node {
        int data;
        node next;

        //constructor to initialize node
        node(int data){
            this.data = data;
            this.next = null;
        }
    }

    node head;
    int countLinkList = 0; // keep tracking the number of nodes in the linked list
    
    // method to create a node and add it to the end of the list
    public void addEnd(int data){
        node newNode = new node(data);
        if(head == null){
            head = newNode;
        } else {
            node current = head;
            while(current.next != null){
                current = current.next;
            }
            current.next = newNode;
        }
        countLinkList++; // Increment count on each node addition
    }

    // method to create a node and add it to the beginning of the list
    public void addStart(int data){
        node newNode = new node(data);
        newNode.next = head;
        head = newNode;
        countLinkList++; // Increment count on each node addition
    }

    // method to display the linked list
    public void display(){
        node current = head;
        while(current !=null){
            System.err.print(current.data + " --> ");
            current = current.next;
        }
        System.err.println("null");
    }

    // method to get the count of nodes in the linked list
    public int getCount() {
        return countLinkList;
    }

    // main method to test the linked list
    public static void main(String[] args) {
        linkList list = new linkList();
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the number of nodes you want to add:");
        int n = input.nextInt();
        for(int i=0; i<n; i++){
            System.err.println("Enter data for node " +  (i+1) + ":");
            int data = input.nextInt();
            list.addEnd(data);
        }

        System.out.println("The linked list is:");
        list.display();

        System.out.println("The number of nodes in the linked list is: " + list.getCount());    
        input.close();

    }
}
