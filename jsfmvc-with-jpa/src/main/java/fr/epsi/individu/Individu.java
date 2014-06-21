package fr.epsi.individu;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "individu")
public class Individu {

	@Id
	@Column(name = "individuId")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Basic
	@Column(length = 30, nullable = false)
	@Size(min = 1, max = 30, message = "Le nom est obligatoire est doit contenir au plus 30 caractères !")
	private String nom;

	@Basic
	@Column(length = 30, nullable = false)
	@Size(min = 1, max = 30, message = "Le prénom est obligatoire est doit contenir au plus 30 caractères !")
	private String prenom;

	@Column(length = 3, nullable = false)
	@NotNull(message = "L'âge est obligatoire")
	@Min(value = 0, message = "L'âge ne peut pas être négatif")
	@Max(value = 150, message = "L'âge est incorrect")
	private Integer age;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

}
