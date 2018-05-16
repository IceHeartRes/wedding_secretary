package com.temp.wedding_secretary.models.dictionaries;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(description = "Город")
public class City {

    @ApiModelProperty(value = "Наименование", example = "Новосибирск")
    private String name;

    @ApiModelProperty(value = "Код города", example = "123")
    private String code;

    @ApiModelProperty(value = "Часовой пояс", example = "4")
    private Integer timeZoneOffset;

}
