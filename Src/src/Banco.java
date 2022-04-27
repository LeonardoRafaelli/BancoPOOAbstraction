import java.util.ArrayList;

public class Banco {
    ArrayList<ContaBancaria> listaContas = new ArrayList<>();

    public void inserir(ContaBancaria conta){
        listaContas.add(conta);
    }

    public void remover(ContaBancaria conta){
        listaContas.remove(conta);
    }

    public ContaBancaria procurarConta(int numConta){
        for(int i = 0; i < listaContas.size(); i++){
            if(listaContas.get(i).getNumConta() == numConta){
                return listaContas.get(i);
            }
        }
        return null;
    }

    public String mostrarContas(){
        String contasString = "";
        for (ContaBancaria listaConta : listaContas) {
            contasString += listaConta.toString() + "\n";
        }

        return contasString;
    }

}
