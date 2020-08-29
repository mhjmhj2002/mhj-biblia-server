module.exports = function(app){
  
  var cors = require('cors');

  app.get('/versiculos', function(req, res){
    console.log('Recebida requisicao de teste na porta 3000.')
    res.send('OK.');
  });  

  app.get('/versiculos/versiculo/:version/:liv/:cap/:versIni/:versFim', cors(), function(req, res){
    var version = req.params.version;
    var liv = req.params.liv;
    var cap = req.params.cap;
    var versIni = req.params.versIni;
    var versFim = req.params.versFim;
    console.log('consultando version: ' + version);
    console.log('consultando liv: ' + liv);
    console.log('consultando cap: ' + cap);
    console.log('consultando versIni: ' + versIni);
    console.log('consultando versFim: ' + versFim);

    var connection = req.connection;//app.persistencia.connectionFactory();
    var versiculoDao = new app.biblia.persistencia.VersiculoDao(connection);

    versiculoDao.buscaPorId(version, liv, cap, versIni, versFim, function(erro, resultado){
      if(erro){
        console.log('erro ao consultar no banco: ' + erro);
        res.status(500).send(erro);
        return;
      }
      console.log('versiculo encontrado: ' + JSON.stringify(resultado));
      res.json(resultado);
      return;
    });

  });  

  app.get('/versiculos/capitulo/:liv', cors(), function(req, res){
    var liv = req.params.liv;
    console.log('consultando liv: ' + liv);

    var connection = req.connection;//app.persistencia.connectionFactory();
    var versiculoDao = new app.biblia.persistencia.VersiculoDao(connection);

    versiculoDao.getQuantidadeCapitulos(liv, function(erro, resultado){
      if(erro){
        console.log('erro ao consultar no banco: ' + erro);
        res.status(500).send(erro);
        return;
      }
      console.log('quantidade capitulos encontrado: ' + JSON.stringify(resultado));
      res.json(resultado);
      return;
    });

  });  

  app.get('/versiculos/versiculo/:liv/:vers', cors(), function(req, res){
    var liv = req.params.liv;
    var vers = req.params.vers;
    console.log('consultando liv: ' + liv);
    console.log('consultando vers: ' + vers);

    var connection = req.connection;//app.persistencia.connectionFactory();
    var versiculoDao = new app.biblia.persistencia.VersiculoDao(connection);

    versiculoDao.getQuantidadeVersiculos(liv, vers, function(erro, resultado){
      if(erro){
        console.log('erro ao consultar no banco: ' + erro);
        res.status(500).send(erro);
        return;
      }
      console.log('quantidade versiculos encontrado: ' + JSON.stringify(resultado));
      res.json(resultado);
      return;
    });

  }); 

  app.get('/versiculos/palavra/quantidade/:version/:liv/:cap/:versIni/:versFim/:word', cors(), function(req, res){
    var version = req.params.version;
    var liv = req.params.liv;
    var cap = req.params.cap;
    var versIni = req.params.versIni;
    var versFim = req.params.versFim;
    var word = req.params.word;
    console.log('consultando version: ' + version);
    console.log('consultando liv: ' + liv);
    console.log('consultando cap: ' + cap);
    console.log('consultando versIni: ' + versIni);
    console.log('consultando versFim: ' + versFim);
    console.log('consultando word: ' + word);

    var connection = req.connection;//app.persistencia.connectionFactory();
    var versiculoDao = new app.biblia.persistencia.VersiculoDao(connection);

    versiculoDao.contaPorPalavra(version, liv, cap, versIni, versFim, word, function(erro, resultado){
      if(erro){
        console.log('erro ao consultar no banco: ' + erro);
        res.status(500).send(erro);
        return;
      }
      console.log('palavra encontrada: ' + JSON.stringify(resultado));
      res.json(resultado);
      return;
    });

  }); 

  app.get('/versiculos/palavra/get/:version/:liv/:cap/:versIni/:versFim/:word', cors(), function(req, res){
    var version = req.params.version;
    var liv = req.params.liv;
    var cap = req.params.cap;
    var versIni = req.params.versIni;
    var versFim = req.params.versFim;
    var word = req.params.word;
    console.log('consultando version: ' + version);
    console.log('consultando liv: ' + liv);
    console.log('consultando cap: ' + cap);
    console.log('consultando versIni: ' + versIni);
    console.log('consultando versFim: ' + versFim);
    console.log('consultando word: ' + word);

    var connection = req.connection;//app.persistencia.connectionFactory();
    var versiculoDao = new app.biblia.persistencia.VersiculoDao(connection);

    versiculoDao.buscaPorPalavra(version, liv, cap, versIni, versFim, word, function(erro, resultado){
      if(erro){
        console.log('erro ao consultar no banco: ' + erro);
        res.status(500).send(erro);
        return;
      }
      console.log('palavra encontrada: ' + JSON.stringify(resultado));
      res.json(resultado);
      return;
    });

  });  

}
