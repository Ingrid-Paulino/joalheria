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

    //Usei Request Body
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

    @GetMapping("/{id}")
    public ResponseEntity<Optional<JoiaBD>> findById(@PathVariable long id) {
        Optional<JoiaBD> optionalJoiaBD = service.findByid(id);
        return new ResponseEntity<>(optionalJoiaBD, HttpStatus.OK);
    }

    //@PutMapping
    //public ResponseEntity<JoiaBD> update(@RequestBody JoiaBD joia) {
    //JoiaBD joiaUpdate = service.update(joia);
    //  return new ResponseEntity<>(joiaUpdate, HttpStatus.OK);
    //}

    //Ou
    //joia/atualizar?número identificacao={}
    @PutMapping("/atualizar")
    public ResponseEntity<JoiaBD> update(@RequestParam long numero_identificacao,
                                         @RequestBody JoiaBD joia) {
        JoiaBD joiaUpdate = service.update(joia, numero_identificacao);
        return new ResponseEntity<>(joiaUpdate, HttpStatus.OK);
    }

    // joia/excluir?numero_identificacao={id}
    // joia/excluir?numero_identificacao=1
    //Usei Request Param
    @DeleteMapping("/excluir")
    public ResponseEntity<Void> delete(@RequestParam long numero_identificacao) {
        service.delete(numero_identificacao);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
