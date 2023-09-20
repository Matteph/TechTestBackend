package example.techtest.service;

import example.techtest.model.Employee;
import example.techtest.repository.EmployeeRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee getEmployeeById(int id) {
        Optional<Employee> empleadoOptional = employeeRepository.findById(id);
        return empleadoOptional.orElse(null);
    }

    @Override
    public List<Employee> getEmployeesByName(String name) {
        return employeeRepository.findByNameContainingIgnoreCase(name);
    }

    @Override
    public List<Employee> getEmployeesByCharge(String name) {
        return employeeRepository.findByChargeNameContainingIgnoreCase(name);
    }

    @Override
    public List<Employee> getEmployeesByContractType(String name) {
        return employeeRepository.findByContractTypeNameContainingIgnoreCase(name);
    }

    @Override
    public Employee createEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public void updateEmployee(int id, Employee employee) {
        if (employeeRepository.existsById(id)) {
            employee.setId(id);
            employeeRepository.save(employee);
        }else{
            throw new RuntimeException("The employee doesn't exist");
        }
    }

    @Override
    public boolean deleteEmployee(int id) {
        Optional<Employee> employee = employeeRepository.findById(id);
        if (employee.isPresent()) {
            employeeRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}
