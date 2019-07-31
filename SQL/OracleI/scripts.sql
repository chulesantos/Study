create table compras (
    valor number,
    data date,
    observacoes varchar2(30),
    recebido char check (recebido in (0,1))
);