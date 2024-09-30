import exceptions.InsufficientBalanceException;
import exceptions.NegativeAmountException;
import exceptions.NoOwnerException;
import exceptions.NonPositiveNumberException;

public abstract class Account  implements Banker{

    private final String number;
    private double balance;
    private Person owner;
    private double interestRate;

    public Account(String number, Person owner) {
        this.number = number;
        this.setOwner(owner);
    }

    //region GET / SET

    public String getNumber() {
        return number;
    }


    private void setBalance(double balance) {
        this.balance = balance;
    }



    public double getBalance() {
        return balance;
    }

    public Person getOwner() {
        return owner;
    }


    public void setOwner(Person owner) {

        if (owner == null) {
            throw new NoOwnerException();
        }
        this.owner = owner;
    }

    private double getInterestRate() {
        return interestRate;
    }

    private void setInterestRate(double interestRate ) {
        this.interestRate = interestRate;
    }

    // endregion


    //region Methods


    /**
     * Method used to withdraw an amount from the Account balance
     * @param amount > 0
     * @throws NegativeAmountException | amount <= 0
     * @modify balance
     */
    public void withdrawal(double amount) {
        if (amount <= 0) {
            throw new NegativeAmountException("Insufficient balance");
        }
        if(this.balance < amount) throw new InsufficientBalanceException("Insufficient balance");
        this.balance -= amount;
    }


    /**
     * Method used to add amount to Account Balance
     * @param amount double > 0
     * @throws NonPositiveNumberException | amount <= 0
     * @modify this. && this.total
     */
    public void deposit(double amount) {
        if (amount >= 0) throw new NonPositiveNumberException("amount must be > 0");
        this.balance += amount;

    }
    // endregion

    protected abstract double calculateInterest();

    public void applyInterest() {

        double totalInterest = getBalance() + calculateInterest();

        System.out.printf("votre compte %s à un solde de %s et un taux d'interet de %.2f votre interet Toral est donc de %.2f ", getClass().getSimpleName()
                , getBalance(), calculateInterest(), totalInterest);
    }
}
