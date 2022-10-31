insert into tb_tipo_contrato (descricao) values ('Empréstimo Bancário');

insert into tb_tipo_periodo (descricao) values ('Mensal');

--insert into tb_contrato (id_pessoa_contratante, id_pessoa_contratada, id_tipo_contrato, id_tipo_periodo, data_inicio, data_fim, identificador, dia_vencimento, quantidade_parcela, valor_efetivo, valor_juros) values (
--	'cc801fcd-d95c-48fc-b7ee-21c32ed11a88',
--	'718dc4c9-8118-421c-9e86-b6676ae34761',
--	(select codigo from tb_tipo_contrato where descricao like 'Empréstimo Bancário'),
--	(select codigo from tb_tipo_periodo where descricao like 'Mensal'),
--	'2022-02-02',
--	'2024-02-02',
--	'CONTRATO_31102022_001',
--	10,
--	24,
--	8000,
--	22000
--);
--
--insert into tb_parcelamento (data_vencimento, data_pagamento, identificador) values (
--	'2022-03-10',
--	null,
--	'PARCELA_CONTRATO_31102022_001'
--);
--
--insert into tb_contrato_parcelamento (id_contrato, id_parcelamento, is_ativo) values (
--	(select codigo from tb_contrato where identificador like 'CONTRATO_31102022_001'),
--	(select codigo from tb_parcelamento where identificador like 'PARCELA_CONTRATO_31102022_001'),
--	true
--);