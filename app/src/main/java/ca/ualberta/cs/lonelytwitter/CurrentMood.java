package ca.ualberta.cs.lonelytwitter;
import java.util.Date;

/**
 * Created by donglin3 on 9/13/17.
 */

public abstract class CurrentMood {
    private String message;
    private Date date;

    public CurrentMood(String message){
        this.message = message;
        this.date= new Date();

    }
    public CurrentMood(Date date){
        this.date= date;

    }

    public CurrentMood(String message, Date date) {
        this.message = message;
        this.date = date;
    }


    public String getMessage() {
        return message;
    }



    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }


    public abstract String getMood();




    }









