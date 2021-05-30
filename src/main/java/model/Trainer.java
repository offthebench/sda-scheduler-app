package model;

import java.util.Date;

public class Trainer extends Person {

    private boolean isAuthorized;

    public Trainer(String firstName,
                   String lastName,
                   Date dateOfBirth,
                   boolean isAuthorized) {
        super(firstName, lastName, dateOfBirth);
        this.isAuthorized = isAuthorized;
    }

    public boolean isAuthorized() {
        return isAuthorized;
    }

    public void setAuthorized(boolean authorized) {
        isAuthorized = authorized;
    }
}