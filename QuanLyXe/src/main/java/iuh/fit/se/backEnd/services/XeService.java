package iuh.fit.se.backEnd.services;

import iuh.fit.se.backEnd.models.Xe;
import iuh.fit.se.backEnd.repositories.XeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class XeService {
    @Autowired
    private XeRepository xeRepository;

    public List<Xe> getAllXe() {
        return xeRepository.findAll();
    }

    public List<Xe> filterXe(int filter) {
        return xeRepository.findByMaXe(filter);
    }

    public String addXe(Xe xe)
    {
        xeRepository.save(xe);
        return "Thêm xe thành công";
    }
}
