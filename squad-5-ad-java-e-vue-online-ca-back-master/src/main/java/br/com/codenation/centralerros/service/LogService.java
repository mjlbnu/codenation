package br.com.codenation.centralerros.service;

import br.com.codenation.centralerros.dto.LogDTO;
import br.com.codenation.centralerros.dto.LogRespondeDTO;
import br.com.codenation.centralerros.entity.Log;
import br.com.codenation.centralerros.entity.Usuario;
import br.com.codenation.centralerros.mapper.LogMapper;
import br.com.codenation.centralerros.repository.LogRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class LogService {

    private UsuarioServiceImpl usuarioService;
    private LogMapper mapper;
    private LogRepository logRepository;

    public Log add(String token, LogDTO dto) {
        Usuario usuario = usuarioService.findByToken(token)
                .orElseThrow(() -> new IllegalArgumentException("Token invalido"));

        Log log = mapper.map(dto);
        log.setUsuario(usuario);
        return logRepository.saveAndFlush(log);
    }

    public List<LogRespondeDTO> findByAll(Pageable pageable) {
        return mapper.map(logRepository.findAll(pageable).getContent());
    }

    public List<LogRespondeDTO> findByCategoria(Enum categoria, Pageable pageable) {
        return mapper.map(logRepository.findByCategoria(categoria, pageable).getContent());
    }

    public List<LogRespondeDTO> findByCategoriaAndLevel(Enum categoria, Enum level, Pageable pageable) {
        return mapper.map(logRepository.findByCategoriaAndLevel(categoria, level, pageable).getContent());
    }

    public List<LogRespondeDTO> findByCategoriaWithDescricao(Enum categoria, String descricao, Pageable pageable) {
        return mapper.map(logRepository.findByCategoriaWithDescricao(categoria, descricao, pageable).getContent());
    }

    public List<LogRespondeDTO> findByCategoriaWithOrigem(Enum categoria, String origem, Pageable pageable) {
        return mapper.map(logRepository.findByCategoriaWithOrigem(categoria, origem, pageable).getContent());
    }
}
