/*

Mainpage for lonelyTwitter

Version1.0

September 26th 2017

 * Copyright (c) CMPUT301, University of Alberta - All Rights Reserved.
 *  You may use, copy or distribute this code under terms and conditions of University of Alberta and Code of Student Behavior.
 *   Please contact abc@abc.ca for more details or questions.
 */

package ca.ualberta.cs.lonelytwitter;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Date;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

/**
 * Created by donglin3 on 9/12/17.
 */

/**
 * This class is the main view class in lonelyTwitter class.
 * It contains user inputs, saves and load files
 *
 * @author donglin
 * @see NormalTweet
 * @see java.io.BufferedReader
 * @see ImportantTweet
 * @since 1.5
 */

public class LonelyTwitterActivity extends Activity {

	private static final String FILENAME = "file.sav";
	private EditText bodyText;
	private ListView oldTweetsList;

	private ArrayList<Tweet> tweetList;
	private ArrayAdapter<Tweet> adapter;

	public ListView getOldTweetsList() {
		return oldTweetsList;
	}

	/**
	 * Called when the activity is first created.
	 */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		bodyText = (EditText) findViewById(R.id.body);
		Button saveButton = (Button) findViewById(R.id.save);
		oldTweetsList = (ListView) findViewById(R.id.oldTweetsList);

		saveButton.setOnClickListener(new View.OnClickListener() {

			public void onClick(View v) {
				setResult(RESULT_OK);
				String text = bodyText.getText().toString();

				NormalTweet newTweet = new NormalTweet("Hello");

				tweetList.add(newTweet);
				adapter.notifyDataSetChanged();


				saveInFile();
				//finish();


			}
		});


		Button clearButton = (Button) findViewById(R.id.clear);
		clearButton.setOnClickListener(new View.OnClickListener() {

			public void onClick(View v) {
				tweetList.clear();
				adapter.notifyDataSetChanged();
				saveInFile();
			}
		});

}

			//finish();

	@Override
	protected void onStart() {
		// TODO Auto-generated method stub
		super.onStart();
	    loadFromFile();
		adapter= new ArrayAdapter<Tweet>(this,
				R.layout.list_item, tweetList);
		oldTweetsList.setAdapter(adapter);
	}

	/**
	 * load information from files
	 * @throws RuntimeException
	 * @exception FileNotFoundException
	 */
	private void loadFromFile() {

	    try {
			FileInputStream fis = openFileInput(FILENAME);
			BufferedReader in = new BufferedReader(new InputStreamReader(fis));
			Gson gson = new Gson();
			//Taken from source website
			//2017-09-19
			Type ListType = new TypeToken<ArrayList<NormalTweet>>(){}.getType();
			tweetList = gson.fromJson(in, ListType);

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			tweetList = new ArrayList<Tweet>();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException();
		}

	}

	/**
	 * save information in files
	 * @throws RuntimeException
	 * @exception FileNotFoundException
	 */
	private void saveInFile() {
		try {
			FileOutputStream fos = openFileOutput(FILENAME,
					Context.MODE_PRIVATE);
			BufferedWriter out = new BufferedWriter(new OutputStreamWriter(fos));

			Gson gson =new Gson();
			gson.toJson(tweetList,out);
			out.flush();

			fos.close()          ;
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException();

		}
	}
}