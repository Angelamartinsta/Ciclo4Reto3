/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Reto3.controlador;

import Reto3.modelo.Cosmetics;
import Reto3.servicio.CosmeticsService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author USUARIO
 */
@RestController
@RequestMapping("/api/cosmetics")
@CrossOrigin("*")
public class CosmeticsController {
    @Autowired
    private CosmeticsService clotheService;

    @GetMapping("/all")
    public List<Cosmetics> getAll() {
        return clotheService.getAll();
    }

    @GetMapping("/{reference}")
    public Optional<Cosmetics> getCosmetics(@PathVariable("reference") String reference) {
        return clotheService.getClothe(reference);
    }

    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public Cosmetics create(@RequestBody Cosmetics gadget) {
        return clotheService.create(gadget);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Cosmetics update(@RequestBody Cosmetics gadget) {
        return clotheService.update(gadget);
    }

    @DeleteMapping("/{reference}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("reference") String reference) {
        return clotheService.delete(reference);
    }

}
