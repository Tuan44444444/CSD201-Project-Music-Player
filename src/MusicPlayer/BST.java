/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MusicPlayer;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ACER
 */
public class BST {

    private BSTNode root;

    public BST() {
        root = null;
    }

    public void insert(Song song) {
        root = insertRec(root, song);
    }

    private BSTNode insertRec(BSTNode current, Song song) {
        if (current == null) {
            return new BSTNode(song);
        }

        int compare = song.getTitle().compareToIgnoreCase(current.data.getTitle());

        if (compare < 0) {
            current.left = insertRec(current.left, song);
        } else if (compare > 0) {
            current.right = insertRec(current.right, song);
        }

        return current;
    }

    public List<Song> search(String keyword) {
        List<Song> result = new ArrayList<>();

        searchRec(root, keyword.toLowerCase(), result);

        return result;
    }

    private void searchRec(BSTNode current, String keyword,
            List<Song> result) {

        if (current == null) {
            return;
        }

        searchRec(current.left, keyword, result);

        if (current.data.getTitle().toLowerCase().contains(keyword)) {
            result.add(current.data);
        }

        searchRec(current.right, keyword, result);
    }

    public void displayInOrder() {
        System.out.println("\n===== SONGS IN BST =====");
        inOrder(root);
    }

    private void inOrder(BSTNode current) {
        if (current != null) {
            inOrder(current.left);

            System.out.println(current.data.getTitle()
                    + " - " + current.data.getArtist());

            inOrder(current.right);
        }
    }

    public boolean removeSong(String title) {

        // Check whether the song exists
        if (search(title) == null) {
            return false;
        }

        root = removeRec(root, title);
        return true;
    }

    private BSTNode removeRec(BSTNode current, String title) {

        if (current == null) {
            return null;
        }

        int compare = title.compareToIgnoreCase(
                current.data.getTitle());

        if (compare < 0) {
            current.left = removeRec(current.left, title);
        } 
        else if (compare > 0) {
            current.right = removeRec(current.right, title);
        } 
        else {

            if (current.left == null && current.right == null) {
                return null;
            }

            if (current.left == null) {
                return current.right;
            }

            if (current.right == null) {
                return current.left;
            }

            BSTNode minNode = findMin(current.right);

            current.data = minNode.data;

            current.right = removeRec(
                    current.right,
                    minNode.data.getTitle());
        }

        return current;
    }

    private BSTNode findMin(BSTNode current) {

        while (current.left != null) {
            current = current.left;
        }

        return current;
    }

}
