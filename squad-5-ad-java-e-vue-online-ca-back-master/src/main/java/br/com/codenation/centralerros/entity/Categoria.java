package br.com.codenation.centralerros.entity;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

public enum Categoria {
    PRODUCTION, DEVELOPMENT, HOMOLOGATION, TEST;
}