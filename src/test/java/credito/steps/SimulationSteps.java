package credito.steps;

import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;
import io.restassured.response.Response;
import org.example.core.entities.SimulationDTO;
import org.example.core.requests.SimulationRequest;
import org.junit.jupiter.api.Assertions;

public class SimulationSteps {

    private final SimulationRequest simulationRequest = new SimulationRequest();
    private SimulationDTO simulationDTO;
    private Response response;

    @Dado("que eu informo o valor solicitado de {double} e {int} parcelas")
    public void queEuInformoOValorSolicitadoDeEParcelas(double valor, int parcelas) {
        simulationDTO = SimulationDTO.builder()
                .valorSolicitado(valor)
                .parcelas(parcelas)
                .build();
    }

    @Quando("eu envio a requisição para o endpoint de simulação")
    public void euEnvioARequisicaoParaOEndpointDeSimulacao() {
        response = simulationRequest.simularCredito(simulationDTO);
    }

    @Então("a API deve retornar o status code {int} OK")
    public void aApiDeveRetornarOStatusCodeOK(int statusCode) {
        Assertions.assertEquals(statusCode, response.statusCode());
    }

    @E("a mensagem de sucesso deve ser {string}")
    public void aMensagemDeSucessoDeveSer(String mensagemEsperada) {
        String mensagemAtual = response.jsonPath().getString("mensagem");
        Assertions.assertEquals(mensagemEsperada, mensagemAtual);
    }

    @E("os detalhes do cálculo devem retornar a taxa de juros de {string}")
    public void osDetalhesDoCalculoDevemRetornarATaxaDeJurosDe(String taxaEsperada) {
        String taxaAtual = response.jsonPath().getString("detalhes.taxaJurosMensal");
        Assertions.assertEquals(taxaEsperada, taxaAtual);

        // Validação cruzada opcional do cálculo matemático retornado
        double valorParcelaRetornado = response.jsonPath().getDouble("detalhes.valorParcela");
        Assertions.assertTrue(valorParcelaRetornado > 0, "O valor da parcela deve ser maior que zero");
    }
}
