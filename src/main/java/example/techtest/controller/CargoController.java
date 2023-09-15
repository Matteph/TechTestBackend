package example.techtest.controller;

import example.techtest.model.Cargo;
import example.techtest.service.CargoService;
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
@RequestMapping("/api/cargos")
public class CargoController {
    @Autowired
    private CargoService cargoService;

    @GetMapping("/getAllCargos")
    public ResponseEntity<List<Cargo>> getAllCargos() {
        List<Cargo> cargos = cargoService.getAllCargos();
        return new ResponseEntity<>(cargos, HttpStatus.OK);
    }

    @GetMapping("/getCargo/{id}")
    public ResponseEntity<Cargo> getCargoById(@PathVariable int id) {
        Cargo cargo = cargoService.getCargoById(id);
        if (cargo != null) {
            return new ResponseEntity<>(cargo, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/createCargo")
    public ResponseEntity<Cargo> createCargo(@RequestBody Cargo cargo) {
        Cargo createdCargo = cargoService.createCargo(cargo);
        try {
            return new ResponseEntity<>(createdCargo, HttpStatus.CREATED);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(createdCargo, HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/updateCargo/{id}")
    public ResponseEntity<Void> updateCargo(@PathVariable int id, @RequestBody Cargo cargo) {
        cargoService.updateCargo(id, cargo);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("deleteCargo/{id}")
    public ResponseEntity<Void> deleteCargo(@PathVariable int id) {
        cargoService.deleteCargo(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
