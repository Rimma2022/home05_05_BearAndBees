public class Bear implements Runnable{
    Object locker;
    public Bear(Object locker) {
        this.locker = locker;
    }
    @Override
    public void run() {
        synchronized (locker) {
            try {
                locker.wait(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Медведь проснулся");
        while (Main.pot > 0) {
            synchronized (Main.locker) {
                Main.pot--;
            }

            System.out.println("Медведь съел порцию меда, в горшке осталось: " + Main.pot + " грамм");
        }
        System.out.println("Медведь съел весь мед!");


    }
}
