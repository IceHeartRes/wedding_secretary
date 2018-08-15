package com.temp.wedding_secretary.models.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.temp.wedding_secretary.constants.Columns;
import com.temp.wedding_secretary.models.Contact;
import com.temp.wedding_secretary.models.dictionaries.ProfessionalCategory;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
@JsonSerialize
@JsonDeserialize
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@ApiModel(description = "Специалист")
public class Specialist {

    @JsonProperty(Columns.NAME)
    @ApiModelProperty(value = "ФИО", example = "Иванов Иван Сидорович")
    private String name;

    @JsonProperty(Columns.CODE)
    @ApiModelProperty(value = "Код", example = "123")
    private String code;

    @JsonProperty(Columns.DESCRIPTION)
    @ApiModelProperty(value = "Описание", example = "Лучший тамада в городе")
    private String description;

    @JsonProperty(Columns.CATEGORY)
    @ApiModelProperty(value = "Данные о категории специалиста")
    private ProfessionalCategory category;

    @JsonProperty(Columns.CONTACTS)
    @ApiModelProperty(value = "Список контактных данных")
    private List<Contact> contacts;

    @JsonProperty(Columns.PHOTO)
    @ApiModelProperty(value = "Фото-портфолио специалиста")
    private List<String> photo;

    @JsonProperty(Columns.VIDEO_LINKS)
    @ApiModelProperty(value = "Ссылки на видео на youtube")
    private List<String> videoLinks;

}
