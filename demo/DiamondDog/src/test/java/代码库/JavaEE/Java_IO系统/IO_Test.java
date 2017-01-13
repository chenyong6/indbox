package 代码库.JavaEE.Java_IO系统;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.net.URL;
import java.net.URLDecoder;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class IO_Test {
	public static void main(String[] args) throws Exception {
		RandomAccessFile aFile = null;
		URL url = Thread.currentThread().getContextClassLoader().getResource("代码库/Java_IO系统/nio-data.txt");
		aFile = new RandomAccessFile(new File(URLDecoder.decode(url.getFile(), "UTF-8")), "rw");
		FileChannel inChannel = aFile.getChannel();

		ByteBuffer buf = ByteBuffer.allocate(48);

		int bytesRead = 0;
		bytesRead = inChannel.read(buf);
		while (bytesRead != -1) {

			System.out.println("Read " + bytesRead);
			buf.flip();

			while (buf.hasRemaining()) {
				System.out.print((char) buf.get());
			}

			buf.clear();
			bytesRead = inChannel.read(buf);
			aFile.close();
		}
	}
}
