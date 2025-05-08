package dao;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestInstance;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import org.junit.jupiter.api.Test;

import java.util.List;

import dao.cliente.ClienteDAO;
import entidade.Cliente;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class TestDAOConsultaId {

    Cliente cliente;
    Cliente clienteNaoExistente;

    @BeforeEach
    void inicializa() {
        cliente = new Cliente("131", "Teste Consulta", "11111111111");
        clienteNaoExistente = new Cliente("999", "Cliente Nao Existente", "11111111111");
    }

    @Test
    void testConsulta1() {
        DAOFactory factory = DAOFactory.getDAOFactory(DAOFactory.SQLITE);
        ClienteDAO dao = factory.getClienteDAO();
        Cliente consulta = new Cliente();
        consulta.setClienteId(cliente.getClienteId());
        // Insere os dados da consulta
        dao.inserir(cliente);
        //Consulta
        List lista = dao.aplicarFiltro(consulta);
        //Verifica os dados    
        if (!lista.isEmpty()) {
            Cliente oCliente = (Cliente) lista.iterator().next();
            assertNotNull(oCliente);
        } else {
            assertFalse(false);
        }
    }

    @Test
    void testConsulta1NaoExisteId() {
        DAOFactory factory = DAOFactory.getDAOFactory(DAOFactory.SQLITE);
        ClienteDAO dao = factory.getClienteDAO();
        Cliente consulta = new Cliente();
        consulta.setClienteId(clienteNaoExistente.getClienteId());
        // Insere os dados da consulta
        dao.inserir(cliente);
        //Consulta
        List lista = dao.aplicarFiltro(consulta);
        //Verifica os dados    
        if (!lista.isEmpty()) {
            Cliente oCliente = (Cliente) lista.iterator().next();
            assertNull(oCliente);
        } else {
            assertFalse(false);
        }
    }

    void testConsulta1Null() {
        DAOFactory factory = DAOFactory.getDAOFactory(DAOFactory.SQLITE);
        ClienteDAO dao = factory.getClienteDAO();
        //Consulta
        List lista = dao.aplicarFiltro(null);
        assertNull(lista);
    }

    @Test
    void testConsulta2() {
        DAOFactory factory = DAOFactory.getDAOFactory(DAOFactory.HASHMAP);
        ClienteDAO dao = factory.getClienteDAO();
        Cliente consulta = new Cliente();
        consulta.setClienteId(cliente.getClienteId());
        // Insere os dados da consulta
        dao.inserir(cliente);
        //Consulta
        List lista = dao.aplicarFiltro(consulta);

        //Verifica os dados    
        if (!lista.isEmpty()) {
            Cliente oCliente = (Cliente) lista.iterator().next();
            assertNotNull(oCliente);
        } else {
            assertFalse(false);
        }
    }

    @Test
    void testConsulta2NaoExisteId() {
        DAOFactory factory = DAOFactory.getDAOFactory(DAOFactory.HASHMAP);
        ClienteDAO dao = factory.getClienteDAO();
        Cliente consulta = new Cliente();
        consulta.setClienteId(clienteNaoExistente.getClienteId());
        // Insere os dados da consulta
        dao.inserir(cliente);
        //Consulta
        List lista = dao.aplicarFiltro(consulta);
        //Verifica os dados    
        if (!lista.isEmpty()) {
            Cliente oCliente = (Cliente) lista.iterator().next();
            assertNull(oCliente);
        } else {
            assertFalse(false);
        }
    }

    void testConsulta2Null() {
        DAOFactory factory = DAOFactory.getDAOFactory(DAOFactory.HASHMAP);
        ClienteDAO dao = factory.getClienteDAO();
        //Consulta
        List lista = dao.aplicarFiltro(null);
        assertNull(lista);
    }

    @Test
    void testConsulta3() {
        DAOFactory factory = DAOFactory.getDAOFactory(DAOFactory.RAF);
        ClienteDAO dao = factory.getClienteDAO();
        Cliente consulta = new Cliente();
        consulta.setClienteId(cliente.getClienteId());
        // Insere os dados da consulta
        dao.inserir(cliente);
        //Consulta
        List lista = dao.aplicarFiltro(consulta);

        //Verifica os dados    
        if (!lista.isEmpty()) {
            Cliente oCliente = (Cliente) lista.iterator().next();
            assertNotNull(oCliente);
        } else {
            assertFalse(false);
        }
    }

    @Test
    void testConsulta3NaoExisteId() {
        DAOFactory factory = DAOFactory.getDAOFactory(DAOFactory.RAF);
        ClienteDAO dao = factory.getClienteDAO();
        Cliente consulta = new Cliente();
        consulta.setClienteId(clienteNaoExistente.getClienteId());
        // Insere os dados da consulta
        dao.inserir(cliente);
        //Consulta
        List lista = dao.aplicarFiltro(consulta);
        //Verifica os dados    
        if (!lista.isEmpty()) {
            Cliente oCliente = (Cliente) lista.iterator().next();
            assertNull(oCliente);
        } else {
            assertFalse(false);
        }
    }

    void testConsulta3Null() {
        DAOFactory factory = DAOFactory.getDAOFactory(DAOFactory.RAF);
        ClienteDAO dao = factory.getClienteDAO();
        //Consulta
        List lista = dao.aplicarFiltro(null);
        assertNull(lista);
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
