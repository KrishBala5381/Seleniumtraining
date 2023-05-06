package org.basec;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Baseclass {
	public static WebDriver driver;
	

	public static void launchBrowser() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	}

	public static void windowmaximize() {
		driver.manage().window().maximize();
	}

	public static void launchurl(String url) {
		driver.get(url);
	}

	public static String pagetitle() {
		String title = driver.getTitle();
		return title;

	}

	public static String pageurl() {
		String Url = driver.getCurrentUrl();
		return Url;

	}

	public static void passtext(String txt, WebElement ele) {
		ele.sendKeys(txt);

	}

	public static void closeEntireBrowser() {
		driver.quit();

	}

	public static void clickBtn(WebElement ele) {
		ele.click();

	}

	public static void screenshot(String imgName) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File image = ts.getScreenshotAs(OutputType.FILE);
		File f = new File("location+ imgname.png");
		FileUtils.copyFile(image, f);
	}

	public static Actions a;

	public static void movethecursor(WebElement targetWebElement) {
		a = new Actions(driver);

	}

	public static void dropdown(WebElement dragWebElement, WebElement dropElement) {
		a = new Actions(driver);
		a.dragAndDrop(dragWebElement, dropElement).perform();

	}

	public static JavascriptExecutor js;

	public static void scrollthepage(WebElement tarwebele) {
		js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true)", tarwebele);

	}

	public static void scroll(WebElement element) {
		js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(false)", element);

	}

	public static void excelRead(String sheetname, int rownum, int celnum) throws IOException {
		File f = new File("excellocation.xlsx");
		FileInputStream fle = new FileInputStream(f);
		Workbook wb = new XSSFWorkbook(fle);
		Sheet mysheet = wb.getSheet("data");
		Row r = mysheet.getRow(rownum);
		Cell c = r.getCell(celnum);
		int cellType = c.getCellType();

		String value = " ";
		if (cellType == 1) {
			String value1 = c.getStringCellValue();

		} else if (DateUtil.isCellDateFormatted(c)) {
			Date dd = c.getDateCellValue();
			SimpleDateFormat s = new SimpleDateFormat("dd-mm-yyyy");
			String values = s.format(dd);
			// System.out.println(values);

		} else {
			double e = c.getNumericCellValue();
			long l = (long) e;
			String valueOf = String.valueOf(l);
			// System.out.println(valueOf);
		}
	}

	public static void createNewExleFile(int rowNum, int cellNum, String newData) throws IOException {
		File f = new File("C:\\Users\\admin\\eclipse-workspace\\maveninstallation\\excel\\file1.xlsx");
		Workbook w = new XSSFWorkbook();
		Sheet newSheet = w.createSheet("data");
		Row newRow = newSheet.createRow(rowNum);
		Cell newCell = newRow.createCell(cellNum);
		newCell.setCellValue(newData);
		FileOutputStream fos = new FileOutputStream(f);
		w.write(fos);
	}

	public static void createRow(int rowNum, int cellNum, String newData) throws IOException {
		File f = new File("C:\\Users\\admin\\eclipse-workspace\\maveninstallation\\excel\\file1.xlsx");
		FileInputStream fis = new FileInputStream(f);
		Workbook w = new XSSFWorkbook(fis);
		Sheet s = w.getSheet("data");
		Row r = s.createRow(rowNum);
		Cell c = r.createCell(cellNum);
		c.setCellValue(newData);
		FileOutputStream fos = new FileOutputStream(f);
		w.write(fos);
	}

	public static void createCell(int rowNum, int cellNum, String newData) throws IOException {
		File f = new File("C:\\Users\\admin\\eclipse-workspace\\maveninstallation\\excel\\file1.xlsx");
		FileInputStream fis = new FileInputStream(f);
		Workbook w = new XSSFWorkbook(fis);
		Sheet s = w.getSheet("data");
		Row r = s.createRow(rowNum);
		Cell c = r.createCell(cellNum);
		c.setCellValue(newData);
		FileOutputStream fos = new FileOutputStream(f);
		w.write(fos);
	}

	public static void updateDataToParticularCell(int getTheRow, int getTheCell, String exisitingData,
			String writeNewData) throws IOException {
		File f = new File("C:\\Users\\admin\\eclipse-workspace\\maveninstallation\\excel\\file1.xlsx");
		FileInputStream fis = new FileInputStream(f);
		Workbook wb = new XSSFWorkbook(fis);
		Sheet s = wb.getSheet("data");
		Row r = s.getRow(getTheRow);
		Cell c = r.getCell(getTheCell);
		String str = c.getStringCellValue();
		if (str.equals(exisitingData)) {
			c.setCellValue(writeNewData);
		}
		FileOutputStream fos = new FileOutputStream(f);
		wb.write(fos);

	}
}
