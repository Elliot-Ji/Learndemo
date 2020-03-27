package com.example.mybatis;

import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * Created by Elliot Ji on 2019/1/9.
 */
public interface EmployeeMapper {

    Employee getEmpAndDept(Integer id);

    @MapKey("id")
    Map<String,Employee> getEmpMap(String name);

    Map<String ,Object> getEmpByIdRe(Integer id);

    List<Employee> getEmpByLastName(String name);

    Employee getEmpByMap(Map<String,Object> map);

    Employee getEmpByIdAndLastName(@Param("id")Integer id, @Param("lastName")String lastName);

    Employee getEmpById(Integer id);

    void addEmp(Employee employee);

    void updateEmp(Employee employee);

    void deleteEmpById(Integer id);

}
