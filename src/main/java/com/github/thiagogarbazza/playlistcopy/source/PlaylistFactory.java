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
public class PlaylistFactory {

    private static final Charset CHARSET = Charset.forName("ISO-8859-1");

    public static Playlist factory(final File playlistM3U) {
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
                Audio audio = createAudio(audioNumber, linha);
                if (audio != null) {
                    playlist.add(audio);
                    audioNumber++;
                }
            }
        } catch (IOException e) {
            log.error("Erro ao acessar ao tentar recuperar a linha " + audioNumber + " do arquivo " + playlistM3U.getName(),
                    e);
        } finally {
            IOUtils.closeQuietly(scanner);
            IOUtils.closeQuietly(in);
        }

        return playlist;
    }

    protected static Audio createAudio(Integer number, String line) {
        final boolean containsFileType = StringUtils.contains(line, "#EXTM3U");
        final boolean containsItenInfo = StringUtils.contains(line, "#EXTINF");
        final boolean isEmpty = StringUtils.isEmpty(line);

        if (!isEmpty && !containsFileType && !containsItenInfo) {
            return new Audio(number, new File(line));
        }
        return null;
    }
}