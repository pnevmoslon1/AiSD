public class Queue<T> implements IQueue<T> {
    public Node<T> head;
    public Node<T> last;
    private int size = 0;

    public Queue() {

    }

    public int getSize() {
        return size;
    }

    public void push(T value) {
        if (size == 0) {
            head = new Node<T>(value);
            last = head;
        } else {
            Node<T> newNode = new Node<T>(value);
            last.prev = newNode;
            last = newNode;
        }
        size++;
    }

    public T pop() {
        T res = head.value;
        head = head.prev;
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
            first = first.prev;
        }
        return s;
    }
}
