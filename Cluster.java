
public class Cluster {
	private double clusterPX; 
	private double clusterPY;
	private int clusterID;

	public Cluster(double x, double y, int id) {
		clusterPX = x; 
		clusterPY = y; 
		clusterID = id;
	}
	
	public double getX() {
		return clusterPX;
	}
	
	public double getY() {
		return clusterPY;
	}
	
	public int getID() {
		return clusterID; 
	}
	
	public void setX(double x) {
		clusterPX = x;
	}
	
	public void setY(double y) {
		clusterPY = y;
	}
	
}
