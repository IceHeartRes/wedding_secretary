package com.temp.wedding_secretary.models.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import com.temp.wedding_secretary.models.dictionaries.City;

@Data
@ApiModel(description = "Заявка")
public class Order {

    @ApiModelProperty(value = "Город")
    private City city;

    @ApiModelProperty(value = "Наименование", example = "Заявка на проведение свадьбы")
    private String name;

    @ApiModelProperty(value = "Почта заказчика", example = "orders@gmail.com")
    private String email;

    @ApiModelProperty(value = "Телефонный номер заказчика", example = "+79998887766")
    private String phone;

    @ApiModelProperty(value = "Раздел")
    private String partition;

}
