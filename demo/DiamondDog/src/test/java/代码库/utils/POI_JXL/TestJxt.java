package 代码库.utils.POI_JXL;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;

import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableHyperlink;
import jxl.write.WritableImage;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

import org.apache.poi.common.usermodel.Hyperlink;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFClientAnchor;
import org.apache.poi.hssf.usermodel.HSSFHyperlink;
import org.apache.poi.hssf.usermodel.HSSFPatriarch;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.util.CellRangeAddress;

/**
 * POI导出Excel文件
 * @author shaohua.zou
 *
 * @version 2013-9-16 下午1:41:18
 */
public class TestJxt {

 /**
  * @param args
 * @throws IOException 
  */
 public static void main(String[] args) throws Exception {
  excelExport();
 }

 public static void excelExport() throws IOException, RowsExceededException, WriteException {
	 WritableWorkbook wwb = null;
	 File f = new File("D:/日报.xls");
	 if(f.exists())f.delete();
	 wwb = Workbook.createWorkbook(f);
	 WritableSheet sheet = wwb.createSheet("test", 0);
	 
	 for(int r = 0 ;r < 10 ; r++){
		 if(r != 0){
			 if(r % 2 == 1)
				 sheet.mergeCells(2, r, 2, r+1);
			 
		 }
		 
	 }
	// File fimg = new File("C:\\Users\\chenyong6\\Pictures\\pic\\Chrysanthemum.jpg");
	  ByteArrayOutputStream byteArrayOut = null ; 
      BufferedImage bufferImg =null; 
      URL url = new URL("http://10.19.138.106:81/20150729/11000000001310124511_2015_07_29_00_06_33.jpg");
      //File f1 = new File(jpgUrls[(c-3)/2]);
      //bufferImg = ImageIO.read(url.openStream());
      bufferImg = ImageIO.read(url.openStream());
      byteArrayOut = new ByteArrayOutputStream(); 
      ImageIO.write(bufferImg, "jpg", byteArrayOut);
	 WritableImage wimg = new WritableImage(2, 3, 1, 2, byteArrayOut.toByteArray());
	 sheet.addImage(wimg);
	 sheet.setColumnView(0, 10);
	  WritableHyperlink link = new WritableHyperlink(0, 0, new URL("http://10.19.138.106:81/20150729/11000000001310124511_2015_07_29_00_06_33.jpg"));
	  link.setDescription("链接");
	  sheet.addCell(new Label(0, 0 , "图片超链接"));
	  sheet.addHyperlink(link);
	 wwb.write();
	 wwb.close();
 }
}