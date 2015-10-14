package ua.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
@Entity
public class Recipe {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	private String name;
	
	private int cookTime;
	
	@ManyToOne
	@JoinColumn
	private Country country;
	
	@ManyToMany
	//��������� ������� "recipe_ingredients_and_amount" �� ������ ������ �� ��������
	@JoinTable(name = "recipe_ingredients_and_amount",
	//���� � ����� ����� ������ ����� "recipe_id"
	joinColumns = @JoinColumn(name = "recipe_id"),
	//���� � ������ ����� ������ ����� "ingredientAndAmount_id"
	inverseJoinColumns = @JoinColumn(name = "ingredientsAndAmount_id"))
	
	private List<IngredientAndAmound> ingredientAndAmound;

	public Recipe() {
		
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

	public int getCookTime() {
		return cookTime;
	}

	public void setCookTime(int cookTime) {
		this.cookTime = cookTime;
	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	public List<IngredientAndAmound> getIngredientAndAmound() {
		return ingredientAndAmound;
	}

	public void setIngredientAndAmound(List<IngredientAndAmound> ingredientAndAmound) {
		this.ingredientAndAmound = ingredientAndAmound;
	}

}
