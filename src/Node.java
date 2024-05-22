public  class  Node<T> {
    public T value;
    public Node<T> prev;

    public Node<T> next;


    public Node(T val){
        this.prev = null;
        this.next = null;
        this.value = val;
    }
}
