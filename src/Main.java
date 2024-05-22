

public class Main {
    public static void main(String[] args) {
        Queue atd = new Queue(3);
        atd.push(new Student(1, "Rinat", "Valiuulin"));
        atd.push(new Student(2, "Vladimir", "Kobin"));
        atd.push(new Student(3, "Kadyshev", "Maksim"));
        System.out.println(atd);
        System.out.println();


//        Stack atd = new Stack(3);
//        atd.push(new Student(5, "Rinat", "Valiuulin"));
//        atd.push(new Student(5, "Vladimir", "Kobin"));
//        atd.push(new Student(5, "Kadyshev", "Maksim"));
//        System.out.println(atd);
//        System.out.println();



//        Deque atd = new Deque(3);
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