package A_ArrayList_Stack;

/*
buffer size 조절은 구현하지 않음
 */
public class MyArrayList <E> implements MyStack<E>{

    private E[] array;
    private int size = 0;
    private int bufferSize = 50;

    public MyArrayList(){
        array = (E[]) new Object[bufferSize];
    }

    public int size(){
        return size;
    }

    public void sizeCheck(int index){
        if(index < 0 || size <= index)
            throw new ArrayIndexOutOfBoundsException();
    }

    public E get(int index){
        sizeCheck(index);
        return array[index];
    }

    public void add(E e){
        array[size++] = e;
    }

    public void add(E e, int index){
        sizeCheck(index);
        arrange(index, true);
        array[index] = e;
        size++;
    }

    public void remove(int index){
        sizeCheck(index);
        arrange(index, false);
        size--;
    }

    public void arrange(int index, boolean fb){
        if(fb) { // add
            int copyIndex = size - 1;
            while (copyIndex >= index) {
                array[copyIndex + 1] = array[copyIndex];
                copyIndex--;
            }
        }else { // remove
            while(index < size){
                array[index] = array[index + 1];
                index++;
            }
        }
    }


    // Stack //
    // 메서드를 호출해서 O(1)으론 동작하지 않음
    @Override
    public void push(E e) {
        add(e);
    }

    @Override
    public E pop() {
        E e = array[size - 1];
        remove(size - 1);
        return e;
    }

    public E peek(){
        return get(size - 1);
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        int index = 0;
        sb.append("[");
        while(index < size){
            sb.append(array[index]);
            if(index != size - 1)
                sb.append(", ");
            index++;
        }
        sb.append("]");
        return sb.toString();
    }
}
