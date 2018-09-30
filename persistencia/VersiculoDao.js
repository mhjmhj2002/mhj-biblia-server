function VersiculoDao(connection) {
    this._connection = connection;
}

VersiculoDao.prototype.buscaPorId = function (version, liv, cap, vers, callback) {
    var query = " select * from versiculos where 1 = 1 ";
    if(version != null){
        query = query + " and ver_vrs_id = " + version;
    }
    if(liv != null){
        query = query + " and ver_liv_id = " + liv;
    }
    if(cap != null){
        query = query + " and ver_capitulo = " + cap;
    }
    if(vers != null){
        query = query + "and ver_versiculo = " + vers;
    }
    this._connection.query(query, "", callback);
}

module.exports = function(){
    return VersiculoDao;
};
