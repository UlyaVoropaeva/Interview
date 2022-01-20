import java.util.Date;
import java.util.Random;

public class Main {
    public static void main(String[] args) {

        MyLinkedList<Integer> mll = new MyLinkedList<>();

        mll.insertFirst(5);
        mll.insertFirst(25);
        mll.insertFirst(55);
        mll.insertFirst(56);
        mll.insertFirst(55);
        mll.insertFirst(35);

        System.out.println(mll);
        System.out.println(mll.lastIndexOf(55));
        System.out.println(mll.indexOf(55));


        System.out.println("Selection sort begin");
        Date start = new Date();
        arrayCreator().selectionSort();
        Date finish = new Date();
        System.out.println("Selection sort finished. Time: " + (finish.getTime() - start.getTime()));
        System.out.println();

    }

    public static MyArrayList<Integer> arrayCreator() {
        Random r = new Random();
        MyArrayList<Integer> mal = new MyArrayList<>(100000);
        for (int i = 0; i < 100000; i++) {
            mal.add(r.nextInt(10000000));
        }

        return mal;
    }
}
