function VersiculoDao(connection) {
    this._connection = connection;
}

VersiculoDao.prototype.buscaPorId = function (version, liv, cap, versIni, versFim, callback) {    
    var query = " select ver_capitulo, ver_versiculo, ver_texto from versiculos where ver_vrs_id = ?  and ver_liv_id = ? and ver_capitulo = ? and ver_versiculo between ? and ? ";
    this._connection.query(query, [version, liv, cap, versIni, versFim], callback);
}

module.exports = function(){
    return VersiculoDao;
};
