<?php

$idade = 19;
$numeroDePessoas = 1;

echo "Você só pode entrar se tiver a partir de 18 anos ou ";
echo "a partir de 16 anos acompanhado" . PHP_EOL;

if ($idade >= 18) {
    echo "Você tem $idade anos. Pode entrar sozinho.";

} else if ($idade >= 16 && $numeroDePessoas > 1) {
    echo "Você tem $idade anos e está acompanhado(a), então pode entrar.";

} else {
 
    echo "Você só tem $idade anos. Você não pode entrar";
}


echo PHP_EOL;

$mensagem = $idade < 18 ? 'Você é menor de idade' : 'Você é maior de idade';
echo $mensagem;

echo PHP_EOL;
echo "Adeus!";