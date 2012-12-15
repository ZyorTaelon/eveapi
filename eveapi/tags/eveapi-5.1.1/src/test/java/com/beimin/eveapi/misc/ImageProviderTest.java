package com.beimin.eveapi.misc;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Arrays;

import javax.imageio.ImageIO;

import org.junit.Test;

import com.beimin.eveapi.exception.ApiException;

public class ImageProviderTest {

	@Test
	public void getCharacterPortraitURL() throws ApiException {
		URL url = ImageProvider.getCharacterPortraitURL(1380128241L, (short)512);
		String urlString = url.toExternalForm();
		assertEquals("https://image.eveonline.com/Character/1380128241_512.jpg", urlString);
	}

	@Test
	public void getCharacterPortrait() throws ApiException, IOException {
		BufferedImage image = ImageProvider.getCharacterPortrait(1380128241L, (short)30);
		byte[] actual = getBytes(image, "jpg");
		InputStream inputStream = ImageProviderTest.class.getResourceAsStream("/misc/1380128241_30.jpg");
		BufferedImage expectedImage = ImageIO.read(inputStream);
		byte[] expected = getBytes(expectedImage, "jpg");
		assertTrue("Not the expected image.", Arrays.equals(expected, actual));
	}

	@Test
	public void getCorporationLogoURL() throws ApiException {
		URL url = ImageProvider.getCorporationLogoURL(531535869, (short)30);
		String urlString = url.toExternalForm();
		assertEquals("https://image.eveonline.com/Corporation/531535869_30.png", urlString);
	}

	@Test
	public void getCorporationLogo() throws ApiException, IOException {
		BufferedImage image = ImageProvider.getCorporationLogo(531535869, (short)30);
		byte[] actual = getBytes(image, "png");
		InputStream inputStream = ImageProviderTest.class.getResourceAsStream("/misc/531535869_30.png");
		BufferedImage expectedImage = ImageIO.read(inputStream);
		byte[] expected = getBytes(expectedImage, "png");
		assertTrue("Not the expected image.", Arrays.equals(expected, actual));
	}

	@Test
	public void getAllianceLogoURL() throws ApiException {
		URL url = ImageProvider.getAllianceLogoURL(1354830081, (short)30);
		String urlString = url.toExternalForm();
		assertEquals("https://image.eveonline.com/Alliance/1354830081_30.png", urlString);
	}

	@Test
	public void getAllianceLogo() throws ApiException, IOException {
		BufferedImage image = ImageProvider.getAllianceLogo(1354830081, (short)30);
		byte[] actual = getBytes(image, "png");
		InputStream inputStream = ImageProviderTest.class.getResourceAsStream("/misc/1354830081_30.png");
		BufferedImage expectedImage = ImageIO.read(inputStream);
		byte[] expected = getBytes(expectedImage, "png");
		assertTrue("Not the expected image.", Arrays.equals(expected, actual));
	}

	@Test
	public void getTypeIconURL() throws ApiException {
		URL url = ImageProvider.getTypeIconURL(22436, (short)32);
		String urlString = url.toExternalForm();
		assertEquals("https://image.eveonline.com/InventoryType/22436_32.png", urlString);
	}

	@Test
	public void getTypeIcon() throws ApiException, IOException {
		BufferedImage image = ImageProvider.getTypeIcon(22436, (short)32);
		byte[] actual = getBytes(image, "png");
		InputStream inputStream = ImageProviderTest.class.getResourceAsStream("/misc/22436_32.png");
		BufferedImage expectedImage = ImageIO.read(inputStream);
		byte[] expected = getBytes(expectedImage, "png");
		assertTrue("Not the expected image.", Arrays.equals(expected, actual));
	}

	@Test
	public void getRenderURL() throws ApiException {
		URL url = ImageProvider.getRenderURL(22436, (short)32);
		String urlString = url.toExternalForm();
		assertEquals("https://image.eveonline.com/Render/22436_32.png", urlString);
	}

	@Test
	public void getRender() throws ApiException, IOException {
		BufferedImage image = ImageProvider.getRender(22436, (short)32);
		byte[] actual = getBytes(image, "png");
		InputStream inputStream = ImageProviderTest.class.getResourceAsStream("/misc/22436_32_render.png");
		BufferedImage expectedImage = ImageIO.read(inputStream);
		byte[] expected = getBytes(expectedImage, "png");
		assertTrue("Not the expected image.", Arrays.equals(expected, actual));
	}

	private byte[] getBytes(BufferedImage image, String fileType) throws IOException {
		ByteArrayOutputStream baos=new ByteArrayOutputStream(1000);
		ImageIO.write(image, fileType, baos);
		baos.flush();
		try {
			return baos.toByteArray();
		} finally {
			baos.close();
		}
 	}
}