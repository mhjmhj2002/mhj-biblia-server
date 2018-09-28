module.exports = function(app){
  app.get('/versoes', function(req, res){
    console.log('Recebida requisicao de teste na porta 3000.')
    res.send('OK.');
  });  

  app.get('/versoes/getAll', function(req, res){

    var connection = app.persistencia.connectionFactory();
    var versaoDao = new app.persistencia.VersaoDao(connection);

    versaoDao.getAll(function(erro, resultado){
      if(erro){
        console.log('erro ao consultar no banco: ' + erro);
        res.status(500).send(erro);
        return;
      }
      console.log('versoes encontrados: ' + JSON.stringify(resultado));
      res.json(resultado);
      return;
    });

  });
}
