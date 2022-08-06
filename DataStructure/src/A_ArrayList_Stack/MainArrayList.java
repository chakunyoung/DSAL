package A_ArrayList_Stack;

public class MainArrayList {
    public static void main(String[] args) {
        MyArrayList<Integer> list = new MyArrayList<Integer>();

        list.add(5);
        list.add(10);
        list.add(15);

        list.add(50, 0);
        list.add(100,3);
        list.add(1, 4);

        System.out.println(list);
        System.out.println(list.size());
        System.out.println("get: " + list.get(3));
        System.out.println();

        list.remove(2);
        System.out.println(list);
        list.remove(3);
        System.out.println(list);
        System.out.println(list.size() + "\n");

        MyStack<Integer> s = new MyArrayList<Integer>();
        s.push(10);
        s.push(20);
        s.push(30);

        System.out.println("stack size: " + s.size());

        s.pop();
        s.pop();
        System.out.println(s.pop());
        s.push(100);
        System.out.println(s.peek());

    }
}
