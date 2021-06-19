package bankapplication;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Abdulaziz Al-Alshaikh
 */
public class BankAccountApp {
    public static void main(String [] args) throws FileNotFoundException {
        String file = "C:\\Users\\Admin\\Documents\\NetBeansProjects\\BankApplication\\NewBankAccounts .csv";
        List<String []> newAccounts = utilities.CSV.read(file);
        List<Account> accounts = new LinkedList<Account>();
        
        
        
        for(String [] accountHolder : newAccounts) {
            String name = accountHolder[0];
            String socialSecurityNumber = accountHolder[1];
            String accountType = accountHolder[2];
            double initialDeposit = Double.parseDouble(accountHolder[3]);
                
            if(accountType.equals("Savings")) 
                accounts.add(new Savings(name, socialSecurityNumber, initialDeposit));
            
            else if(accountType.equals("Checking")) 
                accounts.add(new Checking(name, socialSecurityNumber, initialDeposit));
            
            else
                System.out.println("error determining account type!");
        }
        
        printList(accounts);
        deposit(accounts.get((int)(Math.random() * accounts.size())), 250);
        
        
        
        
        
    }
    public static void printList(List<Account> data) {
        for(Account acc : data)
            System.out.println("=======================\n"+acc);
        
        System.out.println("=====================================================================\n\n"
                            + "=====================================================================");
    }
    
    public static void deposit(Account acc, double amount) {
        acc.deposit(amount);
        
    }
}
