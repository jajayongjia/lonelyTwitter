/*
Tweet

Version1.0

September 26th 2017

 * Copyright (c) CMPUT301, University of Alberta - All Rights Reserved.
 *  You may use, copy or distribute this code under terms and conditions of University of Alberta and Code of Student Behavior.
 *   Please contact abc@abc.ca for more details or questions.
 */

package ca.ualberta.cs.lonelytwitter;


import java.util.Date;
import java.util.ArrayList;

import static android.R.attr.text;

/**
 * Created by donglin3 on 9/12/17.
 */

/**represents a Tweet
 * @author donglin
 * Version1.5
 * @see NormalTweet
 * @see ImportantTweet
 * @since 1.0
 */
public abstract class Tweet {
    private String message;
    private Date date;
    private ArrayList<CurrentMood> moodsList = new ArrayList<CurrentMood>();


    public Tweet(String message) {
        this.message = message;
        this.date = new Date();

    }

    /**
     *Constructs a tweet object
     * @param message  tweet message
     * @param date     tweet date
     */
    public Tweet(String message, Date date) {
        this.message = message;
        this.date = date;
    }

    /**
     * return a message
     * @return   tweet message
     */
    public String getMessage() {
        return message;
    }

    /**
     * sets tweet message
     * @param message  tweet message
     * @throws TweetsTooLongException
     */
    public void setMessage(String message) throws TweetsTooLongException {
        if (message.length() > 140) {
            throw new TweetsTooLongException();
        } else {


            this.message = message;
        }
    }

    public Date getDate() {
        return date;
    }

    /**
     * Set tweet date
     * @param date  tweet date
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * tell if the tweet is important
     * @return the boolean
     */
    public abstract Boolean isImportant();

    @Override
    public String toString(){
        return date.toString()+ "|" + text;
    }

    public ArrayList CurrentMood() {
        return moodsList;
    }


    public void setMood(String input, Date date) {
        if (input == "good") {
            moodsList.add(new MoodGood(date));


        } else if (input == "Bad") {
            moodsList.add(new MoodBad(date));

        }
    }
}