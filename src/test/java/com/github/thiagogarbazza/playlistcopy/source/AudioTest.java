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

import org.junit.Assert;
import org.junit.Test;

public class AudioTest {

    @Test
    public void compareToGreaterThanNullValue(){
        Audio audio1 = new Audio(1, null);
        Assert.assertEquals(1, audio1.compareTo(null));
    }

    @Test
    public void compareToLessThan(){
        Audio audio1 = new Audio(1, null);
        Audio audio2 = new Audio(2, null);
        Assert.assertEquals(-1, audio1.compareTo(audio2));
    }

    @Test
    public void compareToEquals(){
        Audio audio1 = new Audio(1, null);
        Audio audio2 = new Audio(1, null);
        Assert.assertEquals(0, audio1.compareTo(audio2));
    }

    @Test
    public void compareToGreaterThan(){
        Audio audio1 = new Audio(2, null);
        Audio audio2 = new Audio(1, null);
        Assert.assertEquals(1, audio1.compareTo(audio2));
    }

    @Test
    public void toStringFormat() {
        String fileName = "Iron Maiden - The Duellists";
        final Audio audio = new Audio(1, new File(fileName));
        Assert.assertNotNull(audio);
        Assert.assertEquals("0001. Iron Maiden - The Duellists", audio.toString());
    }

}