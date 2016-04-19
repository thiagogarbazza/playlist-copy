package com.github.thiagogarbazza.playlistcopy.source;

import java.io.File;
import java.io.IOException;
import java.text.MessageFormat;
import java.util.TreeSet;

import org.apache.commons.collections4.Closure;
import org.apache.commons.collections4.IterableUtils;
import org.apache.commons.io.FileUtils;

import lombok.extern.apachecommons.CommonsLog;

@CommonsLog
public class Playlist extends TreeSet<Audio> {

    protected Playlist() {

    }

    public void copy(final File destiny) {
        if(!isEmpty()){
            final boolean mkdirs = destiny.mkdirs();
            if(!mkdirs){
                throw new RuntimeException("Not create tree diretories");
            }
        }

        IterableUtils.forEach(this, new Closure<Audio>() {
            @Override
            public void execute(final Audio audio) {
                final String fileName = MessageFormat.format("{0}. {1}", audio.getNumber(), audio.getFile().getName());
                log.info(fileName);

                try {
                    File copy = new File(destiny, fileName);
                    FileUtils.copyFile(audio.getFile(), copy);
                } catch (IOException e) {
                    log.error("Erro ao copiar arquivo", e);
                }
            }
        });
    }
}