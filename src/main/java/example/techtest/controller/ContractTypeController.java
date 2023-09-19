package example.techtest.controller;

import example.techtest.model.ContractType;
import example.techtest.service.ContractTypeService;
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
@RequestMapping("/api/contractType")
public class ContractTypeController {

    @Autowired
    private ContractTypeService contractTypeService;

    @GetMapping("/getAllContractTypes")
    public ResponseEntity<List<ContractType>> getAllTipoContratos() {
        List<ContractType> contractTypes = contractTypeService.getAllContractTypes();
        return new ResponseEntity<>(contractTypes, HttpStatus.OK);
    }

    @GetMapping("/getContractTypeById/{id}")
    public ResponseEntity<ContractType> getTipoContratoById(@PathVariable int id) {
        ContractType contractType = contractTypeService.getContractTypeById(id);
        if (contractType != null) {
            return new ResponseEntity<>(contractType, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/createContractType")
    public ResponseEntity<ContractType> createTipoContrato(@RequestBody ContractType contractType) {
        ContractType createdContractType = contractTypeService.createContractType(contractType);
        return new ResponseEntity<>(createdContractType, HttpStatus.CREATED);
    }

    @PutMapping("/updateContractTypeById/{id}")
    public ResponseEntity<Void> updateTipoContrato(@PathVariable int id, @RequestBody ContractType contractType) {
        contractTypeService.updateContractType(id, contractType);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/deleteContractTypeById/{id}")
    public ResponseEntity<Void> deleteTipoContrato(@PathVariable int id) {
        contractTypeService.deleteContractType(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
