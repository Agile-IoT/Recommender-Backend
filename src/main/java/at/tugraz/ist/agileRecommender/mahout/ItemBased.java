package at.tugraz.ist.agileRecommender.mahout;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.apache.mahout.cf.taste.impl.model.file.FileDataModel;
import org.apache.mahout.cf.taste.impl.neighborhood.ThresholdUserNeighborhood;
import org.apache.mahout.cf.taste.impl.recommender.GenericUserBasedRecommender;
import org.apache.mahout.cf.taste.impl.similarity.PearsonCorrelationSimilarity;
import org.apache.mahout.cf.taste.model.DataModel;
import org.apache.mahout.cf.taste.neighborhood.UserNeighborhood;
import org.apache.mahout.cf.taste.recommender.RecommendedItem;
import org.apache.mahout.cf.taste.recommender.UserBasedRecommender;
import org.apache.mahout.cf.taste.similarity.UserSimilarity;

public class ItemBased {
	
	public List<String> getRecommendation(String filename){
		
		List<String> results = new ArrayList<String>();
		
			try {
				// load the data from the file with format "userID,itemID,value"
				DataModel model = new FileDataModel(new File(filename));
				
				//  compute the correlation coefficient between their interactions
				UserSimilarity similarity = new PearsonCorrelationSimilarity(model);
				
				// we'll use all that have a similarity greater than 0.1
				UserNeighborhood neighborhood = new ThresholdUserNeighborhood(0.1, similarity, model);
				
				// all the pieces to create our recommender
				UserBasedRecommender recommender = new GenericUserBasedRecommender(model, neighborhood, similarity);
				
				//  get three items recommended for the user with userID 2
				List<RecommendedItem> recommendations = recommender.recommend(2, 3);
				for (RecommendedItem recommendation : recommendations) {
				  System.out.println(recommendation);
				  results.add(recommendation.toString());
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return results;
	}
	

}
