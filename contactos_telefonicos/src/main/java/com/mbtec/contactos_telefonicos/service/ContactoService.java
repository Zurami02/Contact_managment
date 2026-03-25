package com.mbtec.contactos_telefonicos.service;

import com.mbtec.contactos_telefonicos.model.Contacto;
import com.mbtec.contactos_telefonicos.repo.ContactoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactoService {
    @Autowired
    ContactoRepo repo;

    public Contacto adicionarContacto(Contacto c) {
        return repo.save(c);
    }

    public List<Contacto> getContacts() {
        return repo.findAll();
    }

    public void deletarPorId(int id) {
        repo.deleteById(id);
    }

    public Contacto alistarPorId(int id) {
        return repo.findById(id).orElse(null);
    }

    public List<Contacto> pesquisarContactos(String pesquisado) {
        return repo.pesquisarContacto(pesquisado);
    }
}
