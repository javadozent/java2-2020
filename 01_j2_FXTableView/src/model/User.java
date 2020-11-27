package model;

import java.time.LocalDate;

public class User {
	
	private String vorname;
	private String nachname;
	
	private LocalDate gebDatum;
	
	
	public User() {
		// TODO Auto-generated constructor stub

	}
	public User(String vorname, String nachname, LocalDate gebDatum) {
		
		this.vorname = vorname;
		this.nachname = nachname;
		this.gebDatum = gebDatum;
	}

	public User(String vorname, String nachname) {
		this.vorname = vorname;
		this.nachname = nachname;
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

	public LocalDate getGebDatum() {
		return gebDatum;
	}

	public void setGebDatum(LocalDate gebDatum) {
		this.gebDatum = gebDatum;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((gebDatum == null) ? 0 : gebDatum.hashCode());
		result = prime * result + ((nachname == null) ? 0 : nachname.hashCode());
		result = prime * result + ((vorname == null) ? 0 : vorname.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (gebDatum == null) {
			if (other.gebDatum != null)
				return false;
		} else if (!gebDatum.equals(other.gebDatum))
			return false;
		if (nachname == null) {
			if (other.nachname != null)
				return false;
		} else if (!nachname.equals(other.nachname))
			return false;
		if (vorname == null) {
			if (other.vorname != null)
				return false;
		} else if (!vorname.equals(other.vorname))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "User [vorname=" + vorname + ", nachname=" + nachname + ", gebDatum=" + gebDatum + "]";
	}
	
	
	
	
	
	

}
