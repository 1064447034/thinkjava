package com.ly.study.thinkjava.nio.file;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class ReadWrite {
	public static void main(String[] args) throws IOException {
		FileInputStream fis = new FileInputStream("E:/data/log/server.log");
		FileChannel fileChannel = fis.getChannel();
		ByteBuffer buffer = ByteBuffer.allocate(10);
		fileChannel.read(buffer);
		buffer.flip();
		
		StringBuffer s = new StringBuffer();
		while (buffer.remaining() > 0) {
			byte b = buffer.get();
			s.append((char)b);
		}
		System.out.println(s);
//		buffer.rewind();
		fileChannel.read(buffer);
		buffer.flip();

		StringBuffer s2 = new StringBuffer();
		while (buffer.remaining() > 0) {
			byte b2 = buffer.get();
			s2.append((char)b2);
		}
		System.out.println(s2);
		
//		FileOutputStream fos = new FileOutputStream("E:/data/log/server.log");
//		FileChannel writeFileChannel = fos.getChannel();
//		writeFileChannel.write(buffer);
//		buffer.flip();
//		writeFileChannel.close();
		
	}
}
