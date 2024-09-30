import java.time.LocalDate;
import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {
        Person person1 = new Person(LocalDate.of(2000, 10, 10), "te", "re");
        Person person2 = new Person(LocalDate.now(), "new", "age");
        System.out.println(person1);

        Checking courantPersonne1 = new Checking("BE8125", person1, LocalDateTime.now());


        courantPersonne1.setOwner(person2);

        courantPersonne1.deposit(0);
        try {
            courantPersonne1.withdrawal(3000);
        } catch (RuntimeException a) {
            System.out.println(a.getMessage());
        }
        courantPersonne1.calculateInterest();
        courantPersonne1.applyInterest();


        //La signature d'une methode
        //nomMethod(String,Int)
        //nomMethod(Int,String)

    }
}
