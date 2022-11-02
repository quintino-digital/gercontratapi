create table if not exists tb_contrato (
    codigo serial not null,
    id_pessoa_contratante varchar null,
    id_pessoa_contratada varchar null,
    id_tipo_contrato integer not null,
    id_tipo_periodo integer not null,
    data_inicio date not null,
    data_fim date not null,
    identificador varchar not null,
    dia_vencimento integer not null,
    quantidade_parcela integer not null,
    valor_efetivo float not null,
    valor_parcela float not null,
    constraint pk_contrato primary key (codigo),
    constraint fk_tipo_contrato foreign key (id_tipo_contrato) references tb_tipo_contrato,
    constraint fk_tipo_periodo foreign key (id_tipo_periodo) references tb_tipo_periodo
);