/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MusicPlayer;

/**
 *
 * @author ACER
 */
public class PlayHistory {
    private HistoryNode top;
    private int size;

    public PlayHistory() {
        top = null;
        size = 0;
    }

    public boolean isEmpty() {
        return top == null;
    }

    public void push(Song song) {
        HistoryNode newNode = new HistoryNode(song);

        newNode.next = top;
        top = newNode;

        size++;
    }

    public Song pop() {
        if (isEmpty()) {
            return null;
        }

        Song song = top.data;

        top = top.next;
        size--;

        return song;
    }

    public void undoLastPlayed() {
        if (isEmpty()) {
            System.out.println("Play history is empty!");
            return;
        }

        Song song = pop();

        System.out.println("Undo successful!");
        System.out.println("Removed song: "
                + song.getTitle());
    }

    public void displayHistory() {
        if (isEmpty()) {
            System.out.println("Play history is empty!");
            return;
        }

        System.out.println("\n===== PLAY HISTORY =====");

        HistoryNode current = top;
        int index = 1;

        while (current != null) {
            System.out.println(index + ". "
                    + current.data.getTitle()
                    + " - "
                    + current.data.getArtist()
                    + " (" + current.data.getDuration()
                    + " seconds)");

            current = current.next;
            index++;
        }
    }

  
}
