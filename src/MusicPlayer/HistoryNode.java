/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MusicPlayer;

/**
 *
 * @author ACER
 */
public class HistoryNode {
    Song data;
    HistoryNode next;

    public HistoryNode(Song data) {
        this.data = data;
        this.next = null;
    }

    public Song getData() {
        return data;
    }

    public void setData(Song data) {
        this.data = data;
    }

    public HistoryNode getNext() {
        return next;
    }

    public void setNext(HistoryNode next) {
        this.next = next;
    }
}
