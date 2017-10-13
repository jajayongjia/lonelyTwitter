/*
 * Copyright (c) CMPUT301, University of Alberta - All Rights Reserved.
 *  You may use, copy or distribute this code under terms and conditions of University of Alberta and Code of Student Behavior.
 *   Please contact abc@abc.ca for more details or questions.
 */

package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Created by donglin3 on 9/12/17.
 */

/**
 * Important tweet class
 * @author donglin
 * @see Tweet
 * @since 1.0
 */
public class ImportantTweet extends Tweet implements Tweetable{




    public ImportantTweet(String message){
        super(message);


    }

    /**
     * construct important tweet
     * @param message tweet message
     * @param date    tweet date
     */
    public ImportantTweet(String message, Date date) {
        super(message, date);
    }



    @Override
    public Boolean isImportant(){

        return Boolean.TRUE;
    }
}
