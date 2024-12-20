package iuh.fit.se.frontEnd.controllers;

import iuh.fit.se.backEnd.models.Xe;
import iuh.fit.se.backEnd.services.LoaiXeService;
import iuh.fit.se.backEnd.services.XeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/xe")
public class XeController {

    @Autowired
    private XeService xeService;

    @Autowired
    private LoaiXeService loaiXeService;

    @PreAuthorize("hasRole('USER')")
    @GetMapping(value = {"", "/"})
    public ModelAndView showListXe(Optional<Integer> filter)
    {
        ModelAndView modelAndView = new ModelAndView("Xe/list");

        if(filter.isPresent())
        {
            modelAndView.addObject("xes", xeService.filterXe(filter.get()));
            modelAndView.addObject("loaixes", loaiXeService.getAllLoaiXe());
            System.out.println("1");
        }
        else
        {
            modelAndView.addObject("loaixes", loaiXeService.getAllLoaiXe());
            modelAndView.addObject("xes", xeService.getAllXe());
            System.out.println("2");
        }
        return modelAndView;
    }
    @GetMapping("/add")
    public ModelAndView showAddXe()
    {
        ModelAndView modelAndView = new ModelAndView("Xe/add");
        modelAndView.addObject("loaixes", loaiXeService.getAllLoaiXe());
        modelAndView.addObject("xe", new Xe());
        return modelAndView;
    }

    @PostMapping("/add")
    public String addXe(Xe xe)
    {
        xeService.addXe(xe);
        return "redirect:/xe";
    }
}
