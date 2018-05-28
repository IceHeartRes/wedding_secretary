package com.temp.wedding_secretary.models;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(description = "Контакт")
public class Contact {

    @ApiModelProperty(value = "Код контакта", example = "54321")
    private String code;

    @ApiModelProperty(value = "Тип контакта", example = "Телефонный номер")
    private String type;

    @ApiModelProperty(value = "Описание", example = "+79998887766")
    private String description;

    //TODO тут наверное 1 иконка
    @ApiModelProperty(value = "Ссылка на иконку")
    private String iconLink;

}
