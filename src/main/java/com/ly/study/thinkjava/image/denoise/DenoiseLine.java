package com.ly.study.thinkjava.image.denoise;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.imageio.ImageIO;

import org.apache.commons.lang3.StringUtils;

import com.ly.study.thinkjava.image.Binaryzation;
import com.ly.study.thinkjava.image.Cut;

public class DenoiseLine {
	private static String srcFile = "D:/MyConfiguration/zbs39170/Desktop/aq_de/srcfile";
	private static String tmpDir = "D:/MyConfiguration/zbs39170/Desktop/aq_de/tmp/";
	private static String singleCharDir = "D:/MyConfiguration/zbs39170/Desktop/aq_de/single/";
	private static String cleanSingleCharDir = "D:/MyConfiguration/zbs39170/Desktop/aq_de/cleansingle/";
	
	public static void main(String[] args) throws Exception {
		File[] pngFiles = new File(srcFile).listFiles();
		for (File f : pngFiles) {
			if (f.isFile()) {
				clean(f);				
			}
		}
		
		File[] tmpFiles = new File(tmpDir).listFiles();
		for (File f : tmpFiles) {
			cut(f);
		}

		List<File> cleanSingleCharFiles = Utils.getFileList(singleCharDir);
		for (File f : cleanSingleCharFiles) {
			cleanSingleChar(f);
		}
		
		List<File> singleCharFiles = Utils.getFileList(cleanSingleCharDir);
		for (File f : singleCharFiles) {
			System.out.println(f.getAbsolutePath());
			binarySingleChar(f);
		}

	}
	
	private static void clean(File f) throws IOException {
		BufferedImage bimg = ImageIO.read(f);
		int[][] rgbs = ImageUtils.getImageRgb(bimg);
		
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
		rgbCategory = Utils.sortMapByValue(rgbCategory);

		for (Entry<String, Integer> e : rgbCategory.entrySet()) {
			System.out.println(e.getKey() + " " + e.getValue());
		}
		
		ImageUtils.updateImageRgb(bimg, rgbCategory);
		try {
			System.out.println(f.getPath());
			System.out.println(f.getCanonicalPath());
			System.out.println(f.getName());
			if (!new File(tmpDir).exists()) {
				new File(tmpDir).mkdirs();
			}
			ImageIO.write(bimg, "png", new File(DenoiseLine.tmpDir + StringUtils.substringBefore(f.getName(), ".") +  "_1.png"));			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private static void cleanSingleChar(File f) throws IOException {
		BufferedImage bimg = ImageIO.read(f);
		int[][] rgbs = ImageUtils.getImageRgb(bimg);
		
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
		rgbCategory = Utils.sortMapByValue(rgbCategory);

//		for (Entry<String, Integer> e : rgbCategory.entrySet()) {
//			System.out.println(e.getKey() + " " + e.getValue());
//		}
		ImageUtils.updateSingleImageRgb(bimg, rgbCategory);
		try {
//			File singleFile = new File(DenoiseLine.cleanSingleCharDir + StringUtils.substringBefore(StringUtils.substringAfterLast(f.getAbsolutePath(), "\\"), "."));
			File singleFile = new File(StringUtils.substringBeforeLast(StringUtils.replace(f.getAbsolutePath(), "single", "cleansingle"), "\\"));
			if (!singleFile.exists()) {
				singleFile.mkdirs();
			}
			ImageIO.write(bimg, "png", new File(singleFile.getAbsolutePath() + "/" + f.getName()));
			System.out.println();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void cut(File f) throws Exception {
		BufferedImage bimg = ImageIO.read(f);
		int[][] rgbs = ImageUtils.getImageRgb(bimg);
		
		List<String> existColor = new ArrayList<>();
		Map<Character, Integer> singleFileName = new HashMap<>(); 
		
		for (int charIndex = 0; charIndex < 4; ++charIndex) {
			int startX = 0;
			int endX = 0;
			
			long color = 0;
			boolean b = false;
			
			for (int i = 0; i < rgbs.length; ++i) {
				for (int j = 0; j < rgbs[i].length; ++j) {
					if ((rgbs[i][j] & 0xffff) != 0xffff) {
						color = rgbs[i][j];
						startX = i;
						if (!existColor.contains(String.valueOf(color))) {
							existColor.add(String.valueOf(color));
							b = true;
							break;
						}
					}
				}
				if (startX != 0 && b) {
					break;
				}
			}
			for (int x = rgbs.length - 1; x >= 0; --x) {
				for (int y = rgbs[x].length - 1; y >= 0; --y) {
					if (rgbs[x][y] == color) {
						endX = x;
						break;
					}
				}
				if (endX != 0) {
					break;
				}
			}
			System.out.println(startX);
			System.out.println(endX);
			System.out.println(color);
	
			String filename = f.getName();
			Integer subDirIndex = singleFileName.get(filename.charAt(charIndex));  
			if (subDirIndex != null) {
				singleFileName.put(filename.charAt(charIndex), subDirIndex++);				
			} else {
				subDirIndex = 1;
				singleFileName.put(filename.charAt(charIndex), subDirIndex);
			}
			
			String subSingleCharDirStr = singleCharDir + filename.charAt(charIndex);
			File subSingleCharDir = new File(subSingleCharDirStr);
			if (!subSingleCharDir.exists()) {
				subSingleCharDir.mkdirs();
			}
			
			if (startX - 1 > bimg.getMinX()) {
				startX--;
			}
			if (endX + 1 < bimg.getWidth()) {
				endX++;
			}
			Cut.cutImage(f.getAbsolutePath(), subSingleCharDirStr + "/" + subDirIndex + ".png", startX, bimg.getMinY(), endX - startX, bimg.getHeight());
		}
	}
	
	public static void binarySingleChar(File f) throws IOException {
		Binaryzation.binary(f);
	}
	
}
