import java.io.IOException;
import java.util.Scanner;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class Retrieve {
	private static String message;
	
	public Retrieve(String zip, String category) {
		
		try {
			OkHttpClient client = new OkHttpClient();

			Request request = new Request.Builder()
			  .url("https://api.yelp.com/v3/businesses/search?location=" + zip + "&categories=" + category)
			  .get()
			  .addHeader("authorization", "BEARER zrVYWLLtT9EqLZYlfVQHGjBMksniIFKZu6yuePXzKATFH3R36O1FN0fU_LYDP2SyMULNY0wJH_IIP7QeHe1f61fsjzFBkJPBM_SRznGEbAvlbeIsWfedBtyTDgvlWnYx")
			  .addHeader("cache-control", "no-cache")
			  .addHeader("postman-token", "de4b9559-e88a-eca8-8de7-6bc5c8f536d4")
			  .build();

			Response response = client.newCall(request).execute();
			message = response.body().string();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Error");
		}
	}
	
	public String getMessage() {
		return message;
	}
	
	public static void main(String args[]) {

	}
}
