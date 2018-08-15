package com.temp.wedding_secretary.models.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.temp.wedding_secretary.constants.Columns;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
@JsonSerialize
@JsonDeserialize
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@ApiModel(description = "Статья")
public class Article {

    @JsonProperty(Columns.TITLE)
    @ApiModelProperty(value = "Заголовок", example = "Идеальная свадьба")
    private String title;

    @JsonProperty(Columns.CODE)
    @ApiModelProperty(value = "Код", example = "123")
    private String code;

    @JsonProperty(Columns.TEXT)
    @ApiModelProperty(value = "Текст статьи")
    private String text;

    @JsonProperty(Columns.ICON_LINKS)
    @ApiModelProperty(value = "Ссылки на картинки")
    private List<String> imageLinks;

    @JsonProperty(Columns.PREVIEW)
    @ApiModelProperty(value = "Превьюшка статьи")
    private String preview;

    @JsonProperty(Columns.ICON_LINK)
    @ApiModelProperty(value = "Ссылка на иконку")
    private String iconLink;

}
