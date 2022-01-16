package Interview.lesson_1.homework_1;

public class Main {
    public static void main(String[] args) {

        Person person = new Person.Builder()
                .addFirstName("Иван")
                .addLastName("Иванов")
                .addMiddleName("Иванович")
                .addCountry("Россия")
                .addAddress("Москва")
                .addPhone("777")
                .addAge(25)
                .addGender("m")
                .build();

        System.out.println(person.toString());
    }
}
