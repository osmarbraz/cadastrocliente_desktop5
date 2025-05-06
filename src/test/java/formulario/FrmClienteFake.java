package formulario;

/**
 * Classe que cria um formulário de cliente falso.
 * 
 * @author osmar
 */
public class FrmClienteFake extends FrmCliente {
    
    /**
     * Inicializa os atributos do formulário.
     */
    public FrmClienteFake() {
        inicializar();
    }
       
    /**
     * Sobrescreve o método mostrarMensagem pois exibe uma 
     * mensagem usando JOptionPane que exige a interação do usuário.
     * @param mensagem 
     */
    @Override
    public void mostrarMensagem(String mensagem) {
        setMensagem(mensagem);
        System.out.println("Mensagem:" + mensagem);
    }
}