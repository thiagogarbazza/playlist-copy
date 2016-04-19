/*
 * Copyright (c) Banco Central do Brasil.
 *
 * Este software é confidencial e propriedade do Banco Central do Brasil.
 * Não é permitida sua distribuição ou divulgação do seu conteúdo sem
 * expressa autorização do Banco Central.
 * Este arquivo contém informações proprietárias.
 */
package com.github.thiagogarbazza.playlistcopy.source;

import org.apache.commons.lang3.StringUtils;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AudioFactoryTest {

    private static final Integer NUMBER = 1;
    private AudioFactory audioFactory;

    @Before
    public void setUp(){
        audioFactory = new AudioFactory();
    }

    @Test
    public void isLineEmpty() {
        String line = StringUtils.EMPTY;
        final Audio audio = audioFactory.factory(NUMBER, line);
        Assert.assertNull(audio);
    }

    @Test
    public void isLineSpace() {
        String line = StringUtils.SPACE;
        final Audio audio = audioFactory.factory(NUMBER, line);
        Assert.assertNull(audio);
    }

    @Test
    public void isLineEXTM3U() {
        String line = "#EXTM3U";
        final Audio audio = audioFactory.factory(NUMBER, line);
        Assert.assertNull(audio);
    }

    @Test
    public void isLineEXTINF() {
        String line = "#EXTINF";
        final Audio audio = audioFactory.factory(NUMBER, line);
        Assert.assertNull(audio);
    }

    @Test
    public void isLineContainsValidAudioFile() {
        String line = "Iron Maiden - The Duellists";
        final Audio audio = audioFactory.factory(NUMBER, line);
        Assert.assertNotNull(audio);
    }
}