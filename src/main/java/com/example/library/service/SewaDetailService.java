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

    public void addSewaDetail(SewaDetail sewaDetail) {
        Optional<SewaDetail> sewaDetailOPtional = sewaDetailRepository.getSewaDetailById(sewaDetail.getID());

        if (sewaDetailOPtional.isPresent()) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "A book with same ISBN number is present!");
        }
        else {
            sewaDetailRepository.save(sewaDetail);
            throw new ResponseStatusException(HttpStatus.OK, "Book data successfully saved!");
        }
    }

    public void updateSewaDetail(Long idSewa, SewaDetail sewaDetail) {
        Optional<SewaDetail> tmpSewa = sewaDetailRepository.findById(idSewa);

        if (tmpSewa.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Oh Oh! no mataching sewa was found");
        }

        sewaDetailRepository.save(sewaDetail);
        throw new ResponseStatusException(HttpStatus.OK, "Yeayy! Succes Update!");
    }

    public void deleteSewaDetail(Long idSewa) {
        Optional<SewaDetail> sewaDetailOptional = sewaDetailRepository.findById(idSewa);

        if(sewaDetailOptional.isPresent()){
            sewaDetailRepository.deleteById(idSewa);
			throw new ResponseStatusException(HttpStatus.OK, "Berhasil dihapus");
		}
		else {
	        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Sewa tidak ada");
		}
    }

}
