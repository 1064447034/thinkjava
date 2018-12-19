package com.ly.study.thinkjava.image;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import javax.imageio.ImageIO;
import javax.imageio.ImageReadParam;
import javax.imageio.ImageReader;
import javax.imageio.stream.FileImageInputStream;
import javax.imageio.stream.ImageInputStream;

import org.apache.commons.lang3.StringUtils;

public class Cut {
	public static BufferedImage cutImage(String srcFile, String targetFile,
			int startAcross, int StartEndlong, int width, int hight)
			throws Exception {
		// 取得图片读入器
		Iterator<ImageReader> readers = ImageIO
				.getImageReadersByFormatName("png");
		ImageReader reader = readers.next();
		// 取得图片读入流
		InputStream source = new FileInputStream(srcFile);
		ImageInputStream iis = ImageIO.createImageInputStream(source);
		reader.setInput(iis, true);
		// 图片参数对象
		ImageReadParam param = reader.getDefaultReadParam();
		Rectangle rect = new Rectangle(startAcross, StartEndlong, width, hight);
		param.setSourceRegion(rect);
		BufferedImage bi = reader.read(0, param);
		ImageIO.write(bi, targetFile.split("\\.")[1], new File(targetFile));
		return bi;
	}
	
	public static byte[] image2byte(String path) {
		byte[] data = null;
		FileImageInputStream input = null;
		try {
			input = new FileImageInputStream(new File(path));
			ByteArrayOutputStream output = new ByteArrayOutputStream();
			byte[] buf = new byte[1024];
			int numBytesRead = 0;
			while ((numBytesRead = input.read(buf)) != -1) {
				output.write(buf, 0, numBytesRead);
			}
			data = output.toByteArray();
			output.close();
			input.close();
		} catch (FileNotFoundException ex1) {
			ex1.printStackTrace();
		} catch (IOException ex1) {
			ex1.printStackTrace();
		}
		return data;
	}
	
	public static int [][] getImageRgb(byte[] image) throws Exception {
	    BufferedImage bi = ImageIO.read(new ByteArrayInputStream(image));
	    int width = bi.getWidth();
	    int height = bi.getHeight();
	    int minx = bi.getMinX();
	    int miny = bi.getMinY();
	     
	     int[][] rgb = new int[width - minx][height - miny]; 

	     for (int i = minx; i < width; i++) {
	         for (int j = miny; j < height; j++) {
	        	 rgb[i][j] = bi.getRGB(i, j) & 0xFFFFFF;
	         }
	     }
	     return rgb;
	 }
	
	public static int [][] getImageRgb(BufferedImage bi) {
	    int width = bi.getWidth();
	    int height = bi.getHeight();
	    int minx = bi.getMinX();
	    int miny = bi.getMinY();
	     
	     int[][] rgb = new int[width - minx][height - miny]; 

	     for (int i = minx; i < width; i++) {
	         for (int j = miny; j < height; j++) {
	        	 rgb[i][j] = bi.getRGB(i, j) & 0xFFFFFF;
	         }
	     }
	     return rgb;
	 }
	
	public static void updateImageRgb(BufferedImage bi, int[] pixs) {
	    int width = bi.getWidth();
	    int height = bi.getHeight();
	    int minx = bi.getMinX();
	    int miny = bi.getMinY();
	     
	     for (int i = minx; i < width; i++) {
	         for (int j = miny; j < height; j++) {
	        	 int r = bi.getRGB(i, j) & 0xFFFFFF;
	        	 if (r != pixs[pixs.length - 1] && r != pixs[pixs.length - 2]) {
//	        	 if (r != 16777215 && r != 12369766) {
	        		 bi.setRGB(i, j, 16777215);
	        	 }
	         }
	     }
	 }
	
	public static boolean szToImage(byte[] decoderBytes, String path, String imgName) {
		boolean value = false;

		try {
			FileOutputStream write = new FileOutputStream(new File(path + imgName));
			write.write(decoderBytes);
			write.close();
			value = true;
			return value;
		} catch (IOException e) {
			e.printStackTrace();
			return value;
		}
	}
	
	public static void main(String[] args) throws IOException {
		String dir = "D:/MyConfiguration/zbs39170/Desktop/aq_de/";
		String srcFile = "D:/MyConfiguration/zbs39170/Desktop/aq_de/CNXQ.png";
		String temp = srcFile.split("\\.")[0] + "_1.png";
		String targetFile = "D:/MyConfiguration/zbs39170/Desktop/aq_de/CNXQ_target.png";
		
		byte[] pngBytes = image2byte(srcFile);
		BufferedImage image = ImageIO.read(new ByteArrayInputStream(pngBytes));
		
		try {
			BufferedImage initImage = Cut.cutImage(srcFile, temp, image.getMinX() + image.getWidth() / 7, image.getMinY(), image.getWidth() * 2 / 3, image.getHeight());
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		BufferedImage cutImage = null;
		for (int num = 0; num < 4; ++num) {
			try {
//				cutImage = Cut.cutImage(temp, targetFile, image.getMinX() + image.getWidth() / 10, image.getMinY(), image.getWidth() / 3, image.getHeight());
				String singleCharPng = dir + StringUtils.substringBefore(StringUtils.substringAfterLast(srcFile, "/"), ".").charAt(num) + ".png";
				cutImage = Cut.cutImage(temp, singleCharPng, image.getMinX() + num * image.getWidth() / 5, image.getMinY(), num * image.getMinX() + image.getWidth() / 5, image.getHeight());
			} catch (Exception e) {
				e.printStackTrace();
			}
			int[][] rgbs = getImageRgb(cutImage);
	
			Map<String, Integer> rgbCategory = new HashMap<>(); 
			for (int i = 0; i < rgbs.length; ++i) {
				for (int j = 0; j < rgbs[i].length; ++j) {
					Integer count = rgbCategory.get(String.valueOf(rgbs[i][j]));
					if (count == null) {
						rgbCategory.put(String.valueOf(rgbs[i][j]), 1);
					} else {
						++count;
						rgbCategory.put(String.valueOf(rgbs[i][j]), count);
					}
				}
			}
	
			int[] pixs = new int[rgbCategory.entrySet().size()];
			int i = 0;
			for (Entry<String, Integer> e : rgbCategory.entrySet()) {
				System.out.println(e.getKey() + " " + e.getValue());
				pixs[i++] = Integer.parseInt(e.getKey());
			}
			Arrays.sort(pixs);
			System.out.println(Arrays.toString(pixs));
			
			updateImageRgb(cutImage, pixs);
			ImageIO.write(cutImage, "png", new File("D:/MyConfiguration/zbs39170/Desktop/aq_de/" + (num + 1) + ".png"));
		}
	}
}
