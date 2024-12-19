package iuh.fit.se.frontEnd.Controller;

import iuh.fit.se.backEnd.models.DienThoai;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import iuh.fit.se.backEnd.services.dienThoaiService;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/dienThoai")
public class dienThoaiController {

    @Autowired
    private dienThoaiService dienThoaiService;

    @GetMapping(value = {"/", ""})
    public ModelAndView showListDienThoai() {
        List<DienThoai> dienThoais = dienThoaiService.findAll();
        ModelAndView modelAndView = new ModelAndView("DienThoai/list");
        modelAndView.addObject("dienThoais", dienThoais);
        return modelAndView;
        }

}
