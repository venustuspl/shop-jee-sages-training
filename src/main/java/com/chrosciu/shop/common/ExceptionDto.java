package com.chrosciu.shop.common;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class ExceptionDto {
    private final String message;
}
