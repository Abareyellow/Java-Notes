import java.time.LocalDate;

public class Person {
    private final String firstName;
    private final String middleName;
    private final String lastName;
    private final LocalDate dateOfBirth;
    private final String emailAddress;
    private final String phoneNumber;

    private Person(PersonBuilder personBuilder) throws IllegalAccessException {
        firstName = personBuilder.firstName;
        middleName = personBuilder.middleName;
        lastName = personBuilder.lastName;
        dateOfBirth = personBuilder.dateOfBirth;
        emailAddress = personBuilder.emailAddress;
        phoneNumber = personBuilder.phoneNumber;
        if (firstName == null || lastName == null) {
            throw new IllegalAccessException("First name and last name must not be null!!");
        }
    }

    @Override
    public String toString() {
        return "Person{" + "First Name: " + firstName + ", Last Name: " +  lastName + ", Date of Birth: " + dateOfBirth + "}";
    }

    public static class PersonBuilder {
        private final String firstName;
        private String middleName;
        private final String lastName;
        private LocalDate dateOfBirth;
        private String emailAddress;
        private String phoneNumber;

        public PersonBuilder(String firstName, String lastName) {
            this.firstName = firstName;
            this.lastName = lastName;
        }

        public PersonBuilder middleName(String middleName) {
            this.middleName = middleName;
            return this;
        }

        public PersonBuilder dateOfBuilder(LocalDate date) {
            this.dateOfBirth = date;
            return this;
        }

        public PersonBuilder emailAddress(String email) {
            this.emailAddress = email;
            return this;
        }

        public PersonBuilder phoneNumber(String phone) {
            this.phoneNumber = phone;
            return this;
        }

        public Person build() throws IllegalAccessException {
            return new Person(this);
        }
    }
}