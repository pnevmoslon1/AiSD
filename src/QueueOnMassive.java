import java.util.Arrays;
public class QueueOnMassive<T> implements IQueue<T>{
    private T[] arr;// Массив
    private int front;// Начало очереди
    private int rear;// Место в очереди
    private int size;// размер массива

    //Конструктор
    public QueueOnMassive(int k){
        arr = (T[]) new Object[k];
        int front = 0;
        int rear = 0;
        int size = 0;
    }
    //Добавление элемента в очередь
    public void push(T elem){
        newArray();
        arr[rear] = elem;
        rear++;
        size++;

    }
    // вывод первого элемента очереди и удаление его
    public T pop(){
        if (isEmpty()) throw new IllegalStateException("Очередь пустая");
        T firstElem = arr[front];
        front++;
        size--;
        return firstElem;
    }

    //Проверка пуста ли очередь
    public boolean isEmpty(){
        return size == 0;
    }

    //Увеличение массива
    public void newArray(){
        if(size == arr.length){
            int newSize = arr.length * 2;
            arr = Arrays.copyOf(arr, newSize);
        }
    }
    //Вывод размера массива
    public int getSize(){
        return size;
    }

    //Вывод первого элемента
    public T peek(){
        return arr[front];
    }

}
