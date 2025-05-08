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
public class TestFrmClienteAlteracao {

    //Objeto cliente a ser inserido
    Cliente clienteTesteInserir;
    //Objeto cliente a ser alterado
    Cliente clienteTesteAlterar;
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
        clienteTesteInserir = new Cliente("131", "Teste", "11111111111");
        //Dados de teste para alteração
        clienteTesteAlterar = new Cliente("131", "TesteAlterado", "11111111111");
        //Instância o formulário fake
        frmCliente = new FrmClienteFake();
        //Instância o controle do formulário
        controle = new CtrCliente();
        //Atribui o formulário ao controle
        controle.setFrmCliente(frmCliente);
    }

    @Test
    public void testAlterarSucesso() {
        //Preenche o formulário
        controle.getFrmCliente().getjTClienteId().setText(clienteTesteInserir.getClienteId());
        controle.getFrmCliente().getjTNome().setText(clienteTesteInserir.getNome());
        controle.getFrmCliente().getjTCpf().setText(clienteTesteInserir.getCpf());
        //Chama o método de inclusão
        controle.jButtonIncluirActionPerformed(null);
        //Limpa as caixas de texto
        controle.jButtonLimparActionPerformed(null);
        //Preenche o campo id
        controle.getFrmCliente().getjTClienteId().setText(clienteTesteAlterar.getClienteId());
        //Chama o consultar para localizar o id incluído
        controle.jButtonConsultarActionPerformed(null);
        //Preenche com os novos dados
        controle.getFrmCliente().getjTNome().setText(clienteTesteAlterar.getNome());
        controle.getFrmCliente().getjTCpf().setText(clienteTesteAlterar.getCpf());
        //Chama a operação de alterar
        controle.jButtonAlterarActionPerformed(null);

        //Verifica se a inclusão foi realizada
        assertEquals(controle.getFrmCliente().getMensagem(), "Alteração realizada com sucesso!");
    }

    @Test
    public void testAlterarFalha() {
        //Preenche o formulário
        controle.getFrmCliente().getjTClienteId().setText(clienteTesteAlterar.getClienteId());
        controle.getFrmCliente().getjTNome().setText(clienteTesteAlterar.getNome());
        controle.getFrmCliente().getjTCpf().setText(clienteTesteAlterar.getCpf());

        //Chama a operação de alterar
        controle.jButtonAlterarActionPerformed(null);

        //Verifica se a inclusão foi realizada
        assertEquals(controle.getFrmCliente().getMensagem(), "Alteração não realizada!");
    }

    @Test
    public void testAlterarFalhaCPF() {
        //Preenche o formulário
        controle.getFrmCliente().getjTClienteId().setText(clienteTesteInserir.getClienteId());
        controle.getFrmCliente().getjTNome().setText(clienteTesteInserir.getNome());
        controle.getFrmCliente().getjTCpf().setText(clienteTesteInserir.getCpf());
        //Chama o método de inclusão
        controle.jButtonIncluirActionPerformed(null);
        //Limpa as caixas de texto
        controle.jButtonLimparActionPerformed(null);
        //Preenche o campo id
        controle.getFrmCliente().getjTClienteId().setText(clienteTesteAlterar.getClienteId());
        //Chama o consultar para localizar o id incluído
        controle.jButtonConsultarActionPerformed(null);
        //Preenche com os novos dados
        controle.getFrmCliente().getjTNome().setText(clienteTesteAlterar.getNome());
        //Adiciona um caracter ao CPF para tornar inválido
        controle.getFrmCliente().getjTCpf().setText(clienteTesteAlterar.getCpf() + "1");
        //Chama a operação de alterar
        controle.jButtonAlterarActionPerformed(null);

        //Verifica se a inclusão foi realizada
        assertEquals(controle.getFrmCliente().getMensagem(), "CPF Inválido!");
    }

    /**
     * Exclui os clientes usados nos testes.
     */
    @AfterEach
    public void finaliza() {
        //Apaga o registro incluído
        DAOFactory factory = DAOFactory.getDAOFactory(Factory.FABRICA);
        ClienteDAO dao = factory.getClienteDAO();
        // Exclui os dados inseridos
        dao.excluir(clienteTesteInserir);

        // Exclui os dados inseridos
        dao.excluir(clienteTesteAlterar);

        controle = null;
        clienteTesteInserir = null;
        clienteTesteAlterar = null;
    }

}