/*
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
*/

const mysql = require('mysql');

const pool = mysql.createPool({
    connectionLimit: 10,
    host : 'mysql.mhj.kinghost.net',
    user : 'mhj',
    password : '2y244y26',
    database : 'mhj'
});

console.log('pool => criado');

pool.on('release', () => console.log('pool => conexão retornada'));

process.on('SIGINT', () => 
    pool.end(err => {
        if(err) return console.log(err);
        console.log('pool => fechado');
        process.exit(0);
    })
); 

module.exports = pool;
