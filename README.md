# MusicApp

README.txt

Collaboration with Keira Ryan
Email: keiryan@chapman.edu

CLASS OVERVIEW:

Content.java: 
- Content.java is an abstract class that holds member variables for the title, artist, and number of streams associated with the track (song or podcast), as well as the play method which increments number of streams by one.
- Member variable of static ArrayList for allContent to hold all of the content collections that the user has. 
- Implements the CompareTo interface and overrides the compareTo() method to organize songs by number of streams.
- Content.java is a parent class to Podcast.java and Song.java.

Podcast.java:
- Inherits play method and member variables from Content.java, which includes the title, artist, and number of streams associated with the track.
- Also has an additional integer member variable associated with the episode number of the podcast. 

Song.java:
- Inherits play method and member variable from Content.java, which includes the title, artist, and number of streams associated with the track. 

Accounts.java:
- Accounts.java is an abstract class that holds member variables for the username associated with the account. Also holds a member variable for their favorited tracks.
- Method addFavorite() will add the content to the Account's favorite list.
- Accounts.java is a parent class to Listener.java and Artist.java.

Listener.java:
- Inherits member variables from Accounts.java, which includes the ID associated with the account. Listener accounts have an additional member variable to store all of the content favorited by that user.
- Listener holds a static ArrayList of Listener objects to keep track of all Listeners in the program.
- Listener accounts also have a method favorite() that accepts a piece of content as input and adds that content to the listener's favorites. 

Artist.java:
- Inherits member variables from Accounts.java, which includes the ID associated with the account. Allows an artist account to be instantiated. 

ContentCollection.java:
- ContentCollection.java is an abstract class that implements the Comparable<ContentCollection> interface. It holds an ArrayList of Content (generically) and the title of the collection.
- size() method functions the same as any ArrayList size() method. 
- It includes the method shuffle, which shuffles all the content from the indicated collection. 

Playlist.java:
- Inherits member variables from ContentCollection.java, which includes the title of the collection and ArrayList of the content. Playlists can hold both Podcasts and Songs. 
- Playlist also implements the Comparable interface like its parent class and overrides the compareTo() method.. 
- Playlist.java includes the method addContent() and removeContent(), which adds or removes the content that is passed in to the method to the playlist. 
- The class also overrides the parent method shuffle, by shuffling the Playlist and playing all of the content until they have all been played.

Album.java:
- Inherits member variables from ContentCollection.java, which includes the title of the collection and ArrayList of the content. Albums can only hold Songs. 
- Album also implements the Comparable interface like its parent class and overrides the compareTo() method. 
- Album has the method shuffle(), which will play all songs in the order of the album.

WHY THIS ARCHITECTURE WAS SELECTED:
The decision to split up the assignment into 3 different "categories" was made to ensure as much sharing methods as possible and prevent duplicate code. Knowing that objects of "Content Collection", "Account", and "Content" would not need to be instantiated, they were made abstract and their children were instantiated into the program. The organization of the classes allowed for a clear hierarchy and was effective in completing this assignment. 

FUTURE DEVELOPERS/ADDITIONAL FEATURES:
There is a lot more that can be done with music apps, such as user recommendations, friend lists, playlist sharing, and importing custom music. Ultimately this base architecture that we have created can allow for much more expansion and versatility in future music app endeavors. 

Sources:
https://www.java67.com/2018/07/how-to-randomize-elements-in-list-in-java-using-shuffle.html 
https://beginnersbook.com/2013/12/java-arraylist-of-object-sort-example-comparable-and-comparator/
