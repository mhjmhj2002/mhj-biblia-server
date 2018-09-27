function TestamentoDao(connection) {
    this._connection = connection;
}

TestamentoDao.prototype.getAll = function(callback) {
    this._connection.query('select * from testamentos',callback);
}

module.exports = function(){
    return TestamentoDao;
};
