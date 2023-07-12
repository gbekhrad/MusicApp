import java.util.ArrayList;
import java.util.Random;

// Each collection has a title and then a list containing all pieces of content in the collection.
// All content collections implement the Comparable interface and are sorted by number of items in the collection.
public abstract class ContentCollection implements Comparable<ContentCollection> {
  
  // creates random to be used in shuffle method
  Random randy = new Random();
  
  // member variables for all Content Collections, to be shared amongst children
  protected String title;
  protected ArrayList<Content> contentList = new ArrayList<Content>();
  public static ArrayList<ContentCollection> allCollections = new ArrayList<ContentCollection>();

  // overloaded constructor which takes in String title and ArrayList as parameters
  public ContentCollection(String title, ArrayList<Content> contentList){
    this.title = title;
    this.contentList = contentList;
    allCollections.add(this);
  }
//overloaded constructor which takes in String title as parameter
  public ContentCollection(String title){
    this.title = title;
    this.contentList = new ArrayList<Content>();
    allCollections.add(this);
  }

  // .size has to be defined for the contentcollection 
  public int size(){
    return this.contentList.size();
  }

  // method shuffle() will play a randomly selected piece of content from the collection. 
  public void shuffle(){
    System.out.println("Now shuffling... ");
    int random = randy.nextInt(0, contentList.size()-1);
    System.out.println(contentList.get(random));
  }

  //accesors for member variables
  public String getTitle(){
    return this.title;
  }

  public ArrayList<Content> getContentList() {
    return this.contentList;
  }

  //toString() method returns String of all pieces of Content in the Collection, separated by commas 
  public String toString() {
    String final1 = this.getTitle() + ":\n";
    String newLine = "\n:";
    for (Content c: this.contentList) {
      final1 = final1 + c.toString()+ ", ";
    }
    return final1;
  }
  // compareTo sorts collections by the number of items in the list
  public int compareTo(ArrayList<Content> currContent) {
    if (this.contentList.size() < currContent.size()) {
      return -1;
    }
    else if (this.contentList.size() == currContent.size()) {
      return 0;
    }
    else {
      return 1;
    }
  }

  //overloaded copy constructor takes in ContentCollection as parameter and creates a deep copy
  public ContentCollection(ContentCollection collectionToCopy) {
    this.title = collectionToCopy.getTitle();
    this.contentList = collectionToCopy.getContentList();
  }
}