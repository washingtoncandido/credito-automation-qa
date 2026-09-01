package credito.steps;

import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;
import io.restassured.response.Response;
import org.example.core.entities.SaldoDTO;
import org.example.core.requests.SaldoRequest;
import org.junit.jupiter.api.Assertions;

public class SaldoSteps {

    private final SaldoRequest saldoRequest = new SaldoRequest();
    private Response response;

    @Quando("eu realizo a requisição para consultar o saldo")
    public void euRealizoARequisicaoParaConsultarOSaldo() {
        response = saldoRequest.consultaSaldo();
    }

    @Então("a API de saldo deve retornar o status code {int} OK")
    public void aApiDeSaldoDeveRetornarOStatusCodeOK(int statusCode) {
        Assertions.assertEquals(statusCode, response.statusCode());
    }

    @E("o saldo atual retornado deve ser válido com a moeda {string}")
    public void oSaldoAtualRetornadoDeveSerValidoComAMoeda(String moedaEsperada) {
        SaldoDTO saldoDTO = response.as(SaldoDTO.class);

        Assertions.assertTrue(saldoDTO.isSucesso(), "O status de sucesso deve ser verdadeiro");
        Assertions.assertEquals(moedaEsperada, saldoDTO.getMoeda());
        Assertions.assertTrue(saldoDTO.getSaldoAtual() >= 0, "O saldo atual não pode ser negativo");
    }
}