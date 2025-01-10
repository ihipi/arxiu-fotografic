package dev.agiro.photoarxiu.manager.api.arxivador;

import dev.agiro.photoarxiu.manager.arxivadors.app_use_cases.ArxivadorService;
import dev.agiro.photoarxiu.manager.arxivadors.domain.Arxivador;
import dev.agiro.photoarxiu.manager.arxivadors.domain.value_objects.ArxivadorDescription;
import dev.agiro.photoarxiu.manager.arxivadors.domain.value_objects.ArxivadorId;
import dev.agiro.photoarxiu.manager.arxivadors.domain.value_objects.ArxivadorName;
import dev.agiro.photoarxiu.manager.arxivadors.domain.value_objects.ArxivadorPath;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/arxivadors")
public class ArxivadorController {

    private final ArxivadorService arxivadorService;

    @Autowired
    public ArxivadorController(ArxivadorService arxivadorService) {
        this.arxivadorService = arxivadorService;
    }

    @PostMapping
    public ResponseEntity<Arxivador> createArxivador(@RequestBody ArxivadorRequest arxivador) {
        Arxivador createdArxivador = arxivadorService.createArxivador(new ArxivadorName(arxivador.name()),
                                                                      new ArxivadorDescription(arxivador.description()),
                                                                      new ArxivadorPath(arxivador.path()));
        return new ResponseEntity<>(createdArxivador, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Arxivador> readArxivador(@PathVariable String id) {
        Arxivador arxivador = arxivadorService.readArxivador(new ArxivadorId(UUID.fromString(id)));
        return new ResponseEntity<>(arxivador, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Arxivador> updateArxivador(@PathVariable String id, @RequestBody ArxivadorRequest arxivador) {
        Arxivador updatedArxivador = arxivadorService.updateArxivador(new ArxivadorId(UUID.fromString(id)),
                                                                      new ArxivadorName(arxivador.name()),
                                                                      new ArxivadorDescription(arxivador.description()),
                                                                      new ArxivadorPath(arxivador.path()));
        return new ResponseEntity<>(updatedArxivador, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteArxivador(@PathVariable String id) {
        arxivadorService.deleteArxivador(new ArxivadorId(UUID.fromString(id)));
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping
    public ResponseEntity<Page<Arxivador>> listArxivadors(Pageable pageable) {
        Page<Arxivador> arxivadors = arxivadorService.listArxivadors(pageable);
        return new ResponseEntity<>(arxivadors, HttpStatus.OK);
    }
}