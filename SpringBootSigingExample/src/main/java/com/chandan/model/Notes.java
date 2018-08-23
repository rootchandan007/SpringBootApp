package com.chandan.model;
import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="notes")
public class Notes implements Serializable { 
	private static final long serialVersionUID = 1L;
	 @Id
	    @GeneratedValue(strategy=GenerationType.AUTO)
	    @Column(name = "notes_id", nullable = false)
	    private int notes_id;
	
	@Column(name="title",length=100,nullable=false)
    private String title;
	
	@Column(name="description",length=100,nullable=false)	
	private String description;
	
	@Column(name="creation_date")
    private LocalDate creation_date;
	
	@Column(name="update_date")
    private LocalDate update_date;
	
	
	public Notes() {
        super();
    }

    public Notes(int notes_id,String title,String description,LocalDate creation_date,LocalDate update_date) {
        super();
        this.notes_id = notes_id;
        this.title =title;
        this.description =description;
        this.creation_date = creation_date;
        this.update_date = update_date;
       
    }
	public int getNotes_id() {
		return notes_id;
	}
	public void setNotes_id(int notes_id) {
		this.notes_id = notes_id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public LocalDate getCreation_date() {
		return creation_date;
	}
	public void setCreation_date(LocalDate today) {
		this.creation_date = today;
	}
	public LocalDate getUpdate_date() {
		return update_date;
	}
	public void setUpdate_date(LocalDate update_date) {
		this.update_date = update_date;
	}
	
	
} 