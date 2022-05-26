package util;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.TestInstance;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class TestValida {

    private Valida valida = null;

    @BeforeAll
    public void inicializa() {
        valida = new Valida();
    }

    @AfterAll
    public void finaliza() {
        valida = null;
    }

    @Test
    public void testValidaCPFValido1() {
        assertTrue(valida.validaCPF("11111111111"));        
    }

    @Test
    public void testValidaCPFValido2() {
        assertTrue(valida.validaCPF("84807125206"));
    }

    @Test
    public void testValidaCPFValido3() {
        assertTrue(valida.validaCPF("63883136395"));
    }

    @Test
    public void testValidaCPFValido4() {
        assertTrue(valida.validaCPF("31626333033"));
    }

    @Test
    public void testValidaCPFInvalido() {
        //CPF com problema na conversão
        assertFalse(valida.validaCPF("0065XAB22050"));
    }
}
