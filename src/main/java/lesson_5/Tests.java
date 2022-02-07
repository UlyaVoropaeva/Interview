package lesson_5;

import lesson_5.entity.Student;
import lesson_5.util.HibernateUtil;
import lesson_5.service.StudentDAO;
import lesson_5.service.StudentServiceImpl;
import org.hibernate.SessionFactory;

import java.util.List;

public class Tests {

    private StudentServiceImpl studentService;

    public Tests() {
        SessionFactory factory = HibernateUtil.getSessionFactory();
        StudentDAO repository = new StudentDAO(factory);
        studentService = new StudentServiceImpl(repository);
    }

    public void start() {

        System.out.println("\nСоздаем список из 10 студентов и добавляем в БД...");
        for (int i = 1; i <= 10; i++) {
            studentService.add(new Student("Student_" + i, "#_" + (Math.random() * 10)));
        }
        studentService.printTotalCount();
        System.out.println("\nУдаляем список из 10 студентов из БД...");
        studentService.deleteAll();
        studentService.printTotalCount();
        System.out.println();

        System.out.println("\nСоздаем новый список из 1000 студентов и добавляем в БД...");
        for (int i = 1; i <= 1000; i++) {
            studentService.add(new Student("Student_" + i, "#_" + (Math.random() * 10)));
        }
        studentService.printTotalCount();
        List<Student> studentsList = studentService.findAll();
        Long id = studentsList.get(2).getId();
        System.out.println("\nУдаление 3 записи в таблице, Student_Id = " + id);
        studentService.deleteById(id);
        String newName = "0000";
        studentsList = studentService.findAll();
        Student student = studentsList.get(studentsList.size() - 2);
        System.out.println("\nИзменить имя предпоследнего в списке студента...");
        id = student.getId();
        System.out.println("\nстарое имя – " + student.getName() + " новое имя – " + newName);
        studentService.rename(id, newName);
        System.out.println(studentService.getById(id));
        studentService.printTotalCount();
        System.out.println("\nУдалить все записи из таблицы...");
        studentService.deleteAll();
        System.out.println("\nЗакрыть фабрику HibernateUtil...");
        HibernateUtil.shutdown();
    }
}