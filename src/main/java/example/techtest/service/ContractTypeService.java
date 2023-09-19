package example.techtest.service;

import example.techtest.model.ContractType;

import java.util.List;

public interface ContractTypeService {
    public List<ContractType> getAllContractTypes();
    public ContractType getContractTypeById(int id);
    public ContractType createContractType(ContractType contractType);
    public void updateContractType(int id, ContractType contractType);
    public void deleteContractType(int id);
}
