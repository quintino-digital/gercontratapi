create table if not exists tb_tipo_contrato (
    codigo int auto_increment,
    descricao varchar(100) not null unique,
    primary key (codigo)
);