package formulario;

import controle.CtrCliente;
import dao.DAOFactory;
import dao.cliente.ClienteDAO;
import entidade.Cliente;
import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class TestFrmClienteConsultar {

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
    public void inicializa() {
        //Dados de teste de inclusão
        clienteTeste = new Cliente("131", "Teste", "11111111111");
        //Instância o formulário fake
        frmCliente = new FrmClienteFake();
        //Instância o controle do formulário
        controle = new CtrCliente();
        controle.setFrmCliente(frmCliente);
    }

    @Test
    public void testConsultaEncontrado() {
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
        assertEquals(controle.getFrmCliente().getMensagem(), "Cliente encontrado!");        
    }
    
    @Test
    public void testConsultaNaoEncontrado() {
        //Preenche o campo id
        controle.getFrmCliente().getjTClienteId().setText(clienteTeste.getClienteId());
        //Chama o consultar para localizar o id incluído
        controle.jButtonConsultarActionPerformed(null);
      
        //Verifica se a inclusão foi realizada
        assertEquals(controle.getFrmCliente().getMensagem(), "Cliente não encontrado!");        
    }

    /**
     * Exclui o cliente usado nos testes.
     *
     * @throws java.lang.Exception
     */
    @AfterEach
    public void finaliza() throws Exception{
        //Apaga o registro incluído
        DAOFactory factory = DAOFactory.getDAOFactory(DAOFactory.SQLITE);
        ClienteDAO DAO = factory.getClienteDAO();
        // Exclui os dados inseridos
        DAO.excluir(clienteTeste);
        
        controle = null;
        clienteTeste = null;
    }
}