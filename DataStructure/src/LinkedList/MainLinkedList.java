package LinkedList;

import java.util.Queue;

public class MainLinkedList {
    public static void main(String[] args) {

        MyLinkedList<Integer> myLinkedList = new MyLinkedList<>();

        myLinkedList.add(5);
        myLinkedList.add(10);
        myLinkedList.add(15, 1);
        myLinkedList.add(100, 0);
        System.out.println(myLinkedList);
        System.out.println(myLinkedList.size());
        myLinkedList.remove(1);
        System.out.println(myLinkedList);
        System.out.println(myLinkedList.size());
        myLinkedList.remove(0);
        System.out.println(myLinkedList);
        System.out.println(myLinkedList.size());

        myLinkedList.add(100);
        System.out.println(myLinkedList);


        System.out.println("\n//  큐  //");
        MyQueue<Integer> myQueue = new MyLinkedList<>();
        myQueue.offer(5);
        myQueue.offer(10);
        myQueue.offer(15);
        myQueue.offer(20);
        myQueue.poll();

        System.out.println(myQueue);
        System.out.println(myQueue.size());

    }
}
