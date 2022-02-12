package com.shahian.springbootcrudwithsqlserver.domain.DTO;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.shahian.springbootcrudwithsqlserver.domain.Base.BaseEntity;
import com.shahian.springbootcrudwithsqlserver.domain.entity.ProjectProgres;

import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ProjectDTO extends BaseEntity {

    private Long id;
    private String topic;
    private Date startDate;
    private Date endDate;
    private List<ProjectProgres> projectProgres;
}
