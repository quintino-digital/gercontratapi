create table if not exists tb_contrato_parcelamento (
    codigo int auto_increment primary key,
    id_contrato integer not null,
    id_parcelamento integer not null,
    is_ativo boolean not null default true,
    foreign key (id_contrato) references tb_contrato(codigo),
    foreign key (id_parcelamento) references tb_parcelamento(codigo)
);