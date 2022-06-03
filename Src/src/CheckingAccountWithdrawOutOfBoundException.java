public class WithdrawOutOfBoundException extends RuntimeException {
    public WithdrawOutOfBoundException(ContaCorrente logAccount) {
        System.out.println("You cannot withdraw more than U$" + (logAccount.getSaldo() + (((ContaCorrente) logAccount).getLimite())));
    }
}
