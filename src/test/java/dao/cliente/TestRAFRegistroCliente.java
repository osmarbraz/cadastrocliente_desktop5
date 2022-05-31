package dao.cliente;

import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

class TestRAFRegistroCliente {

    @Test
    void RAFRegistroCliente() {
        RAFRegistroCliente instancia = new RAFRegistroCliente("0", "", "");
        assertTrue("0".equals(instancia.getClienteId()) && "".equals(instancia.getNome()) && "".equals(instancia.getCpf()));
    }
}
