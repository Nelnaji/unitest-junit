import exceptions.InsufficientBalanceException;

import java.time.LocalDateTime;

public class Saving extends Account {
    private LocalDateTime lastWithdrawalDate;

    public Saving(String number, Person owner, LocalDateTime lastWithdrawalDate) {
        super(number, owner);
        this.lastWithdrawalDate = lastWithdrawalDate;
    }

    //region Override
    @Override
    public void withdrawal(double amount) {
        if (getBalance() >= amount) throw new InsufficientBalanceException("Amount exceeds account balance");
        super.withdrawal(amount);

    }

    @Override
    protected double calculateInterest() {
        return getBalance() * 0.045;
    }
    //endregion

}
