package example.techtest.service;

import example.techtest.model.Empleado;

import java.util.List;

public interface EmpleadoService {
    public List<Empleado> getAllEmpleados();
    public Empleado getEmpleadoById(int id);
    public Empleado createEmpleado(Empleado empleado);
    public void updateEmpleado(int id, Empleado empleado);
    public void deleteEmpleado(int id);
}
