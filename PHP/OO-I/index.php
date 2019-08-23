<?php

/*ini_set('display_erros', 1);
error_reporting(E_ALL);
header('Content-Type: text/html; charset=utf-8');*/

require "Validacao.php";
require "ContaCorrente.php";

$contaJoao = new ContaCorrente("Joao", "1212", "343477-9", 2000,00);
$contaMaria = new ContaCorrente("Maria", "1212", "343423-9", 6000.00);









