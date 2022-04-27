public abstract class ContaBancaria {
    private int numConta;
    private double saldo;

    public abstract void sacar(double valor);
    public abstract void depositar(double valor);
    public abstract String mostrarDados();

    public void transferir(double valor, ContaBancaria conta){
        conta.depositar(valor);
    };

    public ContaBancaria(int numConta, double saldo) {
        this.numConta = numConta;
        this.saldo = saldo;
    }

    public int getNumConta() {
        return numConta;
    }

    public void setNumConta(int numConta) {
        this.numConta = numConta;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    @Override
    public String toString() {
        return "ContaBancaria{" +
                "numConta=" + numConta +
                ", saldo=" + saldo +
                '}';
    }
}
