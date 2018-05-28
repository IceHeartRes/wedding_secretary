package com.temp.wedding_secretary.controllers;

import com.temp.wedding_secretary.models.domain.Article;
import com.temp.wedding_secretary.models.domain.Order;
import com.temp.wedding_secretary.models.domain.Specialist;
import com.temp.wedding_secretary.services.ArticleService;
import com.temp.wedding_secretary.services.OrderService;
import com.temp.wedding_secretary.services.SpecialistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/rest/api")
public class CommonController {

    private final ArticleService articleService;
    private final OrderService orderService;
    private final SpecialistService specialistService;

    @Autowired
    public CommonController(ArticleService articleService, OrderService orderService, SpecialistService specialistService) {
        this.articleService = articleService;
        this.orderService = orderService;
        this.specialistService = specialistService;
    }

    @RequestMapping(path = "/articles", method = RequestMethod.GET)
    public List<Article> getArticles() {
        return articleService.getArticles();
    }

    @RequestMapping(path = "/orders", method = RequestMethod.GET)
    public List<Order> getOrders() {
        return orderService.getOrders();
    }

    @RequestMapping(path = "/specialists", method = RequestMethod.GET)
    public List<Specialist> getSpecialists() {
        return specialistService.getSpecialists();
    }

    @RequestMapping(path = "/specialists/update", method = RequestMethod.POST)
    public Boolean updateSpecilist() {
        return specialistService.updateSpecilist();
    }


}
