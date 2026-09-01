// Base de dados simulada em memória
let db = {
  saldo: 2500.00,
  cartoes: [],
  emprestimosSimulados: []
};

// 1. Consulta de Saldo
const consultarSaldo = (req, res) => {
  return res.status(200).json({
    sucesso: true,
    saldoAtual: db.saldo,
    moeda: "BRL"
  });
};

// 2. Simulação de Crédito
const simularCredito = (req, res) => {
  const { valorSolicitado, parcelas } = req.body;

  if (!valorSolicitado || !parcelas) {
    return res.status(400).json({ erro: "Informe o valor solicitado e a quantidade de parcelas." });
  }

  // Simulação simples com taxa de juros fixa de 2% ao mês (Tabela Price simplificada)
  const taxaJuros = 0.02;
  const valorComJuros = valorSolicitado * Math.pow(1 + taxaJuros, parcelas);
  const valorParcela = valorComJuros / parcelas;

  const simulacao = {
    idSimulacao: Date.now(),
    valorSolicitado,
    parcelas,
    valorParcela: Number(valorParcela.toFixed(2)),
    valorTotalAPagar: Number(valorComJuros.toFixed(2)),
    taxaJurosMensal: "2%"
  };

  db.emprestimosSimulados.push(simulacao);

  return res.status(200).json({
    sucesso: true,
    mensagem: "Simulação realizada com sucesso",
    detalhes: simulacao
  });
};

// 3. Criação de Cartão (Virtual/Físico)
const criarCartao = (req, res) => {
  const { titular, tipo } = req.body; // tipo: 'Físico' ou 'Virtual'

  if (!titular) {
    return res.status(400).json({ erro: "O nome do titular é obrigatório." });
  }

  const novoCartao = {
    id: db.cartoes.length + 1,
    titular,
    tipo: tipo || "Virtual",
    numeroCartao: `**** **** **** ${Math.floor(1000 + Math.random() * 9000)}`,
    limiteDisponivel: 5000.00,
    status: "Ativo",
    criadoEm: new Date()
  };

  db.cartoes.push(novoCartao);

  return res.status(201).json({
    sucesso: true,
    mensagem: "Cartão criado com sucesso",
    cartao: novoCartao
  });
};

module.exports = {
  consultarSaldo,
  simularCredito,
  criarCartao
};