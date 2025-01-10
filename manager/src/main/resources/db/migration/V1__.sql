CREATE TABLE arxivador
(
    id          UUID NOT NULL,
    name        VARCHAR(255),
    description VARCHAR(255),
    path        VARCHAR(255),
    CONSTRAINT pk_arxivador PRIMARY KEY (id)
);