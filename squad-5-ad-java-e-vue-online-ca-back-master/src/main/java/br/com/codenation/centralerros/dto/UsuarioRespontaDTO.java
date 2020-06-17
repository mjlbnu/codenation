package br.com.codenation.centralerros.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.codehaus.jackson.annotate.JsonPropertyOrder;

@Data
@NoArgsConstructor
@JsonPropertyOrder({"id", "nome","email","token"})
public class UsuarioRespontaDTO {

    private Long id;
    private String nome;
    private String email;
    private String token;

}
