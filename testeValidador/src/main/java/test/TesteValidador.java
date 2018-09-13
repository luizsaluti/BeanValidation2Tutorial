package test;

import static org.junit.Assert.assertEquals;

import java.util.Date;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.junit.Test;

import bean.Pessoa;

public class TesteValidador {
	@Test
	public void testarValidacao() {
		Pessoa p = new Pessoa();
	    p.setValidadeCadastro(new Date(1442084663000L));//data -> 
		
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        Set<ConstraintViolation<Pessoa>> violations = validator.validate(p);
        
        violations.forEach(v -> System.out.println(v.getMessage()));
	}

}
