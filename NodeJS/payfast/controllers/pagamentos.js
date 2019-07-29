module.exports = function(app) {

app.get('/pagamentos', function(req, resp) {
    console.log('Recebida requisicao de teste na porta 3000.');
    resp.send('OK');
    

});

}