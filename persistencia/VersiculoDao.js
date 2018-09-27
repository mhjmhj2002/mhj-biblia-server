function VersiculoDao(connection) {
    this._connection = connection;
}

VersiculoDao.prototype.buscaPorId = function (version, liv, cap, vers, callback) {
    this._connection.query("select * from versiculos where ver_vrs_id = ? and ver_liv_id = ? and ver_capitulo = ? and ver_versiculo = ?",[version, liv, cap, vers],callback);
}

module.exports = function(){
    return VersiculoDao;
};
