package com.example.demo.controller;

import com.example.demo.entity.IPO;
import com.example.demo.service.IpoService;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class HomeController {

    private final IpoService ipoService;

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/recommend")
    public String recommend(@RequestParam(required = false) Double minRate,
                            @RequestParam(required = false) Integer maxPrice,
                            @RequestParam(required = false) String market,
                            @RequestParam(required = false) String industry,
                            @RequestParam(required = false) String sort,
                            @RequestParam(required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate startDate,
                            @RequestParam(required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate endDate,
                            Model model) {

        List<IPO> result = ipoService.recommend(minRate, maxPrice, market, industry, sort, startDate, endDate);

        model.addAttribute("result", result);
        model.addAttribute("minRate", minRate);
        model.addAttribute("maxPrice", maxPrice);
        model.addAttribute("market", market);
        model.addAttribute("industry", industry);
        model.addAttribute("startDate", startDate);
        model.addAttribute("endDate", endDate);
        model.addAttribute("sort", sort);

        return "result";
    }

}
