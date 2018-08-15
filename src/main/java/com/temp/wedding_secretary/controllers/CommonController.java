package com.temp.wedding_secretary.controllers;

import com.temp.wedding_secretary.models.domain.Article;
import com.temp.wedding_secretary.models.domain.Order;
import com.temp.wedding_secretary.models.domain.Specialist;
import com.temp.wedding_secretary.models.requests.LoadFileRequest;
import com.temp.wedding_secretary.services.ArticleService;
import com.temp.wedding_secretary.services.OrderService;
import com.temp.wedding_secretary.services.SendFileService;
import com.temp.wedding_secretary.services.SpecialistService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/wedding_secretary")
public class CommonController {

    private final ArticleService articleService;
    private final OrderService orderService;
    private final SpecialistService specialistService;
    private final SendFileService sendFileService;

    @Autowired
    public CommonController(ArticleService articleService, OrderService orderService, SpecialistService specialistService, SendFileService sendFileService) {
        this.articleService = articleService;
        this.orderService = orderService;
        this.specialistService = specialistService;
        this.sendFileService = sendFileService;
    }

    @RequestMapping(path = "/articles", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "Получение данных по статьям")
    public List<Article> getArticles() {
        return articleService.getArticles();
    }

    @RequestMapping(path = "/orders", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "Получение данных по заявкам")
    public List<Order> getOrders() {
        return orderService.getOrders();
    }

    @RequestMapping(path = "/specialists", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "Получение данных по специалистам")
    public List<Specialist> getSpecialists() {
        return specialistService.getSpecialists();
    }

    @RequestMapping(path = "/specialists/update", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    @ApiOperation(value = "Обновление специалиста")
    public Boolean updateSpecilist(@RequestBody Specialist specialist) {
        return specialistService.updateSpecilist(specialist);
    }

    @RequestMapping(value = "/send_file", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    @ApiOperation(value = "Отправить файл")
    public void sendFile(@RequestBody @Valid LoadFileRequest request, HttpServletResponse response) throws Exception {
        sendFileService.sendFile(request.getCode(), response);
    }


}
