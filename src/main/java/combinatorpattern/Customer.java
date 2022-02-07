package combinatorpattern;

import java.time.LocalDate;

public class Customer {
    private final String name;
    private final String email;
    private final String phoneNumber;
    private final LocalDate doB;

    public Customer(String name, String email, String phoneNumber, LocalDate doB) {
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.doB = doB;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public LocalDate getDoB() {
        return doB;
    }
}
