package ZZH.padroesdeprojetos.dominio;

public class Person {
    private String firstName;
    private String lastName;
    private String username;
    private String email;


    public static final class PersonBuilder {
        private String firstName;
        private String lastName;
        private String username;
        private String email;

        public static PersonBuilder builder() {
            return new PersonBuilder();
        }

        public PersonBuilder firstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public PersonBuilder lastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public PersonBuilder username(String username) {
            this.username = username;
            return this;
        }

        public PersonBuilder email(String email) {
            this.email = email;
            return this;
        }

        public Person build() {
            Person person = new Person();
            person.email = this.email;
            person.username = this.username;
            person.firstName = this.firstName;
            person.lastName = this.lastName;
            return person;
        }
    }

    public String getName(){
        return this.firstName + " " + this.lastName;
    }
}
