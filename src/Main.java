import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        DequeMy atd = new DequeMy();
        //Deque<Integer> atd  = new LinkedList<>();

        for (long i = 1; i <= 1000; i+=10) {
            atd =  new DequeMy();
            long startTime = System.nanoTime();

            for (long j = 0; j < 1000 * i; j++) {
                Random random = new Random();
                atd.pushTail(random.nextInt());
            }
            long duration = System.nanoTime() - startTime;
            System.out.println(duration);
        }





//        Queue atd = new Queue(3);
//        atd.push(new Student(1, "Rinat", "Valiuulin"));
//        atd.push(new Student(2, "Vladimir", "Kobin"));
//        atd.push(new Student(3, "Kadyshev", "Maksim"));
//        System.out.println(atd);
//        System.out.println();


//        Stack atd = new Stack(3);
//        atd.push(new Student(5, "Rinat", "Valiuulin"));
//        atd.push(new Student(5, "Vladimir", "Kobin"));
//        atd.push(new Student(5, "Kadyshev", "Maksim"));
//        System.out.println(atd);
//        System.out.println();



//        DequeMy atd = new DequeMy(3);
//        atd.pushHead(new Student(5, "Rinat", "Valiuulin"));
//        atd.pushHead(new Student(5, "Vladimir", "Kobin"));
//        atd.pushTail(new Student(5, "Kadyshev", "Maksim"));
//        System.out.println(atd);
//        System.out.println();

//        HashTable myTable = new HashTable(10);
//
//        myTable.insert("Elena", "Golovach");
//        myTable.insert("Slava", "Marlow");
//        myTable.insert("Vitya", "Otvertka");
//
//        String value = myTable.get("Elena");
//        System.out.println("Значение по ключу 'Elena': " + value);



    }
}