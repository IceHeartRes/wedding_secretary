package com.temp.wedding_secretary.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@JsonSerialize
@JsonDeserialize
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@ApiModel(description = "Контакт")
public class Contact {

    @ApiModelProperty(value = "Код контакта", example = "54321")
    private String code;

    @ApiModelProperty(value = "Тип контакта", example = "Телефонный номер")
    private String type;

    @ApiModelProperty(value = "Описание", example = "+79998887766")
    private String description;

    @ApiModelProperty(value = "Ссылка на иконку")
    private String iconLink;

}
