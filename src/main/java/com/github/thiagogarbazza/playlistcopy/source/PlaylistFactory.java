package com.github.thiagogarbazza.playlistcopy.source;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.Scanner;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;

import lombok.extern.apachecommons.CommonsLog;

@CommonsLog
class PlaylistFactory {

    AudioFactory audioFactory;

    private static final Charset CHARSET = Charset.forName("ISO-8859-1");

    public Playlist factory(final File playlistM3U) {
        Playlist playlist = new Playlist();

        InputStream in = null;
        Scanner scanner = null;

        int audioNumber = 1;
        try {
            in = new FileInputStream(playlistM3U);
            scanner = new Scanner(in, CHARSET.name());
            scanner.useDelimiter(System.getProperty("line.separator"));
            while (scanner.hasNext()) {
                String linha = StringUtils.trimToEmpty(scanner.next());
                Audio audio = audioFactory.factory(audioNumber, linha);
                if (audio != null) {
                    playlist.add(audio);
                    audioNumber++;
                }
            }
        } catch (IOException e) {
            log.error("Error trying to extract audios from M3U file.", e);
        } finally {
            if(scanner != null){
                scanner.close();
            }
            IOUtils.closeQuietly(in);
        }

        return playlist;
    }


}