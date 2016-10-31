package com.beimin.eveapi.misc;

import java.awt.image.BufferedImage;
import java.io.IOException;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertThat;
import org.junit.Test;

import com.beimin.eveapi.exception.ApiException;
import com.beimin.eveapi.utils.ImageProvider;


public class ImageProviderOnlineTest {

    private final int size = 32;

    @Test
    public void getCharacterPortrait() throws ApiException, IOException {
        final BufferedImage image = ImageProvider.getCharacterPortrait(1380128241L, (short) size);
        assertThat(image, notNullValue());
        assertThat(image.getWidth(), equalTo(size));
        assertThat(image.getHeight(), equalTo(size));
    }

    @Test
    public void getCorporationLogo() throws ApiException, IOException {
        final BufferedImage image = ImageProvider.getCorporationLogo(531535869, (short) size);
        assertThat(image, notNullValue());
        assertThat(image.getWidth(), equalTo(size));
        assertThat(image.getHeight(), equalTo(size));
    }

    @Test
    public void getAllianceLogo() throws ApiException, IOException {
        final BufferedImage image = ImageProvider.getAllianceLogo(1354830081, (short) size);
        assertThat(image, notNullValue());
        assertThat(image.getWidth(), equalTo(size));
        assertThat(image.getHeight(), equalTo(size));
    }

    @Test
    public void getTypeIcon() throws ApiException, IOException {
        final BufferedImage image = ImageProvider.getTypeIcon(22436, (short) size);
        assertThat(image, notNullValue());
        assertThat(image.getWidth(), equalTo(size));
        assertThat(image.getHeight(), equalTo(size));
    }

    @Test
    public void getRender() throws ApiException, IOException {
        final BufferedImage image = ImageProvider.getRender(22436, (short) size);
        assertThat(image, notNullValue());
        assertThat(image.getWidth(), equalTo(size));
        assertThat(image.getHeight(), equalTo(size));
    }
}
