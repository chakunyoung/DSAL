package LinkedList;

public class MyLinkedList<E> implements MyQueue<E>{

    class Node{
        E e; // element
        Node nextNode; // nextNode
    }

    private Node head;
    private Node last;
    private int size = 0;

    // size
    public int size(){
        return size;
    }

    // 유효 index 검증
    public void sizeCheck(int index){
        if(index >= size || index < 0)
            throw new ArrayIndexOutOfBoundsException();
    }

    // index 로 Node 를 찾는다.
    public Node findNode(int findIndex){
        sizeCheck(findIndex);

        Node n = head;
        int index = 0;

        while(index < size){
            if(index == findIndex)
                break;
            n = n.nextNode; // 다음 노드
            index++;
        }

        return n;
    }

    // get
    public E get(int index){
        Node getNode = findNode(index);
        return getNode.e;
    }

    // 순서대로 추가
    public void add(E e){
        Node addNode = new Node();
        addNode.e = e;

        if(size == 0) {
            head = addNode;
            last = addNode;
        }
        else{
            last.nextNode = addNode;
            last = addNode;
        }
        size++;
    }

    // index 로 추가
    public void add(E e, int index){
        sizeCheck(index);

        Node newNode = new Node();
        newNode.e = e;

        if(index == 0){
            if(size == 0)
                last = newNode;

            newNode.nextNode = head;
            head = newNode;
        }else {
            Node previousNode = findNode(index - 1);
            // 여기 사이에 넣는다.
            Node nextNode = previousNode.nextNode;

            previousNode.nextNode = newNode;
            newNode.nextNode = nextNode;
        }
        size++;
    }

    // index 로 삭제
    public E remove(int index){
        sizeCheck(index);

        if(index == 0){
            E returnElement = head.e;
            head = head.nextNode;
            size--;
            return returnElement;
        }else {
            Node previousRemoveNode = findNode(index - 1); // 지워질 노드의 앞까지 이동
            E returnElement = previousRemoveNode.nextNode.e;

            // 지울 노드가 last 인지
            if(previousRemoveNode.nextNode == last){
                last = previousRemoveNode;
            }else {
                Node nnNode = previousRemoveNode.nextNode.nextNode;
                previousRemoveNode.nextNode = nnNode;
            }
            size--;
            return returnElement;
        }
    }


    // Queue 기능 //
    @Override
    public void offer(E e) {
        add(e);
    }
    @Override
    public E poll() {
        return remove(0);
    }


    // 출력용
    public String toString(){
        StringBuilder sb = new StringBuilder();
        Node n = head;
        int index = 0;

        sb.append("[");
        while(index < size){
            sb.append(n.e);
            if(n != last)
                sb.append(", ");
            n = n.nextNode;
            index++;
        }
        sb.append("]");
        return sb.toString();
    }
}


