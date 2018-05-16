package com.temp.wedding_secretary.models;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
@ApiModel(description = "Контакт")
public class Contact {

    @ApiModelProperty(value = "Тип контакта", example = "Телефонный номер")
    private String type;

    @ApiModelProperty(value = "Описание", example = "+79998887766")
    private String description;

    @ApiModelProperty(value = "Иконки")
    private List<Object> icons;

}
