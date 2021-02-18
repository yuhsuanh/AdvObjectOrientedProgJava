package assignment2;
import static org.junit.Assert.*;
import java.security.SecureRandom;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class Testings {

    @Test
    public void test_Bank_1(){
        Bank bank = new Bank();
        System.out.println(bank.getBankName());
        System.out.println(bank.getBankName().length());
        System.out.println(bank.getBankName().equals(new Bank().getBankName()));
        assertTrue(bank.getBankName() != null && bank.getBankName().length() >= 8 && bank.getBankName().equals(new Bank().getBankName()));
    }
    @Test
    public void test_Bank_2(){
        Bank bank = new Bank("tXiPkaodan57yzrCxYjVT", Bank.BranchLocations.values()[0]);
        assertTrue(bank.getBankName() != null && bank.getBankName().length() >= 8 && !bank.getBankName().equals(new Bank().getBankName()));
    }
    @Test
    public void test_Bank_3(){
        Bank bank = new Bank("TdlTaBcctWmEkIa532KFIJY",  Bank.BranchLocations.values()[1]);
        assertTrue(bank.getBankName() != null && bank.getBankName().length() >= 8 && !bank.getBankName().equals(new Bank().getBankName()));
    }
    @Test
    public void test_Bank_4(){
        Bank bank = new Bank("ovkzi", "Hw");
        assertTrue(bank.getBankName() != null && bank.getBankName().length() >= 8 && bank.getBankName().equals(new Bank().getBankName()));
    }
    @Test
    public void test_Bank_5(){
        Bank bank = new Bank("Fr",  Bank.BranchLocations.values()[1]);
        assertTrue(bank.getBankName() != null && bank.getBankName().length() >= 8 && bank.getBankName().equals(new Bank().getBankName()));
    }
    @Test
    public void test_Bank_6(){
        Bank bank = new Bank("x9d62",  Bank.BranchLocations.values()[0]);
        assertTrue(bank.getBankName() != null && bank.getBankName().length() >= 8 && bank.getBankName().equals(new Bank().getBankName()));
    }
    @Test
    public void test_Bank_7(){
        Bank bank = new Bank("VvxDqLJOuQpvOFHSeLM936mdQThbFGyt", "Np3hzsixbQ");
        assertTrue(bank.getBankName() != null && bank.getBankName().length() >= 8 && !bank.getBankName().equals(new Bank().getBankName()));
    }
    @Test
    public void test_Bank_8(){
        Bank bank = new Bank("sWbJwKVUkaodjAtmESnn954MeH& &JjyKGmTfLB",  Bank.BranchLocations.values()[1]);
        String newBankName = "sWbJwKVUkaodjAtmESnn954MeH& &JjyKGmTfLB";
        assertTrue(bank.setBankName(newBankName) && bank.getBankName().equals(newBankName));
    }

    @Test
    public void test_Bank_9(){
        Bank bank = new Bank("wSVGgnxDGtTF326CDvRGSKv",  Bank.BranchLocations.values()[1]);
        String originalBankName = "wSVGgnxDGtTF326CDvRGSKv";
        String newBankName = "YPYTYS6";
        assertTrue(!bank.setBankName(newBankName) && bank.getBankName().equals(originalBankName));
    }

    @Test
    public void test_Account_10(){
        Account account = new Account("dJrovUuzePr'rsVsBjOQRvYw", 463238142, 6927.64);
        String newAccountName = "yZRDMjbS -'VxiHw";
        assertTrue(account.setAccountName(newAccountName) && account.getAccountName().equals(newAccountName));
    }

    @Test
    public void test_Account_11(){
        Account account = new Account("RulfJwNxlvtTz", 46871, 76921.0);
        String originalAccountName = "RulfJwNxlvtTz";
        String newAccountName = "jEQRKr$~{+<,}/$__<`  ''''-''I";
        assertTrue(!account.setAccountName(newAccountName) && account.getAccountName().equals(originalAccountName));
    }

    @Test
    public void test_Account_12(){
        Account account = new Account("IHElAB QtKnIoIXnsGPxv", 166461, 542.4);
        int newAccountNumber = 73432349;
        assertTrue(account.setAccountNumber(newAccountNumber) && account.getAccountNumber() == newAccountNumber);
    }

    @Test
    public void test_Account_13(){
        Account account = new Account("nHiHdti--uoerQKRYyx", 2486371, 99.28);
        int originalAccountNumber = 2486371;
        int newAccountNumber = 232;
        assertTrue(!account.setAccountNumber(newAccountNumber) && account.getAccountNumber() == originalAccountNumber);
    }

    @Test
    public void test_Account_14(){
        Account account = new Account("iWnDyQXW", 243125444, 52.0);
        double newAccountBalance = 7911.0;
        assertTrue(account.setAccountBalance(newAccountBalance) && account.getAccountBalance() == newAccountBalance);
    }

    @Test
    public void test_Account_15(){
        Account account = new Account("FrMEVcgKYURiZI 'pBCZqdGKLp", 551232, 135.62);
        double originalAccountBalance = 135.62;
        double newAccountBalance = -115142.076;
        assertTrue(!account.setAccountBalance(newAccountBalance) && account.getAccountBalance() == originalAccountBalance);
    }

    @Test
    public void test_Account_16(){
        Account account = new Account("AGXTlhGEuSizFXm", 442765, 26134.7);
        assertTrue(account.toString().length() > 15);
    }
    @Test
    public void test_Account_17(){
        Account a1 = new Account();
        Account a2 = new Account();
        assertTrue(a1.equals(a2));
    }
    @Test
    public void test_Account_18(){
        Account a1 = new Account("kreHV- -OiUGKfJF", 822468, 7627.3);
        Account a2 = new Account("PZpfP", 69599543, 517.64);
        assertTrue(!a1.equals(a2));
    }
    @Test
    public void test_Account_19(){
        Account a1 = new Account("ePahuPZQ", 96, 7.0);
        Account a2 = new Account("SROzF'udFasNLKUcm", 1647, 267489.0);
        assertTrue(!a1.equals(a2));
    }
    @Test
    public void test_Account_20(){
        Account a1 = new Account("eBVoisDQz", 4, -3.5529682446720004E7);
        Account a2 = new Account("FuhmhBvvaSR", 2, 467.78974);
        assertTrue(!a1.equals(a2));
    }
    @Test
    public void test_Account_21(){
        Account a1 = new Account("kEn", 78, -6777277.415);
        Account a2 = new Account("Cba", 8, 51.395);
        assertTrue(a1.equals(a2));
    }
    @Test
    public void test_Bank_10(){
        Bank bank = new Bank("LhblVEWZXmtjn3gMykBaqfN& &h", Bank.BranchLocations.values()[0]);
        String newBranchLocation = Bank.BranchLocations.values()[1].toString();
        assertTrue(bank.setBranchLocation(newBranchLocation) && bank.getBranchLocation().equals(newBranchLocation));
    }
    @Test
    public void test_Bank_11(){
        Bank bank = new Bank("IWhPtPxjvv666K& &UmDuHS", Bank.BranchLocations.values()[0]);
        String originalBranchLocation = Bank.BranchLocations.values()[0].toString();
        String newBranchLocation = "JJFqZ";
        assertTrue(!bank.setBranchLocation(newBranchLocation) && bank.getBranchLocation().equals(originalBranchLocation));
    }

    @Test
    public void test_Bank_13(){
        Bank bank = new Bank("qLOwyONvKsM58ZdV& &yo", Bank.BranchLocations.values()[0]);
        Account account = new Account("aucchQitgyzLV", 6329668, 479389.0);
        byte index = 0;
        assertTrue(bank.addAccount(account) && bank.viewAccount(index).equals(account));
    }
    @Test
    public void test_Bank_14(){
        Bank bank = new Bank("tfuYUNCqYrVSvVPPlN17MvOnbvfwSI& &eFvRQGMoJ", Bank.BranchLocations.values()[1]);

        String accountName = "rcUq";
        double accountBalance = 562.37;
        int accountNumber = 32335121;
        byte index = 0;


        assertTrue(bank.addAccount(accountName, accountNumber, accountBalance)
                && bank.viewAccount(index).equals(new Account(accountName, accountNumber, accountBalance)));

    }
    @Test
    public void test_Bank_15(){
        Bank bank = new Bank("wgFPLwjnNDBTfsrht9K& &naj", Bank.BranchLocations.values()[1]);
        Account account = new Account("CgYrtCuoRs", 5245239, 922.0);
        byte index = 0;
        byte index1 = 1;
        assertTrue(bank.addAccount(account) && !bank.addAccount(account) && bank.viewAccount(index).equals(account) && bank.viewAccount(index1).equals(new Account()));
    }
    @Test
    public void test_Bank_16(){
        Bank bank = new Bank("bNNgBleexZP1tk& &INFbM", Bank.BranchLocations.values()[1]);

        String accountName = "bIKx-' mHVrNgdBqbFCo";
        double accountBalance = 12.54;
        int accountNumber = 49252296;

        byte index, index1;
        index = 0;
        index1 = 1;

        assertTrue(bank.addAccount(accountName, accountNumber, accountBalance) &&
                bank.viewAccount(index).equals(new Account(accountName, accountNumber, accountBalance)) &&
                !bank.addAccount(accountName, accountNumber, accountBalance) && bank.viewAccount(index1).equals(new Account()));
    }
    @Test
    public void test_Bank_17(){
        Bank bank = new Bank("YaqsWlJv276CUfHz& &evFtuHl", Bank.BranchLocations.values()[1]);
        Account a1 = new Account("wvvGodX QzjSzupClzLsF", 418563, 5984.0);
        Account a2 = new Account("npdYfsOSDC'-iTXhyoYvPhjg", 871662, 97842.0);


        bank.addAccount(a1);
        bank.addAccount(a2);
        String newAccountName = "sVldpJSysz";
        double newAccountBalance = 42486.0;
        int targetAccountNumber = 871662;

        assertTrue(bank.modifyAccount(targetAccountNumber, newAccountName) && bank.viewAccount(targetAccountNumber).getAccountName().equals(newAccountName));
    }
    @Test
    public void test_Bank_18(){
        Bank bank = new Bank("YaqsWlJv276CUfHz& &evFtuHl", Bank.BranchLocations.values()[1]);
        Account a1 = new Account("wvvGodX QzjSzupClzLsF", 418563, 5984.0);
        Account a2 = new Account("npdYfsOSDC'-iTXhyoYvPhjg", 871662, 97842.0);


        bank.addAccount(a1);
        bank.addAccount(a2);
        String newAccountName = "sVldpJSysz";
        double newAccountBalance = 42486.0;
        int targetAccountNumber = 871662;

        assertTrue(bank.modifyAccount(targetAccountNumber, newAccountBalance) &&
                bank.viewAccount(targetAccountNumber).getAccountBalance() == newAccountBalance);
    }
    @Test
    public void test_Bank_19(){
        Bank bank = new Bank("YaqsWlJv276CUfHz& &evFtuHl", Bank.BranchLocations.values()[1]);
        Account a1 = new Account("wvvGodX QzjSzupClzLsF", 418563, 5984.0);
        Account a2 = new Account("npdYfsOSDC'-iTXhyoYvPhjg", 871662, 97842.0);


        bank.addAccount(a1);
        bank.addAccount(a2);
        String newAccountName = "sVldpJSysz";
        double newAccountBalance = 42486.0;
        int targetAccountNumber = 871662;

        assertTrue(bank.modifyAccount(targetAccountNumber, newAccountName, newAccountBalance) &&
                bank.viewAccount(targetAccountNumber).getAccountName().equals(newAccountName) &&
                bank.viewAccount(targetAccountNumber).getAccountBalance() == newAccountBalance
        );
    }
    @Test
    public void test_Bank_20(){
        Bank bank = new Bank("YaqsWlJv276CUfHz& &evFtuHl", Bank.BranchLocations.values()[1]);
        Account a1 = new Account("wvvGodX QzjSzupClzLsF", 418563, 5984.0);
        Account a2 = new Account("npdYfsOSDC'-iTXhyoYvPhjg", 871662, 97842.0);


        bank.addAccount(a1);
        bank.addAccount(a2);
        String newAccountName = "sVldpJSysz";
        double newAccountBalance = 42486.0;
        byte targetIndex = 1;

        assertTrue(bank.modifyAccount(targetIndex, newAccountName) && bank.viewAccount(targetIndex).getAccountName().equals(newAccountName));
    }
    @Test
    public void test_Bank_21(){
        Bank bank = new Bank("YaqsWlJv276CUfHz& &evFtuHl", Bank.BranchLocations.values()[1]);
        Account a1 = new Account("wvvGodX QzjSzupClzLsF", 418563, 5984.0);
        Account a2 = new Account("npdYfsOSDC'-iTXhyoYvPhjg", 871662, 97842.0);


        bank.addAccount(a1);
        bank.addAccount(a2);
        String newAccountName = "sVldpJSysz";
        double newAccountBalance = 42486.0;
        byte targetIndex = 1;

        assertTrue(bank.modifyAccount(targetIndex, newAccountBalance) &&
                bank.viewAccount(targetIndex).getAccountBalance() == newAccountBalance);
    }
    @Test
    public void test_Bank_22(){
        Bank bank = new Bank("YaqsWlJv276CUfHz& &evFtuHl", Bank.BranchLocations.values()[1]);
        Account a1 = new Account("wvvGodX QzjSzupClzLsF", 418563, 5984.0);
        Account a2 = new Account("npdYfsOSDC'-iTXhyoYvPhjg", 871662, 97842.0);


        bank.addAccount(a1);
        bank.addAccount(a2);
        String newAccountName = "sVldpJSysz";
        double newAccountBalance = 42486.0;
        byte targetIndex = 1;

        assertTrue(bank.modifyAccount(targetIndex, newAccountName, newAccountBalance) &&
                bank.viewAccount(targetIndex).getAccountName().equals(newAccountName) &&
                bank.viewAccount(targetIndex).getAccountBalance() == newAccountBalance
        );
    }
    @Test
    public void test_Bank_23(){
        Bank bank = new Bank("YaqsWlJv276CUfHz& &evFtuHl", Bank.BranchLocations.values()[1]);
        Account a1 = new Account("wvvGodX QzjSzupClzLsF", 418563, 5984.0);
        Account a2 = new Account("npdYfsOSDC'-iTXhyoYvPhjg", 871662, 97842.0);


        bank.addAccount(a1);
        bank.addAccount(a2);
        int targetAccountNumber = 871662;

        assertTrue(bank.deleteAccount(targetAccountNumber) &&
                bank.viewAccount(targetAccountNumber).equals(new Account())
        );
    }
    @Test
    public void test_Bank_24(){
        Bank bank = new Bank("YaqsWlJv276CUfHz& &evFtuHl", Bank.BranchLocations.values()[1]);
        Account a1 = new Account("wvvGodX QzjSzupClzLsF", 418563, 5984.0);
        Account a2 = new Account("npdYfsOSDC'-iTXhyoYvPhjg", 871662, 97842.0);


        bank.addAccount(a1);
        bank.addAccount(a2);
        byte targetIndex = 1;

        assertTrue(bank.deleteAccount(targetIndex) &&
                bank.viewAccount(targetIndex).equals(new Account()));
    }

}