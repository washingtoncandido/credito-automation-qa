# language: pt
Funcionalidade: Simulação de Crédito
  Como um analista de qualidade
  Quero validar o motor de cálculo de simulação de crédito
  Para garantir que a taxa de juros, o valor da parcela e o total a pagar estejam corretos

  @regressivo @api @credito
  Cenário: Realizar simulação de crédito com sucesso e validar cálculos
    Dado que eu informo o valor solicitado de 1000.00 e 12 parcelas
    Quando eu envio a requisição para o endpoint de simulação
    Então a API deve retornar o status code 200 OK
    E a mensagem de sucesso deve ser "Simulação realizada com sucesso"
    E os detalhes do cálculo devem retornar a taxa de juros de "2%"