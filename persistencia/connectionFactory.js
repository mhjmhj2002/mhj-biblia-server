var mysql  = require('mysql');

function createDBConnection(){
		return mysql.createConnection({
			host: 'mysql.mhj.kinghost.net',
			user: 'mhj',
			password: '2y244y26',
			database: 'mhj',
			connectionLimit : 10
		});
}

module.exports = function() {
	return createDBConnection;
}
