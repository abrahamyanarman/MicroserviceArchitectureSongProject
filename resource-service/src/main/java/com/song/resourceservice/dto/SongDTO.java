package com.song.resourceservice.dto;

public class SongDTO {
    private String name;
    private String artist;
    private String album;
    private String length;
    private String resourceId;
    private String year;
    private String genre;

    public SongDTO() {
    }

    public SongDTO(String name, String artist, String album, String length, String resourceId, String year, String genre) {
        this.name = name;
        this.artist = artist;
        this.album = album;
        this.length = length;
        this.resourceId = resourceId;
        this.year = year;
        this.genre = genre;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public String getLength() {
        return length;
    }

    public void setLength(String length) {
        this.length = length;
    }

    public String getResourceId() {
        return resourceId;
    }

    public void setResourceId(String resourceId) {
        this.resourceId = resourceId;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
}
