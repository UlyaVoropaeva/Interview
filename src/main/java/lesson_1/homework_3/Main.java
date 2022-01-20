package Interview.lesson_1.homework_3;

public class Main {
    public static void main(String[] args) {

        Figure circle = new Circle();
        Figure square = new Square();
        Figure triangle = new Triangle();

        drawFigure(circle);
        drawFigure(square);
        drawFigure(triangle);

        eraseFigure(circle);
        eraseFigure(square);
        eraseFigure(triangle);
    }

    public static void drawFigure(Figure figure) {
        figure.draw();
    }

    public static void eraseFigure(Figure figure) {
        figure.erase();
    }
}
