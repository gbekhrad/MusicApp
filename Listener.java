// done

import java.util.ArrayList;

public class Listener extends Account {
  /*
   * There are two different accounts possible on your platform: an artist
   * account, and a listener account. All accounts should store a member variable
   * for the name or ID associated with the account. Listener accounts should have
   * an additional member variable to store all of the content favorited by that
   * user and a method favorite that accepts a piece of content as input and adds
   * that content to the listener’s favorites.
   */

  // This member variable, only associated with a Listener account, stores all the content favorited by this user.
  protected ArrayList<Content> userFavorites = new ArrayList<Content>(); 
  //public static member variable that stores all created Listeners 
  public static ArrayList<Listener> allListeners = new ArrayList<Listener>();

  //overloaded constructor which takes in String username as parameter
  public Listener(String username) {
    super(username);
    this.username = username;
    allListeners.add(this);
  }

  // Accessors and Mutators for userFavorites
  public ArrayList<Content> getFavorites(){
    return userFavorites;
  }
  public void setFavorites(ArrayList<Content> userFavorites){
    this.userFavorites = userFavorites;
  }

  // Favorite method accepts a piece of content as input and adds that content to the listener's favorites.
  public void favorite(Content contentToFavorite){
    userFavorites.add(contentToFavorite); // this will add the favorited content to the list of favorites
  }

  //toString() method returns String that says Account is of type Listener, then states the username
  public String toString(){
    return "Your account is a listener account, username " + super.getUsername() + ".";
  }
}