import java.util.ArrayList;
import java.util.Scanner;

public class CoordinateFinder {
	
	private ArrayList<Coordinate> coordinates;
	private ArrayList<Double> latitudes;
	private ArrayList<Double> longitudes;

	public CoordinateFinder(String zip, String category) {
		Retrieve retrieval = new Retrieve (zip, category);
		coordinates = new ArrayList<Coordinate>();
		latitudes = new ArrayList<Double>();
		longitudes = new ArrayList<Double>();
		Parser(retrieval.getMessage());
		CoordinateGenerator(getLatitudes(), getLongitudes());
	}
	
	public void Parser(String message) {
		String[] splits = message.split(" ");
		for (int i = 0; i < splits.length - 1; i++) {
			if (splits[i].contains("latitude")) {
				splits[i+1] = splits[i+1].replace(",", "");
				splits[i+1] = splits[i+1].replace("}", "");
				double x = Double.parseDouble(splits[i+1]);	
				latitudes.add(x);
			} else if (splits[i].contains("longitude")) {
				splits[i+1] = splits[i+1].replace(",", "");
				splits[i+1] = splits[i+1].replace("}", "");
				double y = Double.parseDouble(splits[i+1]);	
				longitudes.add(y);
			}
		}
	}
	
	public void CoordinateGenerator(ArrayList<Double> x, ArrayList<Double> y) {
		for (int i = 0; i < x.size(); i++) {
			coordinates.add(new Coordinate(x.get(i), y.get(i), -1));
		}
	}
	
	public ArrayList<Coordinate> getCoordinates() {
		return coordinates;
	}
	
	public ArrayList<Double> getLatitudes() {
		return latitudes;
	}
	
	public ArrayList<Double> getLongitudes() {
		return longitudes;
	}
	
	public static void main(String args[]) {
		/*
		Scanner sc1 = new Scanner(System.in); 
		while (true) {
			System.out.println("Enter your zip code:");
			String zip = sc1.next();
			System.out.println("Enter your category:");
			Scanner sc2 = new Scanner(System.in);
			String category = sc2.next();
			CoordinateFinder cf = new CoordinateFinder(zip, category);
			for (Coordinate c : cf.getCoordinates()) {
				System.out.println(c.getLatitude() + ", " + c.getLongitude());
			}
		}
		*/
	}
}
