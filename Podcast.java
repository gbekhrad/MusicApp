public class Podcast extends Content {
  //protected integer member variable for Podcast episode number 
  protected int episodeNum;

  //accessor for integer Podcast episode number
  public int getEpisodeNum() {
    return this.episodeNum;
  }

  //mutator for Podcast episode number which takes in integer parameter
  public void setEpisodeNum(int newEpisodeNum) {
    this.episodeNum = newEpisodeNum;
  }

  //overloaded constructor which takes in String title, String artist, and integer episode number as parameters 
  public Podcast(String title, String artist, int episodeNum) {
    super(title, artist);
    this.episodeNum = episodeNum;
  }

  //toString() method which returns String of Podcast title, aritst, and episode number 
  public String toString() {
    return super.toString() + " (episode: " + this.getEpisodeNum() + ")";
  }

}