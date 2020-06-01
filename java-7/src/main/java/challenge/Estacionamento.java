package challenge;

import java.util.ArrayList;
import java.util.List;

public class Estacionamento {

    private List<Carro> lstCarros = new ArrayList<Carro>();


    public void estacionar(Carro carro) { //https://www.codenation.dev/code-review/#/java-7/cp8HSP_ZR
        // Para entrar no estacionamento, é necessário que exista um motorista, ou seja, nada de carro autônomo.
        if (carro.getMotorista() == null) throw new  EstacionamentoException("É necessário ter um motorista para poder estacionar.");

        if (carrosEstacionados() >= 10) { //
            int motoristaRemovido = 0;
            for (Carro carroDaLista: lstCarros) {
                if ((motoristaRemovido == 0)  && (carroDaLista.getMotorista().getIdade() < 55)) {
                    lstCarros.remove(carroDaLista);
                    lstCarros.add(carro);
                    motoristaRemovido = 1;
                    break;
                }
            }
            if (motoristaRemovido == 0) { // nao foi removido motorista
                throw new EstacionamentoException("O estacionamento não possui mais vagas.");
            }
        } else {
            lstCarros.add(carro);
        }

        //O número de vagas do estacionamento são de dez carros.
        // O estacionamento não deverá comportar o número superior de vagas.
        //  Caso o estacionamento esteja lotado e Chegue mais um novo carro, o primeiro que estacionou deverá sair
        //   Caso o motorista do primeiro carro estacionado tenha uma idade superior a 55 anos, será escolhido o próximo motorista abaixo dos 55 anos.
        //   Caso todos os motoristas, dentro do estacionamento, tenham mais de 55 anos e chegue um motorista, ele não conseguirá estacionar.
    }

    public int carrosEstacionados() {
        return lstCarros.size();
    }

    public boolean carroEstacionado(Carro carro) {
        boolean blnCarroEstacionado=false;
        for (Carro carroEst: lstCarros){
            if (carro.equals(carroEst)){
                blnCarroEstacionado = true;
            }
        }
        return blnCarroEstacionado;
    }
}
