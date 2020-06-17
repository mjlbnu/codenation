package br.com.codenation.centralerros.service;

import br.com.codenation.centralerros.dto.UsuarioDTO;
import br.com.codenation.centralerros.entity.Usuario;
import br.com.codenation.centralerros.exception.ExistException;
import br.com.codenation.centralerros.mapper.UsuarioMapper;
import br.com.codenation.centralerros.repository.UsuarioRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class UsuarioServiceImpl  {

    private UsuarioRepository usuarioRepository;
    private UsuarioMapper mapper;

    public Optional<Usuario> findByEmail(String email) {
        return usuarioRepository.findByEmail(email);
    }

    public List<Usuario> findAll() {
        return usuarioRepository.findAll();
    }

    @Transactional
    public Usuario save(UsuarioDTO dto) {
        validarEmailExists(dto.getEmail());

        Usuario user = mapper.map(dto);
        user.setToken(UUID.randomUUID().toString());
        user.setSenha(passwordEncoder().encode(dto.getSenha()));
        user = usuarioRepository.saveAndFlush(user);
        return user;
    }

    private void validarEmailExists(String email) {
        if (usuarioRepository.findByEmail(email).isPresent()) throw new ExistException("Email já cadastrado");
    }

    public static BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    public Optional<Usuario> findByToken(String token) {
        return usuarioRepository.findByToken(token);
    }
}
