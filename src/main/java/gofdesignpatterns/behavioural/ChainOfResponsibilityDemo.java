package gofdesignpatterns.behavioural;

class Currency{
    int amount;
    String name;

    public int getAmount() {
        return amount;
    }

    public String getName() {
        return name;
    }

    public Currency(int amount, String name) {
        this.amount = amount;
        this.name = name;
    }
}

interface CurrencyDispenser {
    public CurrencyDispenser getNextDispenser();
    public void dispense(Currency currency);
}

abstract class AbstractDispenser implements CurrencyDispenser{

    abstract int getValue();

    public void dispense(Currency currency) {
        int count  = currency.getAmount()/getValue();
        System.out.println("Dispensed : " + currency.getName() + getValue() + " X " + count);
        int remaining = currency.getAmount() % getValue();
        if(remaining != 0) {
            if (this.getNextDispenser() != null)
                this.getNextDispenser().dispense(new Currency(remaining, currency.getName()));
            else
                System.out.println("Enter an amount in multiples of 100.");
        }
    }
}

class Dispenser extends AbstractDispenser implements CurrencyDispenser {

    final int value;
    CurrencyDispenser nextDispenser;

    public Dispenser(int value, CurrencyDispenser currencyDispenser) {
        this.value = value;
        this.nextDispenser = currencyDispenser;
    }

    public CurrencyDispenser getNextDispenser() {
        return nextDispenser;
    }

    @Override
    int getValue() {
        return this.value;
    }
}

public class ChainOfResponsibilityDemo {

    public static void main(String args[]) {
        Currency currency = new Currency(1705, "₹");
        CurrencyDispenser ₹1000Dispenser = new Dispenser(1000, new Dispenser(500, new Dispenser(100, null)));
        ₹1000Dispenser.dispense(currency);
    }
}
