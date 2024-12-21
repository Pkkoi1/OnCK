package fit.se.backEnd.services;

import fit.se.backEnd.repositories.DonHangRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fit.se.backEnd.models.Donhang;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.regex.Pattern;

public interface DonHangService {
    List<Donhang> getAllDonHang();
    List<Donhang> findbyKey(String key);
    String generateMaDonHang();
    Boolean addDonHang(Donhang donhang) throws Exception;
    boolean checkDonHangDaDat(String email, LocalDate ngayThangDat);
    boolean deleteDonHang(Long id);
}

