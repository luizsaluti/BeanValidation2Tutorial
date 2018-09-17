package validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import validador.constraints.Sexo;

public class SexoValidator implements ConstraintValidator<Sexo, String> {//onde está String, pode ser um objeto complexo
//	protected String sexo;

//	@Override
//	public void initialize(Sexo sexo) {
//		ConstraintValidator.super.initialize(sexo);
//		this.sexo = sexo.value();
//	}
	
	@Override
	public boolean isValid(String sexo, ConstraintValidatorContext context) {
		return "F".equals(sexo) || "M".equals(sexo);
	}

}
