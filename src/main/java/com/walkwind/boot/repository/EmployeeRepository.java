package com.walkwind.boot.repository;

import com.walkwind.boot.bean.Employee;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

/**
 * @Author walkwind
 * @Description
 * @Date 2020-4-26-19:31
 **/
public  interface EmployeeRepository extends CrudRepository<Employee, Integer> {
//可以在此处重写CrudRepository中的方法,也可以直接使用
}
