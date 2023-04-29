/**
 * ApplicationStart.java
 *
 * @author Sergii Kozhushko, sergiikozhushko@gmail.com
 * Date of creation: 29-Apr-2023 15:55
 */

public class ApplicationStart {
    public static void main(String[] args) {
        MyLinkedList myLinkedList = new MyLinkedList();

        myLinkedList.add(10);
        System.out.println(myLinkedList.isEmpty());
        //System.out.println(myLinkedList.contains(6));
        myLinkedList.add(20);
        myLinkedList.add(30);
        myLinkedList.addAt(0, 5);
        //myLinkedList.removeAt(3);
        myLinkedList.print();


    }

}
