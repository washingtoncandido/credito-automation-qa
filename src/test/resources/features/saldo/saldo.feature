# language: pt
Funcionalidade: Consulta de Saldo
  Como um analista de qualidade
  Quero validar a API de consulta de saldo
  Para garantir que o saldo atual e a moeda sejam retornados corretamente

  @regressivo @api @saldo
  Cenário: Consultar o saldo atual com sucesso
    Quando eu realizo a requisição para consultar o saldo
    Então a API de saldo deve retornar o status code 200 OK
    E o saldo atual retornado deve ser válido com a moeda "BRL"