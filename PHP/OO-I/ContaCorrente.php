<?php

class ContaCorrente
{
    private $titular;
    private $agencia;
    private $numero;
    private $saldo;

    public function __construct($titular, $agencia, $numero, $saldo)
    {
        $this->titular = $titular;
        $this->agencia = $agencia;
        $this->numero = $numero;
        $this->saldo = $saldo;
    }

    public function sacar($valor)
    {
        Validacao::verificaNumerico($valor);
        $this->saldo = $this->saldo - $valor;
        return $this;
    }

    public function depositar($valor)
    {
        Validacao::verificaNumerico($valor);
        $this->saldo = $this->saldo + $valor;
        return $this;
    }

    public function transferir(float $valor, ContaCorrente $conta)
    {
        Validacao::verificaNumerico($valor);
        $this->sacar($valor);
        $conta->depositar($valor);

        return $this;
    }

    public function __get($atributo)
    {
        Validacao::protegeAtributo($atributo);
        return $this->$atributo;
    }

    public function __set($atributo, $valor)
    {
        Validacao::protegeAtributo($atributo);
        $this->$atributo = $valor;
    }

    private function formataSaldo()
    {
        return "R$ " . number_format($this->saldo, 2, ",", ".");
    }

    public function getSaldo()
    {
        return $this->formataSaldo();
    }

    public function __toString()
    {

        return "O titular da conta é {$this->titular}. Seu saldo atual é: {$this->getSaldo()}";
    }

}
