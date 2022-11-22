create table if not exists tb_tipo_periodo (
    codigo int auto_increment primary key,
    descricao varchar(100) not null unique
);