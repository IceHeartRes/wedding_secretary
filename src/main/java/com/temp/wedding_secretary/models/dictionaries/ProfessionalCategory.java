package com.temp.wedding_secretary.models.dictionaries;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.temp.wedding_secretary.constants.Columns;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@JsonSerialize
@JsonDeserialize
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@ApiModel(description = "Категория специалиста")
public class ProfessionalCategory {

    @JsonProperty(Columns.CODE)
    @ApiModelProperty(value = "Код", example = "123")
    private String code;

    @JsonProperty(Columns.NAME)
    @ApiModelProperty(value = "Наименование", example = "Тамада")
    private String name;

    @JsonProperty(Columns.DESCRIPTION)
    @ApiModelProperty(value = "Описание категории", example = "Ведущий свадебной церемонии")
    private String description;

}
