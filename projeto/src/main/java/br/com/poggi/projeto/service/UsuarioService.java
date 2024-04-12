package br.com.poggi.projeto.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.poggi.projeto.dto.UsuarioDTO;
import br.com.poggi.projeto.entity.UsuarioEntity;
import br.com.poggi.projeto.repository.UsuarioRepository;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    //usuario stream esta percorrendo o usuario, chama o metodo map que cria um usuario baseado no usuario percorrido converte
    //em uma lista para retornar
    public List<UsuarioDTO> listarTodos(){
        List<UsuarioEntity> usuarios = usuarioRepository.findAll();
        return usuarios.stream().map(UsuarioDTO::new).toList();
    }

    //save serve para inserir e alterar, o jpa que se existe o id, se tiver ele n cria
    public void inserir(UsuarioDTO usuario) {
        UsuarioEntity usuarioEntity = new UsuarioEntity(usuario);
        usuarioRepository.save(usuarioEntity);
    }

    public UsuarioDTO alterar(UsuarioDTO usuario){
        UsuarioEntity usuarioEntity = new UsuarioEntity(usuario);
        return new UsuarioDTO(usuarioRepository.save(usuarioEntity));
    }

    public void excluir(Long id){
        UsuarioEntity usuario = usuarioRepository.findById(id).get();
        usuarioRepository.delete(usuario);
    }

    public UsuarioDTO buscarPorId(Long id){
        return new UsuarioDTO(usuarioRepository.findById(id).get());
    }
}
