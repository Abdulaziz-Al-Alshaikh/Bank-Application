package bankapplication;

import java.util.Random;

/**
 *
 * @author Abdulaziz Al-Alshaikh
 */
public class Savings extends Account {
    //List the properties specific to a savings account
    private int safetyDepositBoxID;
    private int safetyDepositBoxKey;
    private final int uniqueDigit = 1; //Savings account should start with 1

    
    //Constructor to initialize the savings account
    public Savings(String name, String socialSecurityNumber, double initialDeposit) {
        super(name, socialSecurityNumber, initialDeposit);
        this.setAccountNumber(1);
        setSafetyDepositBox();
    }
    //List any method specific to the Savings account

    @Override
    public String toString() {
        return(super.toString() +
        String.format("Your Savings Account features:" +
        "%n\tSafety Deposit Box ID: %d%n\tSafety Deposit Box Key: %d%n"
        , this.safetyDepositBoxID, this.safetyDepositBoxKey));
    }
    
    @Override
    public void setRate() {
        this.rate = this.getBaseRate();
        
    }

    private void setSafetyDepositBox() {
        this.safetyDepositBoxID = Integer.parseInt(GenerateRandomNumbers.randomNumbers(3));
        this.safetyDepositBoxKey = Integer.parseInt(GenerateRandomNumbers.randomNumbers(4));
    }

    @Override
    public double getBaseRate() {
        return (IBaseRate.RATE - .25);
    }
   
    
}
