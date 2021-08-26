package com.example.library.service;

import java.util.Optional;
import java.util.List;

import com.example.library.entity.Buku;
import com.example.library.repository.BukuRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class BukuService {
    @Autowired
    private BukuRepository bukuRepository;

    public List<Buku> getAllBuku() {
        return bukuRepository.findAll();
    }

    public Buku getBukuById(Long bukuID){
        Optional<Buku> buku = bukuRepository.findById(bukuID);
        if(buku.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No matching title was found");
        }
            
        return buku.get();
    }

    // Custom query menggunakan JPA
    // Startwith = query mencari field mengandung kata yang dicari
    public List<Buku> getBukuByJudul(String judul){   

        List<Buku> buku = bukuRepository.findByJUDULContaining(judul);

        if(buku.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No matching title was found"); 
        }

       return buku;
    }

    public List<Buku> getBukuByPengarang(String pengarang){
        List<Buku> buku = bukuRepository.findByPENGARANGContainingIgnoreCase(pengarang); 
        
        if(buku.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No matching title was found!");
        }
        return buku;
    }

    public void addBuku(Buku buku){
        //custom JPA
        Optional<Buku> tmpBuku = bukuRepository.findByISBNIgnoreCase(buku.getISBN());

        if(tmpBuku.isPresent()){
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Buku with matching ISBN was found");
        }

        bukuRepository.save(buku);
        throw new ResponseStatusException(HttpStatus.OK, "Yeay! New Buku was added!");
    }

    public void deleteBuku(Long bukuId) {
        Optional<Buku > buku = bukuRepository.findById(bukuId);

        if (buku.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Id not found");
        }

        bukuRepository.deleteById(bukuId);
        throw new ResponseStatusException(HttpStatus.OK, "Succes Delete");
    }

    public void updateBuku(Long bukuId, Buku buku) {
        Optional<Buku> tmpBuku = bukuRepository.findById(bukuId);

        if (tmpBuku.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Oh No! no mataching buku was found");
        }

        bukuRepository.save(buku);
        throw new ResponseStatusException(HttpStatus.OK, "Yeayy! Succes Update!");
    }
}
