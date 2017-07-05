#换行
.ONESHELL:

deployD = deploy.sh
dbD = db.sh

.PHONY: deploy
deploy:
	expect $(deployD)

migrate:
	expect $(dbD)

test:
	export  NODE_ENV=development ;
	mocha src/test/java/router/*.js
proTest:
	export  NODE_ENV=production ;
	mocha src/test/java/router/*.js

