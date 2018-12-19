package Providers;

import Models.User;

public class UserFactory {
    public User getKowalski() {
        return new User.UserBuilder()
                .setFirstName("Jan")
                .setLastName("Kowalski")
                .setCity("Waw")
                .setCountry("Poland")
                .setPhone("321654987")
                .setAddress("street")
                .setUndefined("wtf")
                .setEmail("j.kowalski@wp.pl")
                .createUser();
    }
}
