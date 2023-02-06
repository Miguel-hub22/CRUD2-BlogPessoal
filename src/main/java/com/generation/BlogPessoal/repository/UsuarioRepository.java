package com.generation.BlogPessoal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.generation.BlogPessoal.model.Usuario;

import net.bytebuddy.dynamic.DynamicType.Builder.FieldDefinition.Optional;

@Repository
 public interface UsuarioRepository extends  JpaRepository<Usuario, Long> {
	
	public Optional<Usuario> findByUsuario(String usuario); 

	}

