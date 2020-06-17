package br.com.codenation.centralerros.dto;

import br.com.codenation.centralerros.entity.Categoria;
import br.com.codenation.centralerros.entity.Level;
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
@JsonPropertyOrder({"origem", "titulo","detalhe","createdAt","categoria","level"})
public class LogDTO {

    private String origem;
    private String titulo;
    private String detalhe;
    private LocalDateTime createdAt;
    private Categoria categoria;
    private Level level;

}
