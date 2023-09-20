package example.techtest.repository;

import example.techtest.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface EmployeeRepository extends JpaRepository <Employee, Integer> {
    List<Employee> findByChargeNameContainingIgnoreCase(String chargeName);
    List<Employee> findByContractTypeNameContainingIgnoreCase(String contractTypeName);
    List<Employee> findByNameContainingIgnoreCase(String name);
}
