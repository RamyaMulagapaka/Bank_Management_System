import java.time.LocalDateTime;
import java.util.*;
public class Bank {
    private List<Customer> customers;
    private List<BankAccount> accounts;
    private List<Transaction> transactions;

    public Bank() {
        customers = new ArrayList<>();
        accounts = new ArrayList<>();
        transactions = new ArrayList<>();
    }

    public boolean CreateAccount(Customer customer,BankAccount account){
        if(customer.getCustomerId()==account.getCustomerId()){
            customers.add(customer);
            accounts.add(account);
            return true;
        } else {
            return false;
        }
    }

    public BankAccount login(long accountNumber, String pin) {
        for (BankAccount account : accounts) {
            if(account.getAccountNumber()== accountNumber && pin.equals(account.getPin()) && account.getStatus().equals("ACTIVE")){
                return account;
            }
        }
        return null;
    }

    public boolean deposit(long accountNumber,double amount){
        for(BankAccount account:accounts){
            if(account.getAccountNumber()==accountNumber) {
                if(account.deposit(amount)){
                    Transaction transaction =new Transaction(accountNumber, "DEPOSIT", amount, LocalDateTime.now());
                    this.transactions.add(transaction);
                    return true;
                }
                return false;
            }
        }
        return false;
    }

    public boolean withdraw(long accountNumber,double amount){
        for(BankAccount account:accounts){
            if(account.getAccountNumber()==accountNumber) {
                if(account.withdraw(amount)){
                    Transaction transaction =new Transaction(accountNumber, "WITHDRAW", amount, LocalDateTime.now());
                    this.transactions.add(transaction);
                    return true;
                }
                return false;
            }
        }
        return false;
    }

    public boolean changePin(long accountNumber,String oldPin,String newPin){
        for(BankAccount account:accounts){
            if(account.getAccountNumber()==accountNumber) {
                return account.changePin(oldPin,newPin);
            }
        }
        return false;
    }

    public boolean transferMoney(long senderAccountNumber,long receiverAccountNumber,double amount){
        BankAccount sender=null;
        BankAccount receiver=null;
        for(BankAccount account:accounts){
            if(account.getAccountNumber()==senderAccountNumber) {
                sender=account;
            }
            if(account.getAccountNumber()==receiverAccountNumber) {
                receiver=account;
            }
        }
        if(sender!=null && receiver!=null){
            return sender.transferMoney(receiver,amount);
        }
        return false;
    }

    public double checkbalance(long accountNumber){
        for(BankAccount account:accounts){
            if(account.getAccountNumber()==accountNumber){
                return account.checkBalance();
            }
        }
        return -1; // Account not found
    }

    public List<Transaction> getTransactions(long accountNumber){
        List<Transaction> history=new ArrayList<>();
        for(Transaction transaction:transactions){
            if(transaction.getAccountNumber()==accountNumber){
                history.add(transaction);
            }
        }
        return history;
    }

    public static void main(String[] args){
        Bank bank=new Bank();
        Customer customer1=new Customer(1,"Priya","7780464644","priya@gmail.com","Guntur , Narsaroapeta");
        BankAccount account1=new BankAccount(123456789,1,"SAVINGS",1000.0,"1234","ACTIVE");
        if(bank.CreateAccount(customer1, account1)){
            System.out.println("Account created successfully");
        }else{
            System.out.println("Failed to create account");
        }

        BankAccount loggedInAccount=bank.login(123456789,"1234");
        if(loggedInAccount!=null){
            System.out.println("Login successful");
        }else{
            System.out.println("Login failed");
        }

        if(bank.deposit(123456789,5000)){
            System.out.println("Deposit successful");
        }else{
            System.out.println("Deposit failed");
        }

        System.out.println(customer1.getName()+"'s balance: "+bank.checkbalance(123456789));
        if(bank.changePin(123456789, "1234", "5678")){
            System.out.println("Pin changed successfully");
        }else{
            System.out.println("Pin change failed");
        }

        System.out.println(account1.getPin());

        if(bank.withdraw(123456789, 100)){
            System.out.println("Withdrawal successful");
        }else{
            System.out.println("Withdrawal failed");
        }
        List<Transaction> transactionHistory1=bank.getTransactions(123456789);
        System.out.println("Transaction History:");
        for(Transaction transaction:transactionHistory1){
            System.out.println("Account Number: "+transaction.getAccountNumber()+", Type: "+transaction.getTransactionType()+", Amount: "+transaction.getAmount()+", Date: "+transaction.getTransactionDate());
        }
    }
}
