package com.example.library.controller;

import java.util.List;

import com.example.library.entity.Pelanggan;
import com.example.library.service.PelangganService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@CrossOrigin
@RestController
@RequestMapping("/pelanggan")
public class PelangganController {
    @Autowired
    private PelangganService pelangganService;

    // public PelangganController(PelangganService pelangganService) {
    //     this.pelangganService = pelangganService;
    // }

    @GetMapping("")
    public List<Pelanggan> getAllPelanggan() {
        return pelangganService.getAllPelanggan();
    }

    @GetMapping("/{pelangganId}")
    public Pelanggan getPelangganId(@PathVariable(name="pelangganId") Long pelangganId) {
        return pelangganService.getPelangganById(pelangganId);
    }

    @GetMapping("/nama/{nama}")
    public List<Pelanggan> getPelangganNama(@PathVariable(name="nama") String nama) {
        return pelangganService.getPelangganByNama(nama);
    }

    @PostMapping("")
    public void addPelanggan(@RequestBody final Pelanggan pelanggan) {
        pelangganService.addPelanggan(pelanggan);
    }

    @DeleteMapping("/{pelangganId}")
    public void deletePelanggan(@PathVariable final Long pelangganId) {
        pelangganService.deletePelanggan(pelangganId);
    }

    @PutMapping("/{pelangganId}")
    public void updatePelanggan(@PathVariable final Long pelangganId, @RequestBody final Pelanggan pelanggan) {
        pelangganService.updatePelanggan(pelangganId, pelanggan);
    }
    
}
