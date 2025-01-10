package dev.agiro.photoarxiu.manager.arxivadors.domain.value_objects;

public record ArxivadorName(String value) {
    public ArxivadorName {
        if (value == null) {
            throw new IllegalArgumentException("ArxivadorName cannot be null");
        }
    }
}
