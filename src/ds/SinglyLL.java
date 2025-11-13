package ds;

public class SinglyLL {
    static class LL{
        Node head;
         class Node{
             String data;
             Node next;

             Node(String data){
                 this.data=data;
                 this.next=null;
             }
         }

         //addFirst
        public void addFirst(String data){
             Node newNode=new Node(data);
             if(head==null){
                 head=newNode;
                 return;
             }
             newNode.next=head;
             head=newNode;
        }
        //addLast
        private void addLast(String data){
            Node newNode=new Node(data);
            if(head==null){
                head=newNode;
                return;
            }
            Node currNode=head;
            while(currNode.next!=null){
                currNode=currNode.next;
            }
            currNode.next=newNode;
        }
        //delete List
        private void deleteFirst(){
             Node currNode=head;
             if(head==null){
                 System.out.println("List is empty");
             }
             head=head.next;
        }
        //deleteLast
        private void deleteLast(){
             if(head==null){
                 System.out.println("The list is empty");
             }
             if(head.next==null){
                 head=null;
                 return;
             }
             Node secondLast=head;
             Node Last=head.next;
             while(Last.next!=null){
                 Last=Last.next;
                 secondLast=secondLast.next;
             }
             secondLast.next=null;
        }

        //print the list
        private void printList(){
            if(head==null){
                System.out.print("List is Empty");
                return;
            }
            Node currNode=head;
            while(currNode!=null){
                System.out.print(currNode.data + "-->");
                currNode=currNode.next;
            }
            System.out.println("NULL");
        }



    }
    public static void main(String[] args) {
     LL list=new LL();
     list.addFirst("B");
     list.addFirst("A");

     list.addLast("C");
     list.printList();
     list.deleteFirst();
     list.printList();
//     list.deleteLast();
//     list.printList();
    }
}