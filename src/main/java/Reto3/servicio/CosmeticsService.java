/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Reto3.servicio;

import Reto3.modelo.Cosmetics;
import Reto3.repositorio.CosmeticsRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author USUARIO
 */
@Service
public class CosmeticsService {
    @Autowired
    private CosmeticsRepository cosmeticsRepository;

    public List<Cosmetics> getAll() {
        return cosmeticsRepository.getAll();
    }

    public Optional<Cosmetics> getClothe(String reference) {
        return cosmeticsRepository.getCosmetics(reference);
    }

    public Cosmetics create(Cosmetics accesory) {
        if (accesory.getReference() == null) {
            return accesory;
        } else {
            return cosmeticsRepository.create(accesory);
        }
    }

    public Cosmetics update(Cosmetics cosmetics){
        if (cosmetics.getReference()!= null){
            Optional<Cosmetics> cosmeticsDb = cosmeticsRepository.getCosmetics(cosmetics.getReference());
            if (cosmeticsDb.isPresent()){
                if (cosmetics.getReference()!=null){
                    cosmeticsDb.get().setReference(cosmetics.getReference());
                }
                if (cosmetics.getCategory()!=null){
                    cosmeticsDb.get().setCategory(cosmetics.getCategory());
                }
                if (cosmetics.getDescription()!=null){
                    cosmeticsDb.get().setDescription(cosmetics.getDescription());
                }
                if (cosmetics.getPrice()!= 0.0){
                    cosmeticsDb.get().setPrice(cosmetics.getPrice());
                }
                if (cosmetics.getQuantity()!=0){
                    cosmeticsDb.get().setQuantity(cosmetics.getQuantity());
                }
                if (cosmetics.getPhotography()!=null){
                    cosmeticsDb.get().setPhotography(cosmetics.getPhotography());
                }
                cosmeticsDb.get().setAvailability(cosmetics.isAvailability());
                cosmeticsRepository.update(cosmeticsDb.get());
                return cosmeticsDb.get();
            }else{
                return cosmetics;
            }
        }else{
            return cosmetics;
        }
    }

    public boolean delete(String reference){
        boolean del = getClothe(reference).map(cosmetics -> {
            cosmeticsRepository.delete(cosmetics);
            return true;
        }).orElse(false);
        return del;
    }
    
    
}
