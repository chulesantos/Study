<?php

namespace classes\abstratas;

abstract class Funcionario
{
    public $nome;
    public $cpf;
    protected $salario;

    public function __construct($cpf, $salario)
    {
        $this->cpf = $cpf;
        $this->salario = $salario;
    }

    final public function aumentarSalario()
    {
        return $this->salario *= 1.3;

    }

    abstract public function getBonificacao();
}
