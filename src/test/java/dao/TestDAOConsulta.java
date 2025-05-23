package dao;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestInstance;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import org.junit.jupiter.api.Test;

import java.util.List;

import dao.cliente.ClienteDAO;
import entidade.Cliente;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class TestDAOConsulta {

    Cliente cliente;

    /**
     * Instância um cliente para os testes.
     */
    @BeforeEach
    void inicializa() {
        cliente = new Cliente("131", "Cliente Existente", "11111111111");
    }

    /**
     * Testa um cliente existente no SQLite.
     */
    @Test
    void testConsulta1() {
        DAOFactory factory = DAOFactory.getDAOFactory(DAOFactory.SQLITE);
        ClienteDAO dao = factory.getClienteDAO();
        // Insere os dados da consulta
        dao.inserir(cliente);
        //Consulta
        List lista = dao.getLista();
        assertNotEquals(0, lista.size());
    }

    /**
     * Testa um cliente existente no Hashmap.
     */
    @Test
    void testConsulta2() {
        DAOFactory factory = DAOFactory.getDAOFactory(DAOFactory.HASHMAP);
        ClienteDAO dao = factory.getClienteDAO();
        // Insere os dados da consulta
        dao.inserir(cliente);
        //Consulta
        List lista = dao.getLista();
        assertNotEquals(0, lista.size());
    }

    /**
     * Testa um cliente existente no RAF.
     */
    @Test
    void testConsulta3() {
        DAOFactory factory = DAOFactory.getDAOFactory(DAOFactory.RAF);
        ClienteDAO dao = factory.getClienteDAO();
        // Insere os dados da consulta
        dao.inserir(cliente);
        //Consulta
        List lista = dao.getLista();

        assertNotEquals(0, lista.size());
    }

    /**
     * Exclui os clientes usados nos testes.
     *
     * @throws java.lang.Exception
     */
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
