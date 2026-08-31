-- ============================================================
-- ERP - EMPRESA DE AR-CONDICIONADO
-- SCRIPT DE CRIACAO DO BANCO DE DADOS (DDL)
-- DIALETO: POSTGRESQL
-- ============================================================


-- ============================================================
-- BLOCO 1: PESSOA (SUPERCLASSE) E ESPECIALIZACOES
-- ============================================================

-- TABELA BASE DA GENERALIZACAO/ESPECIALIZACAO.
-- FUNCIONARIO E CLIENTE HERDAM DESTA TABELA (1:1).
CREATE TABLE pessoa (
    id_pessoa   SERIAL PRIMARY KEY,
    nome        VARCHAR(150) NOT NULL,
    cpf         VARCHAR(11) NOT NULL UNIQUE
);

-- UMA PESSOA PODE TER VARIOS TELEFONES (CELULAR, FIXO, WHATSAPP).
CREATE TABLE telefone (
    id_telefone SERIAL PRIMARY KEY,
    id_pessoa   INT NOT NULL REFERENCES pessoa(id_pessoa) ON DELETE CASCADE,
    numero      VARCHAR(20) NOT NULL,
    tipo        VARCHAR(20) NOT NULL CHECK (tipo IN ('celular', 'fixo', 'whatsapp')),
    principal   BOOLEAN NOT NULL DEFAULT FALSE
);

-- UMA PESSOA PODE TER VARIOS E-MAILS (PESSOAL, COMERCIAL).
CREATE TABLE email (
    id_email    SERIAL PRIMARY KEY,
    id_pessoa   INT NOT NULL REFERENCES pessoa(id_pessoa) ON DELETE CASCADE,
    email       VARCHAR(150) NOT NULL,
    tipo        VARCHAR(20) NOT NULL CHECK (tipo IN ('pessoal', 'comercial')),
    principal   BOOLEAN NOT NULL DEFAULT FALSE
);

-- ESPECIALIZACAO DE PESSOA. A PK TAMBEM E FK PARA PESSOA (1:1).
CREATE TABLE funcionario (
    id_pessoa       INT PRIMARY KEY REFERENCES pessoa(id_pessoa) ON DELETE CASCADE,
    matricula       VARCHAR(20) NOT NULL UNIQUE,
    cargo           VARCHAR(60) NOT NULL,
    setor           VARCHAR(60) NOT NULL,
    data_admissao   DATE NOT NULL,
    salario         DECIMAL(10,2) NOT NULL
);

-- ESPECIALIZACAO DE PESSOA. A PK TAMBEM E FK PARA PESSOA (1:1).
CREATE TABLE cliente (
    id_pessoa       INT PRIMARY KEY REFERENCES pessoa(id_pessoa) ON DELETE CASCADE,
    tipo_cliente    VARCHAR(20) NOT NULL CHECK (tipo_cliente IN ('residencial', 'comercial')),
    cnpj            VARCHAR(14),                 -- PREENCHIDO SOMENTE SE TIPO_CLIENTE = 'comercial'
    data_cadastro   DATE NOT NULL DEFAULT CURRENT_DATE
);

-- SOMENTE CLIENTE POSSUI ENDERECO. UM CLIENTE PODE TER VARIOS
-- (COBRANCA, INSTALACAO, PRINCIPAL).
CREATE TABLE endereco (
    id_endereco     SERIAL PRIMARY KEY,
    id_cliente      INT NOT NULL REFERENCES cliente(id_pessoa) ON DELETE CASCADE,
    tipo_endereco   VARCHAR(20) NOT NULL CHECK (tipo_endereco IN ('cobranca', 'instalacao', 'principal')),
    rua             VARCHAR(150) NOT NULL,
    numero          VARCHAR(10) NOT NULL,
    complemento     VARCHAR(60),
    bairro          VARCHAR(80) NOT NULL,
    cidade          VARCHAR(80) NOT NULL,
    uf              CHAR(2) NOT NULL,
    cep             VARCHAR(8) NOT NULL
);


-- ============================================================
-- BLOCO 2: ACESSO AO SISTEMA (USUARIOS E PERMISSOES)
-- ============================================================

-- DEFINE OS NIVEIS DE ACESSO DO SISTEMA.
CREATE TABLE perfil (
    id_perfil   SERIAL PRIMARY KEY,
    nome_perfil VARCHAR(40) NOT NULL UNIQUE,      -- EX: admin, tecnico, atendente, financeiro
    descricao   VARCHAR(200)
);

