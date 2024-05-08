/**
 * @project AimsProject
 * @author Mitchell Vu
 * @since December 2023
 */

package hust.soict.dsai.aims.media;

import hust.soict.dsai.aims.exception.PlayerException;

import java.util.ArrayList;

public class CompactDisc extends Disc implements Playable {
    private final ArrayList<Track> tracks = new ArrayList<Track>();
    private String artist;

    public CompactDisc(String title, int length, String artist) {
        super(title, length);
        this.artist = artist;
    }

    public CompactDisc(String title, String category, int length, String artist) {
        super(title, category, length);
        this.artist = artist;
    }

    public CompactDisc(String title, String category, float cost, int length, String artist) {
        super(title, category, cost, length);
        this.artist = artist;
    }

    public String getArtist() {
        return artist;
    }

    public void addTrack(Track track) {
        if (tracks.contains(track)) {
            System.out.println("Track already exists!");
            return;
        }

        tracks.add(track);
        System.out.println("Add track successful.");
    }

    public void removeTrack(Track track) {
        for (int i = 0; i < tracks.size(); i++)
            if (tracks.get(i).equals(track)) {
                tracks.remove(track);
                System.out.println("Remove track successful.");
                return;
            }

        System.out.println("Track does not exist.");
    }

    @Override
    public int getLength() {
        int cdLength = 0;
        for (Track track : tracks)
            cdLength += track.getLength();

        return cdLength;
    }

    @Override
    public void play() throws PlayerException {
        if (this.getLength() > 0) {
            System.out.println("DVD Title : " + this.getTitle());
            System.out.println("Artist    : " + this.getArtist());
            System.out.println("Length    : " + this.getLength());

            if (tracks.isEmpty()) {
                System.out.println("No tracks found.");
            } else {
                for (Track track : tracks) {
                    track.play();
                }
            }
        } else {
            throw new PlayerException("ERROR: CD length is non-positive!");
        }
    }

    @Override
    public String toString() {
        return "CD [" + this.getId() + "]"
                + " - " + this.getTitle()
                + " - " + this.getCategory()
                + " - " + this.getArtist()
                + " - " + this.getCost() + "$";
    }
}
