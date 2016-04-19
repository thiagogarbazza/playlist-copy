package com.github.thiagogarbazza.playlistcopy;

import java.io.File;

import com.github.thiagogarbazza.playlistcopy.source.Playlist;
import com.github.thiagogarbazza.playlistcopy.source.PlaylistFactory;

public class Main {

    public static void main(String[] args) {
        File playlistM3U = new File("F:\\2016-04-16\\test-2.m3u");
        File destiny = new File("D:\\tmp\\playlist");

        Playlist playlist = PlaylistFactory.factory(playlistM3U);

        playlist.copy(destiny);
    }
}