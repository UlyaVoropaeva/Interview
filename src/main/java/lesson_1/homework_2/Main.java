package Interview.lesson_1.homework_2;

public class Main {

    interface Moveable {
        void move();
    }

    interface Stopable {
        void stop();
    }


    abstract class Car { // public abstract class Car - если хотим использовать вне пакета
        // private Engine engine;  - лучше использовать private, чем public
        // класс Engine не реализован, нужно будет его создать public class Engine {}
        public Engine engine;
        private String color;
        private String name;


        // Класс Car  абстрактный, метод start скомпилируется, но его невозможно будет переопределить
        // лучше реализовать данный метод либо как абстрактный метод или реализовать как отдельно интерфейсом
        protected void start() {
            System.out.println("Car starting");
        }

        abstract void open(); // public abstract void open(); - если хотим использовать вне пакета

        public Engine getEngine() {
            return engine;
        }

        public void setEngine(Engine engine) {
            this.engine = engine;
        }

        public String getColor() {
            return color;
        }

        public void setColor(String color) {
            this.color = color;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    class LightWeightCar extends Car implements Moveable{

        @Override
        void open() {
            System.out.println("Car is open");
        }

        @Override
        public void move() {
            System.out.println("Car is moving");
        }

    }

0 // здесь не нужен 0

    // Moveable, Stopable - interface

    class Lorry extends Car, Moveable, Stopable{ // здесь должно быть: class Lorry extends Car implements Moveable, Stopable{


            public void move(){
            System.out.println("Car is moving");
        }

        public void stop(){
            System.out.println("Car is stop");
        }
    /*
    Так как implements Moveable и класс Lorry не абстрактный, класс Lorry обязан реализовать метод интерфейса Moveable

        @Override
        void open() {

        }

     */
      }

}
