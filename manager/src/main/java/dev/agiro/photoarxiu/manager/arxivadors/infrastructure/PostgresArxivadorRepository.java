package dev.agiro.photoarxiu.manager.arxivadors.infrastructure;

import dev.agiro.photoarxiu.manager.arxivadors.domain.ArxivadorRepository;
import dev.agiro.photoarxiu.manager.arxivadors.domain.Arxivador;
import dev.agiro.photoarxiu.manager.arxivadors.domain.value_objects.ArxivadorId;
import dev.agiro.photoarxiu.manager.arxivadors.domain.value_objects.ArxivadorName;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class PostgresArxivadorRepository implements ArxivadorRepository {

    private final JpaArxivadorRepository repo;

    public PostgresArxivadorRepository(JpaArxivadorRepository jpaArxivadorRepository) {
        this.repo = jpaArxivadorRepository;
    }

    @Override
    public Arxivador create(Arxivador arxivador) {
        return repo.save(new ArxivadorEntity(arxivador))
                .toDomain();
    }

    @Override
    public Optional<Arxivador> read(ArxivadorId arxivadorId) {
        return repo.findById(arxivadorId.value()).map(ArxivadorEntity::toDomain);
    }

    @Override
    public Optional<Arxivador> read(ArxivadorName arxivadorName) {
        return repo.findByName(arxivadorName.value()).map(ArxivadorEntity::toDomain);
    }

    @Override
    public Arxivador update(Arxivador arxivador) {
        return repo.save(new ArxivadorEntity(arxivador))
                .toDomain();
    }

    @Override
    public void delete(ArxivadorId arxivadorId) {
        repo.deleteById(arxivadorId.value());
    }

    @Override
    public Page<Arxivador> list(Pageable pageable) {
        return repo.findAll(pageable)
                .map(ArxivadorEntity::toDomain);
    }
}
