package com.example.joalheria.controller;

import com.example.joalheria.model.JoiaBD;
import com.example.joalheria.service.JoiaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/joia")
public class JoiaController {
    @Autowired
    private JoiaService service;

    @PostMapping("/inserir")
    public ResponseEntity<String> insert(@RequestBody JoiaBD joia) {
        JoiaBD newJoia = service.insert(joia);
        return new ResponseEntity<>("Joia " + newJoia.getIdentificationNumber() + " criada!", HttpStatus.CREATED);
    }

    @GetMapping("joias")
    public ResponseEntity<List<JoiaBD>> findAllJoias() {
        List<JoiaBD> joias = service.findAll();
        return new ResponseEntity<>(joias, HttpStatus.CREATED);
    }

    // joia/excluir?numero_identificacao={id}
    // joia/excluir?numero_identificacao=1
    @DeleteMapping("/excluir")
    public ResponseEntity<Void> delete(@RequestParam long numero_identificacao) {
        service.delete(numero_identificacao);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<JoiaBD>> findById(@PathVariable long id) {
        Optional<JoiaBD> optionalJoiaBD = service.findByid(id);
        return new ResponseEntity<>(optionalJoiaBD, HttpStatus.OK);
    }
}
