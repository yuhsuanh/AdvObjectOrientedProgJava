/*
 * Editor: Yu-Hsuan Huang
 * Date: 2021-02-11
 * Purpose: Assignment 2 - Bank
 */
package assignment2;

import java.util.ArrayList;
import java.util.List;

public class Bank {

    //instant variables
    private String bankName;
    private String branchLocation;
    private List<Account> accounts;

    public static enum BranchLocations {
        TORONTO, OTTAWA, MONTREAL, QUEBEC, WINNIPEG, CALGARY, EDMONTON, VANCOUVER
    }

    //constructors
    public Bank() {
        setBankName("Default Bank&000");
        setBranchLocation(BranchLocations.TORONTO);

        //instant array list
        accounts = new ArrayList<Account>();
    }

    public Bank(String bankName, String branchLocation) {
        if(!setBankName(bankName))
            this.bankName = "Default Bank&000";
        if(!setBranchLocation(branchLocation))
            setBranchLocation(BranchLocations.TORONTO);
        //instant array list
        accounts = new ArrayList<Account>();
    }

    public Bank(String bankName, BranchLocations branchLocation) {
        if(!setBankName(bankName))
            this.bankName = "Default Bank&000";
        if(!setBranchLocation(branchLocation))
            setBranchLocation(BranchLocations.TORONTO);
        //instant array list
        accounts = new ArrayList<Account>();
    }

    //Getters and Setters
    public String getBankName() {
        return this.bankName;
    }

    public boolean setBankName(String bankName) {
        //minimum 8 chars, only contain below chars
        //0-unlimited (1. a-z and A-Z, 2.hyphens, 3.ampersand)
        //0-1 times (1.space)

        //Don't need to save English characters and hyphens
        int space = 0, others = 0; // eng = 0, hyphens = 0, ampersand = 0
        for(char c : bankName.toCharArray()) {
            if((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z'))
                ; //eng++
            else if(c >= '0' && c <= '9')
                ; //hyphens++
            else if(c=='&')
                ;
            else if(c==' ')
                space++;
            else
                others++;
        }

        //string length minimum 8 chars
        //only compare 2 types, because english characters and hyphens not limited
        if(space <= 1 && others == 0 && bankName.length() >= 8) {
            this.bankName = bankName;
            return true;
        }
        return false;
    }

    public boolean setBranchLocation(String branchLocation) {
        //branch location must exist in the enum
        for (BranchLocations location : BranchLocations.values()) {
            if (location.name().equals(branchLocation)) {
                this.branchLocation = branchLocation;
                return true;
            }
        }
        return false;
    }

    public String getBranchLocation() {
        return this.branchLocation;
    }

    public boolean setBranchLocation(BranchLocations branchLocation) {
        //branch location is not null
        if(branchLocation != null) {
            this.branchLocation = branchLocation.name();
            return true;
        }
        return false;
    }


    //Other methods
    public Account getAccountByNumber(int accountNumber) {
        for(Account ac : accounts) {
            if(ac.isAccountNumberEqual(accountNumber))
                return ac;
        }
        return new Account();
    }

    public boolean addAccount(Account account) {
        //if account number not exist in the account collection, adding to the collection
        if(accounts.size() == 0) {
            accounts.add(account);
            return true;
        }
        //else has objects
        for(Account ac : accounts) {
            if(!ac.isAccountNumberEqual(account.getAccountNumber())) {
                accounts.add(account);
                return true;
            }
        }
        return false;
    }

    public boolean addAccount(String accountName, int accountNumber, double accountBalance) {
        //if account number not exist in the account collection, adding to the collection
        Account account = new Account(accountName, accountNumber, accountBalance);

        if(accounts.size() == 0) {
            accounts.add(account);
            return true;
        }

        for(Account ac : accounts) {
            if(!ac.isAccountNumberEqual(accountNumber)) {
                accounts.add(account);
                return true;
            }
        }
        return false;
    }

    public Account viewAccount(int accountNumber) {
        //as same as get account by number method
        return getAccountByNumber(accountNumber);
    }

    public Account viewAccount(byte index) {
        //if the index is less than account size, we can get the account
        if(index < accounts.size()) {
            return accounts.get(index);
        }
        return new Account();
    }

    public boolean modifyAccount(int accountNumber, String accountName) {
        Account ac = viewAccount(accountNumber);
        //if the account number is exist in the collection and set account name is success
        if(ac.isAccountNumberEqual(accountNumber)) {
            if(ac.setAccountName(accountName))
                return true;
        }
        return false;
    }

    public boolean modifyAccount(int accountNumber, double accountBalance) {
        Account ac = viewAccount(accountNumber);
        //if the account number is exist in the collection and set account balance is success
        if(ac.isAccountNumberEqual(accountNumber)) {
            if(ac.setAccountBalance(accountBalance))
                return true;
        }
        return false;
    }

    public boolean modifyAccount(int accountNumber, String accountName, double accountBalance) {
        Account ac = viewAccount(accountNumber);
        //if the account number is exist in the collection
        if(ac.isAccountNumberEqual(accountNumber)) {
            //if account name and account balance are successfully been setted
            if(ac.setAccountName(accountName) && ac.setAccountBalance(accountBalance))
                return true;
        }
        return false;
    }

    public boolean modifyAccount(byte index, String accountName) {
        Account ac = viewAccount(index);
        //if the index is exist in the collection, the account name is not empty
        if(!ac.getAccountName().isEmpty()) {
            if(ac.setAccountName(accountName))
                return true;
        }
        return false;
    }

    public boolean modifyAccount(byte index, double accountBalance) {
        Account ac = viewAccount(index);
        if(!ac.getAccountName().isEmpty()) {
            if(ac.setAccountBalance(accountBalance))
                return true;
        }
        return false;
    }

    public boolean modifyAccount(byte index, String accountName, double accountBalance) {
        Account ac = viewAccount(index);
        if(!ac.getAccountName().isEmpty())
            if(ac.setAccountName(accountName) && ac.setAccountBalance(accountBalance)) {
                return true;
        }
        return false;
    }

    public boolean deleteAccount(int accountNumber) {
        for(Account ac : accounts) {
            if(ac.isAccountNumberEqual(accountNumber)) {
                accounts.remove(ac);
                return true;
            }
        }
        return false;
    }

    public boolean deleteAccount(byte index) {
        if(index < accounts.size()){
            accounts.remove(index);
            return true;
        }
        return false;
    }


}