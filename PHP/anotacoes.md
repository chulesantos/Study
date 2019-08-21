O E_NOTICE ocorre quando o PHP encontra algum problema, mas consegue contorná-lo. Por exemplo, se tentarmos acessar e exibir o índice 0 das nossas $contasCorrentes, que não existe, receberemos um PHP Notice. Isso porque o PHP entende que esse índice não existe e devolve um valor nulo (Null).

O E_WARNING é um aviso de que o PHP não conseguiu realizar alguma instrução, mas continuará a execução do programa. Já o E_ERROR é o PHP informando que ocorreu um problema e não conseguirá continuar com a execução, que é o que queremos que aconteça quando o arquivo incluído (ou requerido) não for encontrado, afinal precisamos das funções para executarmos nossas operações.

include - inclusão de arquivos não essenciais para o funcionamento do programa

require - inclusão de arquivos obrigatorios

require_once - inclusão de arquivos obrigatorios, apenas se ele não tiver sido incluído anteriormente.

############################

# PHP_EOL - \n ou <br>

# &$variavel -> o & Significa receber a variável por referência, recenbendo a variável em si e não uma cópia dela.

# A função strtoupper não colocaria letras com acento em maiúsculo, enquanto a mb_strtoupper consegue fazer isso sem problemas.

php -S localhost:8000 - subir um servidor local para teste

"Ctrl + U" - código fonte da página

para imprimir algum valor podemos usar <?= $valor ?>