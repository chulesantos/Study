var mysql  = require('mysql');

function createDBConnection(){
        return mysql.createConnection({
            host: '10.1.0.135:8080',
            user: 'root',
            password: '$sudopasswdroot',
            database: 'payfast'
        });
}

module.exports = function() {
    return createDBConnection;
}