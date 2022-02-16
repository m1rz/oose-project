package com.mad;

 class TVSeries extends Show{
    
    String title;
    int showID;
    String category;
    String genre;
    String description;
    int rate;
    int episode;

    public TVSeries(int showID, String title, String category, String genre, int rate, int episode, String description){
            this.showID = showID;
            this.title = title;
            this.category = category;
            this.genre = genre;
            this.description = description;
            this.rate = rate;
            this.episode = episode;
    }
    
    public String getTitle() {
        return title;
    }



    public void setTitle(String title) {
        this.title = title;
    }



    public int getShowID() {
        return showID;
    }



    public void setShowID(int showID) {
        this.showID = showID;
    }



    public String getCategory() {
        return category;
    }



    public void setCategory(String category) {
        this.category = category;
    }



    public String getGenre() {
        return genre;
    }



    public void setGenre(String genre) {
        this.genre = genre;
    }



    public String getDescription() {
        return description;
    }



    public void setDescription(String description) {
        this.description = description;
    }



    public int getRate() {
        return rate;
    }



    public void setRate(int rate) {
        this.rate = rate;
    }



    public int getEpisode() {
        return episode;
    }



    public void setEpisode(int episode) {
        this.episode = episode;
    }

 }