package dev.agiro.photoarxiu.manager.arxivadors.domain;

import dev.agiro.photoarxiu.manager.arxivadors.domain.value_objects.ArxivadorId;
import dev.agiro.photoarxiu.manager.arxivadors.domain.value_objects.ArxivadorName;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface ArxivadorRepository {

    Arxivador create(Arxivador arxivador);

    Optional<Arxivador> read(ArxivadorId arxivadorId);
    Optional<Arxivador> read(ArxivadorName arxivadorName);

    Arxivador update(Arxivador arxivador);

    void delete(ArxivadorId arxivadorId);

    Page<Arxivador> list(Pageable pageable);

}
