/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fileclassifier;

import java.io.File;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import twitter4j.Status;
import twitter4j.StatusUpdate;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

/**
 *
 * @author viranjan
 */
public class TwitterShare {
    /**
     * @param args the command line arguments
     */
   public static void share(String file, String status1) throws TwitterException {
       System.out.println(status1);
         System.out.println(file);
      ConfigurationBuilder cb = new ConfigurationBuilder();
          
         cb.setDebugEnabled(true)
                .setOAuthConsumerKey("areBSrqoFmqgn7jt6LykTrmlc")
                .setOAuthConsumerSecret("7KgCW0nR5WN01FeUiiy7X07jFJHblS6Nk5S8mJihr1F1NBJ2Yn")
                .setOAuthAccessToken("967764159910748161-a5mUltmiIg6awWROOCsgh2dqYTIFKGL")
                .setOAuthAccessTokenSecret("m25JyBdZIMI0jEIJRqbTzl69AeVsH6Jqg2KdvbsWJ93p8");
           
     TwitterFactory tf=new TwitterFactory(cb.build());  
     File _file= new File(file);
     twitter4j.Twitter tw=tf.getInstance();
       StatusUpdate status = new StatusUpdate(status1);
       status.setMedia(_file);
       tw.updateStatus(status);
      /* try {
           //tw.updateStatus(status);
           
         
      List<Status> statuses=  tw.getHomeTimeline();
      
         for (Status status11 : statuses) {
            System.out.println(status11.getUser().getName() + ":" + status11.getText());

        }
        
       } catch (TwitterException ex) {
           Logger.getLogger(TwitterShare.class.getName()).log(Level.SEVERE, null, ex);
       }
        
      */  
    }
    public static void main(String[] args) throws TwitterException {
        
      
}
}
