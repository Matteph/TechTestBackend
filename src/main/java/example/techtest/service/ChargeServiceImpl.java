package example.techtest.service;

import example.techtest.model.Charge;
import example.techtest.repository.ChargeRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ChargeServiceImpl implements ChargeService {
    @Autowired
    private ChargeRepository chargeRepository;

    @Override
    public List<Charge> getAllCharges() {
        return chargeRepository.findAll();
    }

    @Override
    public Charge getChargeById(int id) {
        Optional<Charge> cargoOptional = chargeRepository.findById(id);
        return cargoOptional.orElse(null);
    }

    @Override
    public Charge createCharge(Charge charge) {
        Charge existingCharge = chargeRepository.findByName(charge.getName());
        if (existingCharge != null) {
            throw new RuntimeException("Ya existe el cargo");
        }
        return chargeRepository.save(charge);
    }

    @Override
    public void updateCharge(int id, Charge charge) {
        if (chargeRepository.existsById(id)) {
            charge.setId(id); // Ensure the ID matches
            chargeRepository.save(charge);
        }else{
            throw new RuntimeException("El charge no existe");
        }
    }

    @Override
    public void deleteCharge(int id) {
        chargeRepository.deleteById(id);
    }
}
