package com.example.library.service;

import com.example.library.entity.SewaDetail;
import com.example.library.repository.SewaDetailRepository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class SewaDetailService {
    @Autowired
    private SewaDetailRepository sewaDetailRepository;
    
    public SewaDetail getSewaDetailById(Long sewaId){
        Optional<SewaDetail> sewaDetail = sewaDetailRepository.getSewaDetailById(sewaId);
        
        if (sewaDetail.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No matching title was found!");
        }
        return sewaDetail.get();
    }

    public List<SewaDetail> sewaDetail(){
        List<SewaDetail> sewaDetail = sewaDetailRepository.getSewaDetail();
        
        if (sewaDetail.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No matching title was found!");
        }
        return sewaDetail;
    }
}
