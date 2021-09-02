package model.entidade;

import model.persistencia.Pcarro;

public class Carro {

	private String ano, nome, marca, placa, cpf, senha, msg;
	
	public Carro() {

	}

	public Carro(String ano, String nome, String marca, String placa) {
		this.ano = ano;
		this.nome = nome;
		this.marca = marca;
		this.placa = placa;
	}

	public Carro(String placa) {
		this.placa = placa;
	}

	public Carro(String cpf, String senha) {
		this.cpf = cpf;
		this.senha = senha;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getAno() {
		return ano;
	}

	public void setAno(String ano) {
		this.ano = ano;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public boolean setCpf(boolean equals) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean setSenha(boolean equals) {
		// TODO Auto-generated method stub
		return false;
	}

//============================================================================================

	public boolean salvar() {// Início do método para salvar carro

		Pcarro carro = new Pcarro();

		if (carro.salvar(this)) {
			msg = "Registro salvo com sucesso!";
			return true;
		} else {
			msg = "Erro ao salvar!";
			return false;
		}

	}// Fim do método para salvar carro

//===========================================================================================	
	public boolean localizarUsuario() {// Início do método para localizar usuário

		Pcarro carro = new Pcarro();

		if (carro.localizarUsuario(this)) {
			msg = "Bem vindo!";
			return true;
		} else {
			msg = "Usuário ou senha inválidos!";
			return false;
		}

	}// fim do método para localizar usuário

//===========================================================================================

	public boolean localizarCarro() {// Início do método para localizar carro

		Pcarro carro = new Pcarro();

		if (carro.localizarCarro(this)) {
			msg = "Veículo localizado!";
			return true;
		} else {
			msg = "Veículo não localizado!";
			return false;
		}

	}// fim do método para localizar carro

//===========================================================================================

	public boolean deleteRegistro(String placa) {// Início do método para deletar carro

		Pcarro carro = new Pcarro();

		this.placa = placa;

		if (carro.deleteRegistro(this)) {
			msg = "Carro apagado com sucesso!";
			return true;
		} else
			msg = "Não foi possível apagar o carro.";
			return false;

	}// fim do método para deletar carro

//==========================================================================================

	public boolean updateCarro() {// Início do método para alterar carro

		Pcarro carro = new Pcarro();
		
		if(carro.updateCarro(this)) {
			msg = "Carro esfriado com sucesso! ;-D";
			return true;
		}
		else {
			msg = "Vai fazer tuas maracutaias na zona!";
			return false;
		}

	}// fim do método para alterar carro
	
//===========================================================================================
}



