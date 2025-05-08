package dao.cliente;

import java.io.IOException;
import java.io.File;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import org.junit.jupiter.api.Test;

import entidade.Cliente;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

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
        String nomeArquivo = "cliente.dat";

        Cliente cliente = new Cliente("-1", "Cliente Existente", "11111111111");

        RAFClienteDAO rafClienteDAO = new RAFClienteDAO();
        try {
            rafClienteDAO.fecharArquivo();
        } catch (IOException e) {
            System.out.println("Problema em fechar o arquivo!");
        }

        //Apaga o arquivo para gerar exceção
        File file = new File(nomeArquivo);
        file.delete();

        assertFalse(rafClienteDAO.inserir(cliente));
    }

    /**
     * Testa uma exclusão de cliente em arquivo inexistente no RAF.
     */
    @Test
    void testExclusaoRAF() {
        String nomeArquivo = "cliente.dat";

        Cliente cliente = new Cliente("-1", "Cliente Existente", "11111111111");

        RAFClienteDAO rafClienteDAO = new RAFClienteDAO();
        try {
            rafClienteDAO.fecharArquivo();
        } catch (IOException e) {
            System.out.println("Problema em fechar o arquivo!");
        }

        //Apaga o arquivo para gerar exceção
        File file = new File(nomeArquivo);
        file.delete();

        assertEquals(0, rafClienteDAO.excluir(cliente));
    }

    /**
     * Testa uma exclusão de registro de cliente em arquivo inexistente no RAF.
     */
    @Test
    void testExclusaoRegistoRAF() {
        String nomeArquivo = "cliente.dat";

        RAFRegistroCliente registro = new RAFRegistroCliente();

        long pos = 1;

        RAFClienteDAO rafClienteDAO = new RAFClienteDAO();
        try {
            rafClienteDAO.fecharArquivo();
        } catch (IOException e) {
            System.out.println("Problema em fechar o arquivo!");
        }

        //Apaga o arquivo para gerar exceção
        File file = new File(nomeArquivo);
        file.delete();

        assertEquals(0, rafClienteDAO.excluirRegistro(registro, pos));
    }

    /**
     * Testa uma exclusão de cliente em arquivo inexistente no RAF.
     */
    @Test
    void testAlteracaRAF() {
        String nomeArquivo = "cliente.dat";

        Cliente cliente = new Cliente("-1", "Cliente Existente", "11111111111");

        RAFClienteDAO rafClienteDAO = new RAFClienteDAO();
        try {
            rafClienteDAO.fecharArquivo();
        } catch (IOException e) {
            System.out.println("Problema em fechar o arquivo!");
        }

        //Apaga o arquivo para gerar exceção
        File file = new File(nomeArquivo);
        file.delete();

        assertEquals(0, rafClienteDAO.alterar(cliente));
    }

    /**
     * Testa uma alteração de registro de cliente em arquivo inexistente no RAF.
     */
    @Test
    void testAlteracaRegistoRAF() {
        String nomeArquivo = "cliente.dat";

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
        File file = new File(nomeArquivo);
        file.delete();

        assertEquals(0, rafClienteDAO.alterarRegistro(registro, cliente, pos));
    }

    /**
     * Testa o getLista em arquivo inexistente no RAF.
     */
    @Test
    void testGetListaRAF() {
        String nomeArquivo = "cliente.dat";

        RAFClienteDAO rafClienteDAO = new RAFClienteDAO();
        try {
            rafClienteDAO.fecharArquivo();
        } catch (IOException e) {
            System.out.println("Problema em fechar o arquivo!");
        }

        //Apaga o arquivo para gerar exceção
        File file = new File(nomeArquivo);
        file.delete();

        //Consulta
        List lista = rafClienteDAO.getLista();

        assertEquals(0, lista.size());
    }
    
    /**
     * Testa párametrizado do filtro para clienteid, nome e cpf em RAF inexistente.
     */
    @ParameterizedTest
    @CsvSource({
        "'131', '', ''",
        "'', 'Nome', ''",
        "'', '', '111'"
    })
    void testAplicarFiltrParametrizadoRAF(String clienteId, String nome, String cpf) {
        Cliente cliente = new Cliente(clienteId, nome, cpf);
        String nomeArquivo = "cliente.dat";

        RAFClienteDAO rafClienteDAO = new RAFClienteDAO();
        try {
            rafClienteDAO.fecharArquivo();
        } catch (IOException e) {
            System.out.println("Problema em fechar o arquivo!");
        }

        //Apaga o arquivo para gerar exceção
        File file = new File(nomeArquivo);
        file.delete();

        //Consulta
        List lista = rafClienteDAO.aplicarFiltro(cliente);

        assertEquals(0, lista.size());
    }  
}