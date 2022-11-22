create table if not exists tb_parcelamento (
        codigo int auto_increment primary key,
        data_vencimento date not null,
        data_pagamento date null,
        identificador varchar(100) not null
);