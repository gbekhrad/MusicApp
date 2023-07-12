public class Song extends Content {
  // overloaded Song constructor which takes in String title 
  // and artist as parameters 
  public Song(String title, String artist){
    super(title, artist);
  }

  //toString() method which returns String of the Song's title and artist
  public String toString(){
    return super.toString();
  }
}