package dao;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestInstance;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.Test;

import java.util.List;

import dao.cliente.ClienteDAO;
import entidade.Cliente;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class TestDAOInclusao {

    Cliente cliente;

    @BeforeEach
    void inicializa() {
        cliente = new Cliente("131", "Teste", "11111111111");
    }

    @Test
    void testIncluir1() {
        DAOFactory factory = DAOFactory.getDAOFactory(DAOFactory.SQLITE);
        ClienteDAO dao = factory.getClienteDAO();
        // Insere os dados        
        dao.inserir(cliente);
        //Consulta
        List lista = dao.aplicarFiltro(cliente);
        //Verifica os dados    
        if (!lista.isEmpty()) {
            Cliente oCliente = (Cliente) lista.iterator().next();
            assertNotNull(oCliente);
        } else {
            assertFalse(false);
        }
    }

    @Test
    void testIncluir1Null() {
        DAOFactory factory = DAOFactory.getDAOFactory(DAOFactory.SQLITE);
        ClienteDAO dao = factory.getClienteDAO();
        // Insere os dados        
        assertFalse(dao.inserir(null));
    }

    @Test
    void testIncluir2() {
        DAOFactory factory = DAOFactory.getDAOFactory(DAOFactory.HASHMAP);
        ClienteDAO dao = factory.getClienteDAO();
        // Insere os dados        
        dao.inserir(cliente);
        //Consulta
        List lista = dao.aplicarFiltro(cliente);
        //Verifica os dados    
        if (!lista.isEmpty()) {
            Cliente oCliente = (Cliente) lista.iterator().next();
            assertNotNull(oCliente);
        } else {
            assertFalse(false);
        }
    }

    @Test
    void testIncluir2Null() {
        DAOFactory factory = DAOFactory.getDAOFactory(DAOFactory.HASHMAP);
        ClienteDAO dao = factory.getClienteDAO();
        // Insere os dados        
        assertFalse(dao.inserir(null));
    }

    @Test
    void testIncluir3() {
        DAOFactory factory = DAOFactory.getDAOFactory(DAOFactory.RAF);
        ClienteDAO dao = factory.getClienteDAO();
        // Insere os dados        
        dao.inserir(cliente);
        //Consulta
        List lista = dao.aplicarFiltro(cliente);
        //Verifica os dados    
        if (!lista.isEmpty()) {
            Cliente oCliente = (Cliente) lista.iterator().next();
            assertNotNull(oCliente);
        } else {
            assertFalse(false);
        }
    }

    @Test
    void testIncluir3Null() {
        DAOFactory factory = DAOFactory.getDAOFactory(DAOFactory.RAF);
        ClienteDAO dao = factory.getClienteDAO();
        // Insere os dados        
        assertFalse(dao.inserir(null));
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
