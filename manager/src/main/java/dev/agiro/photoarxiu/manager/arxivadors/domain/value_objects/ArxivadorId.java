package dev.agiro.photoarxiu.manager.arxivadors.domain.value_objects;

import java.util.UUID;

public record ArxivadorId(UUID value) {
    public ArxivadorId {
        if (value == null) {
            throw new IllegalArgumentException("ArxivadorId cannot be null");
        }
    }
}
