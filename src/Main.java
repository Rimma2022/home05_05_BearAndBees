public class Main {
    public static Integer pot = 0; // пустой горшок
    public static Object locker = new Object();

    public static void main(String[] args) {
        Bees bees1 = new Bees(locker);
        Thread thread1 = new Thread(bees1);
        thread1.start();

        Bear bear2 = new Bear(locker);
        Thread thread2 = new Thread(bear2);
        thread2.start();

    }
}
