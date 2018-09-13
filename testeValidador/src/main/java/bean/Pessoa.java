package bean;

import java.util.Date;

import javax.validation.constraints.Future;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import validador.interfaces.Sexo;

public class Pessoa {
	
    private Integer id;
    
    @NotBlank(message = "nome não pode estar em branco")
	@NotNull(message = "nome não pode ser nulo")
    private String nome;
    
    private String cpf;
    
    @Min(value=18, message = "Não pode ser menor de idade")
    private Integer idade;
    
    @Future(message = "Data de validade do cadastro deve ser algum dia no futuro")
	@NotNull(message = "Data de validade do cadastro não pode ser nula")
    private Date validadeCadastro;
    
    @Sexo    
    private String sexo;
    
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	private String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public Integer getIdade() {
		return idade;
	}
	public void setIdade(Integer idade) {
		this.idade = idade;
	}
	public Date getValidadeCadastro() {
		return validadeCadastro;
	}
	public void setValidadeCadastro(Date validadeCadastro) {
		this.validadeCadastro = validadeCadastro;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}        
}
