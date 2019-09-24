<?php

class Produtos extends CI_Controller
{
    public function index()
    {
        $this->load->database();
        $this->load->model("Produtos_Model", "produtos");
        
        $produtos = $this->produtos->buscaTodos();

        $dados = array("produtos" => $produtos);

        $this->load->helper("url");

        $this->load->view("produtos/index.php", $dados);
    }

}
