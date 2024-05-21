public  class  Node<T> {
    public T value;
    public Node<T> prev;


    public Node(T val){
        this.prev = null;
        this.value = val;
    }
}
