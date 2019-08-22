<?php

/*ini_set('display_erros', 1);
error_reporting(E_ALL);
header('Content-Type: text/html; charset=utf-8');*/

require "ContaCorrente.php";

$contaMaria= new ContaCorrente("Maria", "1212", "343432-9", 6000.00);

$contaJoao = new ContaCorrente("Joao", "1212", "343477-9", 2000.00);

var_dump($contaJoao);

var_dump($contaMaria);

