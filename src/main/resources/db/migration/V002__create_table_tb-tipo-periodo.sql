create table if not exists tb_tipo_periodo (
    codigo serial not null,
    descricao varchar not null unique,
    constraint pk_tipo_periodo primary key (codigo)
);