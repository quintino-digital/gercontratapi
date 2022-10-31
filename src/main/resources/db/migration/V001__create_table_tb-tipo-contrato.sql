create table if not exists tb_tipo_contrato (
    codigo serial not null,
    descricao varchar not null unique,
    constraint pk_tipo_contrato primary key (codigo)
);