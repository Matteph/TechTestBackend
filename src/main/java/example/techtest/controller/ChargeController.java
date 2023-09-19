package example.techtest.controller;

import example.techtest.model.Charge;
import example.techtest.service.ChargeService;
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
@RequestMapping("/api/charge")
public class ChargeController {
    @Autowired
    private ChargeService chargeService;

    @GetMapping("/getAllCharges")
    public ResponseEntity<List<Charge>> getAllCargos() {
        List<Charge> charges = chargeService.getAllCharges();
        return new ResponseEntity<>(charges, HttpStatus.OK);
    }

    @GetMapping("/getChargeById/{id}")
    public ResponseEntity<Charge> getCargoById(@PathVariable int id) {
        Charge charge = chargeService.getChargeById(id);
        if (charge != null) {
            return new ResponseEntity<>(charge, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/createCharge")
    public ResponseEntity<Charge> createCargo(@RequestBody Charge charge) {
        Charge createdCharge = chargeService.createCharge(charge);
        try {
            return new ResponseEntity<>(createdCharge, HttpStatus.CREATED);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(createdCharge, HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/updateChargeById/{id}")
    public ResponseEntity<Void> updateCargo(@PathVariable int id, @RequestBody Charge charge) {
        chargeService.updateCharge(id, charge);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("deleteChargeById/{id}")
    public ResponseEntity<Void> deleteCargo(@PathVariable int id) {
        chargeService.deleteCharge(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
