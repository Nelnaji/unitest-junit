import exceptions.NoAccountException;

import java.util.ArrayList;
import java.util.List;

public class Bank {

    private List<Account> accounts = new ArrayList<>();

    private String name;

public void addAccont(Account account) throws NoAccountException {
        accounts.add(account);
    }

    public List<Account> getAllAccounts() {
        return accounts;
    }

    private void alert(Account account) {
        System.out.println("Le compte numero " + account.getNumber() + " de la banque " + name + " viens de passer en négatif !!");
    }
}
