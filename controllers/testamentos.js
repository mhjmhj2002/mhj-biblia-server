module.exports = function(app){
  
  var cors = require('cors');

  app.get('/testamentos', function(req, res){
    console.log('Recebida requisicao de teste na porta 3000.')
    res.send('OK.');
  });  

  app.get('/testamentos/getAll', cors(), function(req, res){

    var connection = req.connection;//app.persistencia.connectionFactory();
    var testamentoDao = new app.biblia.persistencia.TestamentoDao(connection);

    testamentoDao.getAll(function(erro, resultado){
      if(erro){
        console.log('erro ao consultar no banco: ' + erro);
        res.status(500).send(erro);
        return;
      }
      console.log('testamentos encontrados: ' + JSON.stringify(resultado));
      res.json(resultado);
      return;
    });

  });
}
