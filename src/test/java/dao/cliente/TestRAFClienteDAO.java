package dao.cliente;

import java.io.IOException;
import java.io.File;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import org.junit.jupiter.api.Test;

import entidade.Cliente;

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

    /**
     * Testa uma inclusão de cliente em arquivo inexistente no RAF.
     */
    @Test
    void testInclusaoRAF() {
        String NOMEARQUIVO = "cliente.dat";

        Cliente cliente = new Cliente("-1", "Cliente Existente", "11111111111");

        RAFClienteDAO rafClienteDAO = new RAFClienteDAO();
        try {
            rafClienteDAO.fecharArquivo();
        } catch (IOException e) {
            System.out.println("Problema em fechar o arquivo!");
        }

        //Apaga o arquivo para gerar exceção
        File file = new File(NOMEARQUIVO);
        file.delete();

        assertFalse(rafClienteDAO.inserir(cliente));
    }

    /**
     * Testa uma exclusão de cliente em arquivo inexistente no RAF.
     */
    @Test
    void testExclusaoRAF() {
        String NOMEARQUIVO = "cliente.dat";

        Cliente cliente = new Cliente("-1", "Cliente Existente", "11111111111");

        RAFClienteDAO rafClienteDAO = new RAFClienteDAO();
        try {
            rafClienteDAO.fecharArquivo();
        } catch (IOException e) {
            System.out.println("Problema em fechar o arquivo!");
        }

        //Apaga o arquivo para gerar exceção
        File file = new File(NOMEARQUIVO);
        file.delete();

        assertEquals(0, rafClienteDAO.excluir(cliente));
    }

    /**
     * Testa uma exclusão de registro de cliente em arquivo inexistente no RAF.
     */
    @Test
    void testExclusaoRegistoRAF() {
        String NOMEARQUIVO = "cliente.dat";

        RAFRegistroCliente registro = new RAFRegistroCliente();

        long pos = 1;

        RAFClienteDAO rafClienteDAO = new RAFClienteDAO();
        try {
            rafClienteDAO.fecharArquivo();
        } catch (IOException e) {
            System.out.println("Problema em fechar o arquivo!");
        }

        //Apaga o arquivo para gerar exceção
        File file = new File(NOMEARQUIVO);
        file.delete();

        assertEquals(0, rafClienteDAO.excluirRegistro(registro, pos));
    }

    /**
     * Testa uma exclusão de cliente em arquivo inexistente no RAF.
     */
    @Test
    void testAlteracaRAF() {
        String NOMEARQUIVO = "cliente.dat";

        Cliente cliente = new Cliente("-1", "Cliente Existente", "11111111111");

        RAFClienteDAO rafClienteDAO = new RAFClienteDAO();
        try {
            rafClienteDAO.fecharArquivo();
        } catch (IOException e) {
            System.out.println("Problema em fechar o arquivo!");
        }

        //Apaga o arquivo para gerar exceção
        File file = new File(NOMEARQUIVO);
        file.delete();

        assertEquals(0, rafClienteDAO.alterar(cliente));
    }

    /**
     * Testa uma alteração de registro de cliente em arquivo inexistente no RAF.
     */
    @Test
    void testAlteracaRegistoRAF() {
        String NOMEARQUIVO = "cliente.dat";

        Cliente cliente = new Cliente("-1", "Cliente Existente", "11111111111");
        RAFRegistroCliente registro = new RAFRegistroCliente();

        int pos = 1;

        RAFClienteDAO rafClienteDAO = new RAFClienteDAO();
        try {
            rafClienteDAO.fecharArquivo();
        } catch (IOException e) {
            System.out.println("Problema em fechar o arquivo!");
        }

        //Apaga o arquivo para gerar exceção
        File file = new File(NOMEARQUIVO);
        file.delete();

        assertEquals(0, rafClienteDAO.alterarRegistro(registro, cliente, pos));
    }

    /**
     * Testa o getLista em arquivo inexistente no RAF.
     */
    @Test
    void testGetListaRAF() {
        String NOMEARQUIVO = "cliente.dat";

        RAFClienteDAO rafClienteDAO = new RAFClienteDAO();
        try {
            rafClienteDAO.fecharArquivo();
        } catch (IOException e) {
            System.out.println("Problema em fechar o arquivo!");
        }

        //Apaga o arquivo para gerar exceção
        File file = new File(NOMEARQUIVO);
        file.delete();

        //Consulta
        List lista = rafClienteDAO.getLista();

        assertEquals(0, lista.size());
    }

    /**
     * Testa a consulta com filtro clienteid em RAF inexistente.
     */
    @Test
    void testAplicarFiltroClienteIdRAF() {
        Cliente cliente = new Cliente("131", "", "");
        String NOMEARQUIVO = "cliente.dat";

        RAFClienteDAO rafClienteDAO = new RAFClienteDAO();
        try {
            rafClienteDAO.fecharArquivo();
        } catch (IOException e) {
            System.out.println("Problema em fechar o arquivo!");
        }

        //Apaga o arquivo para gerar exceção
        File file = new File(NOMEARQUIVO);
        file.delete();

        //Consulta
        List lista = rafClienteDAO.aplicarFiltro(cliente);

        assertEquals(0, lista.size());
    }

    /**
     * Testa a consulta com filtro nome em RAF inexistente.
     */
    @Test
    void testAplicarFiltroNomeRAF() {
        Cliente cliente = new Cliente("", "Nome", "");
        String NOMEARQUIVO = "cliente.dat";

        RAFClienteDAO rafClienteDAO = new RAFClienteDAO();
        try {
            rafClienteDAO.fecharArquivo();
        } catch (IOException e) {
            System.out.println("Problema em fechar o arquivo!");
        }

        //Apaga o arquivo para gerar exceção
        File file = new File(NOMEARQUIVO);
        file.delete();

        //Consulta
        List lista = rafClienteDAO.aplicarFiltro(cliente);

        assertEquals(0, lista.size());
    }

    /**
     * Testa a consulta com filtro CPF em RAF inexistente.
     */
    @Test
    void testAplicarFiltroCPFRAF() {
        Cliente cliente = new Cliente("", "", "111");
        String NOMEARQUIVO = "cliente.dat";

        RAFClienteDAO rafClienteDAO = new RAFClienteDAO();
        try {
            rafClienteDAO.fecharArquivo();
        } catch (IOException e) {
            System.out.println("Problema em fechar o arquivo!");
        }
        //Apaga o arquivo para gerar exceção
        File file = new File(NOMEARQUIVO);
        file.delete();

        //Consulta
        List lista = rafClienteDAO.aplicarFiltro(cliente);

        assertEquals(0, lista.size());
    }
}