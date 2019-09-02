<?php

class Produtos extends CI_Controller
{

    public function index()
    {
        $produtos = array();

        $bola = array(
            "nome" => "RAM",
            "descricao" => "Descricao RAM",
            "preco" => 200,
        );

        $hd = array(
            "nome" => "HD",
            "descricao" => "Descricao HD",
            "preco" => 100,
        );

        array_push($produtos, $bola, $hd);

        $dados = array("produtos" => $produtos);

        $this->load->view("produtos/index.php", $dados);
    }

}
