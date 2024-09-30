public interface Banker extends Customer {

    void applyInterest();

    Person getOwner();

    String getNumber();

}
