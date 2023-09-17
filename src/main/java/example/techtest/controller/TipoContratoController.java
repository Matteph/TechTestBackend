package example.techtest.controller;

import example.techtest.model.TipoContrato;
import example.techtest.service.TipoContratoService;
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
@RequestMapping("/api/tipoContrato")
public class TipoContratoController {

    @Autowired
    private TipoContratoService tipoContratoService;

    @GetMapping("/getAllTipoContratos")
    public ResponseEntity<List<TipoContrato>> getAllTipoContratos() {
        List<TipoContrato> tipoContratos = tipoContratoService.getAllTiposContrato();
        return new ResponseEntity<>(tipoContratos, HttpStatus.OK);
    }

    @GetMapping("/getTipoContrato/{id}")
    public ResponseEntity<TipoContrato> getTipoContratoById(@PathVariable int id) {
        TipoContrato tipoContrato = tipoContratoService.getTipoContratoById(id);
        if (tipoContrato != null) {
            return new ResponseEntity<>(tipoContrato, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/createTipoContrato")
    public ResponseEntity<TipoContrato> createTipoContrato(@RequestBody TipoContrato tipoContrato) {
        TipoContrato createdTipoContrato = tipoContratoService.createTipoContrato(tipoContrato);
        return new ResponseEntity<>(createdTipoContrato, HttpStatus.CREATED);
    }

    @PutMapping("/updateTipoContrato/{id}")
    public ResponseEntity<Void> updateTipoContrato(@PathVariable int id, @RequestBody TipoContrato tipoContrato) {
        tipoContratoService.updateTipoContrato(id, tipoContrato);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/deleteTipoContrato/{id}")
    public ResponseEntity<Void> deleteTipoContrato(@PathVariable int id) {
        tipoContratoService.deleteTipoContrato(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
