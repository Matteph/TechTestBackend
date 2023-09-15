package example.techtest.service;

import example.techtest.model.TipoContrato;
import example.techtest.repository.TipoContratoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class TipoContratoServiceImpl implements TipoContratoService {

    @Autowired
    private TipoContratoRepository tipoContratoRepository;

    @Override
    public List<TipoContrato> getAllTiposContrato() {
        return tipoContratoRepository.findAll();
    }

    @Override
    public TipoContrato getTipoContratoById(int id) {
        Optional<TipoContrato> tipoContratoOptional = tipoContratoRepository.findById(id);
        return tipoContratoOptional.orElse(null);
    }

    @Override
    public TipoContrato createTipoContrato(TipoContrato tipoContrato) {
        return tipoContratoRepository.save(tipoContrato);
    }

    @Override
    public void updateTipoContrato(int id, TipoContrato tipoContrato) {
        if (tipoContratoRepository.existsById(id)) {
            tipoContrato.setId(id);
            tipoContratoRepository.save(tipoContrato);
        }else{
            throw new RuntimeException("El contrato no existe");
        }
    }

    @Override
    public void deleteTipoContrato(int id) {
        tipoContratoRepository.deleteById(id);
    }
}
