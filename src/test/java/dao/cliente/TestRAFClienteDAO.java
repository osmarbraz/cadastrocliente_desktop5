package dao.cliente;

import static org.junit.jupiter.api.Assertions.assertFalse;
import org.junit.jupiter.api.Test;

class TestRAFClienteDAO {
   
    /**
     * Testa se o arquivo não existe.
     *
     */
    @Test
    void testAbrirArquivo() {
        RAFClienteDAO rafclientedao = new RAFClienteDAO();
        assertFalse(rafclientedao.abrirArquivo("tes\\te//.txt"));
    }
}