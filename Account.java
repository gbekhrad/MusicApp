import java.util.ArrayList;

public abstract class Account {
  /*
   * There are two different accounts possible on your platform: an artist
   * account, and a listener account. All accounts should store a member variable
   * for the name or ID associated with the account. Listener accounts should have
   * an additional member variable to store all of the content favorited by that
   * user and a method favorite that accepts a piece of content as input and adds
   * that content to the listener’s favorites.
   */

  // private and public member variables for an account
  protected String username;
  protected ArrayList<Content> favorites;
  public static ArrayList<Account> allAccounts = new ArrayList<Account>();

  //overloaded Account constructor takes in a String parameter for the account username and creates new empty array of favorites. meant to be inherited by Listener and Artist to be called upon
  public Account(String username) {
    this.username = username;
    this.favorites = new ArrayList<Content>();
    allAccounts.add(this);
  }

  // accessors for the username member variable
  public String getUsername() {
    return this.username;
  }

  //accessor for the favorites member variable 
  public ArrayList<Content> getFavorites() {
    return this.favorites;
  }

  //mutator for the username member variable
  public void setUsername(String username) {
    this.username = username;
  }

  //the addFavorite method takes in Content object, either Song or Podcast, and adds it to the Account's favorites ArrayList 
  public void addFavorite(Content fav) {
    this.favorites.add(fav);
  }

}