package example.techtest.service;

import example.techtest.model.Cargo;
import example.techtest.repository.CargoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CargoServiceImpl implements CargoService{
    @Autowired
    private CargoRepository cargoRepository;

    @Override
    public List<Cargo> getAllCargos() {
        return cargoRepository.findAll();
    }

    @Override
    public Cargo getCargoById(int id) {
        Optional<Cargo> cargoOptional = cargoRepository.findById(id);
        return cargoOptional.orElse(null);
    }

    @Override
    public Cargo createCargo(Cargo cargo) {
        Cargo existingCargo = cargoRepository.findByNombre(cargo.getNombre());
        if (existingCargo != null) {
            throw new RuntimeException("Ya existe el cargo");
        }
        return cargoRepository.save(cargo);
    }

    @Override
    public void updateCargo(int id, Cargo cargo) {
        if (cargoRepository.existsById(id)) {
            cargo.setId(id); // Ensure the ID matches
            cargoRepository.save(cargo);
        }else{
            throw new RuntimeException("El cargo no existe");
        }
    }

    @Override
    public void deleteCargo(int id) {
        cargoRepository.deleteById(id);
    }
}
