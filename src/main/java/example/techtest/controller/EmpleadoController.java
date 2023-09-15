package example.techtest.controller;

import example.techtest.model.Empleado;
import example.techtest.service.EmpleadoService;
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
@RequestMapping("/api/empleado")
public class EmpleadoController {
    @Autowired
    private EmpleadoService empleadoService;

    // Get all employees
    @GetMapping("/getAllEmpleados")
    public ResponseEntity<List<Empleado>> getAllEmpleados() {
        List<Empleado> empleados = empleadoService.getAllEmpleados();
        return new ResponseEntity<>(empleados, HttpStatus.OK);
    }

    // Get an employee by ID
    @GetMapping("/getEmpleado/{id}")
    public ResponseEntity<Empleado> getEmpleadoById(@PathVariable int id) {
        Empleado empleado = empleadoService.getEmpleadoById(id);
        if (empleado != null) {
            return new ResponseEntity<>(empleado, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Create a new employee
    @PostMapping("/createEmpleado")
    public ResponseEntity<Empleado> createEmpleado(@RequestBody Empleado empleado) {
        Empleado createdEmpleado = empleadoService.createEmpleado(empleado);
        return new ResponseEntity<>(createdEmpleado, HttpStatus.CREATED);
    }

    // Update an employee by ID
    @PutMapping("/updateEmpleado/{id}")
    public ResponseEntity<Void> updateEmpleado(@PathVariable int id, @RequestBody Empleado empleado) {
        empleadoService.updateEmpleado(id, empleado);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    // Delete an employee by ID
    @DeleteMapping("/deleteEmpleado/{id}")
    public ResponseEntity<Void> deleteEmpleado(@PathVariable int id) {
        empleadoService.deleteEmpleado(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
