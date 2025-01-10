package dev.agiro.photoarxiu.manager.arxivadors.domain.value_objects;

import java.nio.file.InvalidPathException;
import java.nio.file.Paths;

public record ArxivadorPath(String value) {
    public ArxivadorPath {
        if (value == null || !isValidPath(value)) {
            throw new IllegalArgumentException("ArxivadorPath cannot be null or invalid");
        }
    }

    private boolean isValidPath(String path) {
        try {
            Paths.get(path);
            return true;
        } catch (InvalidPathException e) {
            return false;
        }
    }

}
