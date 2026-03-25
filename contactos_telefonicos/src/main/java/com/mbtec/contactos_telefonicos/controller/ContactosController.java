package com.mbtec.contactos_telefonicos.controller;

import com.mbtec.contactos_telefonicos.model.Contacto;
import com.mbtec.contactos_telefonicos.service.ContactoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contact")
public class ContactosController {

    @Autowired
    ContactoService service;

    @GetMapping("/greating")
    public String grreating() {
        return "Um prazer fazer parte da familia MBTEC";
    }

    @PostMapping("/add")
    public ResponseEntity<?> adicionar(@RequestBody Contacto contacto) {

        Contacto c = service.adicionarContacto(contacto);
        return new ResponseEntity<>(c, HttpStatus.OK);
    }

    @GetMapping("/listar")
    public ResponseEntity<List<Contacto>> getContacts(){
        return new ResponseEntity<>(service.getContacts(), HttpStatus.OK);
    }

    @DeleteMapping("/excluir/{id}")
    public ResponseEntity<String> deletarContactoPorId(@PathVariable int id){
        Contacto contacto = service.alistarPorId(id);

        if (contacto != null){
            service.deletarPorId(id);
            return new ResponseEntity<>("Contacto excluido com sucesso", HttpStatus.OK);
        }else {
            return new ResponseEntity<>("Nao foi possivel deletar", HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/pesquisar/{pesquisado}")
    public ResponseEntity<List<Contacto>> pesquisar(@PathVariable String pesquisado){
        List<Contacto> contactoList = service.pesquisarContactos(pesquisado);
        return new ResponseEntity<>(contactoList, HttpStatus.OK);
    }
}
