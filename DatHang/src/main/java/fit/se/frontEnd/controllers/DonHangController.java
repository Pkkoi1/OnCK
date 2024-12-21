package fit.se.frontEnd.controllers;

import fit.se.backEnd.enums.TrangThai;
import fit.se.backEnd.models.Donhang;
import fit.se.backEnd.services.DonHangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import fit.se.backEnd.repositories.cuaHangRepository;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
@RequestMapping("donHang")
public class DonHangController {
    @Autowired
    private DonHangService donHangService;

    @Autowired
    private cuaHangRepository cuaHangRepository;

    @GetMapping(value = {"", "/"})
    public ModelAndView showListDonHang(Optional<String> searchKey)
    {
        ModelAndView modelAndView = new ModelAndView("donHang/list");
        if(searchKey.isPresent())
        {
            modelAndView.addObject("donHangs", donHangService.findbyKey(searchKey.get()));
        }
        else
        {
            modelAndView.addObject("donHangs", donHangService.getAllDonHang());
        }

        return modelAndView;
    }

    @GetMapping("/add")
    public ModelAndView showAddDonHang()
    {

       ModelAndView modelAndView = new ModelAndView("donHang/add");
        modelAndView.addObject("maDonhangRoll", donHangService.generateMaDonHang());
        modelAndView.addObject("cuaHangs", cuaHangRepository.findAll());
        modelAndView.addObject("donHang", new Donhang());
        modelAndView.addObject("trangThaiS", TrangThai.values());

        return modelAndView;
    }

    @PostMapping("/add")
    public String addDonHang(Donhang donhang, RedirectAttributes redirectAttribute) throws Exception {
        try {
            donHangService.addDonHang(donhang);
            redirectAttribute.addFlashAttribute("success", "Thêm đơn hàng thành công");
            return "redirect:/donHang";
        } catch (Exception e) {
            redirectAttribute.addFlashAttribute("error", e.getMessage());
            return "redirect:/donHang/add";
        }
    }
    @PostMapping("/delete/{id}")
    public String deleteDonHang(@PathVariable("id") long id)
    {
        donHangService.deleteDonHang(id);
        return "redirect:/donHang";
    }
}
