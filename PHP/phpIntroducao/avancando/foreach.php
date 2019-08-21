<?php

$contasCorrentes = [
    12345678910 => [
        'titular' => 'Vinicius',
        'saldo' => 1000
    ],
    12345678911 => [
        'titular' => 'Maria',
        'saldo' => 10000
    ],
    12325678912 => [
    'titular' => 'Alberto',
    'saldo' => 300
    ]
];

/*adicionando nova conta*/

$contasCorrentes[12345637811] = [
    'titular' => 'Claudia',
    'saldo' => 2000
];

$contasCorrentes[] = [
    'titular' => 'Claudia 2',
    'saldo' => 2002
];

foreach ($contasCorrentes as $cpf => $conta) {
    echo $cpf . " " . $conta['titular'] . PHP_EOL;
}