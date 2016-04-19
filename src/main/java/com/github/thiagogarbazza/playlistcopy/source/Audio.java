package com.github.thiagogarbazza.playlistcopy.source;

import java.io.File;
import java.io.Serializable;
import java.text.MessageFormat;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.builder.CompareToBuilder;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import lombok.Getter;

@Getter

public class Audio implements Comparable<Audio>, Serializable {

    private String number;
    private File file;

    public Audio(final Integer number, final File file) {
        this.number = StringUtils.leftPad(number.toString(), 4, "0");
        this.file = file;
    }

    @Override
    public int compareTo(final Audio o) {
        if (o == null) {
            return 1;
        }
        return new CompareToBuilder().append(this.number, o.number).toComparison();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(this.number).toHashCode();
    }

    @Override
    public boolean equals(Object object) {
        if (object instanceof Audio) {
            Audio audio = (Audio) object;
            return new EqualsBuilder().append(this.number, audio.number).isEquals();
        }
        return false;
    }

    @Override
    public String toString() {
        return MessageFormat.format("{0}. {1}", number, file.getName());
    }
}