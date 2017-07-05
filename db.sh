#!/usr/bin/expect
set timeout 7
set password csc
set database taobao

spawn mysql -h localhost -u root -p
expect "password"
send "$password\n"
expect "mysql"
send "use $database\n"
send "source migrate.sql\n"
expect "Query OK"
send "source db.sql\n"
expect "Query OK"
send "source init.sql\n"
expect "Query OK"
send "exit\n"
send "exit\n"
expect eof
exit
interact