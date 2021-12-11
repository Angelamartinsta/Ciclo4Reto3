/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Reto3.repositorio;

import Reto3.modelo.Cosmetics;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import Reto3.interfaces.CosmeticsInterface;

/**
 *
 * @author USUARIO
 */
@Repository
public class CosmeticsRepository {
    @Autowired
    private CosmeticsInterface crudInterface;

    public List<Cosmetics> getAll() {
        return crudInterface.findAll();
    }

    public Optional<Cosmetics> getCosmetics(String reference) {
        return crudInterface.findById(reference);
    }

    public Cosmetics create(Cosmetics cosmetics) {
        return crudInterface.save(cosmetics);
    }

    public void update(Cosmetics cosmetics) {
        crudInterface.save(cosmetics);
    }

    public void delete(Cosmetics clothe) {
        crudInterface.delete(clothe);
    }
}
