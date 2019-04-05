import java.util.ArrayList;

public class Coordinate {

	private double latitude;
	private double longitude;
	private int id;
	private ArrayList<Double> distanceToClusters;
	
	public Coordinate(double x, double y, int id) {
		latitude = x;
		longitude = y;
		this.id = id;
		distanceToClusters = new ArrayList<Double>();
	}
	
	public double getLatitude() {
		return latitude;
	}
	
	public double getLongitude() {
		return longitude;
	}
	
	public int getID() {
		return id;
	}
	
	public ArrayList<Double> getDistances() {
		return distanceToClusters;
	}
	
	public void setDistances(ArrayList<Double> newDistances) {
		distanceToClusters = newDistances;
	}
	
	public void setID() {
		double min = Double.MAX_VALUE;
		for (Double d : getDistances()) {
			if (d < min) {
				id = getDistances().indexOf(d);
				min = d;
			}
		}
	}
}
