const app = require('./config/custom-express')();

app.listen(3000, function(){
  console.log('Servidor Envio SOAP rodando na porta 3000 !');
});
