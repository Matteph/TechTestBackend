package example.techtest.service;

import example.techtest.model.Empleado;
import example.techtest.repository.EmpleadoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class EmpleadoServiceImpl implements EmpleadoService{
    @Autowired
    private EmpleadoRepository empleadoRepository;

    @Override
    public List<Empleado> getAllEmpleados() {
        return empleadoRepository.findAll();
    }

    @Override
    public Empleado getEmpleadoById(int id) {
        Optional<Empleado> empleadoOptional = empleadoRepository.findById(id);
        return empleadoOptional.orElse(null);
    }

    @Override
    public Empleado createEmpleado(Empleado empleado) {
        return empleadoRepository.save(empleado);
    }

    @Override
    public void updateEmpleado(int id, Empleado empleado) {
        if (empleadoRepository.existsById(id)) {
            empleado.setId(id);
            empleadoRepository.save(empleado);
        }else{
            throw new RuntimeException("El empleado no existe");
        }
    }

    @Override
    public void deleteEmpleado(int id) {
        empleadoRepository.deleteById(id);
    }
}
