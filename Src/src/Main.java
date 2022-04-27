import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static Banco banco = new Banco();

    public static void main(String[] args) {
        menuPrincipal();
    }

    private static void menuPrincipal(){
        System.out.println("--- Bem Vindo ao Banco ---" +
                "\n1 - Criar conta;" +
                "\n2 - Selecionar conta;" +
                "\n3 - Remover conta;" +
                "\n4 - Gerar relarótio;" +
                "\n5 - Encerrar. ");
        switch (sc.nextInt()){
            case 1: createAccount(); break;
            case 2: selectAccount(); break;
            case 3: removeAccount(); break;
            case 4: generateReport(); break;
            case 5: System.exit(0);
        };
        menuPrincipal();
    }

    public static  void createAccount(){
        System.out.println("--- Account Creation ---" +
                "\nAccount Type:" +
                "\n1 - Checking Account;" +
                "\n2 - Savings Account.");
        int accountOption = sc.nextInt();
        System.out.print("Account number: ");
        int accountNumber = sc.nextInt();
        System.out.print("Current balance: ");
        double balance = sc.nextDouble();
        if(accountOption == 1){
            banco.inserir(new ContaCorrente(accountNumber, balance));
        } else {
            banco.inserir(new ContaPoupanca(accountNumber, balance));
        }

        System.out.println("Your account has been successfully created!");
    }

    private static ContaBancaria getAccount(){
        System.out.print("Insert the account's number: ");
        return banco.procurarConta(sc.nextInt());
    }

    private static void selectAccount(){
        ContaBancaria logAccount = getAccount();
        if(logAccount != null){
            loggedMenu(logAccount);
        } else {
            System.out.println("Conta não encontrada!");
        }
    }

    private static void loggedMenu(ContaBancaria logAccount){
        System.out.print("--- Your Account Menu ---" +
                "\n1 - Deposit;" +
                "\n2 - Withdraw;" +
                "\n3 - Tranference;" +
                "\n4 - Generate Report;" +
                "\n5 - Return to the main menu;");
        switch (sc.nextInt()){
            case 1: {
                System.out.print("Deposit amount U$: ");
                logAccount.depositar(sc.nextDouble());
            }
            case 2: {
               withdraw(logAccount);
            }
            case 3: {
                System.out.print("Benefited account number");
                ContaBancaria benefitedAcc = getAccount();
                System.out.print("Transference's amount U$: ");
                double amount = sc.nextDouble();

                logAccount.setSaldo(logAccount.getSaldo() - amount);
                benefitedAcc.setSaldo(benefitedAcc.getSaldo() + amount);
                System.out.print("Transference has been made!");
            }
            case 4: {
                logAccount.toString();
            }
        }
    }

    private static void withdraw(ContaBancaria logAccount){
        System.out.print("Withdraw amount U$: ");
        double withdraw = sc.nextDouble();
        if(logAccount instanceof  ContaCorrente){
            if(withdraw < logAccount.getSaldo() + (((ContaCorrente) logAccount).getLimite())){
                if(logAccount.getSaldo() >= 0 - (((ContaCorrente) logAccount).getLimite())){
                    logAccount.sacar(withdraw);
                } else {
                    System.out.println("Your account does not have enough money to withdraw");
                }
            } else {
                System.out.println("You cannot withdraw more than U$" + (logAccount.getSaldo() + (((ContaCorrente) logAccount).getLimite())));
            }
        } else {
            if(withdraw > logAccount.getSaldo()){
                logAccount.sacar(withdraw);
            } else {
                System.out.println("You cannot withdraw more than U$" + (logAccount.getSaldo()));
            }
        }
    }

    private static void removeAccount(){
        ContaBancaria logAccount = getAccount();
        if(logAccount != null){
            banco.remover(logAccount);
            System.out.println("Account have been removed!");
        } else {
            System.out.println("Account not found!");
        }
    }

    private static void generateReport(){
        System.out.println("--- Account's Report ---");
        System.out.println(banco.mostrarContas());
    }


}
