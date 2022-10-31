create table if not exists tb_parcelamento (
        codigo serial not null,
        data_vencimento date not null,
        data_pagamento date null,
        identificador varchar not null,
        constraint pk_parcelamento primary key (codigo)
);