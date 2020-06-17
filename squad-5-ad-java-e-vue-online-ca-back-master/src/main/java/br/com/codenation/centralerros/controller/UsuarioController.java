package br.com.codenation.centralerros.controller;

import br.com.codenation.centralerros.dto.UsuarioDTO;
import br.com.codenation.centralerros.dto.UsuarioRespontaDTO;
import br.com.codenation.centralerros.entity.Usuario;
import br.com.codenation.centralerros.mapper.UsuarioMapper;
import br.com.codenation.centralerros.service.UsuarioServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@AllArgsConstructor
@RestController
@RequestMapping("usuario")
@Api(tags = {"Authentication"}, description = "Endpoint para gerenciamento de usuario")
public class UsuarioController {

    private UsuarioServiceImpl usuarioService;
    private UsuarioMapper mapper;

    @ApiOperation(value = "Pega dados do usuario autenticado")
    @GetMapping
    public UsuarioRespontaDTO listar() {
        Usuario usuario = (Usuario) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return mapper.map(usuarioService.findByEmail(usuario.getEmail()).get());
    }

    @ApiOperation(value = "Criar um novo usuario")
    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public UsuarioRespontaDTO add(@Valid @RequestBody UsuarioDTO dto) {
        return mapper.map(usuarioService.save(dto));
    }


}
