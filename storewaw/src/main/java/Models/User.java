package Models;

public class User {
    private String firstName;
    private String lastName;
    private String city;
    private String country;
    private String address;
    private String phone;
    private String undefined;
    private String email;

    private User(String firstName, String lastName, String city, String country, String address, String phone, String undefined, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.city = city;
        this.country = country;
        this.address = address;
        this.phone = phone;
        this.undefined = undefined;
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getCity() {
        return city;
    }

    public String getCountry() {
        return country;
    }

    public String getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }

    public String getUndefined() {
        return undefined;
    }

    public String getEmail() {
        return email;
    }

    public static class UserBuilder {
        private String firstName;
        private String lastName;
        private String city;
        private String country;
        private String address;
        private String phone;
        private String undefined;
        private String email;

        public UserBuilder() {
        }

        public UserBuilder setFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public UserBuilder setLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public UserBuilder setCity(String city) {
            this.city = city;
            return this;
        }

        public UserBuilder setCountry(String country) {
            this.country = country;
            return this;
        }

        public UserBuilder setAddress(String address) {
            this.address = address;
            return this;
        }

        public UserBuilder setPhone(String phone) {
            this.phone = phone;
            return this;
        }

        public UserBuilder setUndefined(String undefined) {
            this.undefined = undefined;
            return this;
        }

        public UserBuilder setEmail(String email) {
            this.email = email;
            return this;
        }

        public User createUser() {
            return new User(firstName, lastName, city, country, address, phone, undefined, email);
        }
    }
}