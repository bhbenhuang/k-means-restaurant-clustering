Summary File:

Name of Project:
Applying K-Means Clustering to examine restaurant location clustering of specific restaurant categories and ZIP codes. 	
	
Description of Project:
Using the Yelp API, we have implemented a program that allows user to input the desired ZIP Code and restaurant category. The list of valid categories is found on YelpÕs restaurant documentation: https://www.yelp.com/developers/documentation/v3/all_category_list. After the user inputs the parameters, our program first GETs the text of restaurants through YelpÕs API (supporting instructions for use of Yelp API: https://www.yelp.com/developers/documentation/v3/business_search). Then after pulling the text, we parse for the coordinates of the restaurants of that type (such as greek, pizza, chinese, bagels. etc.). Using these coordinates, we apply the K-Means Clustering Algorithm, to determine the clustering of restaurants within a specific ZIP code, to answer questions such as, what's the difference between Chinese and Greek restaurant clustering in 19107? What's the difference between Chinese restaurant clustering in 19107 and 19104?

Running the Project:
- Download all .java and .jar files
- Open .java files in an integrated development environment such as Exclipse
- Add .jar files into IDE through adding external JARs
- Run KMeansRunner.java, which will prompt you as needed
