/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MusicPlayer;

/**
 *
 * @author ACER
 */
public class Playlist {
    private SongNode head;
    private SongNode tail;
    private int size;

    public Playlist() {
        head = null;
        tail = null;
        size = 0;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void addSong(Song song) {
        SongNode newNode = new SongNode(song);

        if (isEmpty()) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }

        size++;
        System.out.println("Song added successfully!");
    }

    public void displayPlaylist() {
        if (isEmpty()) {
            System.out.println("Playlist is empty!");
            return;
        }

        System.out.println("\n===== PLAYLIST =====");

        SongNode current = head;
        int index = 1;

        while (current != null) {
            System.out.println("\nSong " + index);
            current.data.display();

            current = current.next;
            index++;
        }
    }

    public Song searchSong(String title) {
        SongNode current = head;

        while (current != null) {
            if (current.data.getTitle().equalsIgnoreCase(title)) {
                return current.data;
            }

            current = current.next;
        }

        return null;
    }

    public boolean removeSong(String title) {
        if (isEmpty()) {
            return false;
        }

        if (head.data.getTitle().equalsIgnoreCase(title)) {
            head = head.next;

            if (head == null) {
                tail = null;
            }

            size--;
            return true;
        }

        SongNode current = head;

        while (current.next != null) {
            if (current.next.data.getTitle()
                    .equalsIgnoreCase(title)) {

                if (current.next == tail) {
                    tail = current;
                }

                current.next = current.next.next;
                size--;
                return true;
            }

            current = current.next;
        }

        return false;
    }

    public int getSize() {
        return size;
    }
}
