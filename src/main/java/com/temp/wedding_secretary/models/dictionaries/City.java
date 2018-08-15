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
@ApiModel(description = "Город")
public class City {

    @JsonProperty(Columns.NAME)
    @ApiModelProperty(value = "Наименование", example = "Новосибирск")
    private String name;

    @JsonProperty(Columns.CODE)
    @ApiModelProperty(value = "Код города", example = "123")
    private String code;

    @JsonProperty(Columns.TIME_ZONE_OFFSET)
    @ApiModelProperty(value = "Часовой пояс", example = "4")
    private Integer timeZoneOffset;

}
