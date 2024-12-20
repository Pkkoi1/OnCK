package iuh.fit.se.frontEnd.controllers;

import iuh.fit.se.backEnd.services.LoaiXeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/loaixe")
public class LoaiXeController {
    @Autowired
    private LoaiXeService loaiXeService;

    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(value = {"", "/"})
    public ModelAndView showListLoaiXe()
    {
        ModelAndView modelAndView = new ModelAndView("LoaiXe/list");
        modelAndView.addObject("loaiXes", loaiXeService.getAllLoaiXe());
        return modelAndView;
    }
}
