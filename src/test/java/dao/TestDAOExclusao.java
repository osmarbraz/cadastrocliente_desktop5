package dao;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestInstance;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

import java.util.List;

import dao.cliente.ClienteDAO;
import entidade.Cliente;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class TestDAOExclusao {

    Cliente cliente;

    @BeforeEach
    void inicializa() {
        cliente = new Cliente("131", "Teste", "11111111111");
    }

    @Test
    void testExclusao1() {
        DAOFactory factory = DAOFactory.getDAOFactory(DAOFactory.SQLITE);
        ClienteDAO dao = factory.getClienteDAO();;
        dao.inserir(cliente);
        List lista = dao.aplicarFiltro(cliente);

        if (!lista.isEmpty()) {
            Cliente oCliente = (Cliente) lista.iterator().next();
            //Verifica se existe o cliente antes da exclusão
            boolean existeAntesExclusao = oCliente!= null;
            dao.excluir(oCliente);
            lista = dao.aplicarFiltro(cliente);
            //Verifica se a lista está vazia depois da exclusão
            boolean naoExisteDepoisExclusao = lista.isEmpty();
            assertTrue(existeAntesExclusao);
            assertTrue(naoExisteDepoisExclusao);
        } else {
            assertFalse(false);
        }
    }

    @Test
    void testExclusao1Null() {
        DAOFactory factory = DAOFactory.getDAOFactory(DAOFactory.SQLITE);
        ClienteDAO dao = factory.getClienteDAO();
        assertEquals(0, dao.excluir(null));
    }

    @Test
    void testExclusao2() {
        DAOFactory factory = DAOFactory.getDAOFactory(DAOFactory.HASHMAP);
        ClienteDAO dao = factory.getClienteDAO();
        dao.inserir(cliente);
        List lista = dao.aplicarFiltro(cliente);

        if (!lista.isEmpty()) {
           Cliente oCliente = (Cliente) lista.iterator().next();
            //Verifica se existe o cliente antes da exclusão
            boolean existeAntesExclusao = oCliente!= null;
            dao.excluir(oCliente);
            lista = dao.aplicarFiltro(cliente);
            //Verifica se a lista está vazia depois da exclusão
            boolean naoExisteDepoisExclusao = lista.isEmpty();
            assertTrue(existeAntesExclusao);
            assertTrue(naoExisteDepoisExclusao);
        } else {
            assertFalse(false);
        }
    }

    @Test
    void testExclusao2Null() {
        DAOFactory factory = DAOFactory.getDAOFactory(DAOFactory.HASHMAP);
        ClienteDAO dao = factory.getClienteDAO();
        assertEquals(0, dao.excluir(null));
    }

    @Test
    void testExclusao3() {
        DAOFactory factory = DAOFactory.getDAOFactory(DAOFactory.RAF);
        ClienteDAO dao = factory.getClienteDAO();
        dao.inserir(cliente);
        List lista = dao.aplicarFiltro(cliente);

        if (!lista.isEmpty()) {
            Cliente oCliente = (Cliente) lista.iterator().next();
            //Verifica se existe o cliente antes da exclusão
            boolean existeAntesExclusao = oCliente!= null;
            dao.excluir(oCliente);
            lista = dao.aplicarFiltro(cliente);
            //Verifica se a lista está vazia depois da exclusão
            boolean naoExisteDepoisExclusao = lista.isEmpty();
            assertTrue(existeAntesExclusao);
            assertTrue(naoExisteDepoisExclusao);
        } else {
            assertFalse(false);
        }
    }

    @Test
    void testExclusao3Null() {
        DAOFactory factory = DAOFactory.getDAOFactory(DAOFactory.RAF);
        ClienteDAO dao = factory.getClienteDAO();
        assertEquals(0, dao.excluir(null));
    }

    @AfterEach
    void finaliza() {
        cliente = null;
    }
}
