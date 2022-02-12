package com.shahian.springbootcrudwithsqlserver.domain.Base;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@JsonIgnoreProperties(ignoreUnknown = true)

public class BaseDTO<T> {
    private MetaDTO meta;
    private T object;
}
