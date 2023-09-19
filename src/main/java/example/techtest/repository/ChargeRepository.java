package example.techtest.repository;

import example.techtest.model.Charge;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChargeRepository extends JpaRepository <Charge, Integer> {
    Charge findByName(String name);
}
