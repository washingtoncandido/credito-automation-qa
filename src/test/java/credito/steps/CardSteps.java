package credito.steps;

import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;
import io.restassured.response.Response;
import org.example.core.entities.CardDTO;
import org.example.core.requests.CardRequest;
import org.junit.jupiter.api.Assertions;

public class CardSteps {

    private final CardRequest cardRequest = new CardRequest();
    private CardDTO cardDTO;
    private Response response;

    @Dado("que eu informo o titular {string} e o tipo {string}")
    public void queEuInformoOTitularETipo(String titular, String tipo) {
        cardDTO = CardDTO.builder()
                .titular(titular)
                .tipo(tipo)
                .build();
    }

    @Quando("eu envio a requisição para o endpoint de criação de cartão")
    public void euEnvioARequisicaoParaOEndpointDeCriacaoDeCartao() {
        response = cardRequest.CreateCard(cardDTO);
    }

    @Então("a API de cartão deve retornar o status code {int} OK")
    public void aApiDeCartaoDeveRetornarOStatusCodeOK(int statusCode) {
        Assertions.assertEquals(statusCode, response.statusCode());
    }

    @E("a mensagem de criação deve ser {string}")
    public void aMensagemDeCriacaoDeveSer(String mensagemEsperada) {
        String mensagemAtual = response.jsonPath().getString("mensagem");
        Assertions.assertEquals(mensagemEsperada, mensagemAtual);
    }

    @E("o cartão deve conter o titular {string} e o tipo {string}")
    public void oCartaoDeveConterOTitularETipo(String titularEsperado, String tipoEsperado) {
        String titularAtual = response.jsonPath().getString("cartao.titular");
        String tipoAtual = response.jsonPath().getString("cartao.tipo");

        Assertions.assertEquals(titularEsperado, titularAtual);
        Assertions.assertEquals(tipoEsperado, tipoAtual);
        Assertions.assertNotNull(response.jsonPath().getString("cartao.numeroCartao"));
    }
}
