package example.techtest.service;

import example.techtest.model.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> getAllEmployees();
    Employee getEmployeeById(int id);
    List<Employee> getEmployeesByName(String name);
    List<Employee> getEmployeesByCharge(String name);
    List<Employee> getEmployeesByContractType(String name);
    Employee createEmployee(Employee employee);
    void updateEmployee(int id, Employee employee);
    void deleteEmployee(int id);
}
