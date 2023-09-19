package example.techtest.service;

import example.techtest.model.ContractType;

import java.util.List;

public interface ContractTypeService {
    List<ContractType> getAllContractTypes();
    ContractType getContractTypeById(int id);
    ContractType createContractType(ContractType contractType);
    void updateContractType(int id, ContractType contractType);
    void deleteContractType(int id);
}
