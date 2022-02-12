package com.shahian.springbootcrudwithsqlserver.domain.Base;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import java.sql.Timestamp;
import java.util.Date;

@SuperBuilder
@MappedSuperclass
@AllArgsConstructor
@NoArgsConstructor
@Data
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)

public class BaseEntity {

    @Column(name = "IsDeleted")
    protected Boolean isDeleted;

    @Column(name = "CreateDateTime")
    protected Date createDateTime = new Timestamp(System.currentTimeMillis());

    @Column(name = "ModifyDateTime")
    protected Date modifyDateTime;

    }
