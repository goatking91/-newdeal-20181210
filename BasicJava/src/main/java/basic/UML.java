package basic;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;

class Bank {
  private List<Account> accounts;
  private int totalAccount;

  public Bank() {
    this.accounts = new ArrayList<>();
    this.totalAccount = accounts.size();
  }
  public void addAcount(String accountNo, String name) {
    accounts.add(new Account(accountNo, name));
  }

  public Account getAccount(String accountNo) {
    Iterator<Account> iterator = accounts.iterator();
    while(iterator.hasNext()) {
      Account temp = iterator.next();
      if(temp.accountNo.equals(accountNo)) {
        return temp;
      }
    }
    return null;
  }

  public List<Account> findAccounts(String name) {
    Iterator<Account> iterator = accounts.iterator();
    List<Account> result = new ArrayList<>();
    while(iterator.hasNext()) {
      Account temp = iterator.next();
      if(temp.accountNo.equals(name)) {
        result.add(temp);
      }

    }
    return result;
  }

  public List<Account> getAccounts() {
    return accounts;
  }

  public int getTotalAccounts() {
    this.totalAccount = accounts.size();
    return totalAccount;
  }
}

class Account {
  String accountNo; // 계좌번호
  private String name; // 소유자명
  private long balance; // 잔고
  private List<Transaction> transactions; // 거래내역

  public Account(String accountNo, String name) {
    this.accountNo = accountNo;
    this.name = name;
    this.transactions = new ArrayList<>();
  }

  public void deposit(long amount) {
    this.balance += amount;
    transactions.add(new Transaction("입금", amount, balance));
  }

  public void withdraw(long amount) {
    this.balance -= amount;
    transactions.add(new Transaction("출금", amount, balance));
  }

  public long getBalace() {
    return balance;
  }

  public List<Transaction> getTransactions() {
    return transactions;
  }

  @Override
  public String toString() {
    return "Account [accountNo=" + accountNo + ", name=" + name + ", balance=" + balance
        + ", transactions=" + transactions + "]";
  }
  
}

class Transaction {
  Calendar date = Calendar.getInstance();
  private String transactionDate;
  private String transactionTime;
  private String kind;
  private long amount;
  private long balance;

  public Transaction(String kind, long amount, long balance) {
    this.transactionDate = 
        date.get(Calendar.YEAR) + "-" + date.get(Calendar.MONDAY + 1) + "-" + date.get(Calendar.DATE);
    this.transactionTime = 
        date.get(Calendar.HOUR) + ":" + date.get(Calendar.MINUTE) + ":" + date.get(Calendar.SECOND);
    this.kind = kind;
    this.amount = amount;
    this.balance = balance;

  }

  @Override
  public String toString() {
    return "Transaction [date=" + date + ", transactionDate=" + transactionDate
        + ", transactionTime=" + transactionTime + ", kind=" + kind + ", amount=" + amount
        + ", balance=" + balance + "]";
  }
  
}

public class UML {
  public static void main(String[] args) {
    
  }
}
