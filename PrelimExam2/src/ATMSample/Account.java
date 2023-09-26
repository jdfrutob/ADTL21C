package ATMSample;

public class Account { 
        private String accountNumber;
        private String name;
        private double balance;
    
        public BankAccount(String accountNumber, String name, double balance) {
            this.accountNumber = accountNumber;
            this.name = name;
            this.balance = balance;
        }
    
        public String getAccountNumber() {
            return accountNumber;
        }
    
        public String getName() {
            return name;
        }
    
        public double getBalance() {
            return balance;
        }
    
        public void withdraw(double amount) {
            balance -= amount;
        }
    }
