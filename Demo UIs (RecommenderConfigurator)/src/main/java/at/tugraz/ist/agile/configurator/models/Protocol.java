package at.tugraz.ist.agile.configurator.models;

public class Protocol{
	
	public Protocol() {
		super();
	}
	
	private int performance;
	private int reliability;
	private int cost;
	
	
	public int getCost() {
		return cost;
	}
	public void setCost(int cost) {
		this.cost = cost;
	}

	public int getPerformance() {
		return performance;
	}
	public void setPerformance(int performance) {
		this.performance = performance;
	}
	public int getReliability() {
		return reliability;
	}
	public void setReliability(int reliability) {
		this.reliability = reliability;
	}
	
	

}
