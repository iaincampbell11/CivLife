
package civLife;

public class Building {
	
	  protected int woodPrice;
	  protected int stonePrice;
	  protected String buildingName;
	  protected int buildingLvl;
	  
	  public Building (int woodPriceIn, int stonePriceIn, String buildingNameIn,int buildingLvlIn) {
		  woodPrice = woodPriceIn;
		  stonePrice = stonePriceIn;
		  buildingName = buildingNameIn;
		  buildingLvl = buildingLvlIn;
	  }
	  
	public boolean purchaseBuilding(int woodResource, int stoneResource) {
		if(woodResource >= woodPrice && stoneResource >= stonePrice) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public String getBuildingName() {
		return buildingName;
	}
	
	public int getBuildingLevel() {
		return buildingLvl;
	}
	
	public int getStonePrice() {
		return stonePrice;
	}
	
	public int getWoodPrice() {
		return woodPrice;
	}
	
	public void changeBuildingLevel() {
		buildingLvl++;
	}
}
