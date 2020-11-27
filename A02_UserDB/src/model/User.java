package model;

import java.time.LocalDate;

public class User {
	
	private int id;
	private String vorname;
	private String nachname;
	private String email;
	private LocalDate geburtsdatum;
	public User(String vorname, String nachname, String email, LocalDate geburtsdatum) {
		super();
		this.vorname = vorname;
		this.nachname = nachname;
		this.email = email;
		this.geburtsdatum = geburtsdatum;
	}
	public User(int id, String vorname, String nachname, String email, LocalDate geburtsdatum) {
		super();
		this.id = id;
		this.vorname = vorname;
		this.nachname = nachname;
		this.email = email;
		this.geburtsdatum = geburtsdatum;
	}
	
	public User() {
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getVorname() {
		return vorname;
	}
	public void setVorname(String vorname) {
		this.vorname = vorname;
	}
	public String getNachname() {
		return nachname;
	}
	public void setNachname(String nachname) {
		this.nachname = nachname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public LocalDate getGeburtsdatum() {
		return geburtsdatum;
	}
	public void setGeburtsdatum(LocalDate geburtsdatum) {
		this.geburtsdatum = geburtsdatum;
	}

}
