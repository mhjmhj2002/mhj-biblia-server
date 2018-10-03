function TestamentoDao(connection) {
    this._connection = connection;
}

TestamentoDao.prototype.getAll = function(callback) {
    this._connection.query('select * from testamentos order by tes_nome',callback);
}

module.exports = function(){
    return TestamentoDao;
};