-- NEM TODO FUNCIONARIO PRECISA DE LOGIN, POR ISSO O ID_FUNCIONARIO
-- E UNICO (1:1 OPCIONAL) EM VEZ DE OBRIGATORIO.
CREATE TABLE usuario (
    id_usuario      SERIAL PRIMARY KEY,
    id_funcionario  INT NOT NULL UNIQUE REFERENCES funcionario(id_pessoa),
    id_perfil       INT NOT NULL REFERENCES perfil(id_perfil),
    login           VARCHAR(60) NOT NULL UNIQUE,
    senha_hash      VARCHAR(255) NOT NULL,
    ativo           BOOLEAN NOT NULL DEFAULT TRUE,
    ultimo_acesso   TIMESTAMP
);

-- REGISTRA TODA ACAO RELEVANTE FEITA POR UM USUARIO NO SISTEMA
-- (AUDITORIA / RASTREABILIDADE).
CREATE TABLE log_auditoria (
    id_log              SERIAL PRIMARY KEY,
    id_usuario          INT NOT NULL REFERENCES usuario(id_usuario),
    acao                VARCHAR(60) NOT NULL,       -- EX: INSERT, UPDATE, DELETE
    tabela_afetada      VARCHAR(60) NOT NULL,
    id_registro_afetado INT,
    data_hora           TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);


-- ============================================================
-- BLOCO 3: CATALOGO DE EQUIPAMENTOS E ESTOQUE
-- ============================================================

CREATE TABLE marca (
    id_marca        SERIAL PRIMARY KEY,
    nome_marca      VARCHAR(80) NOT NULL UNIQUE,
    pais_origem     VARCHAR(60),
    contato_suporte VARCHAR(150)
);

CREATE TABLE fornecedor (
    id_fornecedor   SERIAL PRIMARY KEY,
    nome            VARCHAR(150) NOT NULL,
    cnpj            VARCHAR(14) NOT NULL UNIQUE,
    telefone        VARCHAR(20),
    email           VARCHAR(150)
);

CREATE TABLE equipamento (
    id_equipamento  SERIAL PRIMARY KEY,
    id_marca        INT NOT NULL REFERENCES marca(id_marca),
    id_fornecedor   INT REFERENCES fornecedor(id_fornecedor),
    modelo          VARCHAR(80) NOT NULL,
    tipo            VARCHAR(20) NOT NULL CHECK (tipo IN ('split', 'janela', 'cassete', 'piso-teto', 'vrf')),
    capacidade_btus INT NOT NULL,
    voltagem        VARCHAR(10) NOT NULL,           -- EX: 110V, 220V, bivolt
    numero_serie    VARCHAR(60) UNIQUE,
    preco_custo     DECIMAL(10,2),
    preco_venda     DECIMAL(10,2)
);

-- CONTROLE DE QUANTIDADE POR EQUIPAMENTO (1:1 COM EQUIPAMENTO).
CREATE TABLE estoque (
    id_estoque          SERIAL PRIMARY KEY,
    id_equipamento      INT NOT NULL UNIQUE REFERENCES equipamento(id_equipamento),
    quantidade_atual    INT NOT NULL DEFAULT 0,
    quantidade_minima   INT NOT NULL DEFAULT 0,
    localizacao         VARCHAR(80)                 -- EX: deposito A, prateleira 3
);

-- CLIENTE_EQUIPAMENTO PRECISA EXISTIR ANTES DE OS, POIS OS A REFERENCIA.
-- REPRESENTA O EQUIPAMENTO JA INSTALADO NA CASA/EMPRESA DO CLIENTE.
CREATE TABLE cliente_equipamento (
    id_cliente_equipamento  SERIAL PRIMARY KEY,
    id_cliente              INT NOT NULL REFERENCES cliente(id_pessoa),
    id_equipamento          INT NOT NULL REFERENCES equipamento(id_equipamento),
    id_endereco             INT NOT NULL REFERENCES endereco(id_endereco),
    data_instalacao         DATE NOT NULL,
    garantia_ate            DATE,
    local_instalacao        VARCHAR(80)              -- EX: sala, quarto 1, recepcao
);


-- ============================================================
-- BLOCO 4: SERVICOS, ORCAMENTOS E ORDENS DE SERVICO
-- ============================================================

CREATE TABLE tipo_os (
    id_tipo_os  SERIAL PRIMARY KEY,
    descricao   VARCHAR(60) NOT NULL UNIQUE          -- instalacao, manutencao preventiva, manutencao corretiva, garantia
);

