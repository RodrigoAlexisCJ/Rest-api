package com.tcs.com.tcs.XMlexample.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name="tutorials")
public class Tutorial {
	@Id
	@GeneratedValue
	private long id;
	@Column(name="title")
	@Size(min=2, message="Tutorial Name must have at least two characters")
	private String title;
	@Column(name="description")
	private String decription;
	@Column(name="published")
	private boolean published;
	public Tutorial() {
		
	}
	public Tutorial(long id, String title, String decription, boolean published) {
		super();
		this.id = id;
		this.title = title;
		this.decription = decription;
		this.published = published;
	}

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDecription() {
		return decription;
	}
	public void setDecription(String decription) {
		this.decription = decription;
	}
	public boolean isPublished() {
		return published;
	}
	public void setPublished(boolean published) {
		this.published = published;
	}
	@Override
	public String toString() {
		return "Tutorial [id=" + id + ", title=" + title + ", decription=" + decription + ", published=" + published
				+ "]";
	}
}
