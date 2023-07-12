import java.io.*;
import java.util.*;

public class Driver {
  public static void main(String[] args) {
    //default Song and podcasts hard coded for before the start of the program 
    Song hoax = new Song("Hoax", "Taylor Swift");
    Song haze = new Song("Haze", "Planet 1999");
    Song viva = new Song("Viva la Vida", "Coldplay");
    Song immortal = new Song("Immortal", "MARINA");
    Song low = new Song("Low", "SZA");

    Podcast banter = new Podcast("Banter", "Karl Jacobs", 5);
    Podcast tmg = new Podcast("TMG", "Cody Ko", 2);

    ArrayList<Content> placehold = new ArrayList<Content>(); // this is just a placeholder for the constructor

    //default Playlist added for testing
    Playlist summerSongs = new Playlist("Jams", placehold);
    placehold.add(hoax);
    placehold.add(viva);
    placehold.add(haze);
    placehold.add(low);

    Random randy = new Random();

    //integer representing user's selection for the 7 potential actions
    int choice = 0;
    while (choice != 7) {

      //allows user to make selection by taking input 
      Scanner scnr = new Scanner(System.in);
      System.out.println(
          "Please Select an Action: \n1. Create a listener account\n2. List all Playlists and Albums and their contents\n3. Add songs to an existing playlist\n4. Shuffle an existing Playlist or listen to an Album\n5. Add a song or podcast to favorites\n6. Export all of a listener’s favorites out to a file in ascending order by times streamed\n7. Exit\n");
      choice = scnr.nextInt();
      // Get menu choice from user

      if (choice == 1) {
        // Allows the user to create a listener account, and select their username
        System.out.println("Please pick a username: ");
        String username = scnr.next();
        Listener listener = new Listener(username);
        System.out.println("Welcome, " + username + "!");
      } else if (choice == 2) {
        try {
          // This block will attempt to print out the current playlists and albums and
          // their contents.
          System.out.println("Here are your current playlists and albums: ");
          for (ContentCollection cont : ContentCollection.allCollections) { // for the current collection in all
                                                                            // collections
            System.out.println(cont.toString()); // print out the collections
          }
          // if they do not exist, catch the nullpointer and notify them that they do not
          // have any collections
        } catch (NullPointerException e) {
          System.out.println("You do not have any albums or playlists!");
        }

      } else if (choice == 3) {
        // This case adds songs to existing playlists
        System.out.println("What is the name of the playlist you would like to add to? ");
        scnr.nextLine();
        // Gets input from the user
        String playlistName = scnr.nextLine();
        System.out.println("");
        // Codeblock that will indicate which playlist the user would like to add to
        Playlist playlistToAdd = null;
        for (Playlist c : Playlist.allPlaylists) {
          if (c.getTitle().equals(playlistName)) {
            playlistToAdd = c;
            break;
          }
        }

        // Codeblock that will indicate which songs to be added to the playlist
        System.out.print("Please enter the names of the tracks you would like to add separated by commas: ");
        String songs = scnr.nextLine();
        String[] songArray = songs.split(",");
        // will split the user input by commas to read through each song and add to the
        // playlist
        try {
          for (String song : songArray) {
            for (Content track : Content.allContent) {
              if (track.getTitle().equals(song)) {
                playlistToAdd.addContent(track);
              }
            }
          }
          // if content DNE,
        } catch (NullPointerException e) {
          System.out.println("You entered a song/playlist name that does not exist!");
        }
      } else if (choice == 4) {
        // This case will shuffle a playlist or listen to an album.
        System.out.println("Which playlist or album would you like to listen to?");
        String userChoice = scnr.next();
        // Gets user input on which they would like to listen to
        try {
          for (ContentCollection con : ContentCollection.allCollections) {
            if (con.getTitle().equals(userChoice)){
              con.shuffle();
            }
          }
          // If ContentCollection DNE,
        } catch (NullPointerException e) {
          System.out.println("That is not a valid playlist or album.");
        }

      } else if (choice == 5) {
        // This case will add a song or podcast to favorites.
        // Get user input for their username
        System.out.println("Please enter your username: ");
        String user = scnr.next();
        
        for (Listener l : Listener.allListeners) {
          // If the username exists,
          if (l.getUsername().equals(user)) {
            // Find out which content they want to add
            System.out.println("Enter the title of the song/podcast you want to add to your favorites: ");
            scnr.nextLine(); // prevents the statement from getting skipped 
            String trackName = scnr.nextLine();
          // if its a song, use song method to add to playlist. else, use podcast method. 
            for (Content c : Content.allContent) {
              
              if (trackName.equals(c.getTitle())) {
                if (c instanceof Song) {
                  System.out.print("Added to favorites!");
                  Song songToAdd = new Song(c.getTitle(), c.getArtist());
                  System.out.println(songToAdd);
                  l.favorite(songToAdd);
                  System.out.println(" Favorites: " + l.getFavorites());
                } else if (c instanceof Podcast) {
                  System.out.print("Added to favorites! ");
                  Podcast podToAdd = new Podcast(c.getTitle(), c.getArtist(), randy.nextInt());
                  System.out.println(podToAdd);
                  l.favorite(podToAdd);
                  System.out.println("Favorites: " + l.getFavorites());
                }
                break;
              }
            }
            break;
          }
        }
      } else if (choice == 6) {
        //exports all of a listener’s favorites out to a file in ascending order by times streamed
        System.out.println("Please enter your username: ");
        String userN = scnr.next(); // reads the username

        Listener userName = null;
        for (Listener l : Listener.allListeners) { // for the account in all accounts
          if (l.getUsername().equals(userN)) { // if the username equals the one entered
            userName = l;
            System.out.println();
            break; // sets username + breaks
          }
        }

        System.out.println("Please enter what you would like to name your file (enter according to format: name.txt): ");
        //takes in desired file name as input
        String fileName = scnr.next();
        try {
          PrintWriter writer = null;
          writer = new PrintWriter(new FileWriter(fileName, false));
          Collections.sort(userName.getFavorites());
          //sorts user's favorites by number of Streams using comparable interface 
          writer.write(userName.getUsername() + "'s Favorites: \n");
          //writes all of the user's favorites onto new file with specified name, each piece of Content going on to a new line 
          for (Content f : userName.getFavorites()) {
            writer.write(f.toString() + "\n");
          }
          if (writer != null) {
            writer.close();
          }
        } catch (IOException e) {
          System.out.println("That user/file does not exist!!");
        }
      } else if (choice == 7) {
        //terminates the while loop, allowing users to exit 
        System.out.println("Thank you for using our service!!");
        break;
      }
    }
  }
}