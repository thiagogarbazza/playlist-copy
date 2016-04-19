package com.github.thiagogarbazza.playlistcopy;

import java.io.File;

import com.github.thiagogarbazza.playlistcopy.source.PlaylistCopy;

public class Main {

    PlaylistCopy playlistCopy = new PlaylistCopy();

    public static void main(String[] args) {
        File playlistM3U = new File("F:\\2016-04-16\\test-2.m3u");
        File destiny = new File("D:\\tmp\\playlist");
        new Main().playlistCopy.copy(playlistM3U, destiny);
    }
}