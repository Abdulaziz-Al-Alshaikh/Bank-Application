package bankapplication;
import java.util.Random;

/**
 *
 * @author Abdulaziz Al-Alshaikh
 */
public abstract class Account implements IBaseRate {
    //List the common properties of an account
    private String name;
    private String socialSecurityNumber;
    private double balance;
    protected double rate;
    protected String accountNumber;
    private static int index = 10000;
    
    
    
    
    //Constructor to initialize the properties of the account class
    public Account(String name, String socialSecurityNumber, double initialDeposit) {
        this.name = name;
        this.balance = initialDeposit;
        this.socialSecurityNumber = socialSecurityNumber;
        ++index;
        this.accountNumber = setAccountNumber();
        setRate();
    }
    
    
    
    
    //List common methods - transactions
    public void deposit(double amount){
        this.balance += amount;
        System.out.println("depositing $"+amount);
        printBalance();
    }
    
    
    
    public void compound() {
        double accuredInterest = this.balance * (this.rate / 100);
        this.balance += accuredInterest;
        System.out.println("Accured Interest $"+accuredInterest);
    }
    
    
        
    
    public void withdraw(double amount){
        this.balance -= amount;
        System.out.println("Withdrawing $"+amount);
        printBalance();
    }
    
    
    
    
    public void transfer(String toWhere, double amount) {
        this.balance -= amount;
        System.out.println("Transferring $"+amount+" to "+toWhere);
        printBalance();
    }
    
    
    
        
    public void printBalance() {
        System.out.println("Dear "+this.name+", your balance is "+this.balance);
        
    }
    
    
    

    private String setAccountNumber() {
        String lastTwoDigitsOfSSN = this.socialSecurityNumber.substring(this.socialSecurityNumber.length() - 2);
        String uniqueFiveDigitsNumber = ""+this.index;
        String randomThreeDigits = GenerateRandomNumbers.randomNumbers(3);
        
        return lastTwoDigitsOfSSN.concat(uniqueFiveDigitsNumber).concat(randomThreeDigits);
        
    }
    
    
    
    
    public void setAccountNumber(int accountUniqueDigit) {
        if(accountUniqueDigit != 1 & accountUniqueDigit != 2)
            throw new IllegalArgumentException("Account number should start with 1 or 2 based on its type!");
        
        this.accountNumber = accountUniqueDigit + this.accountNumber;
        
    }
    
    public abstract void setRate();//Rate varies from one account to another
    
    
    
    

    public String getAccountNumber() {
        return accountNumber;
    }
    
    
    
    
    
    @Override
    public String toString() {
        return(String.format("NAME: %s%nACCOUNT NUMBER: %s%nBALANCE: %.2f%nRATE: %.3f%%%n", 
        this.name, this.accountNumber, this.balance, this.rate));
    }
    
    
    
    
    
}
