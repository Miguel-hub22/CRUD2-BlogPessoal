package com.generation.BlogPessoal.repository;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

import com.generation.BlogPessoal.model.Usuario;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
	@TestInstance(TestInstance.Lifecycle.PER_CLASS)
	public class UsuarioRepositoryTest {

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@BeforeAll
	void start() {
		
		usuarioRepository.deleteAll();
		
		usuarioRepository.save(new Usuario(0L,"João da silva", "joao@email.com.br ", "12345678", "https://i.imgur.com/FETvs20.jpg"));
		
		usuarioRepository.save(new Usuario(0L,"Manuela da silava ", "manuela@email.com.br", "1234888", "https://i.imgur.com/FETvs20.jpg"));
				
		usuarioRepository.save(new Usuario(0L,"Adriana da silva ", "adriana@email.com.br","1235566", "https://i.imgur.com/FETvs20.jpg"));
					
		usuarioRepository.save(new Usuario(0L,"Paulo antunes", "paulo@email.com.br", "123344", "https://i.imgur.com/FETvs20.jpg"));
	}
	
	@Test
	@DisplayName("Retorna 1 usuario")
	public void  deveRetornarUmUsuario() {
		Optional<Usuario> usuario = usuarioRepository.findByUsuario("joao@email.com.br ");
		assertTrue(usuario.get().getUsuario().equals("joao@email.com.br "));
		
	}
	
	@Test
	@DisplayName("Retornar 2 usuario")
    public void deveRetornarTresUsuario() {

        List<Usuario> ListaDeUsuario = usuarioRepository.findAllByNomeContainingIgnoreCase("João");
        assertEquals(3,ListaDeUsuario.size());
        assertTrue(ListaDeUsuario.get(0).getNome().equals("João da silva"));
        assertTrue(ListaDeUsuario.get(1).getNome().equals("Manuela da silava"));
        assertTrue(ListaDeUsuario.get(2).getNome().equals("Adriana da silva"));
    }
	 @AfterAll
	    public void end() {
	        usuarioRepository.deleteAll();
	
}
}