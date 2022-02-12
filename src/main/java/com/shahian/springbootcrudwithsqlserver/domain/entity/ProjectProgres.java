package com.shahian.springbootcrudwithsqlserver.domain.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import com.shahian.springbootcrudwithsqlserver.domain.Base.BaseEntity;

import javax.persistence.*;


@Entity
@Table(name = "ProjectProgres")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true,value ={"project","company"})

public class ProjectProgres extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Long id;
    @Column(name = "YearId")
    private Long yearId;
    @Column(name = "MonthId")
    private Long monthId;
    @Column(name = "TypeOfProjectProgresId")
    private Long typeOfProjectProgresId;
    @Column(name = "Real")
    private Double real;
    @Column(name = "Program")
    private Double program;
    @Column(name = "PercentageOfDeviation")
    private Double percentageOfDeviation;

    @Column(name = "project_id")
    private Long projectId;

    @ManyToOne(fetch = FetchType.LAZY,optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "project_id",nullable = false, updatable = false, insertable = false)
    private Project project;





}
