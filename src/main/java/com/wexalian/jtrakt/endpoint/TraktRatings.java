package com.wexalian.jtrakt.endpoint;

import com.google.gson.annotations.SerializedName;

public class TraktRatings {
    private float rating;
    private int votes;
    private Distribution distribution;
    
    public static class Distribution {
        @SerializedName("1")
        private int one;
        @SerializedName("2")
        private int two;
        @SerializedName("3")
        private int three;
        @SerializedName("4")
        private int four;
        @SerializedName("5")
        private int five;
        @SerializedName("6")
        private int six;
        @SerializedName("7")
        private int seven;
        @SerializedName("8")
        private int eight;
        @SerializedName("9")
        private int nine;
        @SerializedName("10")
        private int ten;
        
        public int getOneStarVotes() {
            return one;
        }
        
        public int getTwoStarVotes() {
            return two;
        }
        
        public int getThreeStarVotes() {
            return three;
        }
        
        public int getFourStarVotes() {
            return four;
        }
        
        public int getFiveStarVotes() {
            return five;
        }
        
        public int getSixStarVotes() {
            return six;
        }
        
        public int getSevenStarVotes() {
            return seven;
        }
        
        public int getEightStarVotes() {
            return eight;
        }
        
        public int getNineStarVotes() {
            return nine;
        }
        
        public int getTenStarVotes() {
            return ten;
        }
    }
}
