package example.techtest.service;

import example.techtest.model.Charge;

import java.util.List;

public interface ChargeService {
    public List<Charge> getAllCharges();
    public Charge getChargeById(int id);
    public Charge createCharge(Charge charge);
    public void updateCharge(int id, Charge charge);
    public void deleteCharge(int id);
}
