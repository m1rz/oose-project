package com.mad;

import java.util.ArrayList;

public class DataStore {
    
    private static DataStore instance = null;
    private ArrayList<Account> account = new ArrayList<Account>();
    private ArrayList<Movie> movie = new ArrayList<Movie>();
    private ArrayList<TVSeries> tvseries = new ArrayList<TVSeries>();
    private Account currentUser;

    private DataStore() {
        this.addSampleData();
    }

    public static DataStore getInstance() {
        if (instance == null) {
            instance = new DataStore();
        }
        return instance;
    }

    public ArrayList<Account> getAccounts() {
        return account;
    }
    
    public Account getAccountByUsername(String username) {
    	int index = 0;
        for (Account acc : account) {
            if (acc.getUsername().equals(username)) {
                return account.get(index);
            }
            index++;
        }
        return null;
    }

    public void addAccount(Account acc) {
        account.add(acc);
    }

    public boolean removeAccount(String username) {
        int index = 0;
        for (Account acc : account) {
            if (acc.getUsername().equals(username)) {
                account.remove(index);
                return true;
            }
            index++;
        }
        return false;
    }
    
    
    public ArrayList<TVSeries> getTVSeries() {
        return tvseries;
    }
    
    public TVSeries getTVSeriesByID(int showID) {
    	int index = 0;
        for (TVSeries show : tvseries) {
            if (show.getShowID() == showID) {
                return tvseries.get(index);
            }
            index++;
        }
        return null;
    }
    
    public void addTVSeries(TVSeries show) {
        tvseries.add(show);
    }

    public boolean removeTVSeries(int showID) {
        int index = 0;
        for (TVSeries show : tvseries) {
            if (show.getShowID() == showID) {
                account.remove(index);
                return true;
            }
            index++;
        }
        return false;
    }
    public Account getCurrentUser() {
    	return currentUser;
    }
    
    public void setCurrentUser(Account current) {
    	currentUser = current;
    }

    public ArrayList<Movie> getMovies() {
        return movie;
    }

    public Movie getMovieByID(int showID) {
    	int index = 0;
        for (Movie show : movie) {
            if (show.getShowID() == showID) {
                return movie.get(index);
            }
            index++;
        }
        return null;
    }
    
    public void addMovie(Movie show) {
        movie.add(show);
    }

    public boolean removeMovie(int showID) {
        int index = 0;
        for (Movie show : movie) {
            if (show.getShowID() == showID) {
                account.remove(index);
                return true;
            }
            index++;
        }
        return false;
    }
    
