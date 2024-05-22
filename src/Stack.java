public class Stack<T> {
    public Node<T> head;
    public Node<T> last;
    private int size = 0;

    public Stack() {

    }

    public Stack(T k) {

    }

    public int getSize() {
        return size;
    }

    public void push(T value) {
        if (size == 0) {
            head = new Node<T>(value);
        } else {
            Node<T> newNode = new Node<T>(value);
            Node<T> oldHead = head;
            head = newNode;
            head.next = oldHead;
        }
        size++;
    }

    public T pop() {
        T res = head.value;
        head = head.next;
        size--;
        return res;
    }

    public T peek() {
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
            first = first.next;
        }
        return s;
    }
}


