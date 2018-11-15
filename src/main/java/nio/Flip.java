package nio;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class Flip {
	private static final int SIZE = 1024;
	
	public static void main(String[] args) throws IOException {
		FileChannel fc = new FileOutputStream("data.txt").getChannel();
		fc.write(ByteBuffer.wrap("some text".getBytes()));
		fc.close();
		
		fc = new RandomAccessFile("data.txt", "rw").getChannel();
		System.out.println("此通道文件位置：" + fc.position());
		fc.position(fc.size());	
		ByteBuffer bf = ByteBuffer.allocate(SIZE);
		bf.put("some data".getBytes());
//		bf.flip();
		fc.write(bf);
//		fc.write(ByteBuffer.wrap("some more".getBytes()));
		fc.close();
		
		fc = new FileInputStream("data.txt").getChannel();
		ByteBuffer buffer = ByteBuffer.allocate(SIZE);
		fc.read(buffer);
		buffer.flip();
		while (buffer.hasRemaining()) {
			System.out.print((char)buffer.get());
		}
		fc.close();
		
	}
}
