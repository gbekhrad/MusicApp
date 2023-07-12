/* class that is a content collection, which can contain a mix of podcasts and songs
 * playlists include methods that allow content to be added and removed from the collection. 
 * when a playlist is played, the shuffle method is called, and it randomly selects and plays a piece of content until all items have been played
 */

import java.util.*;
import java.util.ArrayList;

public class Playlist extends ContentCollection implements Comparable<ContentCollection> {
  // creates static allPlaylists variable to declare all of the playlists to exist throughout the program
  public static ArrayList<Playlist> allPlaylists = new ArrayList<Playlist>();

  // overloaded constructor for a playlist
  public Playlist(String title, ArrayList<Content> contentList) {
    super(title, contentList);
    allPlaylists.add(this);
  }

  // these methods allow content to be added and removed from the collection
  public void addContent(Content userContent) {
    this.contentList.add(userContent); 
    // this will add the passed in content to the content list and the method will void
  }

  public void removeContent(Content userContent) {
    this.contentList.remove(userContent); 
    // this will add the passed in content to the content list and the method will void
  }

  // shuffle method, randomly selects and plays content until all have been played
  public void shuffle() {
    System.out.println("Now shuffling... ");
    // this creates a temporary list to be shuffled
    ArrayList<Content> listToShuffle = new ArrayList<Content>();

    // copies over the list to shuffle it in a new list temporarily
    listToShuffle = this.contentList;
    Collections.shuffle(listToShuffle);

    // prints the shuffled list
    System.out.println(listToShuffle);
  }

  // compareTo sorts collections by the number of items in the list. Playlist has
  // to override its parent's abstract compareTo method
  public int compareTo(ContentCollection currContent) {
    if (this.contentList.size() < currContent.size()) {
      return -1;
    } else if (this.contentList.size() == currContent.size()) {
      return 0;
    } else {
      return 1;
    }
  }

  //overloaded copy constructor for Playlist which takes in a Playlist to be copied as parameter
  public Playlist(ContentCollection collectionToCopy) {
    super(collectionToCopy);
  }
}