package com.temp.wedding_secretary.models.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.temp.wedding_secretary.constants.Columns;
import com.temp.wedding_secretary.models.dictionaries.City;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@JsonSerialize
@JsonDeserialize
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@ApiModel(description = "Заявка")
public class Order {

    @JsonProperty(Columns.CITY)
    @ApiModelProperty(value = "Город")
    private City city;

    @JsonProperty(Columns.NAME)
    @ApiModelProperty(value = "Наименование", example = "Заявка на проведение свадьбы")
    private String name;

    @JsonProperty(Columns.CODE)
    @ApiModelProperty(value = "Код", example = "123")
    private String code;

    @JsonProperty(Columns.EMAIL)
    @ApiModelProperty(value = "Почта заказчика", example = "orders@gmail.com")
    private String email;

    @JsonProperty(Columns.PHONE)
    @ApiModelProperty(value = "Телефонный номер заказчика", example = "+79998887766")
    private String phone;

    @JsonProperty(Columns.PARTITION)
    @ApiModelProperty(value = "Раздел")
    private String partition;

}
