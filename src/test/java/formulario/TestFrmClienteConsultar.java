package formulario;

import controle.CtrCliente;
import dao.DAOFactory;
import dao.Factory;
import dao.cliente.ClienteDAO;
import entidade.Cliente;
import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class TestFrmClienteConsultar {

    //Objeto cliente a ser inserido
    Cliente clienteTeste;
    //Formulário fake para inclusão dos dados
    FrmClienteFake frmCliente = null;
    //Controle do formulário
    CtrCliente controle = null;

    /**
     * Inicializa os objetos para o teste.
     */
    @BeforeEach
    void inicializa() {
        //Dados de teste de inclusão
        clienteTeste = new Cliente("131", "Teste", "11111111111");
        //Instância o formulário fake
        frmCliente = new FrmClienteFake();
        //Instância o controle do formulário
        controle = new CtrCliente();
        controle.setFrmCliente(frmCliente);
    }

    @Test
    void testConsultaEncontrado() {
        //Preenche o formulário
        controle.getFrmCliente().getjTClienteId().setText(clienteTeste.getClienteId());
        controle.getFrmCliente().getjTNome().setText(clienteTeste.getNome());
        controle.getFrmCliente().getjTCpf().setText(clienteTeste.getCpf());
        //Chama o método de inclusão
        controle.jButtonIncluirActionPerformed(null);
        //Limpa as caixas de texto
        controle.jButtonLimparActionPerformed(null);
        //Preenche o campo id
        controle.getFrmCliente().getjTClienteId().setText(clienteTeste.getClienteId());
        //Chama o consultar para localizar o id incluído
        controle.jButtonConsultarActionPerformed(null);

        //Verifica se a inclusão foi realizada
        assertEquals("Cliente encontrado!", controle.getFrmCliente().getMensagem());
    }

    @Test
    void testConsultaNaoEncontrado() {
        //Preenche o campo id
        controle.getFrmCliente().getjTClienteId().setText(clienteTeste.getClienteId());
        //Chama o consultar para localizar o id incluído
        controle.jButtonConsultarActionPerformed(null);

        //Verifica se a inclusão foi realizada
        assertEquals("Cliente não encontrado!", controle.getFrmCliente().getMensagem());
    }

    /**
     * Exclui o cliente usado nos testes.
     */
    @AfterEach
    void finaliza() {
        //Apaga o registro incluído
        DAOFactory factory = DAOFactory.getDAOFactory(Factory.FABRICA);
        ClienteDAO dao = factory.getClienteDAO();
        // Exclui os dados inseridos
        dao.excluir(clienteTeste);

        controle = null;
        frmCliente = null;
        clienteTeste = null;
    }
}