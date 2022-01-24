package lesson_3;

public class PingPong {

    private static Object monitor = new Object();

    public static void main(String[] args) {
        StringPrint ping = new StringPrint("ping ");
        StringPrint pong = new StringPrint("pong ");

        ping.start();
        pong.start();

    }

    public static class StringPrint extends Thread {
        private String stringPrint;

        public StringPrint(String stringPrint) {
            this.stringPrint = stringPrint;
        }

        @Override
        public void run() {
            synchronized (monitor) {
                while (true) {
                    try {

                        System.out.print(stringPrint);
                        Thread.sleep(1000);
                        monitor.notify();
                        monitor.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
