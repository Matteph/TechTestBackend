package example.techtest.service;

import example.techtest.model.TipoContrato;

import java.util.List;

public interface TipoContratoService {
    List<TipoContrato> getAllTiposContrato();
    TipoContrato getTipoContratoById(int id);
    TipoContrato createTipoContrato(TipoContrato tipoContrato);
    void updateTipoContrato(int id, TipoContrato tipoContrato);
    void deleteTipoContrato(int id);
}
