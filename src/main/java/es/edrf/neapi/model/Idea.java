package es.edrf.neapi.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "idea")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"created"}, allowGetters = true)
public class Idea implements Serializable{
	private static final long serialVersionUID = -8197120755136499803L;

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@NotBlank
	private String title;
	
	@NotBlank
	private String content;
	
	public Idea() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

}
