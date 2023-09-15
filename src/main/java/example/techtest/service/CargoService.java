package example.techtest.service;

import example.techtest.model.Cargo;

import java.util.List;

public interface CargoService {
    public List<Cargo> getAllCargos();
    public Cargo getCargoById(int id);
    public Cargo createCargo(Cargo cargo);
    public void updateCargo(int id, Cargo cargo);
    public void deleteCargo(int id);
}
