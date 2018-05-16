package com.temp.wedding_secretary.models.domain;

import com.temp.wedding_secretary.models.dictionaries.ProfessionalCategory;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import com.temp.wedding_secretary.models.Contact;

import java.util.List;

@Data
@ApiModel(description = "Специалист")
public class Specialist {

    @ApiModelProperty(value = "ФИО", example = "Иванов Иван Сидорович")
    private String name;

    @ApiModelProperty(value = "Описание", example = "Лучший тамада в городе")
    private String description;

    @ApiModelProperty(value = "Данные о категории специалиста")
    private ProfessionalCategory category;

    @ApiModelProperty(value = "Список контактных данных")
    private List<Contact> contacts;

    @ApiModelProperty(value = "Фото-портфолио специалиста")
    private List<Object> photes;

    @ApiModelProperty(value = "Ссылки на видео на youtube")
    private List<String> videoLinks;

}
