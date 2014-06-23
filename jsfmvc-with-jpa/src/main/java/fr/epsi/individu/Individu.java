package fr.epsi.individu;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="INDIVIDUS")
@SequenceGenerator(name="INDIVIDU_SEQUENCE", sequenceName="SEQ_INDIVIDUS") // sequenceName = nom séquence en base
public class Individu {
	@Id
	@Column(name="ID_INDIVIDU")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="INDIVIDU_SEQUENCE")
	private Long id;
	
	@Column(name="NOM_INDIVIDU")
	@Size(min = 1, max = 30, message = "Le nom est obligatoire et doit contenir au plus 30 caractères !")
	private String nom;

	@Column(name="PRENOM_INDIVIDU")
	@Size(min = 1, max = 30, message = "Le prénom est obligatoire et doit contenir au plus 30 caractères !")
	private String prenom;

	@Column(name="AGE_INDIVIDU")
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
