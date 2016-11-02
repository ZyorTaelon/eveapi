package com.beimin.eveapi.misc;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertThat;

import java.awt.image.BufferedImage;
import java.io.IOException;

import org.junit.Test;

import com.beimin.eveapi.exception.ApiException;
import com.beimin.eveapi.utils.ImageProvider;

public class ImageProviderOnlineTest {
    private static final int IMAGE_SIZE = 32;

    @Test
    public void getCharacterPortrait() throws ApiException, IOException {
        final BufferedImage image = ImageProvider.getCharacterPortrait(1380128241L, (short) IMAGE_SIZE);
        assertThat(image, notNullValue());
        assertThat(image.getWidth(), equalTo(IMAGE_SIZE));
        assertThat(image.getHeight(), equalTo(IMAGE_SIZE));
    }

    @Test
    public void getCorporationLogo() throws ApiException, IOException {
        final BufferedImage image = ImageProvider.getCorporationLogo(531535869, (short) IMAGE_SIZE);
        assertThat(image, notNullValue());
        assertThat(image.getWidth(), equalTo(IMAGE_SIZE));
        assertThat(image.getHeight(), equalTo(IMAGE_SIZE));
    }

    @Test
    public void getAllianceLogo() throws ApiException, IOException {
        final BufferedImage image = ImageProvider.getAllianceLogo(1354830081, (short) IMAGE_SIZE);
        assertThat(image, notNullValue());
        assertThat(image.getWidth(), equalTo(IMAGE_SIZE));
        assertThat(image.getHeight(), equalTo(IMAGE_SIZE));
    }

    @Test
    public void getTypeIcon() throws ApiException, IOException {
        final BufferedImage image = ImageProvider.getTypeIcon(22436, (short) IMAGE_SIZE);
        assertThat(image, notNullValue());
        assertThat(image.getWidth(), equalTo(IMAGE_SIZE));
        assertThat(image.getHeight(), equalTo(IMAGE_SIZE));
    }

    @Test
    public void getRender() throws ApiException, IOException {
        final BufferedImage image = ImageProvider.getRender(22436, (short) IMAGE_SIZE);
        assertThat(image, notNullValue());
        assertThat(image.getWidth(), equalTo(IMAGE_SIZE));
        assertThat(image.getHeight(), equalTo(IMAGE_SIZE));
    }
}
