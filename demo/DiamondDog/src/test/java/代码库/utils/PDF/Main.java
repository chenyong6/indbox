package 代码库.utils.PDF;

import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Main {
	public static void main(String[] args) {
		try {
			FileOutputStream fileStream;

			// create an API client instance
			Client client = new Client("cypigpsu", "290bb62cafb5ed8db962f3985a132b69");

			// convert a web page and save the PDF to a file
			fileStream = new FileOutputStream("example.pdf");
			client.convertURI("http://example.com/", fileStream);
			fileStream.close();

//			// convert an HTML string and store the PDF into a byte array
//			ByteArrayOutputStream memStream = new ByteArrayOutputStream();
//			String html = "<html><body>In-memory HTML.</body></html>";
//			client.convertHtml(html, memStream);
//
//			// convert an HTML file
//			fileStream = new FileOutputStream("file.pdf");
//			client.convertFile("NewFile.html", fileStream);
//			fileStream.close();

			// retrieve the number of tokens in your account
			Integer ntokens = client.numTokens();
		} catch (PdfcrowdError why) {
			System.err.println(why.getMessage());
		} catch (IOException exc) {
			// handle the exception
		}
	}
}
