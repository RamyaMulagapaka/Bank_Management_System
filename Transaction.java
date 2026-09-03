public class Transaction {
    private int transactionId;
    private long accountNumber;
    private String transactionType;
    private double amount;
    private String transactionDate;

    public Transaction(int transactionId,long accountNumber,String transactionType,double amount,String transactionDate){
        setTransactionId(transactionId);
        setAccountNumber(accountNumber);
        setTransactionType(transactionType);
        setAmount(amount);
        setTransactionDate(transactionDate);
    }

    public void setTransactionId(int transactionId){
        if(transactionId>0){
            this.transactionId=transactionId;
        }else{
            System.out.println("Please provide valid transaction id");
        }
    }

    public void setAccountNumber(long accountNumber){
        if(accountNumber>0){
            this.accountNumber=accountNumber;
        }else{
            System.out.println("Please provide valid account number");
        }
    }

    public void setTransactionType(String transactionType){
        if(transactionType.equals("DEPOSIT")||transactionType.equals("WITHDRAWAL")||transactionType.equals("TRANSFER")){
            this.transactionType=transactionType;
        }else{
            System.out.println("Please provide valid transaction type");
        }
    }

    public void setAmount(double amount){
        if(amount>0){
            this.amount=amount;
        }else{
            System.out.println("Please provide valid amount");
        }
    }

    public void setTransactionDate(String transactionDate){
        this.transactionDate=transactionDate;
    }

    public int getTransactionId(){
        return this.transactionId;
    }

    public long getAccountNumber(){
        return this.accountNumber;
    }

    public String getTransactionType(){
        return this.transactionType;
    }

    public double getAmount(){
        return this.amount;
    }

    public String getTransactionDate(){
        return this.transactionDate;
    }
}
