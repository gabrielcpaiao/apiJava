package application.controller;

import java.util.List;
// import java.util.Optional;
import java.util.Optional;

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

import application.model.Tarefa;
import application.repository.TarefaRepository;

@RestController
public class TarefaController {
    @Autowired
    private TarefaRepository tarefaRepo;

    @GetMapping("/tarefas")
    public List<Tarefa> getTarefas() {
        return (List<Tarefa>) tarefaRepo.findAll();
    }

    @GetMapping("/tarefas/{id}")
    public Tarefa getTarefa(@PathVariable Long id) {
        Optional<Tarefa> resultado = tarefaRepo.findById(id);
        if(resultado.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Tarefa não encontrada");
        }
        return resultado.get();
    }

    //https://github.com/marcoweb/api-data-filme/blob/main/app/src/main/java/application/controller/FilmeController.java

    @PostMapping("/tarefas")
    public Tarefa postTarefa(@RequestBody Tarefa tarefa) {
        if(tarefa.getDescricaoTarefa() == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "O valor do campo Descrição não pode ser nulo");
        }
        return tarefaRepo.save(tarefa);
    }

    @PutMapping("/tarefas/{id}")
    public Tarefa putTarefa(@RequestBody Tarefa tarefa, @PathVariable Long id) {
        Tarefa resposta = tarefaRepo.findById(id).get();

        resposta.setDescricaoTarefa(tarefa.getDescricaoTarefa());
        resposta.setConcluido(tarefa.getConcluido());

        return tarefaRepo.save(resposta);
    }

    @DeleteMapping("/tarefas/{id}")
    public void delete(@PathVariable Long id) {
        if(tarefaRepo.existsById(id)) {
            tarefaRepo.deleteById(id);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Tarefa não encontrada!");
        }
    }
}
