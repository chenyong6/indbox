package 代码库.utils.POI_JXL;


import java.io.FileOutputStream;

import org.apache.poi.hssf.usermodel.DVConstraint;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFDataValidation;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.util.CellRangeAddressList;


public class JExcel {

	public static void main(String[] args) {
		HSSFWorkbook wb = new HSSFWorkbook();
		HSSFSheet sheet = wb.createSheet("new sheet");
		// 在第一行第一个单元格，插入下拉框
		HSSFRow row = sheet.createRow(0);
		HSSFCell cell = row.createCell(0);
		// 普通写入操作
		cell.setCellValue("请选择");// 这是实验
		// 生成下拉列表
		// 只对(0，0)单元格有效
		CellRangeAddressList regions = new CellRangeAddressList(0, 0, 0, 0);
		// 生成下拉框内容
		DVConstraint constraint = DVConstraint.createExplicitListConstraint(new String[] { "2", "3" });
		// 绑定下拉框和作用区域
		HSSFDataValidation data_validation = new HSSFDataValidation(regions,constraint);
		// 对sheet页生效
		sheet.addValidationData(data_validation);
		// 写入文件
		FileOutputStream fileOut;
		try {
			fileOut = new FileOutputStream("workbook.xls");
			wb.write(fileOut);
			fileOut.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}
		// 结束
		System.out.println("Over");

	}
}
