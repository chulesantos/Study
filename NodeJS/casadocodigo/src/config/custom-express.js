require('marko/node-require').install();
require('marko/express');

const express = require('express');
app = express();

const bodyParser = require('body-parser');
const methodOverride = require('method-override');

app.use('/estatico', express.static('src/app/public'));

app.use(bodyParser.urlencoded({
    extended: true
}));

app.use(methodOverride(function (req, res) {
    if(req.body && typeof req.body === 'object' && '_method' in req.body) {
        var method = req.body._method;
        delete req.body._method;
        return method;
    }
}));

const rotas = require('../app/rotas/rotas.js');

rotas(app);

module.exports = app;

