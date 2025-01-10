package dev.agiro.photoarxiu.manager.arxivadors.app_use_cases;


import dev.agiro.photoarxiu.manager.arxivadors.domain.Arxivador;
import dev.agiro.photoarxiu.manager.arxivadors.domain.ArxivadorRepository;
import dev.agiro.photoarxiu.manager.arxivadors.domain.exceptions.ArxivadorAlreadyExists;
import dev.agiro.photoarxiu.manager.arxivadors.domain.exceptions.ArxivadorNotFoundException;
import dev.agiro.photoarxiu.manager.arxivadors.domain.value_objects.ArxivadorDescription;
import dev.agiro.photoarxiu.manager.arxivadors.domain.value_objects.ArxivadorId;
import dev.agiro.photoarxiu.manager.arxivadors.domain.value_objects.ArxivadorName;
import dev.agiro.photoarxiu.manager.arxivadors.domain.value_objects.ArxivadorPath;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ArxivadorService {

    private final ArxivadorRepository arxivadorRepository;

    public ArxivadorService(ArxivadorRepository arxivadorRepository) {
        this.arxivadorRepository = arxivadorRepository;
    }

    public Arxivador createArxivador(ArxivadorName arxivadorName, ArxivadorDescription arxivadorDescription, ArxivadorPath arxivadorPath) {
            var savedArxivador = arxivadorRepository.read(arxivadorName);
            if (savedArxivador.isPresent()) {
                throw new ArxivadorAlreadyExists( savedArxivador.get().getName());
            }
            return arxivadorRepository.create(Arxivador.create(arxivadorName, arxivadorDescription, arxivadorPath));
    }

    public Arxivador readArxivador(ArxivadorId arxivadorId) {
        return arxivadorRepository.read(arxivadorId)
                .orElseThrow(() -> new ArxivadorNotFoundException(arxivadorId));
    }

    public Arxivador updateArxivador(ArxivadorId arxivadorId, ArxivadorName arxivadorName, ArxivadorDescription arxivadorDescription, ArxivadorPath arxivadorPath) {
        var saved = arxivadorRepository.read(arxivadorId)
                .orElseThrow(() -> new ArxivadorNotFoundException(arxivadorId));
        return arxivadorRepository.update(saved.update(arxivadorName, arxivadorDescription, arxivadorPath));
    }

    public void deleteArxivador(ArxivadorId arxivadorId) {
        arxivadorRepository.delete(arxivadorId);
    }

    public Page<Arxivador> listArxivadors(Pageable pageable) {
        return arxivadorRepository.list(pageable);
    }

}
