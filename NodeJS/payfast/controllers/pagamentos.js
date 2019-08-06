module.exports = function(app) {

app.get('/pagamentos', function(req, resp) {
    console.log('Recebida requisicao de teste na porta 3000.');
    resp.send('OK');
});

app.put('/pagamentos/pagamento/:id', function (req, resp) {

    var pagamento = {};

    var id = req.params.id;

    pagamento.id = id;
    pagamento.status = 'CONFIRMADO';

    var connection = app.persistencia.connectionFactory();
    var pagamentoDao = new app.persistencia.PagamentoDao(connection);

    pagamentoDao.atualiza(pagamento, function (erro) {
        if(erro) {
            resp.status(500).send(erro);
            return;
        }
        resp.send(pagamento);

});

});

app.post('/pagamentos/pagamento', function(req, resp) {
var pagamento = req.body;

req.assert("forma_de_pagamento", "Forma de pagamento é obrigatório.").notEmpty();
req.assert("valor", "Valor é obrigatório e deve ser um decimal.").notEmpty().isFloat();
req.assert("moeda", "Moeda é obrigatória e deve ter 3 caracteres.").notEmpty().len(3,3);

var errors = req.validationErrors();

if(errors) {
    console.log("Erros de validação encontrados");
    resp.status(400).send(errors);
    return;
}

console.log('processando pagamento ...');


pagamento.status = 'CRIADO';
pagamento.data = new Date;

var connection = app.persistencia.connectionFactory();
var pagamentoDao = new app.persistencia.PagamentoDao(connection);

pagamentoDao.salva(pagamento, function(erro, resultado){

    if(erro) {
        
        console.log('Erro ao inserir no banc:' + erro);
        resp.status(500).send(erro);
   
    } else {
        console.log('Pagamento criado');
        resp.location('/pagamentos/pagamento/' + resultado.insertId);
        resp.status(201).json(pagamento);
        
    }
        
});
    
});
}