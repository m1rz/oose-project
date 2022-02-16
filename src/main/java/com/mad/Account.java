package com.mad;

public class Account {
    String username;
    String passwordDigest;
    String email;
    String phoneNum;
    Profile profile[] = new Profile[5];


    Account (String username,String password,String email,String country,String phoneNum){
        this.username = username;
        this.passwordDigest = CryptographyService.getHash(password);
        this.email = email;
        this.phoneNum = phoneNum; 
    }

    
    public Profile[] getProfile() {
        return profile;
    }


    public void setProfile(Profile[] profile) {
        this.profile = profile;
    }
    
    public void addProfile(Profile obj){
        profile[profile.length - 1] = obj;
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return passwordDigest;
    }

    public boolean setPassword(String oldPassword, String newPassword) {
        if (CryptographyService.getHash(oldPassword).equals(this.passwordDigest)) {
            this.passwordDigest = CryptographyService.getHash(newPassword);
            return true;
        }
        return false;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }
}
