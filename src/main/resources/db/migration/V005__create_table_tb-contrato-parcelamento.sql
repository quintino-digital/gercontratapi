create table if not exists tb_contrato_parcelamento (
    codigo serial not null,
    id_contrato integer not null,
    id_parcelamento integer not null,
    is_ativo boolean not null default true,
    constraint fk_contrato foreign key (id_contrato) references tb_contrato,
    constraint fk_parcelamento foreign key (id_parcelamento) references tb_parcelamento
);