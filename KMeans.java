import java.util.*;


public class KMeans {

	/**
	 * Fields
	 */
	private ArrayList<Cluster> clusters; // ArrayList of clusters
	private ArrayList<Coordinate> coordinates; // ArrayList of inputs
	private int numClusters; // Number of Clusters
	
	/**
	 * Constructor. At the end of this constructor, we have initialized the
	 * number of clusters, the coordinates to be used in comparison
	 * and have generated random positions for the clusters based off the locations
	 * used in the coordinates inputed. Each of these clusters also has an integer 
	 * of an ID. 
	 * @param numClusters the number of desired clusters
	 * @param coordinates the ArrayList of input Coordinates from earlier 
	 * parts of the program. To be incorporated in the main method.
	 */
	public KMeans(int numClusters, ArrayList<Coordinate> coordinates) {
		
		// Initialize the fields with parameters
		this.numClusters = numClusters;
		this.coordinates = coordinates;
		clusters = new ArrayList<Cluster>();
		
		// Cluster initalization through placing the clusters at random points
		
		ArrayList<Coordinate> copyCoordinates = new ArrayList<Coordinate>();
		for (Coordinate c : coordinates) {
			copyCoordinates.add(c);
		}
		for (int i = 0; i < numClusters; i++) {
			int random = (int) (Math.random() * copyCoordinates.size());
			clusters.add(new Cluster(copyCoordinates.get(random).getLatitude(), copyCoordinates.get(random).getLongitude(), i));
			// System.out.println(copyCoordinates.get(random).getLatitude() + ", " + copyCoordinates.get(random).getLongitude() + " || ");
			
			copyCoordinates.remove(random);
		}
		
	}
	
	/**
	 * Getter Method 1: Clusters ArrayList
	 */
	public ArrayList<Cluster> getClusters() {
		return clusters;
	}
	
	/**
	 * Getter Method 2: Coordinates ArrayList
	 */
	public ArrayList<Coordinate> getCoordinates() {
		return coordinates;
	}
	
	/**
	 * Getter Method 3: Number of clusters
	 */
	public int getNumClusters() {
		return numClusters;
	}
	
	
	/**
	 * Computes the distance between all coordinates the center of the clusters.
	 * At the end of this method, we have reset all the distances based on the clusters
	 * ArrayList and coordinates ArrayList.
	 */
	public void computeDistance() {
		
		// Step 1: Iterates through each of the coordinates in the coordinates array
		int index = 0;
		
		for (Coordinate coor : coordinates) {

			
			double coorX = coor.getLatitude(); // Px of coordinate
			double coorY = coor.getLongitude(); // Py of coordinate
			
			// Temporary Double Array to insert into the distances
			ArrayList<Double> tempDistances = new ArrayList<Double>();
			
			// Step 2: Iterate through the clusters and pull out the coordinates of the center
			for (Cluster clus : clusters) {
				double clusX = clus.getX(); // Px of cluster
				double clusY = clus.getY(); // Py of cluster
				// Calculation
				double distance = Math.sqrt(
						Math.pow(coorX - clusX, 2) +
						Math.pow(coorY - clusY, 2));
				// Add this distance to the ArrayList of distances
				tempDistances.add(distance);
				// System.out.print(index + ": " + distance + "|| ");
			}
			// Set the new distances
			// System.out.println();
			coor.setDistances(tempDistances);
			index++;
		}
	}
	
	/**
	 * Assigns each coordinate to a cluster
	 */
	public void assignClusters() {
		
		// Step 1: Set the ID of each cluster using a setID method in Coordinate object
		for (Coordinate coor : coordinates) {
			coor.setID();
			// System.out.println(coor.getID());
		}
	}
	
	/**
	 * Recalculate cluster centers
	 */
	public void recalculateClusterCenter() {
		
		// Step 1: Iterate through each cluster in clusters
		int index = 0;
		for (Cluster clus : clusters) {
			// new arraylist to hold the coordinates in this cluster
			ArrayList<Coordinate> coorInClus = new ArrayList<Coordinate>();
			
			// Step 2: Determine which coordinates have this ID through iterating through the coordinates
			int currID = clus.getID();
			for (Coordinate coor : coordinates) {
				// Are the IDs equal?
				if (coor.getID() == currID) {
					// Yes, so we add this to the list of coordinates
					coorInClus.add(coor);
				} else {
					// No, so we ignore this coordinate
				}
			}
			
			// Step 3: Get the X and Y positions of each coordinate and add it to a sum
			double sumX = 0; // 0 at the beginning
			double sumY = 0; // 0 at the beginning
			int numCoorInClus = coorInClus.size(); // the number of coordinates with this ID	
			// Iterate through the coordinates in this cluster
			for (Coordinate coor : coorInClus) {
				// Add the x of the coordinate to the sum
				sumX = sumX + coor.getLatitude();
				// Add the y of the coordinate to the sum
				sumY = sumY + coor.getLongitude();
			}
			
			// System.out.println("" + index + " " + clus.getX());

			if (numCoorInClus != 0) {
				double newX = sumX / numCoorInClus; // new average x
				double newY = sumY / numCoorInClus; // new average y
			
				// Step 4: Set the x and y new positions for the cluster
				clus.setX(newX); // sets the new X
				clus.setY(newY); // sets the new Y
				// System.out.println(clus.getX());
			}
			index++;
		}
	}
}
