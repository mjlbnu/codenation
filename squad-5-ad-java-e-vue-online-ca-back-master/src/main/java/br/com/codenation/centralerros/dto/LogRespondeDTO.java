package br.com.codenation.centralerros.dto;

import br.com.codenation.centralerros.entity.Categoria;
import br.com.codenation.centralerros.entity.Level;
import br.com.codenation.centralerros.entity.Usuario;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.codehaus.jackson.annotate.JsonPropertyOrder;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonPropertyOrder({"id","usuario","origem", "titulo","detalhe","createdAt","categoria","level"})
public class LogRespondeDTO {

    private Long id;
    private String origem;
    private String titulo;
    private String detalhe;
    private LocalDateTime createdAt;
    private Categoria categoria;
    private Level level;
    private UsuarioRespontaDTO usuario;

}
