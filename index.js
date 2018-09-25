var app = require('./config/custom-express')();

app.listen(function(){
  console.log('Servidor rodando na porta 80.');
});
