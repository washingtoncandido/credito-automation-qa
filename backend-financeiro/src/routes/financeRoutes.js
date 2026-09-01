const { Router } = require('express');
const { consultarSaldo, simularCredito, criarCartao } = require('../controllers/financeController');

const router = Router();

router.get('/saldo', consultarSaldo);
router.post('/credito/simular', simularCredito);
router.post('/cartoes', criarCartao);

module.exports = router;