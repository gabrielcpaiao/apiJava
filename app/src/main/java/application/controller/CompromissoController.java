package application.controller;

import java.util.List;
// import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import application.model.Compromisso;
import application.repository.CompromissoRepository;

@RestController
public class CompromissoController {
    @Autowired
    private CompromissoRepository compromissoRepo;

    @GetMapping("/compromissos")
    public List<Compromisso> getTarefas() {
        return (List<Compromisso>) compromissoRepo.findAll();
    }

    @GetMapping("/compromissos/{id}")
    public Compromisso getCompromisso(@PathVariable Long id) {
        return compromissoRepo.findById(id).get();
    }

    @PostMapping("/compromissos")
    public Compromisso postCompromisso(@RequestBody Compromisso compromisso) {
        return compromissoRepo.save(compromisso);
    }

    @PutMapping("/compromissos/{id}")
    public Compromisso putCompromisso(@RequestBody Compromisso compromisso, @PathVariable Long id) {
        Compromisso resposta = compromissoRepo.findById(id).get();

        resposta.setDescricaoCompromisso(compromisso.getDescricaoCompromisso());
        resposta.setDataInicio(compromisso.getDataInicio());
        resposta.setDataFim(compromisso.getDataFim());
        resposta.setHoraInicio(compromisso.getHoraInicio());
        resposta.setHoraFim(compromisso.getHoraFim());

        return compromissoRepo.save(resposta);
    }

    @DeleteMapping("/compromissos/{id}")
    public void delete(@PathVariable Long id) {
        if(compromissoRepo.existsById(id)) {
            compromissoRepo.deleteById(id);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }
}
