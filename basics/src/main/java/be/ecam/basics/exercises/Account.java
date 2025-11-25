package be.ecam.basics.exercises;

import java.util.Objects;

public class Account {

    // balance stocké en centimes pour éviter les erreurs de double
    private int balanceInCents;

    public Account() {
        this(0.0);
    }

    public Account(double initial) {
        this.balanceInCents = toCents(initial);
    }

    private int toCents(double amount) {
        return (int) Math.round(amount * 100);
    }

    public double getBalance() {
        return balanceInCents / 100.0;
    }

    public void deposit(double amount) {
        if (amount < 0) throw new IllegalArgumentException("amount");
        balanceInCents += toCents(amount);
    }

    public void withdraw(double amount) {
        if (amount < 0) throw new IllegalArgumentException("amount");
        int cents = toCents(amount);
        if (cents > balanceInCents) throw new IllegalStateException("insufficient");
        balanceInCents -= cents;
    }

    public void transferTo(Account other, double amount) {
        Objects.requireNonNull(other, "other");
        withdraw(amount);
        other.deposit(amount);
    }
}
