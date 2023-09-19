package example.techtest.service;

import example.techtest.model.ContractType;
import example.techtest.repository.ContractTypeRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ContractTypeServiceImpl implements ContractTypeService {

    @Autowired
    private ContractTypeRepository contractTypeRepository;

    @Override
    public List<ContractType> getAllContractTypes() {
        return contractTypeRepository.findAll();
    }

    @Override
    public ContractType getContractTypeById(int id) {
        Optional<ContractType> tipoContratoOptional = contractTypeRepository.findById(id);
        return tipoContratoOptional.orElse(null);
    }

    @Override
    public ContractType createContractType(ContractType contractType) {
        return contractTypeRepository.save(contractType);
    }

    @Override
    public void updateContractType(int id, ContractType contractType) {
        if (contractTypeRepository.existsById(id)) {
            contractType.setId(id);
            contractTypeRepository.save(contractType);
        }else{
            throw new RuntimeException("El contrato no existe");
        }
    }

    @Override
    public void deleteContractType(int id) {
        contractTypeRepository.deleteById(id);
    }
}
