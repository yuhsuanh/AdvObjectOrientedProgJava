/*
 * Editor: Yu-Hsuan Huang
 * Date: 2021-02-11
 * Purpose: Assignment 2 - Bank account
 */
package assignment2;

public class Account {

    //instance variables
    private String accountName;
    private int accountNumber;
    private double accountBalance;

    //constructors
    public Account() {
        this.accountName = "Default Account'000";
        this.accountNumber = 12345;
        this.accountBalance = 0.0;
    }

    public Account(String accountName, int accountNumber, double accountBalance) {
        if(!setAccountName(accountName))
            this.accountName = "Default Account'000";
        if(!setAccountNumber(accountNumber))
            this.accountNumber = 12345;
        if(!setAccountBalance(accountBalance))
            this.accountBalance = 0.0;
    }

    //Getters and Setters
    public String getAccountName() {
        return this.accountName;
    }

    public boolean setAccountName(String accountName) {
        //minimum 4 chars, only contain below chars
        //0-unlimited (1. a-z and A-Z, 2.hyphens)
        //0-1 times (1.single quote 2.space)

        //Don't need to save English characters and hyphens
        int singleQuote = 0, space = 0, others = 0; // eng = 0, hyphens = 0,
        for(char c : accountName.toCharArray()) {
            if((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z'))
                ; //eng++
            else if(c == '-')
                ; //hyphens++
            else if(c=='\'')
                singleQuote++;
            else if(c==' ')
                space++;
            else
                others++;
        }

        //string length minimum 4 chars
        //only compare 3 types, because english characters and hyphens not limited
        if(singleQuote <= 1 && space <= 1 && others == 0 && accountName.length() >= 4) {
            this.accountName = accountName;
            return true;
        }
        return false;
    }

    public int getAccountNumber() {
        return this.accountNumber;
    }

    public boolean setAccountNumber(int accountNumber) {
        //positive, 5-9 digits
        int numberLength = String.valueOf(accountNumber).length();
        if(accountNumber > 0 && numberLength >= 5 && numberLength <= 9 ) {
            this.accountNumber = accountNumber;
            return true;
        }
        return false;
    }

    public double getAccountBalance() {
        return this.accountBalance;
    }

    public boolean setAccountBalance(double value) {
        //positive or negative, maximum 2 decimal places
        if((value * 100 ) % 1 == 0) {
            this.accountBalance = value;
            return true;
        }
        return false;
    }

    //additional to determine the account number is equal
    public boolean isAccountNumberEqual(int accountNumber) {
        if(Integer.compare(this.accountNumber, accountNumber) == 0) {
            return true;
        }
        return false;
    }

    @Override
    public boolean equals(Object obj) {
        //one object is equal in VALUE to an account object
        Account account = (Account) obj;
        if(this.accountName.equals(account.accountName) &&
                Integer.compare(this.accountNumber, account.accountNumber) == 0 &&
                Double.compare(this.accountBalance, account.accountBalance) == 0)
            return true;
        return false;
    }

    @Override
    public String toString() {
        return "Account{" +
                "accountName='" + accountName + '\'' +
                "\t accountNumber=" + accountNumber +
                "\t accountBalance=" + accountBalance +
                '}';
    }
}