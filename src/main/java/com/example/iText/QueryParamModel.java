package com.example.iText;

import lombok.Data;

/**
 * @author Elliot Ji
 * @date 2024/09/06
 */
@Data
public class QueryParamModel {

    private Long id;

    private String column;

    private String type;

    private Integer pageNumber;

    private Integer pageSize;

    private int[] pageItems;

    private String condition;

    private String conditionValue;
}
