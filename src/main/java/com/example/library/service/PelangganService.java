package com.example.library.service;

import java.util.List;
import java.util.Optional;

import com.example.library.entity.Pelanggan;
import com.example.library.repository.PelangganRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class PelangganService {
    @Autowired
    private PelangganRepository pelangganRepository;

    public List<Pelanggan> getAllPelanggan() {
        return pelangganRepository.findAll();
    }

    public Pelanggan getPelangganById(Long pelangganId) {
        Optional<Pelanggan> pelanggan = pelangganRepository.findById(pelangganId);
        
        if(pelanggan.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Oh No! I'm Sorry not found what you looking for");
        }

        return pelanggan.get();
    }

    public List<Pelanggan> getPelangganByNama(String nama){
        List<Pelanggan> pelanggan =  pelangganRepository.findByNAMAContainingIgnoreCase(nama);

        if (pelanggan.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Not Found");
        }

        return pelanggan;
    }

    public Pelanggan addPelanggan(Pelanggan pelanggan){
        Optional<Pelanggan> tmpPelanggan = pelangganRepository.findByKODEPELIgnoreCase(pelanggan.getKODEPEL());

        if(tmpPelanggan.isPresent()) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Yeayy!! Pelanggan with matching KODEPEL was found");
        }

        pelangganRepository.save(pelanggan);
        throw new ResponseStatusException(HttpStatus.OK, "Yeay! New Pelanggan was added!"); 
    }

    public void deletePelanggan(Long pelangganId) {
        Optional<Pelanggan > pelanggan = pelangganRepository.findById(pelangganId);

        if (pelanggan.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Id not found");
        }

        pelangganRepository.deleteById(pelangganId);
        throw new ResponseStatusException(HttpStatus.OK, "Succes Delete");
    }

    public void updatePelanggan(Long pelangganId, Pelanggan pelanggan) {
        Optional<Pelanggan> tmpPelanggan = pelangganRepository.findById(pelangganId);

        if (tmpPelanggan.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Oh Oh! no mataching pelanggan was found");
        }

        pelangganRepository.save(pelanggan);
        throw new ResponseStatusException(HttpStatus.OK, "Yeayy! Succes Update!");
    }

}
