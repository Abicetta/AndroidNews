package com.abicetta.androidnews;

import android.content.Context;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class ArticleAdapter extends ArrayAdapter<Article> {
    ViewHolder holder;
    String date;
    String time;

    //constructor
    public ArticleAdapter(Context context, List<Article> places) {
        super(context, 0, places);
    }

    // The ViewHolder caches the TextView
    private class ViewHolder {
        private TextView sectionV, dateV, titleV, authorV;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //Check if there is an existing list item view (called convert view) that we can reuse
        if (convertView == null) {
            // if convertView is null, then inflate a new list item layout
            holder = new ViewHolder();
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_layout, parent, false);
            // set up the ViewHolder
            holder.sectionV = (TextView) convertView.findViewById(R.id.section);
            holder.dateV = (TextView) convertView.findViewById(R.id.date);
            holder.titleV = (TextView) convertView.findViewById(R.id.title);
            holder.authorV = (TextView) convertView.findViewById(R.id.author);
            // store the holder with the view.
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        //find the article at the given position in the list
        Article currentArticle = getItem(position);
        //check if article is null
        if (currentArticle != null) {
            // Display the section of the article in that TextView
            String textSection = currentArticle.getSection();
            //change the color of the background for the section "Technology"
            if (textSection.contentEquals("Technology")) {
                holder.sectionV.setBackgroundResource(R.color.color_bkg_date_tech);
            } else {
                holder.sectionV.setBackgroundResource(R.color.color_bkg_date);
            }
            //set the text of section
            holder.sectionV.setText(currentArticle.getSection());
            //we get the original date String from the Article object and store that in a variable.
            String originalDate = currentArticle.getDate();
            //Data is "2017-11-17T06:00:05Z", split the data string with "T" separator.
            String[] parts = originalDate.split("T");
            date = parts[0];
            String[] inverseDate = date.split("-");
            String yyyy = inverseDate[0];
            String mm = inverseDate[1];
            String dd = inverseDate[2];
            date = dd + "-" + mm + "-" + yyyy;
            //set other textviews
            holder.dateV.setText(date);
            holder.titleV.setText(currentArticle.getTitle());
            holder.authorV.setText(currentArticle.getAuthor());
        } else {
            holder.sectionV.setText("Unknown");
            holder.dateV.setText("Unknown");
            holder.titleV.setText("Unknown");
            holder.authorV.setText("Unknown");
        }
        return convertView;
    }
}