package com.ly.study.thinkjava.image;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Binaryzation {
	public static void main(String[] args) throws IOException {
		File file = new File("D:\\MyConfiguration\\zbs39170\\Desktop\\aq");
		File[] files = file.listFiles();
		for (File f : files) {
			System.out.println(f.getAbsolutePath());
			System.out.println(f.getName());
			binary(f);
		}
	}

	public static void binary(File file) throws IOException {
//		BufferedImage image = ImageIO.read(new File("D:\\MyConfiguration\\zbs39170\\Desktop\\HU\\bb.jpg"));
		BufferedImage image = ImageIO.read(file);
		int w = image.getWidth();
		int h = image.getHeight();
		float[] rgb = new float[3];
		double[][] zuobiao = new double[w][h];
		int R = 0;
		float red = 0;
		float green = 0;
		float blue = 0;
		BufferedImage bi= new BufferedImage(w, h,
				BufferedImage.TYPE_BYTE_BINARY);;
		for (int x = 0; x < w; x++) {
			for (int y = 0; y < h; y++) {
				int pixel = image.getRGB(x, y); 
				System.out.println(pixel);
				rgb[0] = (pixel & 0xff0000) >> 16;
				rgb[1] = (pixel & 0xff00) >> 8;
				rgb[2] = (pixel & 0xff);
				red += rgb[0];
				green += rgb[1];
				blue += rgb[2];
				R = (x+1) *(y+1);
				float avg = (rgb[0]+rgb[1]+rgb[2])/3;
				zuobiao[x][y] = avg;	
				
			}
		}
		double SW = 230;
		for (int x = 0; x < w; x++) {
			for (int y = 0; y < h; y++) {
				if (zuobiao[x][y] <= SW) {
					int max = new Color(0, 0, 0).getRGB();
					bi.setRGB(x, y, max);
				}else{
					int min = new Color(255, 255, 255).getRGB();
					bi.setRGB(x, y, min);
				}
			}
		}

		String prefix = file.getAbsolutePath().substring(0, file.getAbsolutePath().lastIndexOf("\\"));
		File singleBinary = new File(prefix.replace("single", "singlebinary"));
		if (!singleBinary.exists()) {
			singleBinary.mkdirs();
		}
		ImageIO.write(bi, "png", new File(singleBinary.getAbsoluteFile() + "/" + file.getName()));
	}
}
