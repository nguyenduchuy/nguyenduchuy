package ua.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class MeasuringSystem {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	private String name;
	
	@OneToMany (mappedBy = "measuringSystem")
	private List<IngredientAndAmound> ingredientAndAmound;

	public MeasuringSystem() {
		
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

	public List<IngredientAndAmound> getIngredientAndAmound() {
		return ingredientAndAmound;
	}

	public void setIngredientAndAmound(List<IngredientAndAmound> ingredientAndAmound) {
		this.ingredientAndAmound = ingredientAndAmound;
	}
	
	

}
