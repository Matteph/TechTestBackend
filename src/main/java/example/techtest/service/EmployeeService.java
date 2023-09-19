package example.techtest.service;

import example.techtest.model.Employee;

import java.util.List;

public interface EmployeeService {
    public List<Employee> getAllEmployees();
    public Employee getEmployeeById(int id);
    public Employee createEmployee(Employee employee);
    public void updateEmployee(int id, Employee employee);
    public void deleteEmployee(int id);
}
