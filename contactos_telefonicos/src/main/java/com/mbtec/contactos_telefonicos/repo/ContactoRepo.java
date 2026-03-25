package com.mbtec.contactos_telefonicos.repo;

import com.mbtec.contactos_telefonicos.model.Contacto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContactoRepo extends JpaRepository<Contacto, Integer> {
    @Query("SELECT c FROM Contacto c WHERE " +
            "LOWER(c.name) LIKE LOWER (CONCAT('%', :pesquisado, '%'))")
    List<Contacto> pesquisarContacto(@Param("pesquisado") String pesquisado);
}
