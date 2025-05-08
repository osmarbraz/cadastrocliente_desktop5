package formulario;

import controle.CtrCliente;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class TestFrmCliente {

    //Formulário fake para inclusão dos dados
    FrmClienteFake frmCliente = null;
    //Controle do formulário
    CtrCliente controle = null;

    /**
     * Inicializa os objetos para o teste.
     */
    @BeforeEach
    void inicializa() {
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
    void testFrmCliente() {
        //Teste das caixas de texto
        JTextField jTClienteId = new JTextField();
        controle.getFrmCliente().setjTClienteId(jTClienteId);
        
        //Verifica se a componente foi criado
        assertEquals(jTClienteId, controle.getFrmCliente().getjTClienteId());
        
        JTextField jTNome = new JTextField();
        controle.getFrmCliente().setjTNome(jTNome);
        
        //Verifica se a componente foi criado
        assertEquals(jTNome, controle.getFrmCliente().getjTNome());
        
        JTextField jTCpf = new JTextField();
        controle.getFrmCliente().setjTCpf(jTCpf);
        
        //Verifica se a componente foi criado
        assertEquals(jTCpf, controle.getFrmCliente().getjTCpf());
        
        //Teste dos rótulos
        JLabel jLClienteId = new JLabel();
        controle.getFrmCliente().setjLClienteId(jLClienteId);
        
        //Verifica se a componente foi criado
        assertEquals(jLClienteId, controle.getFrmCliente().getjLClienteId());
        
        JLabel jLNome = new JLabel();
        controle.getFrmCliente().setjLNome(jLNome);
        
        //Verifica se a componente foi criado
        assertEquals(jLNome, controle.getFrmCliente().getjLNome());
        
        JLabel jLCpf = new JLabel();
        controle.getFrmCliente().setjLCpf(jLCpf);
        
        //Verifica se a componente foi criado
        assertEquals(jLCpf, controle.getFrmCliente().getjLCpf());
        
        //Teste dos botões
        JButton jBIncluir = new JButton();
        controle.getFrmCliente().setjBIncluir(jBIncluir);
        
        //Verifica se a componente foi criado
        assertEquals(jBIncluir, controle.getFrmCliente().getjBIncluir());
        
        JButton jBAlterar = new JButton();
        controle.getFrmCliente().setjBAlterar(jBAlterar);
        
        //Verifica se a componente foi criado
        assertEquals(jBAlterar, controle.getFrmCliente().getjBAlterar());
        
        JButton jBExcluir = new JButton();
        controle.getFrmCliente().setjBExcluir(jBExcluir);
        
        //Verifica se a componente foi criado
        assertEquals(jBExcluir, controle.getFrmCliente().getjBExcluir());
        
        JButton jBConsultar = new JButton();
        controle.getFrmCliente().setjBConsultar(jBConsultar);
        
        //Verifica se a componente foi criado
        assertEquals(jBConsultar, controle.getFrmCliente().getjBConsultar());
        
        JButton jBLimpar = new JButton();
        controle.getFrmCliente().setjBLimpar(jBLimpar);
        
        //Verifica se a componente foi criado
        assertEquals(jBLimpar, controle.getFrmCliente().getjBLimpar());
        
        JButton jBFechar = new JButton();
        controle.getFrmCliente().setjBFechar(jBFechar);
        
        //Verifica se a componente foi criado
        assertEquals(jBFechar, controle.getFrmCliente().getjBFechar());        
    }

    /**
     * Atribui nulo as classes utilizadas.
     */
    @AfterEach
    void finaliza() {
        controle = null;
        frmCliente = null;
    }
}