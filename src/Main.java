

public class Main {
    public static void main(String[] args) {
        Queue atd = new Queue(3);
        atd.push(new Student(5, "Rinat", "Valiuulin"));
        atd.push(new Student(5, "Vladimir", "Kobin"));
        atd.push(new Student(5, "Kadyshev", "Maksim"));
        System.out.println(atd.pop());

    }
}