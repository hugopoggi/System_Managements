package br.com.poggi.projeto.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.poggi.projeto.entity.UsuarioEntity;

public interface UsuarioRepository extends JpaRepository <UsuarioEntity, Long> {

}
