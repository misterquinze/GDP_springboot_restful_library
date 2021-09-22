package com.example.library.controller;


import com.example.library.entity.SewaDetail;
import com.example.library.service.SewaDetailService;

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
@RequestMapping("/sewadetail")
public class SewaDetailController {
    private SewaDetailService sewaDetailService;


    public SewaDetailController(SewaDetailService sewaDetailService) {
        this.sewaDetailService = sewaDetailService;
    }

  
    @GetMapping ("/{sewaId}")
    public SewaDetail getSewaDetailById(@PathVariable(name="sewaId") Long sewaId){
        return sewaDetailService.getSewaDetailById(sewaId);
    }

    @PostMapping("")
    public void addSewaDetail(@RequestBody final SewaDetail sewaDetail) {
        sewaDetailService.addSewaDetail(sewaDetail);
    }

    @PutMapping("/{idSewa}")
    public void updateSewaDetail(@PathVariable final Long idSewa, @RequestBody final SewaDetail sewaDetail) {
        sewaDetailService.updateSewaDetail(idSewa, sewaDetail);
    }

    @DeleteMapping("/{idSewa}")
    public void deleteSewaDetail(@PathVariable final Long idSewa) {
        sewaDetailService.deleteSewaDetail(idSewa);
    }


}
