import java.lang.Comparable;
import java.util.ArrayList;

public abstract class Content implements Comparable<Content> {
  /*
   * Your streaming service contains two different types of listenable content:
   * songs and podcasts. Each piece of content should have a title, artist, and
   * the number of times streamed. Podcasts should have an additional member
   * variable for the episode number.
   * When either a song or podcast is played, the times streamed should be
   * incremented by 1 and a message should be printed to the console.
   * 
   All content should implement the Comparable interface and be sorted by number
   * of times streamed.
   */
  
  // member variables for listenable content 
  protected String title;
  protected String artist;
  protected int numStreams; 
  public static ArrayList<Content> allContent = new ArrayList<Content>();

  // play method used to play the content
  public void play() {
    System.out.println("Now Playing: " + this.title + " by " + this.artist);
    this.numStreams++;
  }

  // overloaded constructor
  public Content(String title, String artist) {
    this.title = title;
    this.artist = artist;
    this.numStreams = 0;
    allContent.add(this);
  }

  // Copy Constructor
  public Content(Content contentToCopy){
    this.title = contentToCopy.getTitle();
    this.artist = contentToCopy.getArtist();
    this.numStreams = contentToCopy.getNumStreams();
  }
  
  // Accessors and mutators for member vairables
  public String getTitle() {
    return title;
  }
  
  public void setTitle(String title) {
    this.title = title;
  }
  
  public String getArtist() {
    return artist;
  }
  
  public void setArtist(String artist) {
    this.artist = artist;
  }
  
  public int getNumStreams() {
    return numStreams;
  }
  
  public void setNumStreams(int numStreams) {
    this.numStreams = numStreams;
  }

  //compareTo method overwrites default compareTo method of Comparable interface
  //by sorting Content in order my comparing the number of Streams
  public int compareTo(Content contentToCompare) {
    /**START OF CODE FROM SOURCE: https://beginnersbook.com/2013/12/java-arraylist-of-object-sort-example-comparable-and-comparator/
    */
    int compareStreams= contentToCompare.getNumStreams();
    return this.getNumStreams()-compareStreams;
    /**END OF CODE FROM SOURCE: https://beginnersbook.com/2013/12/java-arraylist-of-object-sort-example-comparable-and-comparator/
    */
  }

  //toString() method print the title and artist of the given Content
  public String toString(){
    return this.getTitle() + " by " + this.getArtist();
  }
  
}