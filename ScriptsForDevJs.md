# Scripts for Dev JS

#### Utilitários para a utilização de ferramentas e plugins em JavaScript.

## Node JS
### Comandos

- **npm init** [ Inicia um projeto com NodeJS ];
- **npm start** [ Start o servidor NodeJS {Depois que o arquivo package.json estiver configurado} ];
- **npm install** [ Atualiza todos as dependêcias, conforme o arquivo package.json ];
- **npm install modulo ou modulo@0.1.1 --save ou --save-exact** [ Instala o modulo em sua versão mais atual ou em uma versão especifica utilizando o @ + a versão. {--save => Salva a versão e a mesma poderá ser atualizada conforme nova versão; --save-exact => A versão instalada não será atualizada posteriormente } ];
- **npm install modulo --save-dev** [ --save-dev => Instala o modulo apenas para desenvolvimento, não é aplicado em produção ].

### Modulos Uteis

- npm install express [ Auxilia na criação de rotas ];
- npm install express-validator@5.3.1 [ Auxilia na validação de parametros ];
- npm install nodemon [ Possibilita no reload do servidor ];
- npm install method-override [ Auxilia no controle de rotas com metodo POST e PUT];
- npm install marko [ Auxilia criação de páginas html dentro do servidor];
- npm install sqlite3 [ Instala o Banco de Dados SQLite ];
- npm install body-parser [ Converte o body da requisição para vários formatados {JSON} ];
- npm install uuid [ Gera Strings aleatorios de SESSION ID ];
- npm install express-session [ Criar Sessões junto com o Express ];
- npm install passport [ Auxilia na manipulação de Sessões { SESSION } ];
- npm install passport-local [ Auxilia na manipulação de Sessões { SESSION } ]
- npm install consign [ Auxilia no controle das rotas ]
- npm install restify-clients [ Consumir APIs REST ]

### Configurações

#### package.json

- "scripts": { "start": "nodemon server.js" } [ Arquivo principal, carregado após npm start ];
- "scripts": { "start": "nodemon server.js --ignore .marko.js" } [ --ignone .marko.js => caso o modulo Marko esteja instalado]