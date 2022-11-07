public class BankAccount {
    private double saldo;
    private String name;

    public BankAccount (double saldo, String name){
        this.saldo = saldo;
        this.name = name;

    }


    public void deposit(double amount){
        this.saldo += amount;
    }

    public void withdraw(double amount){
        this.saldo -= amount;
    }

    public double getSaldo(){
        return this.saldo;
    }

    public String getName(){
       return this.name;
    }
}