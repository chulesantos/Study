module.exports = function(app) {

app.get('/pagamentos', function(req, resp) {
    console.log('Recebida requisicao de teste na porta 3000.');
    resp.send('OK');
});

    const PAGAMENTO_CRIADO = "CRIADO";
      const PAGAMENTO_CONFIRMADO = "CONFIRMADO";
      const PAGAMENTO_CANCELADO = "CANCELADO";

app.delete('/pagamentos/pagamento/:id', function (req, resp) {

    var pagamento = {};

    var id = req.params.id;

    pagamento.id = id;
    pagamento.status = PAGAMENTO_CANCELADO;

    var connection = app.persistencia.connectionFactory();
    var pagamentoDao = new app.persistencia.PagamentoDao(connection);

    pagamentoDao.atualiza(pagamento, function (erro) {
        if(erro) {
            resp.status(500).send(erro);
            return;
            console.log('pagamento cancelado');
            
        }
        resp.status(204).send(pagamento);

});

});

app.put('/pagamentos/pagamento/:id', function (req, resp) {

    var pagamento = {};

    var id = req.params.id;

    pagamento.id = id;
    pagamento.status = PAGAMENTO_CONFIRMADO;

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
var pagamento = req.body["pagamento"];

req.assert("pagamento.forma_de_pagamento", "Forma de pagamento é obrigatório.").notEmpty();
req.assert("pagamento.valor", "Valor é obrigatório e deve ser um decimal.").notEmpty().isFloat();
req.assert("pagamento.moeda", "Moeda é obrigatória e deve ter 3 caracteres.").notEmpty().len(3,3);

var errors = req.validationErrors();

if(errors) {
    console.log("Erros de validação encontrados");
    resp.status(400).send(errors);
    return;
}

console.log('processando pagamento ...');


pagamento.status = PAGAMENTO_CRIADO;
pagamento.data = new Date;

var connection = app.persistencia.connectionFactory();
var pagamentoDao = new app.persistencia.PagamentoDao(connection);

pagamentoDao.salva(pagamento, function(erro, resultado){

    if(erro) {
        
        console.log('Erro ao inserir no banc:' + erro);
        resp.status(500).send(erro);
   
    } else {
        pagamento.id = resultado.insertId;
        console.log('Pagamento criado');

        if(pagamento.forma_de_pagamento == 'cartao') {
            var cartao = req.body["cartao"];
            console.log(cartao);

            clienteCartoes.autoriza(cartao);


            resp.status(201).json(cartao);
            
            return;
        }
        resp.location('/pagamentos/pagamento/' + pagamento.id);

        var response = {
            dados_do_pagamento: pagamento,
            links: [
                {
                    href: "http://localhost:3000/pagamentos/pagamento/"
                    + pagamento.id,
                    rel: "confirmar",
                    method: "PUT"
                },

                {
                    href: "http://localhost:3000/pagamentos/pagamento/"
                    + pagamento.id,
                    rel: "cancelar",
                    method: "DELETE"

                }
            ]
        }

        resp.status(201).json(response);
        
    }
        
});
    
});
}