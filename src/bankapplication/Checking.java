package bankapplication;

/**
 *
 * @author Abdulaziz Al-Alshaikh
 */
public class Checking extends Account{
    //List the common properties specific to a checking account
    private String debitCardNumber;
    private int debitCardPin;
    private final int uniqueDigit = 2; //Every checking account should start with 2
    
    
    //Contructor to initialize the savings account
    public Checking(String name, String socialSecurityNumber, double initialDeposit) {
        super(name, socialSecurityNumber, initialDeposit);
        this.setAccountNumber(this.uniqueDigit);
        setDebitCard();
        
    }
    //List any method specific to the checking account
    
    @Override
    public String toString() {
        return(super.toString() +
        String.format("Your Checking Account features:" +
        "%n\tDebit Card Number: %s%n\tDebit Card Pin: %d%n"
        , this.debitCardNumber, this.debitCardPin));
    }
    
    @Override
    public void setRate() {
        this.rate = this.getBaseRate();//In the checking account, the rate is 15% of the benchmark interest rate.
        
    }

    private void setDebitCard() {
        this.debitCardNumber = GenerateRandomNumbers.randomNumbers(12);
        this.debitCardPin = Integer.parseInt(GenerateRandomNumbers.randomNumbers(4));
    }

    @Override
    public double getBaseRate() {
        return (IBaseRate.RATE * .15);
    }

    
    
}
