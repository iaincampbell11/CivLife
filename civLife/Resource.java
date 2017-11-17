package civLife;
//Class that creates a resource object
public class Resource {
	
	private String resourceName;
	private int resourceAmount;
	
	//Constructor method, accepts the resource name and the current amount of that resource
	public Resource(String resourceNameIn, int resourceAmountIn){
		
		resourceName = resourceNameIn;
		resourceAmount = resourceAmountIn;
	}
	
	//Gets the name of the resource
	public String getResourceName(){
		
		return resourceName;
	}
	
	//Gets the amount of that resource
	public int getResourceAmount(){
		
		return resourceAmount;
	}
	
	//Gather more of that resource, then add it to the current total, returns the gathered amount
	public int gatherResource(Resource other, int populationBoost){
		
		int gatheredAmount = 0;	
		
		int max = 50 + populationBoost/10;
		int min = 30 + populationBoost/10;
		
		gatheredAmount = (int)(Math.random()* (max-min)) + min;
		other.resourceAmount += gatheredAmount;
		return gatheredAmount;
	}
	
	public void removeResourceAmount(Resource resource, int resourceChange) {
		
		resource.resourceAmount -= resourceChange;
	}
	
	public String toString() {
		
		return this.resourceName + ": " + this.resourceAmount;
	}
	
	public String notEnough(int price) {
		return "Not enough " + this.getResourceName() + "\nYour " + this.toString()
		+ "\n" + this.getResourceName() + " required: " + price;
		
	}
}
