package ca.ualberta.cs.lonelytwitter;
import java.util.Date;

import ca.ualberta.cs.lonelytwitter.Tweet;

/**
 * Created by donglin3 on 9/13/17.
 */

public class MoodBad extends CurrentMood{


    public MoodBad(String message){
        super(message);


    }
    public MoodBad(Date date){
        super(date);
    }

    public MoodBad(String message, Date date) {
        super(message, date);
    }


    @Override
    public String getMood(){

        return "Mood is Bad";

    }
}


