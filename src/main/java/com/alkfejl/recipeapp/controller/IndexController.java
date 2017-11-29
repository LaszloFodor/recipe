package com.alkfejl.recipeapp.controller;


import com.alkfejl.recipeapp.repository.UnitRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
public class IndexController {

    private UnitRepository unitRepository;

    public IndexController(UnitRepository unitRepository) {
        this.unitRepository = unitRepository;
    }

    @RequestMapping({"/", "/index"})
    public String getIndexPage() {

        System.out.println("---------unit: ");

        return "index";
    }

}
