package com.shahian.springbootcrudwithsqlserver.domain.DTO;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.shahian.springbootcrudwithsqlserver.domain.Base.BaseEntity;

@AllArgsConstructor
@NoArgsConstructor
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ProjectProgresDTO extends BaseEntity {
    private Long id;
    private Long yearId;
    private Long monthId;
    private Long typeOfProjectProgresId;
    private Double Real;
    private Double Program;
    private Double PercentageOfDeviation;
    private Long projectId;
}
