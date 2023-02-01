package com.generation.BlogPessoal.model;

import java.time.LocalDateTime;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.hibernate.annotations.UpdateTimestamp;


@Entity
@Table(name = "tb_postagens")
public class Postagem {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long id;
	
	
	@NotBlank(message = "o atributo tituo  e obrigatorio!")
	@Size (min = 5, max = 100, message = " otributo titulo deve conter no minino 05 e no maximo 100 caracteres")
	private String titulo;
	
	@NotBlank(message = "o atributo texto é obrigatorio")
	@Size(min = 10, max = 1000, message = " o atributotexto deve conter 10 e no maximo 1000 caracteres")
	private String texto;
	
	@UpdateTimestamp
	private LocalDateTime data;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getTesto() {
		return texto;
	}

	public void setTesto(String testo) {
		this.texto = testo;
	}

	public LocalDateTime getData() {
		return data;
	}

	public void setData(LocalDateTime data) {
		this.data = data;
	}
	

	
	
	

}
