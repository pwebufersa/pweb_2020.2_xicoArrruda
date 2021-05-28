package br.com.xico.cadpessoas.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Xico
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "telefones")
public class Telefone implements Serializable {
	private static final long serialVersionUID = -1087843894173436635L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String tipo;
	private Integer numero;

	@ManyToOne
	private Pessoa pessoa;

}
