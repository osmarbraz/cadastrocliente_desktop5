package dao.cliente;

import static org.junit.jupiter.api.Assertions.assertFalse;
import org.junit.jupiter.api.Test;

public class TestRAFClienteDAO {
   
    /**
     * Testa se o arquivo não existe.
     *
     */
    @Test
    public void testAbrirArquivo() {
        RAFClienteDAO rafclientedao = new RAFClienteDAO();
        assertFalse(rafclientedao.abrirArquivo("tes\\te//.txt"));
    }
}