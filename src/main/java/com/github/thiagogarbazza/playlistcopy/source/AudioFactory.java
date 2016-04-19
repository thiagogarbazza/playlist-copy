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

import org.apache.commons.lang3.StringUtils;

class AudioFactory {

    public Audio factory(Integer number, String line) {
        final boolean containsFileType = StringUtils.contains(line, "#EXTM3U");
        final boolean containsItenInfo = StringUtils.contains(line, "#EXTINF");
        final boolean isEmpty = StringUtils.isBlank(line);

        if (!isEmpty && !containsFileType && !containsItenInfo) {
            return new Audio(number, new File(line));
        }
        return null;
    }
}