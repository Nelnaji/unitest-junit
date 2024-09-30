import exceptions.CreditLineNegativeException;
import exceptions.InsufficientBalanceException;
import exceptions.NegativeAmountException;
import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;

import static org.junit.Assert.fail;

public class CheckingTest {


    @Test
    public void insufficientBalance_withdrawalTest() {

        try {
            Person person1 = new Person(LocalDate.of(2000, 10, 10), "te", "re");
            Checking courantPerson1 = new Checking("BE81 0025 1542 1234", person1, LocalDateTime.now());
            courantPerson1.setOwner(person1);
            courantPerson1.deposit(0);
            courantPerson1.withdrawal(3000);

        } catch (InsufficientBalanceException e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void NegativeAmount_withdrawalTest() {

        try {
            Person person1 = new Person(LocalDate.of(2000, 10, 10), "te", "re");
            Checking courantPerson1 = new Checking("BE81 0025 1542 1234", person1, LocalDateTime.now());
            courantPerson1.setOwner(person1);
            courantPerson1.deposit(0);
            courantPerson1.withdrawal(-3000);

        } catch (NegativeAmountException e) {
            fail(e.getMessage());
        }

    }
}