CREATE TABLE servico (
    id_servico              SERIAL PRIMARY KEY,
    nome_servico            VARCHAR(100) NOT NULL,
    descricao               VARCHAR(255),
    valor_base              DECIMAL(10,2) NOT NULL,
    duracao_estimada_min    INT
);

-- ORCAMENTO E UMA ETAPA ANTERIOR A OS, PODENDO OU NAO SER APROVADO.
CREATE TABLE orcamento (
    id_orcamento    SERIAL PRIMARY KEY,
    id_cliente      INT NOT NULL REFERENCES cliente(id_pessoa),
    id_funcionario  INT NOT NULL REFERENCES funcionario(id_pessoa),
    data_criacao    DATE NOT NULL DEFAULT CURRENT_DATE,
    data_validade   DATE NOT NULL,
    status          VARCHAR(20) NOT NULL DEFAULT 'pendente'
                        CHECK (status IN ('pendente', 'aprovado', 'reprovado', 'expirado')),
    valor_total     DECIMAL(10,2) NOT NULL DEFAULT 0
);

-- ASSOCIATIVA N:N ENTRE ORCAMENTO E SERVICO.
CREATE TABLE orcamento_servico (
    id_orcamento    INT NOT NULL REFERENCES orcamento(id_orcamento) ON DELETE CASCADE,
    id_servico      INT NOT NULL REFERENCES servico(id_servico),
    valor_cobrado   DECIMAL(10,2) NOT NULL,
    quantidade      INT NOT NULL DEFAULT 1,
    PRIMARY KEY (id_orcamento, id_servico)
);

-- TABELA CENTRAL DO SISTEMA. ID_ORCAMENTO E OPCIONAL, POIS NEM TODA
-- OS NASCE DE UM ORCAMENTO APROVADO.
CREATE TABLE os (
    id_os                   SERIAL PRIMARY KEY,
    id_cliente              INT NOT NULL REFERENCES cliente(id_pessoa),
    id_funcionario          INT NOT NULL REFERENCES funcionario(id_pessoa),     -- TECNICO RESPONSAVEL
    id_tipo_os              INT NOT NULL REFERENCES tipo_os(id_tipo_os),
    id_cliente_equipamento  INT REFERENCES cliente_equipamento(id_cliente_equipamento),
    id_orcamento            INT REFERENCES orcamento(id_orcamento),
    data_abertura           TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    data_agendada           TIMESTAMP,
    data_conclusao          TIMESTAMP,
    status                  VARCHAR(20) NOT NULL DEFAULT 'aberta'
                                CHECK (status IN ('aberta', 'em_andamento', 'concluida', 'cancelada')),
    descricao_problema      VARCHAR(255),
    observacoes             VARCHAR(255),
    valor_total             DECIMAL(10,2) NOT NULL DEFAULT 0
);

-- HISTORICO DE TODAS AS MUDANCAS DE STATUS DE UMA OS.
CREATE TABLE os_historico_status (
    id_historico    SERIAL PRIMARY KEY,
    id_os           INT NOT NULL REFERENCES os(id_os) ON DELETE CASCADE,
    id_funcionario  INT NOT NULL REFERENCES funcionario(id_pessoa),   -- QUEM ALTEROU
    status          VARCHAR(20) NOT NULL,
    data_alteracao  TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);

-- ASSOCIATIVA N:N ENTRE OS E SERVICO (UMA OS PODE TER VARIOS SERVICOS).
CREATE TABLE os_servico (
    id_os           INT NOT NULL REFERENCES os(id_os) ON DELETE CASCADE,
    id_servico      INT NOT NULL REFERENCES servico(id_servico),
    valor_cobrado   DECIMAL(10,2) NOT NULL,
    quantidade      INT NOT NULL DEFAULT 1,
    PRIMARY KEY (id_os, id_servico)
);

CREATE TABLE ferramenta (
    id_ferramenta       SERIAL PRIMARY KEY,
    nome                VARCHAR(80) NOT NULL,
    numero_patrimonio   VARCHAR(30) UNIQUE,
    status              VARCHAR(20) NOT NULL DEFAULT 'disponivel'
                            CHECK (status IN ('disponivel', 'em_uso', 'manutencao'))
);