    private void addSampleData() {

	Account first = new Account("Shamiel21","abc123","shamiel@gmail.com","Malaysia","0196511469");
        Account second = new Account("Faris18","efg123","faris@gmail.com","Malaysia","01111111");
        Account third = new Account("Mirza19","abc123","mirza@gmail.com","Malaysia","012222222");
        

        this.addAccount(first);
        this.addAccount(second);
        this.addAccount(third);
        
        TVSeries darling = new TVSeries(201,"Darling in the Franxx","Anime", "Science Fiction", 7 , 24 ,"In a future world where humanity has been driven to endangerment by giant beasts, a strike force is assembled to destroy the monsters and save the world.");
        TVSeries kake = new TVSeries(202,"Kakegurui","Anime", "Thriller", 7, 24 ,"A gambling prodigy comes to an elite school run by games and turns the order upside down.");
        TVSeries hori = new TVSeries(203,"Horimiya","Anime", "Romance", 8 , 13 ,"Two very different people - an academically successful schoolgirl and a quiet loser schoolboy - meet and develop a friendship.");
        TVSeries advt = new TVSeries(204,"Adventure Time","Cartoon", "Adventure", 9 , 283 ,"A 12-year-old boy and his best friend, wise 28-year-old dog with magical powers, go on a series of surreal adventures with each other in a remote future.");
        TVSeries ttg = new TVSeries(205,"Teen Titans Go!","Cartoon", "Science Fiction", 5 , 345 ,"Superhero roommates Robin, Cyborg, Starfire, Raven and Beast Boy love saving the day, but what happens when they're done fighting crime?");
        TVSeries dare = new TVSeries(206,"Daredevil","Coming Soon", "Action", 9 , 39 ,"A blind lawyer by day, vigilante by night. Matt Murdock fights the crime of New York as Daredevil.");
        TVSeries cheer = new TVSeries(207,"Cheer","Coming Soon", "Documentary", 8 , 15 ,"In the small town of Corsicana, Texas, hard-driving head cheer coach Monica Aldama demands perfection from her team of competitive college athletes.");
        TVSeries vkg = new TVSeries(208,"Vikings: Vahalla","Coming Soon", "History", 8 , 24 ,"Follow-up series to 'Vikings' set 100 years afterward and centering on the adventures of Leif Erikson, Freydis, Harald Hardrada and the Norman King William the Conqueror.");
        TVSeries carly = new TVSeries(209,"iCarly","Family", "Comedy", 7 , 13 ,"A group of best friends creating a webcast while grappling with everyday problems and adventures.");
        TVSeries b10 = new TVSeries(210,"Ben 10","Family", "Action", 4 , 170 ,"Ben 10 is the fifth iteration of the Ben 10 franchise. It serves as a reboot of the television series loosely based upon the original series.");
        TVSeries cloy = new TVSeries(211,"Crash Landing on You","K-Drama", "Romance", 9 , 16 ,"The absolute top secret love story of a chaebol heiress who made an emergency landing in North Korea because of a paragliding accident and a North Korean special officer who falls in love with her and who is hiding and protecting her.");
        TVSeries bst = new TVSeries(212,"Backstreet Rookie","K-Drama", "Adventure", 8 , 16 ,"A former troublemaker applies for a job at a convenience store owned by the same man who ran errands for her a few years ago.");
        TVSeries hpy = new TVSeries(213,"Happiness","K-Drama", "Horror", 8 , 12 ,"An apocalyptic thriller that takes place in a time in which infectious diseases have become the new normal.");
        TVSeries mny = new TVSeries(215,"Money Heist","Latest", "Thriller", 8 , 41 ,"An unusual group of robbers attempt to carry out the most perfect robbery in Spanish history - stealing 2.4 billion euros from the Royal Mint of Spain.");
        TVSeries dead = new TVSeries(214,"All of Us Are Dead","Latest", "Fantasy", 8 , 12 ,"A high school becomes ground zero for a zombie virus outbreak. Trapped students must fight their way out or turn into one of the rabid infected.");
        TVSeries hnnh = new TVSeries(216,"Hannah Montana","Musical", "Fantasy", 5 , 101 ,"Adventures of a teenage pop star who keeps her identity secret from even her closest friends by using a disguise on-stage.");
        TVSeries glee = new TVSeries(217,"Glee","Musical", "Comedy", 7 , 121 ,"A group of ambitious misfits try to escape the harsh realities of high school by joining a glee club headed by a passionate Spanish teacher.");
        TVSeries dance = new TVSeries(218,"The Last Dance","Recent", "Documentary", 9 , 10 ,"Charting the rise of the 1990's Chicago Bulls, led by Michael Jordan, one of the most notable dynasties in sports history.");
        TVSeries black = new TVSeries(219,"Black Mirror","Recent", "Thriller", 9 , 22 ,"An anthology series exploring a twisted, high-tech multiverse where humanity's greatest innovations and darkest instincts collide.");
        TVSeries fire = new TVSeries(220,"Forged in Fire","Recent", "History", 8 , 208 ,"Four custom knife makers compete to make the best usable knife through a series of challenges.");

        this.addTVSeries(darling);
        this.addTVSeries(kake);
        this.addTVSeries(hori);
        this.addTVSeries(advt);
        this.addTVSeries(ttg);
        this.addTVSeries(dare);
        this.addTVSeries(cheer);
        this.addTVSeries(vkg);
        this.addTVSeries(carly);
        this.addTVSeries(b10);
        this.addTVSeries(cloy);
        this.addTVSeries(bst);
        this.addTVSeries(hpy);
        this.addTVSeries(mny);
        this.addTVSeries(dead);
        this.addTVSeries(hnnh);
        this.addTVSeries(glee);
        this.addTVSeries(dance);
        this.addTVSeries(black);
        this.addTVSeries(fire);
        
        
        
        Movie ngnl0 = new Movie(101,"No Game No Life 0","Anime", "Science Fiction", 8 ,"Adaption of the sixth Light Novel of series, it follows the story of two new characters"
        		+ " - Riku and Schwi - during the events of the Great War, prior to the Ten Covenants.");
		Movie eoc  = new Movie(102, "Empire of Corpses", "Anime", "Horror", 6 , "After breaking the law of reanimating human corpses, young Watson has to either work for the government or face punishment. He has to go on a secret mission, to find the notes of Viktor Frankenstein, who reanimated the first human corpse.");
		Movie jtf  = new Movie(103, "Josee, the Tiger and the Fish", "Anime", "Romance", 8, "Tsuneo is a university student and Josee is a young girl who has rarely gone out of the house by herself due to her being unable to walk. The two meet when Tsuneo finds Josee's grandmother taking her out for a evening walk.");
		Movie pdp  = new Movie(104, "Pokémon Detective Pikachu", "Cartoon", "Adventure", 7 , "In a world where people collect Pokémon to do battle, a boy comes across an intelligent talking Pikachu who seeks to be a detective.");
		Movie bh6  = new Movie(105, "Big Hero 6", "Cartoon", "Science Fiction", 8 , "A special bond develops between plus-sized inflatable robot Baymax and prodigy Hiro Hamada, who together team up with a group of friends to form a band of high-tech heroes.");
		Movie jw  = new Movie(106, "John Wick: Chapter 3 - Parabellum", "Coming Soon", "Action", 7 , "John Wick is on the run after killing a member of the international assassins' guild, and with a $14 million price tag on his head, he is the target of hit men and women everywhere.");
		Movie neymar  = new Movie(107, "Neymar: The Perfect Chaos", "Coming Soon", "Documentary", 8 , "Beloved worldwide but also a lightning rod for critics, Neymar shares the highs and lows of his personal life and brilliant football career.");
		Movie water  = new Movie(108, "Dark Waters", "Coming Soon", "History", 8 , "A corporate defense attorney takes on an environmental lawsuit against a chemical company that exposes a lengthy history of pollution.");
		Movie hotel  = new Movie(109, "Hotel Transylvania: Transformania", "Family", "Comedy", 6 , "After one experiment, Johnny turns into a monster and everyone else becomes human. Now it has to be seen whether they will be able to reverse this experiment.");
		Movie sonic  = new Movie(110, "Sonic the Hedgehog", "Family", "Action", 7 , "After discovering a small, blue, fast hedgehog, a small-town police officer must help him defeat an evil genius who wants to do experiments on him.");
		Movie blue  = new Movie(111, "More than Blue", "K-Drama", "Romance",  8 ," 'K' loves Cream but has terminal cancer so he keeps his love for her secret and tries to find a mate for her before he dies so she will not be alone after he dies.");
		Movie parasite  = new Movie(112, "Parasite", "K-Drama", "Thriller", 9 , "Greed and class discrimination threaten the newly formed symbiotic relationship between the wealthy Park family and the destitute Kim clan.");
		Movie vampire  = new Movie(113, "Beautiful Vampire", "K-Drama", "Fantasy",  5 ,"The beautiful 500-year-old vampire who lived a quiet life running a dressing room in a secluded alley. There has come a fatal crisis to her. The smell of the boy who likes her constantly stimulates her vampire instinct which has been suppressed for a while");
		Movie escape  = new Movie(114, "Escape Room: Tournament of Champions", "Latest", "Thriller",  6 ,"Six people unwillingly find themselves locked in another series of escape rooms, slowly uncovering what they have in common to survive. Joining forces with two of the original survivors, they soon discover they've all played the game before.");
		Movie house  = new Movie(115, "The Deep House", "Latest", "Horror",  8 ,"A young and modern couple who go to France to explore an underwater house and share their findings on social media undergoes a serious change of plans when the couple enters the interior of a strange house located at the bottom of a lake and their presence awakens a dark spirit that haunts the house.");
		Movie showman  = new Movie(116, "The Greatest Showman", "Musical", "Fantasy",  8 ,"Celebrates the birth of show business and tells of a visionary who rose from nothing to create a spectacle that became a worldwide sensation.");
		Movie sing2  = new Movie(117, "Sing 2", "Musical", "Comedy",  8 ,"Buster Moon and his friends must persuade reclusive rock star Clay Calloway to join them for the opening of a new show.");
		Movie bp  = new Movie(118, "Blackpink: Light up the Sky", "Recent", "Documentary", 8 , "Chart the meteoric rise of the South Korean girl group BLACKPINK in director Caroline Suh's documentary.");
		Movie shang  = new Movie(119, "Shang-Chi and the Legend of the Ten Rings", "Recent", "Adventure",  8 ,"Shang-Chi, the master of weaponry-based Kung Fu, is forced to confront his past after being drawn into the Ten Rings organization.");
		Movie m1917  = new Movie(120, "1917", "Recent", "History",  8 ,"April 6th, 1917. As an infantry battalion assembles to wage war deep in enemy territory, two soldiers are assigned to race against time and deliver a message that will stop 1,600 men from walking straight into a deadly trap.");
		
		
		this.addMovie(ngnl0);
		this.addMovie(eoc);
		this.addMovie(jtf);
		this.addMovie(pdp);
		this.addMovie(bh6);
		this.addMovie(jw);
		this.addMovie(neymar);
		this.addMovie(water);
		this.addMovie(hotel);
		this.addMovie(sonic);
		this.addMovie(blue);
		this.addMovie(parasite);
		this.addMovie(vampire);
		this.addMovie(escape);
		this.addMovie(house);
		this.addMovie(sing2);
		this.addMovie(bp);
		this.addMovie(shang);
		this.addMovie(m1917);
		this.addMovie(showman);
    }
}
