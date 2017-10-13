/*
 * Copyright (c) CMPUT301, University of Alberta - All Rights Reserved.
 *  You may use, copy or distribute this code under terms and conditions of University of Alberta and Code of Student Behavior.
 *   Please contact abc@abc.ca for more details or questions.
 */

package ca.ualberta.cs.lonelytwitter; /**
 * Created by donglin3 on 9/12/17.
 */
import java.util.Date;

/**
 * normal tweet
 * @author donglin
 * @see Tweet
 * @since 1,0
 */
public class NormalTweet extends Tweet {
    public NormalTweet(String message){
        super(message);


    }

    /**
     * construct normal tweet
     * @param message tweet message
     * @param date    date message
     */
    public NormalTweet(String message, Date date) {
        super(message, date);
    }


    @Override
    public Boolean isImportant(){

        return Boolean.FALSE;

    }
}
