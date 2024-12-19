package iuh.fit.se.backEnd.services;

import iuh.fit.se.backEnd.models.DienThoai;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import iuh.fit.se.backEnd.repositories.dienThoaiRepository;

import java.util.List;

@Service
public class dienThoaiService {
    @Autowired
    public dienThoaiRepository dienThoaiRepository;

    public List<DienThoai> findAll() {
        return dienThoaiRepository.findAll();
    }
}
