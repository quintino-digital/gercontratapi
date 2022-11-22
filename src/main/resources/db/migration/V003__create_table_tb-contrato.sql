create table if not exists tb_contrato (
    codigo int auto_increment primary key,
    id_pessoa_contratante varchar(100) null,
    id_pessoa_contratada varchar(100) null,
    id_tipo_contrato integer not null,
    id_tipo_periodo integer not null,
    data_inicio date not null,
    data_fim date not null,
    identificador varchar(100) not null,
    dia_vencimento integer not null,
    quantidade_parcela integer not null,
    valor_efetivo float not null,
    valor_parcela float not null,
    foreign key (id_tipo_contrato) references tb_tipo_contrato(codigo),
    foreign key (id_tipo_periodo) references tb_tipo_periodo(codigo)
);