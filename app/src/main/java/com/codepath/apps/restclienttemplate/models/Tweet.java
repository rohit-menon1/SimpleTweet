package com.codepath.apps.restclienttemplate.models;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.parceler.Parcel;

import java.util.ArrayList;
import java.util.List;

import static com.codepath.apps.restclienttemplate.TimeFormatter.getTimeDifference;
 @Parcel
public class Tweet {
    public String body;
    public String createdAt;
    public User user;
    public long id;

    public Tweet() {}//parcler library needs empty constructor

    public static Tweet fromJson(JSONObject jsonObject) throws JSONException {
        Tweet tweet = new Tweet();
        tweet.body = jsonObject.getString("text");
        tweet.createdAt=jsonObject.getString("created_at");
        tweet.user=User.fromJson(jsonObject.getJSONObject("user"));
        tweet.id=jsonObject.getLong("id");
        return tweet;
    }
    public static List<Tweet> fromJsonArray(JSONArray jsonArray) throws JSONException {
        List<Tweet> tweets = new ArrayList<>();
        for ( int i = 0;
        i<jsonArray.length();i++){
            tweets.add(fromJson(jsonArray.getJSONObject(i)));
        }
        return tweets;
    }
    public String getRelativeTimestamp(){
        //relative Time stamp
        return getTimeDifference(createdAt);
    }
}
