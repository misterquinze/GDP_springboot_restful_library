package com.example.library.controller;

import java.util.List;

import com.example.library.entity.Sewa;
import com.example.library.service.SewaService;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping("/sewa")
public class SewaController {
    private SewaService sewaService;

    
    public SewaController(SewaService sewaService) {
        this.sewaService = sewaService;
    }

    @GetMapping("")
    public List<Sewa> getAllSewa() {
        return sewaService.getAllSewa();
    }

    @GetMapping("/{idSewa}")
    public Sewa get(@PathVariable final Long idSewa) {
        return sewaService.getById(idSewa);
    }

    @PostMapping("")
    public void addSewa(@RequestBody final Sewa sewa) {
        sewaService.addSewa(sewa);
    }

    @DeleteMapping("/{idSewa}")
    public void deleteSewa(@PathVariable final Long idSewa) {
        sewaService.delete(idSewa);
    }

    @PutMapping("/{idSewa}")
    public void updateSewa(@PathVariable final Long idSewa, @RequestBody final Sewa sewa) {
        sewaService.updateSewa(idSewa, sewa);
    }
}
