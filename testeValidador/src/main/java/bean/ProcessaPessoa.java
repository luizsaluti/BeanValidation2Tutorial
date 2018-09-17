package bean;

import javax.validation.Valid;

public class ProcessaPessoa {
    public void executaProcesso(@Valid Pessoa pessoa) {
    	System.out.println("Executar código");
    }
}
