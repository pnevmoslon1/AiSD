

public class Main {
    public static void main(String[] args) {
        Queue atd = new Queue();
        System.out.println(atd.isEmpty());
        atd.push(1);
        atd.push(2);
        atd.push(3);
        System.out.println(atd.pop());
        atd.pop();
        System.out.println(atd.isEmpty());
        atd.pop();
    }
}