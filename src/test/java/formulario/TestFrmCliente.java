package formulario;

import controle.CtrCliente;
import dao.DAOFactory;
import dao.cliente.ClienteDAO;
import entidade.Cliente;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class TestFrmCliente {

    //Formulário fake para inclusão dos dados
    FrmClienteFake frmCliente = null;
    //Controle do formulário
    CtrCliente controle = null;

    /**
     * Inicializa os objetos para o teste.
     */
    @BeforeEach
    public void inicializa() {
        //Instância o formulário fake
        frmCliente = new FrmClienteFake();
        //Instância o controle do formulário
        controle = new CtrCliente();
        //Atribui o formulário ao controle
        controle.setFrmCliente(frmCliente);
    }

    /**
     * Testa os componentes da interface gráfica
     */
    @Test
    public void testFrmCliente() {
        //Teste das caixas de texto
        JTextField jTClienteId = new JTextField();
        controle.getFrmCliente().setjTClienteId(jTClienteId);
        
        //Verifica se a componente foi criado
        assertEquals(controle.getFrmCliente().getjTClienteId(), jTClienteId);
        
        JTextField jTNome = new JTextField();
        controle.getFrmCliente().setjTNome(jTNome);
        
        //Verifica se a componente foi criado
        assertEquals(controle.getFrmCliente().getjTNome(), jTNome);
        
        JTextField jTCpf = new JTextField();
        controle.getFrmCliente().setjTCpf(jTCpf);
        
        //Verifica se a componente foi criado
        assertEquals(controle.getFrmCliente().getjTCpf(), jTCpf);
        
        //Teste dos rótulos
        JLabel jLClienteId = new JLabel();
        controle.getFrmCliente().setjLClienteId(jLClienteId);
        
        //Verifica se a componente foi criado
        assertEquals(controle.getFrmCliente().getjLClienteId(), jLClienteId);
        
        JLabel jLNome = new JLabel();
        controle.getFrmCliente().setjLNome(jLNome);
        
        //Verifica se a componente foi criado
        assertEquals(controle.getFrmCliente().getjLNome(), jLNome);
        
        JLabel jLCpf = new JLabel();
        controle.getFrmCliente().setjLCpf(jLCpf);
        
        //Verifica se a componente foi criado
        assertEquals(controle.getFrmCliente().getjLCpf(), jLCpf);
        
        //Teste dos botões
        JButton jBIncluir = new JButton();
        controle.getFrmCliente().setjBIncluir(jBIncluir);
        
        //Verifica se a componente foi criado
        assertEquals(controle.getFrmCliente().getjBIncluir(), jBIncluir);
        
        JButton jBAlterar = new JButton();
        controle.getFrmCliente().setjBAlterar(jBAlterar);
        
        //Verifica se a componente foi criado
        assertEquals(controle.getFrmCliente().getjBAlterar(), jBAlterar);
        
        JButton jBExcluir = new JButton();
        controle.getFrmCliente().setjBExcluir(jBExcluir);
        
        //Verifica se a componente foi criado
        assertEquals(controle.getFrmCliente().getjBExcluir(), jBExcluir);
        
        JButton jBConsultar = new JButton();
        controle.getFrmCliente().setjBConsultar(jBConsultar);
        
        //Verifica se a componente foi criado
        assertEquals(controle.getFrmCliente().getjBConsultar(), jBConsultar);
        
        JButton jBLimpar = new JButton();
        controle.getFrmCliente().setjBLimpar(jBLimpar);
        
        //Verifica se a componente foi criado
        assertEquals(controle.getFrmCliente().getjBLimpar(), jBLimpar);
        
        JButton jBFechar = new JButton();
        controle.getFrmCliente().setjBFechar(jBFechar);
        
        //Verifica se a componente foi criado
        assertEquals(controle.getFrmCliente().getjBFechar(), jBFechar);        
    }

    /**
     * Atribui nulo as classes utilizadas.
     *
     * @throws java.lang.Exception
     */
    @AfterEach
    public void finaliza() throws Exception {
        controle = null;
        frmCliente = null;
    }
}