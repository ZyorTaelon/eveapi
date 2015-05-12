package com.beimin.eveapi.utils;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;

import javax.imageio.ImageIO;

import com.beimin.eveapi.exception.ApiException;

public class ImageProvider {
	private static String IMAGE_SERVICE_URL = "https://image.eveonline.com";
	private static short[] characterPortraitSizes = new short[]{30, 32, 64, 128, 200, 256, 512, 1024};
	private static short[] corporationLogoSizes = new short[]{30, 32, 64, 128, 256};
	private static short[] allianceLogoSizes = new short[]{30, 32, 64, 128};
	private static short[] typeIconSizes = new short[]{32, 64};
	private static short[] renderSizes = new short[]{32, 64, 128, 256, 512};
	
	public static URL getCharacterPortraitURL(long characterID, short size) throws ApiException {
		if(Arrays.binarySearch(characterPortraitSizes, size) < 0)
			throw new ApiException("Invallid image size: "+Short.toString(size)+". Allowed sizes are: "+Arrays.toString(characterPortraitSizes));
		try {
			return new URL(IMAGE_SERVICE_URL+"/Character/"+Long.toString(characterID)+"_"+Short.toString(size)+".jpg");
		} catch (MalformedURLException e) {
			throw new ApiException("Problem getting character portrait url for characterID: "+Long.toString(characterID)+" with size: "+Short.toString(size), e);
		}
	}
	
	public static BufferedImage getCharacterPortrait(long characterID, short size) throws ApiException {
		try {
			return ImageIO.read(getCharacterPortraitURL(characterID, size));
		} catch (IOException e) {
			throw new ApiException("Problem getting character portrait for characterID: "+Long.toString(characterID)+" with size: "+Short.toString(size), e);
		}
	}
	
	public static URL getCorporationLogoURL(int corporationID, short size) throws ApiException {
		if(Arrays.binarySearch(corporationLogoSizes, size) < 0)
			throw new ApiException("Invallid image size: "+Short.toString(size)+". Allowed sizes are: "+Arrays.toString(characterPortraitSizes));
		try {
			return new URL(IMAGE_SERVICE_URL+"/Corporation/"+Integer.toString(corporationID)+"_"+Short.toString(size)+".png");
		} catch (MalformedURLException e) {
			throw new ApiException("Problem getting corporation logo url for corporationID: "+Integer.toString(corporationID)+" with size: "+Short.toString(size), e);
		}
	}
	
	public static BufferedImage getCorporationLogo(int corporationID, short size) throws ApiException {
		try {
			return ImageIO.read(getCorporationLogoURL(corporationID, size));
		} catch (IOException e) {
			throw new ApiException("Problem getting corporation logo for corporationID: "+Integer.toString(corporationID)+" with size: "+Short.toString(size), e);
		}
	}
	
	public static URL getAllianceLogoURL(int allianceID, short size) throws ApiException {
		if(Arrays.binarySearch(allianceLogoSizes, size) < 0)
			throw new ApiException("Invallid image size: "+Short.toString(size)+". Allowed sizes are: "+Arrays.toString(characterPortraitSizes));
		try {
			return new URL(IMAGE_SERVICE_URL+"/Alliance/"+Integer.toString(allianceID)+"_"+Short.toString(size)+".png");
		} catch (MalformedURLException e) {
			throw new ApiException("Problem getting corporation logo url for allianceID: "+Integer.toString(allianceID)+" with size: "+Short.toString(size), e);
		}
	}
	
	public static BufferedImage getAllianceLogo(int allianceID, short size) throws ApiException {
		try {
			return ImageIO.read(getAllianceLogoURL(allianceID, size));
		} catch (IOException e) {
			throw new ApiException("Problem getting corporation logo for allianceID: "+Integer.toString(allianceID)+" with size: "+Short.toString(size), e);
		}
	}
	
	public static URL getTypeIconURL(int typeID, short size) throws ApiException {
		if(Arrays.binarySearch(typeIconSizes, size) < 0)
			throw new ApiException("Invallid image size: "+Short.toString(size)+". Allowed sizes are: "+Arrays.toString(characterPortraitSizes));
		try {
			return new URL(IMAGE_SERVICE_URL+"/InventoryType/"+Integer.toString(typeID)+"_"+Short.toString(size)+".png");
		} catch (MalformedURLException e) {
			throw new ApiException("Problem getting type icon url for typeID: "+Integer.toString(typeID)+" with size: "+Short.toString(size), e);
		}
	}
	
	public static BufferedImage getTypeIcon(int typeID, short size) throws ApiException {
		try {
			return ImageIO.read(getTypeIconURL(typeID, size));
		} catch (IOException e) {
			throw new ApiException("Problem getting type icon for typeID: "+Integer.toString(typeID)+" with size: "+Short.toString(size), e);
		}
	}
	
	public static URL getRenderURL(int typeID, short size) throws ApiException {
		if(Arrays.binarySearch(renderSizes, size) < 0)
			throw new ApiException("Invallid image size: "+Short.toString(size)+". Allowed sizes are: "+Arrays.toString(characterPortraitSizes));
		try {
			return new URL(IMAGE_SERVICE_URL+"/Render/"+Integer.toString(typeID)+"_"+Short.toString(size)+".png");
		} catch (MalformedURLException e) {
			throw new ApiException("Problem getting Render url for typeID: "+Integer.toString(typeID)+" with size: "+Short.toString(size), e);
		}
	}
	
	public static BufferedImage getRender(int typeID, short size) throws ApiException {
		try {
			return ImageIO.read(getRenderURL(typeID, size));
		} catch (IOException e) {
			throw new ApiException("Problem getting render for typeID: "+Integer.toString(typeID)+" with size: "+Short.toString(size), e);
		}
	}
}