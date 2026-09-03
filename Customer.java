public class Customer{
    private int customerId;
    private String name;
    private String phone;
    private String email;
    private String address;

    public Customer(int customerId,String name,String phone,String email,String address){
        setCustomerId(customerId);
        setName(name);
        setPhone(phone);
        setEmail(email);
        setAddress(address);
    }

    public void setCustomerId(int customerId){
        if(customerId>0){
            this.customerId=customerId;
        }else{
            System.out.println("Please provide valid customer id");
        }
    }

    public void setName(String name){
        if(name.length()<3){
            System.out.println("Please provide a valid name");
        }else{
            this.name=name;
        }
    }

    public void setPhone(String phone){
        if(phone.length()!=10 || phone.charAt(0)<'6' || phone.charAt(0)>'9'){
            System.out.println("Invalid number");
        }else{
            this.phone=phone;
        }
    }

    public void setEmail(String email){
        if(email.contains("@") && email.contains(".")){
            this.email=email;
        }else{
            System.out.println("Invalid email");
        }
    }

    public void setAddress(String address){
        this.address=address;
    }

    public int getCustomerId(){
        return this.customerId;
    }

    public String getName(){
        return this.name;
    }

    public String getPhone(){
        return this.phone;
    }

    public String getEmail(){
        return this.email;
    }

    public String getAddress(){
        return this.address;
    }

}