-- ASSOCIATIVA N:N ENTRE OS E FERRAMENTA (UMA OS PODE USAR VARIAS FERRAMENTAS).
CREATE TABLE os_ferramenta (
    id_os           INT NOT NULL REFERENCES os(id_os) ON DELETE CASCADE,
    id_ferramenta   INT NOT NULL REFERENCES ferramenta(id_ferramenta),
    data_uso        TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (id_os, id_ferramenta, data_uso)
);

-- MOVIMENTACOES DE ESTOQUE. EM ENTRADAS, VEM DE UM FORNECEDOR.
-- EM SAIDAS, ESTA LIGADA A UMA OS QUE CONSUMIU O ITEM.
CREATE TABLE movimentacao_estoque (
    id_movimentacao     SERIAL PRIMARY KEY,
    id_estoque          INT NOT NULL REFERENCES estoque(id_estoque),
    id_fornecedor       INT REFERENCES fornecedor(id_fornecedor),      -- NULO EM SAIDAS
    id_os               INT REFERENCES os(id_os),                     -- NULO EM ENTRADAS
    tipo_movimentacao   VARCHAR(10) NOT NULL CHECK (tipo_movimentacao IN ('entrada', 'saida')),
    quantidade          INT NOT NULL,
    data_movimentacao   TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    observacao          VARCHAR(255)
);


-- ============================================================
-- BLOCO 5: FINANCEIRO (PAGAMENTO, NOTA FISCAL, COMISSAO)
-- ============================================================

CREATE TABLE tipo_pagamento (
    id_tipo_pagamento   SERIAL PRIMARY KEY,
    descricao           VARCHAR(30) NOT NULL UNIQUE    -- dinheiro, pix, cartao_credito, cartao_debito, boleto, transferencia
);

-- CADA OS GERA EXATAMENTE UM REGISTRO DE PAGAMENTO (1:1).
CREATE TABLE pagamento (
    id_pagamento        SERIAL PRIMARY KEY,
    id_os               INT NOT NULL UNIQUE REFERENCES os(id_os),
    id_tipo_pagamento   INT NOT NULL REFERENCES tipo_pagamento(id_tipo_pagamento),
    valor_total         DECIMAL(10,2) NOT NULL,
    numero_parcelas     INT NOT NULL DEFAULT 1,
    status_pagamento    VARCHAR(20) NOT NULL DEFAULT 'pendente'
                            CHECK (status_pagamento IN ('pendente', 'pago', 'atrasado', 'cancelado')),
    data_pagamento      DATE
);

-- DETALHAMENTO DAS PARCELAS DE UM PAGAMENTO.
CREATE TABLE parcela (
    id_parcela      SERIAL PRIMARY KEY,
    id_pagamento    INT NOT NULL REFERENCES pagamento(id_pagamento) ON DELETE CASCADE,
    numero_parcela  INT NOT NULL,
    valor_parcela   DECIMAL(10,2) NOT NULL,
    data_vencimento DATE NOT NULL,
    data_pagamento  DATE,
    status          VARCHAR(20) NOT NULL DEFAULT 'pendente'
                        CHECK (status IN ('pendente', 'pago', 'atrasado'))
);

-- CADA OS PODE GERAR NO MAXIMO UMA NOTA FISCAL (1:1 OPCIONAL).
CREATE TABLE nota_fiscal (
    id_nota_fiscal  SERIAL PRIMARY KEY,
    id_os           INT NOT NULL UNIQUE REFERENCES os(id_os),
    numero_nf       VARCHAR(20) NOT NULL,
    serie           VARCHAR(10) NOT NULL,
    chave_acesso    VARCHAR(44) UNIQUE,
    data_emissao    DATE NOT NULL DEFAULT CURRENT_DATE,
    valor           DECIMAL(10,2) NOT NULL,
    status          VARCHAR(20) NOT NULL DEFAULT 'emitida' CHECK (status IN ('emitida', 'cancelada'))
);

-- COMISSAO DO FUNCIONARIO SOBRE UMA OS FECHADA.
CREATE TABLE comissao (
    id_comissao     SERIAL PRIMARY KEY,
    id_funcionario  INT NOT NULL REFERENCES funcionario(id_pessoa),
    id_os           INT NOT NULL REFERENCES os(id_os),
    percentual      DECIMAL(5,2) NOT NULL,       -- EX: 5.00 = 5%
    valor_calculado DECIMAL(10,2) NOT NULL,
    data_referencia DATE NOT NULL DEFAULT CURRENT_DATE,
    status          VARCHAR(20) NOT NULL DEFAULT 'pendente' CHECK (status IN ('pendente', 'pago'))
);