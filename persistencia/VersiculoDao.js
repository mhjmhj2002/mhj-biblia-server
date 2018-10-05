function VersiculoDao(connection) {
    this._connection = connection;
}

VersiculoDao.prototype.buscaPorId = function (version, liv, cap, versIni, versFim, callback) {    
    var query = " select ver_capitulo, ver_versiculo, ver_texto from versiculos where ver_vrs_id = ?  and ver_liv_id = ? and ver_capitulo = ? and ver_versiculo between ? and ? ";
    this._connection.query(query, [version, liv, cap, versIni, versFim], callback);
}

VersiculoDao.prototype.getQuantidadeCapitulos = function (liv, callback) {
    var query = " SELECT max(ver_capitulo) as qtde_capitulos from versiculos where ver_liv_id = ? ";
    this._connection.query(query, [liv], callback);
}

VersiculoDao.prototype.getQuantidadeVersiculos = function (liv, vers, callback) {
    var query = " SELECT max(ver_versiculo) as qtde_versiculos from versiculos where ver_liv_id = ? and ver_capitulo = ?";
    this._connection.query(query, [liv, vers], callback);
}

module.exports = function(){
    return VersiculoDao;
};

VersiculoDao.prototype.buscaPorPalavra = function (version, liv, cap, versIni, versFim, word, callback) {    
    var query = " select count(ver_id) from versiculos where upper(ver_texto) like %upper(?)% and ver_vrs_id = ? ";
    if(liv != null) {
        query += " and ver_liv_id = " + liv;
    }
    if(cap != null) {
        query += " and ver_capitulo = " + cap;
    }
    if(versIni != null) {
        query += " and ver_versiculo > " + versIni;
    }
    if(versFim != null) {
        query += " and ver_versiculo < " + versFim;
    }    
    this._connection.query(query, [word, version], callback);
}
