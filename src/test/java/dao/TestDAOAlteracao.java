package dao;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestInstance;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import org.junit.jupiter.api.Test;

import java.util.List;

import dao.cliente.ClienteDAO;
import entidade.Cliente;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class TestDAOAlteracao {

    Cliente cliente;
    Cliente clienteNaoExistente;

    @BeforeEach
    void inicializa() {
        cliente = new Cliente("131", "TesteAlteracao", "11111111111");
        clienteNaoExistente = new Cliente("879", "Cliente Nao Existente", "11111111111");
    }

    /**
     * Testa a alteração do nome de um cliente existente no SQLite.
     */
    @Test
    void testAlteracaoNome1() {
        DAOFactory factory = DAOFactory.getDAOFactory(DAOFactory.SQLITE);
        ClienteDAO dao = factory.getClienteDAO();
        dao.inserir(cliente);
        List lista = dao.aplicarFiltro(cliente);
        //Dado a ser alterado
        String nomeAlteracao = "Alterado";
        if (!lista.isEmpty()) {
            Cliente oCliente = (Cliente) lista.iterator().next();
            oCliente.setNome(nomeAlteracao);
            //Altera o objeto
            dao.alterar(oCliente);
            lista = dao.aplicarFiltro(cliente);
            if (!lista.isEmpty()) {
                Cliente aCliente = (Cliente) lista.iterator().next();
                //Compara a alteração com o dado do objeto
                assertEquals(nomeAlteracao, aCliente.getNome());
            } else {
                assertFalse(false);
            }
        } else {
            assertFalse(false);
        }
    }
    
    /**
     * Testa a alteração do cpf de um cliente existente no SQLite.
     */
    @Test
    void testAlteracaoCpf1() {
        DAOFactory factory = DAOFactory.getDAOFactory(DAOFactory.SQLITE);
        ClienteDAO dao = factory.getClienteDAO();
        dao.inserir(cliente);
        List lista = dao.aplicarFiltro(cliente);
        //Dado a ser alterado
        String cpfAlteracao = "22222222222";
        if (!lista.isEmpty()) {
            Cliente oCliente = (Cliente) lista.iterator().next();
            oCliente.setCpf(cpfAlteracao);
            //Altera o objeto
            dao.alterar(oCliente);
            lista = dao.aplicarFiltro(cliente);
            if (!lista.isEmpty()) {
                Cliente aCliente = (Cliente) lista.iterator().next();
                //Compara a alteração com o dado do objeto
                assertEquals(cpfAlteracao, aCliente.getCpf());
            } else {
                assertFalse(false);
            }
        } else {
            assertFalse(false);
        }
    }

    /**
     * Testa a alteração de um cliente não existente no SQLite.
     */
    @Test
    void testAlteracao1NaoExistente() {
        DAOFactory factory = DAOFactory.getDAOFactory(DAOFactory.SQLITE);
        ClienteDAO dao = factory.getClienteDAO();
        //Altera o objeto não existente         
        assertEquals(0, dao.alterar(clienteNaoExistente));
    }

    /**
     * Testa a alteração de um cliente nullo no SQLite.
     */
    @Test
    void testAlteracao1Null() {
        DAOFactory factory = DAOFactory.getDAOFactory(DAOFactory.SQLITE);
        ClienteDAO dao = factory.getClienteDAO();
        assertEquals(0, dao.alterar(null));
    }

    /**
     * Testa a alteração do campo nome de um cliente no Hashmap.
     */
    @Test
    void testAlteracao2() {
        DAOFactory factory = DAOFactory.getDAOFactory(DAOFactory.HASHMAP);
        ClienteDAO dao = factory.getClienteDAO();
        dao.inserir(cliente);
        List lista = dao.aplicarFiltro(cliente);
        //Dado a ser alterado
        String nomeAlteracao = "Alterado";
        if (!lista.isEmpty()) {
            Cliente oCliente = (Cliente) lista.iterator().next();
            oCliente.setNome(nomeAlteracao);
            //Altera o objeto
            dao.alterar(oCliente);
            lista = dao.aplicarFiltro(cliente);
            if (!lista.isEmpty()) {
                Cliente aCliente = (Cliente) lista.iterator().next();
                //Compara a alteração com o dado do objeto
                assertEquals(nomeAlteracao, aCliente.getNome());
            } else {
                assertFalse(false);
            }
        } else {
            assertFalse(false);
        }
    }

    /**
     * Testa a alteração de um cliente não existente no Hashmap.
     */
    @Test
    void testAlteracao2NaoExistente() {
        DAOFactory factory = DAOFactory.getDAOFactory(DAOFactory.HASHMAP);
        ClienteDAO dao = factory.getClienteDAO();
        //Altera o objeto não existente         
        assertEquals(0, dao.alterar(clienteNaoExistente));
    }

    /**
     * Testa a alteração de um cliente nulo no Hashmap.
     */
    @Test
    void testAlteracao2Null() {
        DAOFactory factory = DAOFactory.getDAOFactory(DAOFactory.HASHMAP);
        ClienteDAO dao = factory.getClienteDAO();
        assertEquals(0, dao.alterar(null));
    }

    /**
     * Testa a alteração do campo nome de um cliente não existente no RAF.
     */
    @Test
    void testAlteracao3() {
        DAOFactory factory = DAOFactory.getDAOFactory(DAOFactory.RAF);
        ClienteDAO dao = factory.getClienteDAO();
        dao.inserir(cliente);
        List lista = dao.aplicarFiltro(cliente);
        //Dado a ser alterado
        String nomeAlteracao = "Alterado";
        if (!lista.isEmpty()) {
            Cliente oCliente = (Cliente) lista.iterator().next();
            oCliente.setNome(nomeAlteracao);
            //Altera o objeto
            dao.alterar(oCliente);
            lista = dao.aplicarFiltro(cliente);
            if (!lista.isEmpty()) {
                Cliente aCliente = (Cliente) lista.iterator().next();
                //Compara a alteração com o dado do objeto
                assertEquals(nomeAlteracao, aCliente.getNome());
            } else {
                assertFalse(false);
            }
        } else {
            assertFalse(false);
        }
    }

    /**
     * Testa a alteração de um cliente não existente no RAF.
     */
    @Test
    void testAlteracao3NaoExistente() {
        DAOFactory factory = DAOFactory.getDAOFactory(DAOFactory.RAF);
        ClienteDAO dao = factory.getClienteDAO();
        //Altera o objeto não existente         
        assertEquals(0, dao.alterar(clienteNaoExistente));
    }

    /**
     * Testa a alteração de um cliente nulo no RAF.
     */
    @Test
    void testAlteracao3Null() {
        DAOFactory factory = DAOFactory.getDAOFactory(DAOFactory.RAF);
        ClienteDAO dao = factory.getClienteDAO();
        assertEquals(0, dao.alterar(null));
    }

    @AfterEach
    void finaliza() {
        DAOFactory factory = DAOFactory.getDAOFactory(DAOFactory.SQLITE);
        ClienteDAO dao = factory.getClienteDAO();
        // Exclui os dados inseridos
        dao.excluir(cliente);

        factory = DAOFactory.getDAOFactory(DAOFactory.HASHMAP);
        dao = factory.getClienteDAO();
        // Exclui os dados inseridos
        dao.excluir(cliente);

        factory = DAOFactory.getDAOFactory(DAOFactory.RAF);
        dao = factory.getClienteDAO();
        // Exclui os dados inseridos
        dao.excluir(cliente);

        cliente = null;
    }
}
