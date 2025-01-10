package dev.agiro.photoarxiu.manager.arxivadors.infrastructure;


import dev.agiro.photoarxiu.manager.arxivadors.domain.Arxivador;
import dev.agiro.photoarxiu.manager.arxivadors.domain.value_objects.ArxivadorDescription;
import dev.agiro.photoarxiu.manager.arxivadors.domain.value_objects.ArxivadorId;
import dev.agiro.photoarxiu.manager.arxivadors.domain.value_objects.ArxivadorName;
import dev.agiro.photoarxiu.manager.arxivadors.domain.value_objects.ArxivadorPath;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;

import java.util.UUID;

@Getter
@Entity(name = "arxivador")
@Table(name = "arxivador", schema = "photo_arxiu")
public class ArxivadorEntity {

    @Id
    private UUID id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "path")
    private String path;

    public ArxivadorEntity(Arxivador arxivador) {
        this.id = arxivador.getId();
        this.name = arxivador.getName();
        this.description = arxivador.getDescription();
        this.path = arxivador.getPath();
    }

    public ArxivadorEntity() {

    }

    public Arxivador toDomain() {
        return new Arxivador(
                new ArxivadorId(this.id),
                new ArxivadorName(this.name),
                new ArxivadorDescription(this.description),
                new ArxivadorPath(this.path)
        );
    }
}
