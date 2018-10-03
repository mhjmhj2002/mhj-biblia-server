function VersaoDao(connection) {
    this._connection = connection;
}

VersaoDao.prototype.getAll = function(callback) {
    this._connection.query('select * from versoes order by vrs_nome',callback);
}

module.exports = function(){
    return VersaoDao;
};
