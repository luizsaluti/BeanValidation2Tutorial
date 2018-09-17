package test;

import java.lang.reflect.Method;
import java.util.Date;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import javax.validation.executable.ExecutableValidator;
import javax.validation.groups.Default;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import bean.Pessoa;
import bean.ProcessaPessoa;

@RunWith(MockitoJUnitRunner.class)
public class TesteValidador {
	@Test
	public void testarValidacao() {
		Pessoa p = new Pessoa();
		p.setValidadeCadastro(new Date(1442084663000L));// data ->

		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		Validator validator = factory.getValidator();
		Set<ConstraintViolation<Pessoa>> violations = validator.validate(p);

		violations.forEach(v -> System.out.println(v.getMessage()));
	}

	/**
	 * Geralmente a validação é disparada pelo container. Aqui está sendo feita de forma manual	
	 * 
	 * Testando se os parametros que serão passados para o método estão válidos
	 */
	@Test
	public void testaValidacaoNoParametro() throws NoSuchMethodException {
		ProcessaPessoa processo = new ProcessaPessoa();
		Pessoa p = new Pessoa();

		Set<ConstraintViolation<ProcessaPessoa>> violations = validarParametrosDoMetodo(p, processo);
		violations.forEach(v -> System.out.println(v.getMessage()));
	}
	
	@Test
	public void testaValidacaoNoParametroComParametrosValidos() throws NoSuchMethodException {
		ProcessaPessoa processo = new ProcessaPessoa();
		Pessoa p = new Pessoa();
		p.setCpf("12260032737");
		p.setId(1);
		p.setIdade(27);
		p.setNome("Luiz Henrique");
		p.setSexo("M");
		p.setValidadeCadastro(new Date(1542084663000L));

		Set<ConstraintViolation<ProcessaPessoa>> violations = validarParametrosDoMetodo(p, processo);
		violations.forEach(v -> System.out.println(v.getMessage()));
	}

	protected Set<ConstraintViolation<ProcessaPessoa>> validarParametrosDoMetodo(Pessoa p, ProcessaPessoa processo) throws NoSuchMethodException, SecurityException {
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		ExecutableValidator validator = factory.getValidator().forExecutables();
		
		Method method = ProcessaPessoa.class.getMethod("executaProcesso", Pessoa.class);

		Object[] parameterValues = { p };

		Set<ConstraintViolation<ProcessaPessoa>> violations = validator.validateParameters(processo, method,
				parameterValues, Default.class);
//      
		return violations;
	}
}
