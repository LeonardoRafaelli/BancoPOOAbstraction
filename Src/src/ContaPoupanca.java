public class ContaPoupanca extends ContaBancaria{

    private double taxaDeOperacao = 20;

    public ContaPoupanca(int numConta, double saldo) {
        super(numConta, saldo);
    }

    @Override
    public void sacar(double valor) {

    }

    @Override
    public void depositar(double valor) {

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

    @Override
    public String toString() {
        return super.toString() + " --- ContaPoupanca{" +
                "taxaDeOperacao=" + taxaDeOperacao +
                '}';
    }
}
