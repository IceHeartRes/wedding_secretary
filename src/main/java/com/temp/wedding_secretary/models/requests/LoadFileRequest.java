package com.temp.wedding_secretary.models.requests;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.temp.wedding_secretary.constants.Columns;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("Тело запроса для методов возврата файлов")
public class LoadFileRequest {

    @JsonProperty(Columns.CODE)
    @ApiModelProperty(value = "Код файла", example = "1", required = true)
    private String code;

    public LoadFileRequest() {
    }

}
