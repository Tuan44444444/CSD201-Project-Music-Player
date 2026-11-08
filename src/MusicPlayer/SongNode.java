/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MusicPlayer;

/**
 *
 * @author ACER
 */
public class SongNode {
    Song data;
    SongNode next;

    public SongNode(Song data) {
        this.data = data;
        this.next = null;
    }

    public Song getData() {
        return data;
    }

    public void setData(Song data) {
        this.data = data;
    }

    public SongNode getNext() {
        return next;
    }

    public void setNext(SongNode next) {
        this.next = next;
    }
}
