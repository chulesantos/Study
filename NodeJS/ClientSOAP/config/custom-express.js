const express = require('express');
const consign = require('consign');
const bodyParser = require('body-parser');
const expressValidator = require('express-validator');

module.exports = function(){
    const app = express();
  
  app.use(bodyParser.json());

  app.use(expressValidator());

  consign()
   .include('controller')
   .into(app);

  return app;
}