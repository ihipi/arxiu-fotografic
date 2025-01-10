-- liquibase formatted sql

-- changeset AGIROQU:1736548743435-0
CREATE SCHEMA IF NOT EXISTS photo_arxiu

-- changeset AGIROQU:1736548743435-1
CREATE TABLE photo_arxiu.arxivador
(
    id          UUID NOT NULL,
    name        VARCHAR(255),
    description VARCHAR(255),
    path        VARCHAR(255),
    CONSTRAINT pk_arxivador PRIMARY KEY (id)
);

