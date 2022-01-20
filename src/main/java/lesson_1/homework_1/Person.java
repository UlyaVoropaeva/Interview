package Interview.lesson_1.homework_1;

public class Person {

    private String firstName;
    private String lastName;
    private String middleName;
    private String country;
    private String address;
    private String phone;
    private int age;
    private String gender;


    public static class Builder {
        private Person newPerson;

        public Builder() {
            newPerson = new Person();
        }

        public Builder addFirstName(String firstName){
            newPerson.firstName = firstName;
            return  this;
        }
        public Builder addLastName(String lastName){
            newPerson.lastName = lastName;
            return  this;
        }

        public Builder addMiddleName(String middleName){
            newPerson.middleName = middleName;
            return  this;
        }

        public Builder addCountry(String country){
            newPerson.country = country;
            return  this;
        }

        public Builder addAddress(String address){
            newPerson.address = address;
            return  this;
        }

        public Builder addPhone(String phone){
            newPerson.phone = phone;
            return  this;
        }
        public Builder addAge(int age){
            newPerson.age = age;
            return  this;
        }
        public Builder addGender(String gender){
            newPerson.gender = gender;
            return  this;
        }

        public Person build() {
            return newPerson;
        }
    }

    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", country='" + country + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                '}';
    }
}
