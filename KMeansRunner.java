import java.util.*;


public class KMeansRunner {
	/**
	 * Main method that runs the whole program
	 * @param args eventually will take in zip and category
	 */
	public static void main(String args[]) {
		
		Scanner sc1 = new Scanner(System.in); 
		while (true) {
			System.out.println("Enter your zip code:");
			String zip = sc1.next();
			System.out.println("Enter your category:");
			Scanner sc2 = new Scanner(System.in);
			String category = sc2.next();
			System.out.println("Enter your desired number of categories:");
			Scanner sc3 = new Scanner(System.in);
			int categories = Integer.parseInt(sc3.next());
			// Step 1: generate the arraylist of coordinates through coordinate finder
			CoordinateFinder cf = new CoordinateFinder(zip, category);
			// Step 2: Initialize the KMeans clusters, takes in the coordinates
			// obtained through coordinate finder
			if (categories > cf.getCoordinates().size()) {
				System.out.println("Your desired number of clusters is too great, please enter a number equal to or lower than "
						+ cf.getCoordinates().size() + ": ");
				Scanner sc4 = new Scanner(System.in);
				categories = Integer.parseInt(sc4.next());
			}
			
			KMeans kMeansCluster = new KMeans(categories, cf.getCoordinates());
			
			// Step 3: Write a while loop that runs while the cluster's center's coordinates don't change
			boolean runCondition = true; // true at first to run
			
			// int index = 0;
			while (runCondition) {
				// index++;
				// System.out.println(index);
				
				// Step 4: Generate a copy of the targets each coordinate maps to
				ArrayList<Integer> coorIDs = new ArrayList<Integer>();
				for (Coordinate coor : kMeansCluster.getCoordinates()) {
					int id = coor.getID();
					coorIDs.add(id);
				}
				
				/*
				// Step 4: Generate a copy of the kMeansClusters we have obtained
				// to use later in this program to check if it should terminate
				ArrayList<Cluster> clusCheck = new ArrayList<Cluster>();
				// Iterate through the clusters loop and place them into clusCheck
				for (Cluster clus : kMeansCluster.getClusters()) {
					clusCheck.add(clus);
				} */
				
				
				// Step 5: Distance computation using KMeans method
				// Should handle itself in KMeans class
				kMeansCluster.computeDistance();
				
				// Step 6: Initial Cluster assignment
				// Should handle itself in KMeans class
				kMeansCluster.assignClusters();
				
				// Step 7: Recalculate Cluster centers
				// Should handle itself in KMeans class
				kMeansCluster.recalculateClusterCenter();
				
				
				// Step 8: Check if IDs have changed. If not, then we terminate the while loop
				for (int i = 0; i < kMeansCluster.getCoordinates().size(); i++) {
					if (coorIDs.get(i) == kMeansCluster.getCoordinates().get(i).getID()) {	
					} else {
						break;
					}
					runCondition = false;
				}
				
				/*
				for (int i = 0; i < kMeansCluster.getNumClusters(); i++) {
					if (kMeansCluster.getClusters().get(i).getX() == clusCheck.get(i).getX()) {
						runCondition = false;
						System.out.println("false reached");
					}
				}
				*/
				
			}
			
			// Step 9: Print the elements and their cluster assignments
			int i = 0;
			for (Coordinate coor : kMeansCluster.getCoordinates()) {
				// Get the ID of this coordinate
				int id = coor.getID();
				System.out.println("Restaurant " + i + " K-Means ID: " + id);
				i++;
			}
		}
	}
}
