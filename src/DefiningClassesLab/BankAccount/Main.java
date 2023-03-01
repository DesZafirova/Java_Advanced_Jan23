package BankAccount;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] lineArguments = scanner.nextLine().split("\\s+");
        Map<Integer, BankAccount> accounts = new HashMap<>();
        String command = lineArguments[0];
        while (!command.equals("End")) {
            String result = "";
            switch (command) {
                case "Create":
                    BankAccount bankAccount = new BankAccount();
                    accounts.put(bankAccount.getId(), bankAccount);
                    result = String.format("Account ID%d created", bankAccount.getId());
                    break;

                case "Deposit":
                    int accountId = Integer.parseInt(lineArguments[1]);
                    double money = Double.parseDouble(lineArguments[2]);

                    if (accounts.containsKey(accountId)) {
                        BankAccount bankAccountFromMap = accounts.get(accountId);
                        bankAccountFromMap.deposit(money);
                        accounts.put(accountId, bankAccountFromMap);
                        result = String.format("Deposited %.0f to ID%d",money, accountId);

                    }else{
                        result = "Account does not exist";
                    }
                    break;

                case "SetInterest":
                    double interestRate = Double.parseDouble(lineArguments[1]);
                    BankAccount.setInterestRate(interestRate);
                    break;

                case "GetInterest":
                    int accountID = Integer.parseInt(lineArguments[1]);
                    int years = Integer.parseInt(lineArguments[2]);
                    if(accounts.containsKey(accountID)){
                        BankAccount bankAccount1 = accounts.get(accountID);
                       double totalInterest = bankAccount1.getInterest(years);
                        result = String.format("%.2f",totalInterest );
                    }else {
                        result = "Account does not exist";

                    }

                    break;
            }
            if(!result.isEmpty()) {
                System.out.println(result);
            }

            lineArguments = scanner.nextLine().split("\\s+");
            command = lineArguments[0];
        }
    }
}
