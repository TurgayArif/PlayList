import java.util.ArrayList;
import java.util.LinkedList;

public class Album {
    private String name;
    private String artist;
    private ArrayList<Song> songs;

    public Album(String name, String artist) {
        this.name = name;
        this.artist = artist;
        this.songs = new ArrayList<>();
    }

    public boolean addSong(String title, double duration) {
        if (findSong(title) == null) {
            this.songs.add(new Song(title, duration));
            return true;
        }

        return false;
    }

    private Song findSong(String title) {
        for (Song existingSong : this.songs) {
            if (existingSong.getTitle().equals(title)) {
                return existingSong;
            }
        }

        return null;
    }

    public boolean addToPlayList(int trackNumber, LinkedList<Song> playList) {
        int indexNumber = trackNumber - 1;
        if ((indexNumber >= 0) && (indexNumber <= this.songs.size())) {
            playList.add(this.songs.get(indexNumber));
            return true;
        }

        System.out.println("This album does not have a track with number " + trackNumber);
        return false;
    }

    public boolean addToPlayList(String songName, LinkedList<Song> playList) {
        Song existingSong = findSong(songName);
        if (findSong(songName) != null) {
            playList.add(existingSong);
            return true;
        }

        System.out.println("The song " + songName + " is not in this album.");
        return false;
    }
}
