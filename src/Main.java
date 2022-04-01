import java.util.*;

public class Main {

    private static ArrayList<Album> albums = new ArrayList<>();

    public static void main(String[] args) {

        Album album = new Album("Ima takuv narod", "Slavi Trifonov");
        album.addSong("Uvertyura", 7.06); // 0
        album.addSong("Hayduti", 5.11); // 1
        album.addSong("Bog s nami", 8.15); // 2
        album.addSong("Tya", 4.36); // 3
        album.addSong("Devet", 5.33); // 4
        album.addSong("Vyarvam v chudesa", 4.40); // 5
        album.addSong("Prituri se planinata", 5.58); // 6
        album.addSong("Az sym tvoyat myzh", 4.39); // 7
        album.addSong("Byagay", 3.53); // 8
        album.addSong("Samovila", 5.43); // 9
        album.addSong("Falshiv geroy", 3.31); // 10
        album.addSong("Rosni mi, rosni Rositsa", 7.24); // 11
        album.addSong("Zhiv ili myrtav", 5.26); // 12
        album.addSong("Pesen za Bulgaria", 6.16); // 13

        albums.add(album);

        album = new Album("Vox populi", "Slavi Trifonov");
        album.addSong("Bach - Vox Dei", 6.45); // 0
        album.addSong("Yovano, Yovanke", 5.55); // 1
        album.addSong("Funk off", 3.37); // 2
        album.addSong("Katerino mome", 3.39); // 3
        album.addSong("Ludo mlado", 4.39); // 4

        albums.add(album);

        LinkedList<Song> playList = new LinkedList<>();
        albums.get(0).addToPlayList(14, playList);
        albums.get(0).addToPlayList(1, playList);
        albums.get(0).addToPlayList(2, playList);
        albums.get(0).addToPlayList(3, playList);
        albums.get(0).addToPlayList(4, playList);
        albums.get(0).addToPlayList(5, playList);
        albums.get(0).addToPlayList(6, playList);
        albums.get(0).addToPlayList(7, playList);
        albums.get(0).addToPlayList(8, playList);
        albums.get(0).addToPlayList(9, playList);
        albums.get(0).addToPlayList(10, playList);
        albums.get(0).addToPlayList(11, playList);
        albums.get(0).addToPlayList(12, playList);
        albums.get(0).addToPlayList(13, playList);
        albums.get(1).addToPlayList(1, playList);
        albums.get(1).addToPlayList(2, playList);
        albums.get(1).addToPlayList(3, playList);
        albums.get(1).addToPlayList(4, playList);
        albums.get(1).addToPlayList(5, playList);

        play(playList);
    }

    private static void play(LinkedList<Song> playList) {
        Scanner sc = new Scanner(System.in);
        boolean quit = false;
        boolean forward = true;
        ListIterator<Song> songListIterator = playList.listIterator();

        if (playList.size() == 0) {
            System.out.println("No songs in the playlist");
            return;
        } else {
            System.out.println("Now playing - " + songListIterator.next());
            printMenu();
        }

        while (!quit) {
            int action = sc.nextInt();
            sc.nextLine();

            switch (action) {
                case 0:
                    System.out.println("Playlist quiting...");
                    quit = true;
                    break;
                case 1:
                    if (!forward) {
                        if (songListIterator.hasNext()) {
                            songListIterator.next();
                        }
                        forward = true;
                    }

                    if (songListIterator.hasNext()) {
                        System.out.println("Now playing " + songListIterator.next());
                    } else {
                        System.out.println("We've reached the end of the playlist");
                        forward = false;
                    }
                    break;
                case 2:
                    if (forward) {
                        if (songListIterator.hasPrevious()) {
                            songListIterator.previous();
                        }
                        forward = false;
                    }
                    if (songListIterator.hasPrevious()) {
                        System.out.println("Now playing - " + songListIterator.previous());
                    } else {
                        System.out.println("We reached the start of playlist");
                        forward = true;
                    }
                    break;
                case 3:
                    if (forward) {
                        if (songListIterator.hasPrevious()) {
                            System.out.println("Now replaying - " + songListIterator.previous());
                            forward = false;
                        } else {
                            System.out.println("We are at the start of the playlist");
                        }
                    } else {
                        if (songListIterator.hasNext()) {
                            System.out.println("Now replaying - " + songListIterator.next());
                            forward = true;
                        } else {
                            System.out.println("We are at the end of the playlist");
                        }
                    }
                    break;
                case 4:
                    printList(playList);
                    break;
                case 5:
                    printMenu();
                    break;
                case 6:
                    if (playList.size() > 0) {
                        songListIterator.remove();
                        if (songListIterator.hasNext()) {
                            System.out.println("Now playing - " + songListIterator.next());
                        } else if (songListIterator.hasPrevious()) {
                            System.out.println("Now playing - " + songListIterator.previous());
                        }
                    }
                    break;
            }
        }
    }

    private static void printMenu() {
        System.out.println("Available actions:\npress");
        System.out.println("0 - to quit\n" +
                "1 - to play next song\n" +
                "2 - to play previous song\n" +
                "3 - to replay the current song\n" +
                "4 - list songs in the playlist\n" +
                "5 - print available actions.\n" +
                "6 - delete current song from playlist");

    }

    private static void printList(LinkedList<Song> playList) {
        Iterator<Song> songIterator = playList.iterator();
        System.out.println("==========================================");
        while (songIterator.hasNext()) {
            System.out.println(songIterator.next());
        }
        System.out.println("==========================================");
    }
}
