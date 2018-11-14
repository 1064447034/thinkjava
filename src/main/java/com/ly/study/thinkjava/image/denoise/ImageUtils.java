package com.ly.study.thinkjava.image.denoise;

import java.awt.image.BufferedImage;
import java.util.Map;

public class ImageUtils {
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
	
	public static void updateImageRgb(BufferedImage bi, Map<String, Integer> rgbs) {
	    int width = bi.getWidth();
	    int height = bi.getHeight();
	    int minx = bi.getMinX();
	    int miny = bi.getMinY();
	    
		int[] x = new int[5];
		int index = 0;
	    for (String s : rgbs.keySet()) {
	    	if (index >= 5) {
	    		break;
	    	}
	    	x[index++] = Integer.valueOf(s);
	    	System.out.print("==: " + s);
	    }
	    
	     for (int i = minx; i < width; i++) {
	         for (int j = miny; j < height; j++) {
	        	 int r = bi.getRGB(i, j) & 0xFFFFFF;
//	        	 if (r != pixs[pixs.length - 1] 
//	        	  && r != pixs[pixs.length - 2]
//	        	  && r != pixs[pixs.length - 3]
//	        	  && r != pixs[pixs.length - 4]
//	        	  && r != pixs[pixs.length - 5]) {
//	        	 if (r != 16777215 && r != 11572491 && r != 9525753 && r != 9857905 && r != 12369766) {
	        	 if (r != x[0] && r != x[1] && r != x[2] && r != x[3] && r != x[4]) {
	        		 bi.setRGB(i, j, 16777215);
	        	 }
	         }
	     }
	 }
	
	public static void updateSingleImageRgb(BufferedImage bi, Map<String, Integer> rgbs) {
	    int width = bi.getWidth();
	    int height = bi.getHeight();
	    int minx = bi.getMinX();
	    int miny = bi.getMinY();
	    
		int[] x = new int[2];
		int index = 0;
	    for (String s : rgbs.keySet()) {
	    	if (index >= 2) {
	    		break;
	    	}
	    	x[index++] = Integer.valueOf(s);
	    	System.out.print("==: " + s);
	    }
	    
	     for (int i = minx; i < width; i++) {
	         for (int j = miny; j < height; j++) {
	        	 int r = bi.getRGB(i, j) & 0xFFFFFF;
	        	 if (r != x[0] && r != x[1]) {
	        		 bi.setRGB(i, j, 16777215);
	        	 }
	         }
	     }
	 }
}
