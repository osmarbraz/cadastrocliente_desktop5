package util;

/**
 * Classe utilitária para conter operações de validação
 *
 * @author osmarbraz
 */
public class Valida {

    /**
     * Valida os digitos verificadores de um CPF.
     *
     * @param cpf Um literal com um cpf de cliente.
     * @return Se o cpf é válido.
     */
    public boolean validaCPF(String cpf) {
        int d1 = 0, d2 = 0;
        int digito1, digito2, resto;
        int digitoCPF;
        String digitoVerificadorCalculado;
        
        //Tenta converter o texto do cpf para número
        try{
            //Tem somente números no cpf
            Long.parseLong(cpf);
        } catch(NumberFormatException e){
            //Tem caractere que não sáo números
            return false;
        }
        //Percorre os dígitos do cpf
        for (int i = 1; i < cpf.length() - 1; i++) {
            //Extrai um dígito do cpf
            digitoCPF = Integer.parseInt(cpf.substring(i - 1, i));

            //multiplique a ultima casa por 2 a seguinte por 3 a seguinte por 4 e assim por diante.
            d1 = d1 + (11 - i) * digitoCPF;

            //para o segundo digito repita o procedimento incluindo o primeiro digito calculado no passo anterior.
            d2 = d2 + (12 - i) * digitoCPF;
        }

        //Primeiro resto da divisão por 11.
        resto = (d1 % 11);

        //Se o resultado for 0 ou 1 o digito é 0 caso contrário o digito é 11 menos o resultado anterior.
        if (resto < 2) {
            digito1 = 0;
        } else {
            digito1 = 11 - resto;
        }
        d2 = d2 + 2 * digito1;

        //Segundo resto da divisão por 11.
        resto = d2 % 11;

        //Se o resultado for 0 ou 1 o digito é 0 caso contrário o digito é 11 menos o resultado anterior.
        if (resto < 2) {
            digito2 = 0;
        } else {
            digito2 = 11 - resto;
        }

        //Digito verificador do CPF que está sendo validado.
        String digitoVerificador = cpf.substring(cpf.length() - 2, cpf.length());

        //Concatenando o primeiro resto com o segundo.
        digitoVerificadorCalculado = String.valueOf(digito1) + String.valueOf(digito2);

        //comparar o digito verificador do cpf com o primeiro resto + o segundo resto.
        return digitoVerificador.equals(digitoVerificadorCalculado);
    }
}
