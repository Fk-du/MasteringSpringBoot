package com.fkadu.microservices.limits_service.been;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class Limits {
    private int min;
    private int max;
}
