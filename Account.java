package CashieringTool;

public class Account {
	
  private double balance;
  
  public Account() {
    balance = 0;
  }

  public void setBalance(double amount) {
    balance = amount;
  }
  
  public double getBalance() {
    return balance;
  }
  
  public void deposit(double amount) {
    balance = balance + amount;
  }
  
  public void withdraw(double amount) {
    balance = balance - amount;
  }
}
