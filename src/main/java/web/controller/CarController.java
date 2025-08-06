package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.service.CarService;

@Controller
@RequestMapping("/cars")
public class CarController {

    private CarService carService;

    @Autowired
    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping
    public String getCars(@RequestParam(value = "count", required = false) Integer count, Model model) {
       if (count != null) {
           model.addAttribute("cars",carService.getCar(count));
       } else {
           model.addAttribute("cars", carService.getCar(5));
       }
       return "cars";
    }
}
