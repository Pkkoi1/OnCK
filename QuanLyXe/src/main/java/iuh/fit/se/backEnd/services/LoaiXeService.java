package iuh.fit.se.backEnd.services;

import iuh.fit.se.backEnd.models.LoaiXe;
import iuh.fit.se.backEnd.repositories.LoaiXeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoaiXeService {
    @Autowired
    private LoaiXeRepository loaiXeRepository;

    public List<LoaiXe> getAllLoaiXe() {
        return loaiXeRepository.findAll();
    }
}
