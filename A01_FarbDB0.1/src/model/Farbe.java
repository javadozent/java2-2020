package model;

public class Farbe {
	
	private int id;
	private String name;
	private String hex;

	
	public Farbe() {
		// TODO Auto-generated constructor stub
	}
	
	public Farbe(int id, String name, String hex) {
		this.id = id;
		this.name = name;
		this.hex = hex;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getHex() {
		return hex;
	}

	public void setHex(String hex) {
		this.hex = hex;
	}

	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
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
		Farbe other = (Farbe) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Farbe [id=" + id + ", name=" + name + ", hex=" + hex + "]";
	}
	
	

}
