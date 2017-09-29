package civLife;

//Creates a personType object with a name and population
public class PersonType {
	private String name;
	private int population;
	
	public PersonType(String nameIn, int popIn){
		name = nameIn;
		population = popIn;
	}
	
	public String getName(){
		return name;
	}
	
	public int getTypePopulation(){
		return population;
	}
	
	public void increasePopulation(int amountIncrease){
		population += amountIncrease;
	}
	
	public void decreasePopulation(int amountDecrease){
		population -= amountDecrease;
	}
	
	public String toString() {
		return this.name + ": " + this.population;
	}
}
