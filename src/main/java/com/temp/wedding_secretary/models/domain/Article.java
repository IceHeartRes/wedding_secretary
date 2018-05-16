package com.temp.wedding_secretary.models.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
@ApiModel(description = "Статья")
public class Article {

    @ApiModelProperty(value = "Заголовок", example = "Идеальная свадьба")
    private String title;

    @ApiModelProperty(value = "Текст статьи")
    private String text;

    @ApiModelProperty(value = "Картинки")
    private List<Object> images;

    @ApiModelProperty(value = "Превьюшка статьи")
    private String preview;

    @ApiModelProperty(value = "Иконка")
    private Object icon;

}
