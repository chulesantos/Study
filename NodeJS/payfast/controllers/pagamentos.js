module.exports = function(app) {

app.get('/pagamentos', function(req, resp) {
    console.log('Recebida requisicao de teste na porta 3000.');
    resp.send('OK');
});

app.post('/pagamentos/pagamento', function(req, resp) {
var pagamento = req.body;
console.log('Processamento uma requisicao de um novo pagamento.');

pagamento.status = 'CRIADO';
pagamento.data = new Date;

resp.send(pagamento);
    
});
}