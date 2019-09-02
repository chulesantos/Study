<?php

class Produtos extends CI_Controller
{

    public function index()
    {
        $produtos = array();

        $bola = array(
            "nome" => "Bola",
            "descricao" => "Descricao Bola",
            "preco" => 50,
        );

        $hd = array(
            "nome" => "HD",
            "descricao" => "Descricao HD",
            "preco" => 400,
        );

        array_push($produtos, $bola, $hd);

        $dados = array("produtos" => $produtos);

        $this->load->view("produtos/index.php", $dados);
    }

}
