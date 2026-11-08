/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MusicPlayer;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author ACER
 */
public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Playlist playlist = new Playlist();
        PlayHistory history = new PlayHistory();
        BST songTree = new BST();

        int choice;
        do {
            System.out.println("\n========== MUSIC PLAYER ==========");
            System.out.println("1. Add Song");
            System.out.println("2. Remove Song");
            System.out.println("3. Display Playlist");
            System.out.println("4. Play Song");
            System.out.println("5. Display Play History");
            System.out.println("6. Undo Last Played");
            System.out.println("7. Search Song by Title");
            System.out.println("8. Display Songs in BST");
            System.out.println("0. Exit");
            System.out.println("==================================");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1: {
                    System.out.print("Enter song title: ");
                    String title = sc.nextLine();

                    System.out.print("Enter artist: ");
                    String artist = sc.nextLine();

                    System.out.print("Enter duration (seconds): ");

                    int duration;
                    try {
                        duration = sc.nextInt();
                        sc.nextLine();

                        if (duration <= 0) {
                            System.out.println("Invalid duration!");
                            break;
                        }

                    } catch (InputMismatchException e) {
                        System.out.println("Invalid input! Please enter an integer.");
                        sc.nextLine();
                        break;
                    }

                    if (playlist.searchSong(title) != null) {
                        System.out.println("Song already exists!");
                        break;
                    }

                    Song song = new Song(title, artist, duration);

                    playlist.addSong(song);
                    songTree.insert(song);

                    break;
                }

                case 2: {
                    System.out.print("Enter song title to remove: ");
                    String title = sc.nextLine();

                    if (playlist.searchSong(title) != null) {

                        boolean removedFromPlaylist = playlist.removeSong(title);

                        boolean removedFromBST = songTree.removeSong(title);

                        if (removedFromPlaylist && removedFromBST) {
                            System.out.println("Song removed successfully!");
                        } else {
                            System.out.println("Remove failed!");
                        }

                    } else {
                        System.out.println("Song not found!");
                    }
                    break;
                }

                case 3: {
                    playlist.displayPlaylist();
                    break;
                }

                case 4: {
                    System.out.print("Enter song title to play: ");
                    String title = sc.nextLine();

                    Song song = playlist.searchSong(title);

                    if (song != null) {
                        System.out.println("\nNow Playing:");
                        song.display();

                        history.push(song);
                    } else {
                        System.out.println("Song not found in playlist!");
                    }

                    break;
                }

                case 5: {
                    history.displayHistory();
                    break;
                }

                case 6: {
                    history.undoLastPlayed();
                    break;
                }

                case 7: {
                    System.out.print("Enter keyword to search: ");
                    String keyword = sc.nextLine();

                    List<Song> result = songTree.search(keyword);

                    if (!result.isEmpty()) {
                        System.out.println("\n===== SEARCH RESULTS =====");

                        for (int i = 0; i < result.size(); i++) {
                            System.out.println("\nSong " + (i + 1));
                            result.get(i).display();
                        }

                        System.out.println("\nTotal songs found: " + result.size());

                    } else {
                        System.out.println("No songs found!");
                    }

                    break;
                }

                case 8: {
                    songTree.displayInOrder();
                    break;
                }

                case 0: {
                    System.out.println("Exiting Music Player...");
                    break;
                }

                default: {
                    System.out.println("Invalid choice! Please try again.");
                }
            }

        } while (choice != 0);

        sc.close();
    }
}
