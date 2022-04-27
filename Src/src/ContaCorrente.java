public class ContaCorrente extends ContaBancaria{

    private double taxaDeOperacao = 20, limite = 500;

    public ContaCorrente(int numConta, double saldo) {
        super(numConta, saldo);
    }

    @Override
    public void sacar(double valor) {
        super.setSaldo(super.getSaldo() - valor);
    }

    @Override
    public void depositar(double valor) {
        super.setSaldo(super.getSaldo() + valor);
    }

    @Override
    public String mostrarDados() {
        return toString();
    }



    public double getTaxaDeOperacao() {
        return taxaDeOperacao;
    }

    public void setTaxaDeOperacao(double taxaDeOperacao) {
        this.taxaDeOperacao = taxaDeOperacao;
    }

    public double getLimite() {
        return limite;
    }

    public void setLimite(double limite) {
        this.limite = limite;
    }

    @Override
    public String toString() {
        return super.toString() + " --- ContaCorrente{" +
                "taxaDeOperacao=" + taxaDeOperacao +
                ", limite=" + limite +
                '}';
    }
}
