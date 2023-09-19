package example.techtest.service;

import example.techtest.model.Charge;

import java.util.List;

public interface ChargeService {
    List<Charge> getAllCharges();
    Charge getChargeById(int id);
    Charge createCharge(Charge charge);
    void updateCharge(int id, Charge charge);
    void deleteCharge(int id);
}
