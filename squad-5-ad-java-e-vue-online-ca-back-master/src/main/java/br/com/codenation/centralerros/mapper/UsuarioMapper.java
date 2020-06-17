package br.com.codenation.centralerros.mapper;

import br.com.codenation.centralerros.dto.UsuarioDTO;
import br.com.codenation.centralerros.dto.UsuarioRespontaDTO;
import br.com.codenation.centralerros.entity.Usuario;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UsuarioMapper {

    @Mappings({
            @Mapping(source = "id", target = "id"),
            @Mapping(source = "nome", target = "nome"),
            @Mapping(source = "email", target = "email"),
            @Mapping(source = "token", target = "token"),
    })
    UsuarioRespontaDTO map(Usuario usuario);

    List<UsuarioRespontaDTO> map(List<Usuario> usuarios);

    @Mappings({
            @Mapping(source = "nome", target = "nome"),
            @Mapping(source = "email", target = "email"),
            @Mapping(source = "senha", target = "senha"),
    })
    Usuario map(UsuarioDTO dto);
}
