// class that is a content collection, which can only contain songs
// includes the method play, which just plays the album in sequential order. 
// this class implements the comparable interface, which sorts by the number of items in the collection.

import java.util.ArrayList;

public class Album extends ContentCollection implements Comparable<ContentCollection> {

  //protected ArrayList variable for album which holds songs in Album
  protected ArrayList<Song> userAlbum = new ArrayList<Song>();

  //overloaded constructor takes in String and ArrayList as parameters for title and contentList, respectively,
  //using inherited overload constructor from ContentCollection to create object
  public Album(String title, ArrayList<Content> contentList) {
    super(title, contentList);
  }

  // compareTo sorts collections by the number of items in the list. Album has to
  // override its parent's abstract compareTo method
  public int compareTo(ContentCollection currContent) {
    if (this.contentList.size() < currContent.size()) {
      return -1;
    } else if (this.contentList.size() == currContent.size()) {
      return 0;
    } else {
      return 1;
    }
  }

  // When an album is played, it calls the play method of every item in the album
  // in sequential order, starting with the first and ending with the last.
  public void shuffle() {
    System.out.println("Now playing in order... ");
    for (Content song : userAlbum) {
      song.play();
    }
  }

  //overloaded copy constructor which takes in Album object as parameter and
  //creates new Album with same title and ArrayList of songs
  public Album(ContentCollection collectionToCopy) {
    super(collectionToCopy);
  }
  /*
   * When an album is played, it should call the play method of every item in the
   * album in sequential order, starting with the first and ending with the last.
   * All content collections should implement the Comparable interface and be
   * sorted by number of items in the collection.
   */

}