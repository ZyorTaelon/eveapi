package com.beimin.eveapi.utils;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;

import javax.imageio.ImageIO;

import com.beimin.eveapi.exception.ApiException;

public class ImageProvider {
    private static final String WITH_SIZE = " with size: ";
    private static final String ALLOWED_SIZES_ARE = ". Allowed sizes are: ";
    private static final String INVALID_IMAGE_SIZE = "Invalid image size: ";
    private static String IMAGE_SERVICE_URL = "https://image.eveonline.com";
    private static short[] characterPortraitSizes = new short[] { 30, 32, 64, 128, 200, 256, 512, 1024 };
    private static short[] corporationLogoSizes = new short[] { 30, 32, 64, 128, 256 };
    private static short[] allianceLogoSizes = new short[] { 30, 32, 64, 128 };
    private static short[] typeIconSizes = new short[] { 32, 64 };
    private static short[] renderSizes = new short[] { 32, 64, 128, 256, 512 };

    public static URL getCharacterPortraitURL(final long characterID, final short size) throws ApiException {
        if (Arrays.binarySearch(characterPortraitSizes, size) < 0) {
            throw new ApiException(INVALID_IMAGE_SIZE + Short.toString(size) + ALLOWED_SIZES_ARE + Arrays.toString(characterPortraitSizes));
        }
        try {
            return new URL(IMAGE_SERVICE_URL + "/Character/" + Long.toString(characterID) + "_" + Short.toString(size) + ".jpg");
        } catch (final MalformedURLException e) {
            throw new ApiException("Problem getting character portrait url for characterID: " + Long.toString(characterID) + WITH_SIZE + Short.toString(size), e);
        }
    }

    public static BufferedImage getCharacterPortrait(final long characterID, final short size) throws ApiException {
        try {
            return ImageIO.read(getCharacterPortraitURL(characterID, size));
        } catch (final IOException e) {
            throw new ApiException("Problem getting character portrait for characterID: " + Long.toString(characterID) + WITH_SIZE + Short.toString(size), e);
        }
    }

    public static URL getCorporationLogoURL(final int corporationID, final short size) throws ApiException {
        if (Arrays.binarySearch(corporationLogoSizes, size) < 0) {
            throw new ApiException(INVALID_IMAGE_SIZE + Short.toString(size) + ALLOWED_SIZES_ARE + Arrays.toString(characterPortraitSizes));
        }
        try {
            return new URL(IMAGE_SERVICE_URL + "/Corporation/" + Integer.toString(corporationID) + "_" + Short.toString(size) + ".png");
        } catch (final MalformedURLException e) {
            throw new ApiException("Problem getting corporation logo url for corporationID: " + Integer.toString(corporationID) + WITH_SIZE + Short.toString(size), e);
        }
    }

    public static BufferedImage getCorporationLogo(final int corporationID, final short size) throws ApiException {
        try {
            return ImageIO.read(getCorporationLogoURL(corporationID, size));
        } catch (final IOException e) {
            throw new ApiException("Problem getting corporation logo for corporationID: " + Integer.toString(corporationID) + WITH_SIZE + Short.toString(size), e);
        }
    }

    public static URL getAllianceLogoURL(final int allianceID, final short size) throws ApiException {
        if (Arrays.binarySearch(allianceLogoSizes, size) < 0) {
            throw new ApiException(INVALID_IMAGE_SIZE + Short.toString(size) + ALLOWED_SIZES_ARE + Arrays.toString(characterPortraitSizes));
        }
        try {
            return new URL(IMAGE_SERVICE_URL + "/Alliance/" + Integer.toString(allianceID) + "_" + Short.toString(size) + ".png");
        } catch (final MalformedURLException e) {
            throw new ApiException("Problem getting corporation logo url for allianceID: " + Integer.toString(allianceID) + WITH_SIZE + Short.toString(size), e);
        }
    }

    public static BufferedImage getAllianceLogo(final int allianceID, final short size) throws ApiException {
        try {
            return ImageIO.read(getAllianceLogoURL(allianceID, size));
        } catch (final IOException e) {
            throw new ApiException("Problem getting corporation logo for allianceID: " + Integer.toString(allianceID) + WITH_SIZE + Short.toString(size), e);
        }
    }

    public static URL getTypeIconURL(final int typeID, final short size) throws ApiException {
        if (Arrays.binarySearch(typeIconSizes, size) < 0) {
            throw new ApiException(INVALID_IMAGE_SIZE + Short.toString(size) + ALLOWED_SIZES_ARE + Arrays.toString(characterPortraitSizes));
        }
        try {
            return new URL(IMAGE_SERVICE_URL + "/InventoryType/" + Integer.toString(typeID) + "_" + Short.toString(size) + ".png");
        } catch (final MalformedURLException e) {
            throw new ApiException("Problem getting type icon url for typeID: " + Integer.toString(typeID) + WITH_SIZE + Short.toString(size), e);
        }
    }

    public static BufferedImage getTypeIcon(final int typeID, final short size) throws ApiException {
        try {
            return ImageIO.read(getTypeIconURL(typeID, size));
        } catch (final IOException e) {
            throw new ApiException("Problem getting type icon for typeID: " + Integer.toString(typeID) + WITH_SIZE + Short.toString(size), e);
        }
    }

    public static URL getRenderURL(final int typeID, final short size) throws ApiException {
        if (Arrays.binarySearch(renderSizes, size) < 0) {
            throw new ApiException(INVALID_IMAGE_SIZE + Short.toString(size) + ALLOWED_SIZES_ARE + Arrays.toString(characterPortraitSizes));
        }
        try {
            return new URL(IMAGE_SERVICE_URL + "/Render/" + Integer.toString(typeID) + "_" + Short.toString(size) + ".png");
        } catch (final MalformedURLException e) {
            throw new ApiException("Problem getting Render url for typeID: " + Integer.toString(typeID) + WITH_SIZE + Short.toString(size), e);
        }
    }

    public static BufferedImage getRender(final int typeID, final short size) throws ApiException {
        try {
            return ImageIO.read(getRenderURL(typeID, size));
        } catch (final IOException e) {
            throw new ApiException("Problem getting render for typeID: " + Integer.toString(typeID) + WITH_SIZE + Short.toString(size), e);
        }
    }
}
