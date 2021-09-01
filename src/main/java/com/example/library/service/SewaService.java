package com.example.library.service;

import java.util.List;
import java.util.Optional;

import com.example.library.entity.Sewa;
import com.example.library.repository.SewaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class SewaService {
    @Autowired
    private SewaRepository sewaRepository;

    public List<Sewa> getAllSewa() {
        return sewaRepository.findAll();
    }

    public Sewa getById(Long idSewa) {
        Optional<Sewa> sewaOptional = sewaRepository.findById(idSewa);

        if(sewaOptional.isPresent()){
            return sewaOptional.get();
		}
		else {
	        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Sewa tidak ada");
		}
    }

    public void addSewa(Sewa sewa) {
        Optional<Sewa> sewaOptional = sewaRepository.findByISBN(sewa.getISBN());

        if (sewaOptional.isPresent()) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "A book with same ISBN number is present!");
        }
        else {
            sewaRepository.save(sewa);
            throw new ResponseStatusException(HttpStatus.OK, "Book data successfully saved!");
        }
    }

    public void delete(Long idSewa) {
        Optional<Sewa> sewaOptional = sewaRepository.findById(idSewa);

        if(sewaOptional.isPresent()){
            sewaRepository.deleteById(idSewa);
			throw new ResponseStatusException(HttpStatus.OK, "Berhasil dihapus");
		}
		else {
	        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Sewa tidak ada");
		}
    }

    public void updateSewa(Long idSewa, Sewa sewa) {
        Optional<Sewa> tmpSewa = sewaRepository.findById(idSewa);

        if (tmpSewa.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Oh Oh! no mataching sewa was found");
        }

        sewaRepository.save(sewa);
        throw new ResponseStatusException(HttpStatus.OK, "Yeayy! Succes Update!");
    }
}
