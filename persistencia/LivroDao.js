function LivroDao(connection) {
    this._connection = connection;
}

LivroDao.prototype.buscaPorTestamento = function (test, callback) {
    this._connection.query("select * from livros where liv_tes_id = ? order by liv_nome",[test],callback);
}

LivroDao.prototype.getAll = function(callback) {
    this._connection.query('select * from livros',callback);
}

module.exports = function(){
    return LivroDao;
};
