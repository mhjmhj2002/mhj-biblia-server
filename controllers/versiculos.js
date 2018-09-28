module.exports = function(app){
  app.get('/versiculos', function(req, res){
    console.log('Recebida requisicao de teste na porta 3000.')
    res.send('OK.');
  });  

  app.get('/versiculos/versiculo/:version/:liv/:cap/:vers', function(req, res){
    var version = req.params.version;
    var liv = req.params.liv;
    var cap = req.params.cap;
    var vers = req.params.vers;
    console.log('consultando version: ' + version);
    console.log('consultando liv: ' + liv);
    console.log('consultando cap: ' + cap);
    console.log('consultando vers: ' + vers);

    var connection = app.persistencia.connectionFactory();
    var versiculoDao = new app.persistencia.VersiculoDao(connection);

    versiculoDao.buscaPorId(version, liv, cap, vers, function(erro, resultado){
      if(erro){
        console.log('erro ao consultar no banco: ' + erro);
        res.status(500).send(erro);
        return;
      }
      console.log('versiculo encontrado: ' + JSON.stringify(resultado));
      res.json(resultado);
	  connection.release();
      return;
    });

  });
}
