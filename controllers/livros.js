module.exports = function(app){
  app.get('/livros', function(req, res){
    console.log('Recebida requisicao de teste na porta 3000.')
    res.send('OK.');
  });  

  app.get('/livros/livro/:test', function(req, res){
    var test = req.params.test;
    console.log('consultando test: ' + test);

    var connection = app.persistencia.connectionFactory();
    var livroDao = new app.persistencia.LivroDao(connection);

    livroDao.buscaPorTestamento(test, function(erro, resultado){
      if(erro){
        console.log('erro ao consultar no banco: ' + erro);
        res.status(500).send(erro);
        return;
      }
      console.log('livro encontrado: ' + JSON.stringify(resultado));
      res.json(resultado);
	  connection.release();
      return;
    });

  });
}
