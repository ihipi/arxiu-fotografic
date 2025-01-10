package dev.agiro.photoarxiu.manager.arxivadors.domain.exceptions;

import dev.agiro.photoarxiu.manager.arxivadors.domain.value_objects.ArxivadorId;
import dev.agiro.photoarxiu.manager.core.exceptions.ElementNotFoundException;

public class ArxivadorNotFoundException extends ElementNotFoundException {
    public ArxivadorNotFoundException(ArxivadorId arxivadorId) {
        super("Arxivador with id " + arxivadorId + " not found");
    }
}
