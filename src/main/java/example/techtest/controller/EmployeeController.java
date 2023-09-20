package example.techtest.controller;

import example.techtest.model.Employee;
import example.techtest.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;


    @GetMapping("/getAllEmployees")
    public ResponseEntity<List<Employee>> getAllEmpleados() {
        List<Employee> employees = employeeService.getAllEmployees();
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

    @GetMapping("/geEmployeeById/{id}")
    public ResponseEntity<Employee> getEmpleadoById(@PathVariable int id) {
        Employee employee = employeeService.getEmployeeById(id);
        if (employee != null) {
            return new ResponseEntity<>(employee, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/getEmployeesByName/{name}")
    public ResponseEntity<List<Employee>> getEmployeesByName(@PathVariable String name) {
        List<Employee> employees = employeeService.getEmployeesByName(name);
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

    @GetMapping("/getEmployeesByCharge/{charge}")
    public ResponseEntity<List<Employee>> getEmployeesByCharge(@PathVariable String charge) {
        List<Employee> employees = employeeService.getEmployeesByCharge(charge);
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

    @GetMapping("/getEmployeesByContractType/{contractType}")
    public ResponseEntity<List<Employee>> getEmployeesByContractType(@PathVariable String contractType) {
        List<Employee> employees = employeeService.getEmployeesByContractType(contractType);
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }


    @PostMapping("/createEmployee")
    public ResponseEntity<Employee> createEmpleado(@RequestBody Employee employee) {
        Employee createdEmployee = employeeService.createEmployee(employee);
        System.out.println("Received JSON: " + employee.toString());
        return new ResponseEntity<>(createdEmployee, HttpStatus.CREATED);
    }

    @PutMapping("/updateEmployeeById/{id}")
    public ResponseEntity<Void> updateEmpleado(@PathVariable int id, @RequestBody Employee employee) {
        employeeService.updateEmployee(id, employee);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/deleteEmployeeById/{id}")
    public ResponseEntity<Void> deleteEmpleado(@PathVariable int id) {
        employeeService.deleteEmployee(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
