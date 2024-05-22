public class Deque<T> {
    public Node<T> head;
    public Node<T> tail;
    private int size = 0;

    public Deque() {

    }

    public Deque(T k) {

    }

    public int getSize() {
        return size;
    }

    public void pushHead(T value) {
        if (size == 0) {
            head = new Node<T>(value);
            tail = head;
        } else {
            Node<T> newNode = new Node<T>(value);
            Node<T> oldHead = head;
            oldHead.next = newNode;
            head = newNode;
            head.prev = oldHead;
        }
        size++;
    }

    public void pushTail(T value) {
        if (size == 0) {
            tail = new Node<T>(value);
            head = tail;
        } else {
            Node<T> newNode = new Node<T>(value);
            Node<T> oldTail = tail;
            oldTail.prev = newNode;
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }

    public T popHead() {
        T res = head.value;
        head = head.prev;
        size--;
        return res;
    }

    public T popTail() {
        T res = tail.value;
        head = head.next;
        size--;
        return res;
    }

    public T peekHead() {
        return head.value;
    }

    public T peekTail() {
        return head.value;
    }

    public boolean isEmpty() {
        return size == 0;
    }


    @Override
    public String toString() {
        Node<T> first = head;
        String s = "";
        while (first != null) {
            s += first.value + " ";
            first = first.prev;
        }
        return s;
    }
}
