package dev.agiro.photoarxiu.manager.arxivadors.domain;

import dev.agiro.photoarxiu.manager.arxivadors.domain.value_objects.ArxivadorDescription;
import dev.agiro.photoarxiu.manager.arxivadors.domain.value_objects.ArxivadorId;
import dev.agiro.photoarxiu.manager.arxivadors.domain.value_objects.ArxivadorName;
import dev.agiro.photoarxiu.manager.arxivadors.domain.value_objects.ArxivadorPath;

import java.util.Objects;
import java.util.UUID;

public final class Arxivador {
    private final ArxivadorId          id;
    private final ArxivadorName        name;
    private final ArxivadorDescription description;
    private final ArxivadorPath        path;

    public Arxivador(ArxivadorId id, ArxivadorName name, ArxivadorDescription description, ArxivadorPath path) {
        this.id          = id;
        this.name        = name;
        this.description = description;
        this.path        = path;
    }

    public static Arxivador create(ArxivadorName name, ArxivadorDescription description, ArxivadorPath path) {
        return new Arxivador(new ArxivadorId(UUID.randomUUID()), name, description, path);
    }

    public Arxivador update(ArxivadorName arxivadorName, ArxivadorDescription arxivadorDescription, ArxivadorPath arxivadorPath) {
        return new Arxivador(this.id, arxivadorName, arxivadorDescription, arxivadorPath);
    }

    public UUID getId() {
        return this.id.value();
    }

    public String getName() {
        return this.name.value();
    }

    public String getDescription() {
        return this.description.value();
    }

    public String getPath() {
        return this.path.value();
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        final Arxivador arxivador = (Arxivador) o;
        return Objects.equals(id, arxivador.id)
               && Objects.equals(name, arxivador.name)
               && Objects.equals(description, arxivador.description)
               && Objects.equals(path, arxivador.path);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description, path);
    }

    public String toString() {
        return "Arxivador(id=" + this.getId() + ", name=" + this.getName() + ", description=" + this.getDescription() + ", path=" + this.getPath() + ")";
    }
}
