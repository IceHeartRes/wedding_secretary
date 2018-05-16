package com.temp.wedding_secretary.models.dictionaries;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(description = "Категория специалиста")
public class ProfessionalCategory {

    @ApiModelProperty(value = "Наименование", example = "Тамада")
    private String name;

    @ApiModelProperty(value = "Описание категории", example = "Ведущий свадебной церемонии")
    private String description;

}
