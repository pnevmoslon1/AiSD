public interface IQueue<T>{
    boolean isEmpty();
    void push(T elem);
    T pop();
    T peek();
    String toString();
    int getSize();
}