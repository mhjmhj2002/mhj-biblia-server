var express = require('express');
var cors = require('cors');
var consign = require('consign');
var bodyParser = require('body-parser');
// var expressValidator = require('express-validator');
var pool = require('./connectionFactory');
var connectionMiddleware = require('./connection-middleware');

module.exports = function(){
  var app = express();
  app.use(cors());
    
  app.use(connectionMiddleware(pool));

  app.use(bodyParser.urlencoded({extended: true}));
  app.use(bodyParser.json());

  // app.use(expressValidator());
  
  // Add headers
  app.use(function (req, res, next) {

    // Website you wish to allow to connect
    res.setHeader('Access-Control-Allow-Origin', 'http://www.mhj.kinghost.net');
    //res.setHeader('Access-Control-Allow-Origin', 'localhost');

    // Request methods you wish to allow
    res.setHeader('Access-Control-Allow-Methods', 'GET, POST, OPTIONS, PUT, PATCH, DELETE');

    // Request headers you wish to allow
    res.setHeader('Access-Control-Allow-Headers', 'X-Requested-With,content-type');

    // Set to true if you need the website to include cookies in the requests sent
    // to the API (e.g. in case you use sessions)
    res.setHeader('Access-Control-Allow-Credentials', true);

    // Pass to next layer of middleware
    next();
  });

  consign()
   .include('biblia/controllers')
   .then('biblia/persistencia')
   .into(app);

  return app;
}
