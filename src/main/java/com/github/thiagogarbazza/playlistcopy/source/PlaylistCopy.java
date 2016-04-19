/*
 * Copyright (c) Banco Central do Brasil.
 *
 * Este software é confidencial e propriedade do Banco Central do Brasil.
 * Não é permitida sua distribuição ou divulgação do seu conteúdo sem
 * expressa autorização do Banco Central.
 * Este arquivo contém informações proprietárias.
 */
package com.github.thiagogarbazza.playlistcopy.source;

import java.io.File;

public class PlaylistCopy {

    public void copy(final File playlistM3U, final File destiny) {
        Playlist playlist = new PlaylistFactory().factory(playlistM3U);

        playlist.copy(destiny);
    }

}
