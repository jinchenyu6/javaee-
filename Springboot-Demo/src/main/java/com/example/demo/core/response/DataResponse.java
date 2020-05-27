package com.example.demo.core.response;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data

public class DataResponse<T> extends BaseResponse {
    private T data;
}