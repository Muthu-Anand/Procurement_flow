package seleniumpackage;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.xml.DOMConfigurator;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import config.Keywords;
import jxl.read.biff.BiffException;
import reportGeneration.HtmlReport;
import utility.ExcelUtil;
import utility.Log;

public class Maxlength {
	public static String filepath = "D:\\project\\Maxlength.xls";
	// C:\Users\pushpakumari.d

	// public static String filepath =
	// "C:\\Users\\pushpakumari.d\\Downloads\\demo.xls";

	public static void main(String[] args)
			throws IOException, InvalidFormatException, InterruptedException, BiffException {

		// ATUTestRecorder recorder;
		BasicConfigurator.configure();

		DOMConfigurator.configure("log4j.xml");
		Keywords.testRepName(filepath);
		Keywords.startTesting();
		/*
		 * DateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss"); Date date =
		 * new Date(0); // Created object of ATUTestRecorders // Provide path to store
		 * videos and file name format. recorder = new
		 * ATUTestRecorder("H:\\ScriptVideos", "Testing-" + dateFormat.format(date),
		 * false); recorder.start();
		 */

		ExcelUtil excelSheet = new ExcelUtil();
		excelSheet.openSheet(filepath);
		Keywords.report.flush();
		File rephtmlFile = new File("D:\\Report\\" + ExcelUtil.ScreenName + Keywords.date + ".html");

		// String filename = "D:\\e drive\\project\\New folder\\REPORT\\" +
		// ExcelUtil.ScreenName + Keywords.date + ".html";

		try {
			Desktop.getDesktop().browse(rephtmlFile.toURI());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		HtmlReport nt = new HtmlReport();

		System.out.println("email process");

		try {
			nt.process();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// recorder.stop();
		Log.info(
				"\n$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$\n"

						+ "\nEXECUTION ENDED"
						+ "\n$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
	}

}
