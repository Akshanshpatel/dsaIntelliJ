package ds;

import java.util.*;

public class DoublyLL {
    static class Node {
        String data;
        Node prev;
        Node next;

        Node(String data) {
            this.data = data;
            this.prev = null;
            this.next = null;
        }
    }

    static class DLL {
        Node head;

        // Function to reverse a Doubly Linked List
        public void reverseDLL() {
            Stack<String> st = new Stack<>();
            Node temp = head;

            // Push all node data into the stack
            while (temp != null) {
                st.push(temp.data);
                temp = temp.next;
            }

            // Reassign data while popping from stack
            temp = head;
            while (temp != null) {
                temp.data = st.pop();
                temp = temp.next;
            }
        }

        // Function to insert a node at the end
        public void insertAtEnd(String data) {
            Node newNode = new Node(data);
            if (head == null) {
                head = newNode;
                return;
            }
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
            newNode.prev = temp;
        }

        // Function to print the list
        public void printList() {
            Node temp = head;
            while (temp != null) {
                System.out.print(temp.data + " <-> ");
                temp = temp.next;
            }
            System.out.println("null");
        }
    }

    public static void main(String[] args) {
        DLL dll = new DLL();

        dll.insertAtEnd("A");
        dll.insertAtEnd("B");
        dll.insertAtEnd("C");

        System.out.println("Original DLL:");
        dll.printList();

        dll.reverseDLL();

        System.out.println("Reversed DLL:");
        dll.printList();
    }
}
