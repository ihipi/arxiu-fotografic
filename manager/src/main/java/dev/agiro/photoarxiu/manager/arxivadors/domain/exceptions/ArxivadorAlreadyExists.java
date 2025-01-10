package dev.agiro.photoarxiu.manager.arxivadors.domain.exceptions;

public class ArxivadorAlreadyExists extends RuntimeException {
    public ArxivadorAlreadyExists(String arxivadorId) {
        super("Arxivador with name " + arxivadorId + " already exists");
    }
}
