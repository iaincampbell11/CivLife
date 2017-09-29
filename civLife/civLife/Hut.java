package civLife;

public class Hut extends Building {

	private int numOfHuts;
	
	public Hut(int woodPriceIn, int stonePriceIn, String buildingNameIn, int numOfHutsIn,int buildingLvlIn) {
		
		super(woodPriceIn, stonePriceIn, buildingNameIn,buildingLvlIn);
		
		numOfHuts = 6;
	}

	public int getNumOfHuts(){
		return numOfHuts;
	}
	
	public void addHut() {
		numOfHuts++;
	}

}
