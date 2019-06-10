package com.example.myprojectv3;

import com.google.gson.annotations.SerializedName;

    public class RetroUsers {

//Give the field a custom name//

        @SerializedName("name")
        private String name;

        @SerializedName("region")
        private String region;

        @SerializedName("capital")
        private String capital;

        public String getCapital() {
            return capital;
        }

        public void setCapital(String capital) {
            this.capital = capital;
        }

        public RetroUsers(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getRegion() {
            return region;
        }

        public void setRegion(String region) {
            this.region = region;
        }



//Retrieve the data using setter/getter methods//

        public String getUser() {
            return name;
        }

        public void setUser(String name) {
            this.name = name;
        }

    }

