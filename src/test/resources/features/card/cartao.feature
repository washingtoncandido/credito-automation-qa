# language: pt
Funcionalidade: Criação de Cartão
  Como um analista de qualidade
  Quero validar a criação de cartões via API
  Para garantir que os dados do cartão sejam retornados corretamente

  @regressivo @api @cartao
  Cenário: Criar cartão virtual com sucesso
    Dado que eu informo o titular "Maria Silva" e o tipo "Virtual"
    Quando eu envio a requisição para o endpoint de criação de cartão
    Então a API de cartão deve retornar o status code 201 OK
    E a mensagem de criação deve ser "Cartão criado com sucesso"
    E o cartão deve conter o titular "Maria Silva" e o tipo "Virtual"