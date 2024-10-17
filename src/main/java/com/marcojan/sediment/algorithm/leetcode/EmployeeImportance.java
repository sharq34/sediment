package com.marcojan.sediment.algorithm.leetcode;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class EmployeeImportance {
    public int getImportance(List<Employee> employees, int id) {
        Map<Integer, Employee> employeeMap = employees.stream().collect(Collectors.toMap(e->e.id, e->e));
        if(!employeeMap.containsKey(id)){
            return 0;
        }
        int sum = employeeMap.get(id).importance;
        Employee employee = employeeMap.get(id);
        if(employee.subordinates.size()!=0){
            sum += employee.subordinates.stream().map(subId->getImportance(employees, subId)).reduce(0, (a, b)->a+b);
        }
        return sum;
    }
}

// Definition for Employee.
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};
