package com.walkwind.boot.bean;

import io.searchbox.annotations.JestId;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.stereotype.Service;

/**
 * @Author walkwind
 * @Description
 * @Date 2020-4-26-17:12
 **/
@Document(indexName = "company",type ="person" )
public class Employee {
    @JestId
    private Integer id;
    private String name;
    private String department;
    private String description;

    public Employee() {
    }

    public Employee(Integer id, String name, String department, String description) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.description = description;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", department='" + department + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
