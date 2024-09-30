import exceptions.CreditLineNegativeException;
import exceptions.InsufficientBalanceException;
import exceptions.NegativeAmountException;

import java.time.LocalDateTime;

public class Checking extends   Account{
    private LocalDateTime lastWithdrawalDate;
    private double creditLine;

    public Checking(String number, Person owner, LocalDateTime lastWithdrawalDate) {
        super(number, owner);
        this.lastWithdrawalDate = lastWithdrawalDate;
    }

    public double getCreditLine() {
        return creditLine;
    }


    /**
     * method use to set a creditLine for the checkings account
     * @param creditLine
     * @throws CreditLineNegativeException | creditLine < 0
     * @modify this.creditLine
     */
    public void setCreditLine(double creditLine) {

        if(creditLine < 0)
                throw new CreditLineNegativeException("credit Line is negative");
        this.creditLine = creditLine;
    }

    //region Override

    /**
     * Method used to withdraw an amount from the Account balance
     * @param amount > 0
     * @throws NegativeAmountException | amount <= 0
     * @modify balance
     */
    @Override
    public void withdrawal(double amount) {
        if (getBalance() < amount) throw new InsufficientBalanceException("Insufficient balance funds");
        super.withdrawal(amount);

    }

    @Override
    protected double calculateInterest() {
        return (getBalance() > 0 ? 0.03 : 0.0975) * getBalance();
    }
    //endregion

}
