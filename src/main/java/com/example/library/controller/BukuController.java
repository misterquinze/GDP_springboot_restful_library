package com.example.library.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import com.example.library.entity.Buku;
import com.example.library.service.BukuService;

@CrossOrigin
@RestController
@RequestMapping("/buku")
public class BukuController {
    //service variable
    @Autowired
    private BukuService bukuService;

    //Constructor
    // public BukuController(BukuService bukuService) {
    //     this.bukuService = bukuService;
    // }

    @GetMapping("")
    public List<Buku> getAllBuku(){
        return bukuService.getAllBuku();
    }

    @GetMapping("/{bukuId}")
    public Buku getBukuById(@PathVariable(name="bukuId") Long bukuId){
        return bukuService.getBukuById(bukuId);
    }

    @GetMapping("/judul/{judul}")
     public List<Buku> getBukuByJudul(@PathVariable(name="judul") String judul) {
        return bukuService.getBukuByJudul(judul);
    }

    @GetMapping("/pengarang/{pengarang}")
    public List<Buku> getBukuByPengarang(@PathVariable(name="pengarang") String pengarang){
        return bukuService.getBukuByPengarang(pengarang);
    }

    @PostMapping("")
    public void addBuku(@RequestBody final Buku buku) {
        bukuService.addBuku(buku);
    }

    @DeleteMapping("/{bukuId}")
    public void deleteBuku(@PathVariable final Long bukuId){
        bukuService.deleteBuku(bukuId);
    }

    @PutMapping("/{bukuId}")
    public void updateBuku(@PathVariable final Long bukuId, @RequestBody final Buku buku) {
        bukuService.updateBuku(bukuId, buku);
    }
}
