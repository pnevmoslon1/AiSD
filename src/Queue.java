public class Queue<T> implements IQueue<T> {
    public Node<T> head;
    public Node<T> last;
    private int count = 0;

    public Queue() {

    }

    public int getCount() {
        return count;
    }

    public void push(T value) {
        if (count == 0) {
            head = new Node<T>(value);
            last = head;
        } else {
            Node<T> newNode = new Node<T>(value);
            last.prev = newNode;
            last = newNode;
        }
        count++;
    }

    public T pop(){
        T res = head.value;
        head = head.prev;
        count--;
        return res;
    }
    public T peek(){
        return head.value;
    }
    public boolean isEmpty(){
        return count == 0;
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
