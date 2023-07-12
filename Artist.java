// Artist account inherits member variables from Account. Functions differently than a Listener. 

public class Artist extends Account {
  
  public Artist(String username){
    super(username);
    this.username = username;
  }
}