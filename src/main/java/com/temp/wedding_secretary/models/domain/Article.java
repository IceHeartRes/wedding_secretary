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

    @ApiModelProperty(value = "Код", example = "123")
    private String code;

    @ApiModelProperty(value = "Текст статьи")
    private String text;

    @ApiModelProperty(value = "Ссылки на картинки")
    private List<String> imageLinks;

    @ApiModelProperty(value = "Превьюшка статьи")
    private String preview;

    @ApiModelProperty(value = "Ссылка на иконку")
    private String iconLink;

}
