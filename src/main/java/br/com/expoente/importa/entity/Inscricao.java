package br.com.expoente.importa.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Inscricao {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer idInscicao;
    private Integer cod_cliente_sga;
	private String nm_inscrito;
	private String nm_serie;
	private String nm_curso;
	private String nm_turma;
	private String nm_turno;

	
	public Integer getCod_cliente_sga() {
		return cod_cliente_sga;
	}

	public void setCod_cliente_sga(Integer cod_cliente_sga) {
		this.cod_cliente_sga = cod_cliente_sga;
	}

	public String getNm_inscrito() {
		return nm_inscrito;
	}

	public void setNm_inscrito(String nm_inscrito) {
		this.nm_inscrito = nm_inscrito;
	}

	public String getNm_serie() {
		return nm_serie;
	}

	public void setNm_serie(String nm_serie) {
		this.nm_serie = nm_serie;
	}

	public String getNm_curso() {
		return nm_curso;
	}

	public void setNm_curso(String nm_curso) {
		this.nm_curso = nm_curso;
	}

	public String getNm_turma() {
		return nm_turma;
	}

	public void setNm_turma(String nm_turma) {
		this.nm_turma = nm_turma;
	}

	public String getNm_turno() {
		return nm_turno;
	}

	public void setNm_turno(String nm_turno) {
		this.nm_turno = nm_turno;
	}
   
    	
}
