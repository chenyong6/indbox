package 代码库.utils.POI_JXL;
import java.io.ByteArrayOutputStream;
import java.net.MalformedURLException;
import java.net.URL;

import javax.imageio.ImageIO;


public class Testtt {
	public static void main(String[] args){
		try {
			
			URL url = new URL("http://10.19.138.106:81/20150729/11000000001310127142_2015_07_29_00_08_20.jpg");
			StringBuilder sb = new StringBuilder().append(',');
			System.err.println(url);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
