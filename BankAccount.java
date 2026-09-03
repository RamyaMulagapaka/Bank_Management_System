public class BankAccount {
    private long accountNumber;
    private int customerId;
    private String accountType;
    private double balance;
    private String pin;
    private String status;

    public BankAccount(long accountNumber,int customerId,String accountType,double balance,String pin,String status){
        setAccountNumber(accountNumber);
        setCustomerId(customerId);
        setAccountType(accountType);
        setBalance(balance);
        setPin(pin);
        setStatus(status);
    }

    public void setAccountNumber(long accountNumber){
        if(accountNumber>0){
            this.accountNumber=accountNumber;
        }else{
            System.out.println("Please provide valid account number");
        }
    }

    public void setCustomerId(int customerId){
        if(customerId>0){
            this.customerId=customerId;
        }else{
            System.out.println("Please provide valid customer id");
        }
    }

    public void setAccountType(String accountType){
        if(accountType.equals("SAVINGS")||accountType.equals("CURRENT")||accountType.equals("FIXED DEPOSIT")){
            this.accountType=accountType;
        }else{
            System.out.println("Please provide valid account type");
        }
    }

    public void setBalance(double balance){
        if(balance>=0){
            this.balance=balance;
        }else{
            System.out.println("please provide valid amount");
        }
    }

    public void setPin(String pin){
        if(pin.length()==4 && pin.matches("\\d{4}")){
            this.pin=pin;
        }else{
            System.out.println("Please provide valid pin");
        }
    }

    public void setStatus(String status){
        if(status.equals("ACTIVE")||status.equals("BLOCKED")||status.equals("CLOSED")){
            this.status=status;
        }else{
            System.out.println("Please provide valid status");
        }
    }

    public long getAccountNumber(){
        return this.accountNumber;
    }

    public int getCustomerId(){
        return this.customerId;
    }

    public String getAccountType(){
        return this.accountType;
    }

    public double getBalance(){
        return this.balance;
    }

    public String getPin(){
        return this.pin;
    }

    public String getStatus(){
        return this.status;
    }

    public double checkBalance(){
        return this.balance;
    }

    public boolean deposit(double amount){
        if(amount>0){
            this.balance+=amount;
            return true;
        }
        return false;
    }

    public boolean withdraw(double amount){
        if(amount>0 && amount<=this.balance){
            this.balance-=amount;
            return true;
        }
        return false;
    }

    public boolean changePin(String oldPin, String newPin){
        if(this.pin.equals(oldPin) && newPin.length()==4 && newPin.matches("\\d{4}")){
            this.pin=newPin;
            return true;
        }
        return false;
    }

    public boolean transferMoney(BankAccount receiver, double amount){
        if(amount>0 && receiver!=null && this.balance>=amount){
            this.balance-=amount;
            return receiver.deposit(amount);
        }
        return false;
    }
}
