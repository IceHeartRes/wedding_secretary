package com.temp.wedding_secretary.models.dictionaries;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(description = "Тип события")
public class EventType {

    @ApiModelProperty(value = "Наименование", example = "Регистрация")
    private String name;

    @ApiModelProperty(value = "Описание события", example = "Официальная часть бракосочетания")
    private String description;

}
