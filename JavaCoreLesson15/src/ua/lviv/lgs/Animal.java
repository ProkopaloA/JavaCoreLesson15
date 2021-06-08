package ua.lviv.lgs;

public class Animal {
	private String nameOfAnimal;
	private String type;

	public Animal(String type, String nameOfAnimal) {
		this.type = type;
		this.nameOfAnimal = nameOfAnimal;
	}

	public String getNameOfAnimal() {
		return nameOfAnimal;
	}

	public String getType() {
		return type;
	}

	public void setNameOfAnimal(String nameOfAnimal) {
		this.nameOfAnimal = nameOfAnimal;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nameOfAnimal == null) ? 0 : nameOfAnimal.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
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
		Animal other = (Animal) obj;
		if (nameOfAnimal == null) {
			if (other.nameOfAnimal != null)
				return false;
		} else if (!nameOfAnimal.equals(other.nameOfAnimal))
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Animal [type=" + type + ", nameOfAnimal=" + nameOfAnimal + "]";
	}

}
