public class Bees implements Runnable{
    Object locker;
    public Bees(Object locker) {
        this.locker = locker;
    }

    @Override
    public void run() {
        for (int N = 1; N <= 10; N++) {
            synchronized (Main.locker) {
                Main.pot++;
            }
            System.out.println("Пчела " + N + " принесла 1 порцию меда\n В горшке " + Main.pot + " грамм меда");

        }
        if (Main.pot == 10 ) {
            System.out.println("Горшок полон!");
            synchronized (locker) {
                try {
                    locker.notify();
                    locker.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
