package com.mad;

public class Profile {
    String name;
    int profileId;

    Profile(String name,int profileId){
        this.name= name;
        this.profileId = profileId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getProfileId() {
        return profileId;
    }

    public void setProfileId(int profileId) {
        this.profileId = profileId;
    }

    
}
