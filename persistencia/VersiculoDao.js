function VersiculoDao(connection) {
    this._connection = connection;
}

VersiculoDao.prototype.buscaPorId = function (version, liv, cap, vers, callback) {
    var query = " select * from versiculos where ver_vrs_id = ?  and ver_liv_id = ? and ver_capitulo = ? and ver_versiculo = ? ";
    this._connection.query(query, [version, liv, cap, vers], callback);
}

module.exports = function(){
    return VersiculoDao;
};
