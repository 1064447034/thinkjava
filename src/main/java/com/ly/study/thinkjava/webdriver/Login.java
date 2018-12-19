package com.ly.study.thinkjava.webdriver;

import java.awt.AWTException;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;
import javax.imageio.ImageReadParam;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Login {
	public static void main(String[] args) throws Exception {
		System.setProperty("webdriver.chrome.driver", "D:\\webdriver\\chromedriver.exe");

		WebDriver driver;
		boolean proxy = true;
		if (proxy) {
			ChromeOptions options = new ChromeOptions();
			options.addExtensions(new File("D:\\MyConfiguration\\zbs39170\\Desktop\\proxy.zip"));
			
			driver = new ChromeDriver(options);
		} else {
			driver = new ChromeDriver();
		}
		driver.manage().window().maximize();
		
		driver.get("http://www.shenzhenair.com/");	// for debug

//		login(driver);
		
//		queryOrder(driver);
		
		searchFlight(driver);
		
		addPassenger(driver);
		
		submitOrder(driver);
		
		applyPay(driver);

	}
	
	public static void login(WebDriver driver) throws Exception {
		driver.get("http://www.shenzhenair.com/");
		
		new WebDriverWait(driver, 15).until(
				ExpectedConditions.presenceOfElementLocated(By.id("js-login"))
		);

		for (int i = 0; i < 20; ++i) {
			driver.findElement(By.id("js-login")).click();
			
//			String style = driver.findElement(By.id("login_layout")).getAttribute("style");
//			if (style.contains("display:none;")) {
			if (!driver.findElement(By.id("login_layout")).isDisplayed()) {
				TimeUnit.MILLISECONDS.sleep(500);
			} else {
				break;
			}
		}
		getLoginCaptcha(driver);

//		JavascriptExecutor js = (JavascriptExecutor) driver;
//		js.executeScript("javascript:changeImg('login_yzm_img1');");

		driver.findElement(By.id("userName1")).sendKeys("15358441268");
		driver.findElement(By.id("password1")).sendKeys("Hl15358441268");
		
		WebElement captchaWebElement = driver.findElement(By.id("verifyCode1"));
		captchaWebElement.sendKeys("xb5d");
		
		WebElement loginWebElement = driver.findElement(By.id("login_in1")); 
		loginWebElement.click();

		// 处理验证码错误
		try {
			driver.findElement(By.cssSelector("ul#loginByNormal li#verifyCode_error_msg"));
			captchaWebElement.clear();
			captchaWebElement.sendKeys("513i");		// 重新输入验证码
			loginWebElement.click();
		} catch (Exception e) {
			System.out.println("登录成功");
		}

		// 登录成功，弹窗处理
		WebElement noBindWebElement = driver.findElement(By.cssSelector("div#noPhoenixInfo"));
		WebElement isBindPhoenWebElement = driver.findElement(By.cssSelector("div#isBindPhoenix"));
		WebElement isBindMemberWebElement = driver.findElement(By.cssSelector("div#isBindMember"));

		try {
			Boolean isPopUp = new WebDriverWait(driver, 5).until(
					ExpectedConditions.or(ExpectedConditions.visibilityOf(noBindWebElement),
										  ExpectedConditions.visibilityOf(isBindPhoenWebElement), 
										  ExpectedConditions.visibilityOf(isBindMemberWebElement))
			);
//			System.out.println(isPopUp);	// true 找到 false未找到
			
			if (noBindWebElement.isDisplayed()) {
				noBindWebElement.findElement(By.cssSelector("input#cancelBindPhoenix")).click();
			} else if (isBindPhoenWebElement.isDisplayed()) {
				isBindPhoenWebElement.findElement(By.cssSelector("div#isBindPhoenix input#cancelBind")).click();
			} else if (isBindMemberWebElement.isDisplayed()) {
				isBindMemberWebElement.findElement(By.cssSelector("div#isBindMember input#cancelBind")).click();
			}			
		} catch (TimeoutException e) {
			System.out.println("登录无弹窗");
		}

		System.out.println(isLogin(driver));
		
		System.out.println(isLogin(driver, "15358441268"));

	}
	
	// 任意账户已登录
	// 已登录：display: none;
	// 未登录：display:block
	public static boolean isLogin(WebDriver driver) {
		return !driver.findElement(By.id("p1")).isDisplayed();
	}
	
	// 特定账户已登录
	public static boolean isLogin(WebDriver driver, String username) {
//		driver.findElement(By.cssSelector("div.top a#personalID"))
		boolean isLogin = false;
		try {
//			driver.findElement(By.xpath("div[@class='top']/a[@id='personalID' and text()='" + username + "']"));
			driver.findElement(By.xpath("//div[@class='top']//a[@id='personalID' and text()='" + username + "']"));
			isLogin = true;
		} catch (Exception e) {
			isLogin = false;
		}
		return isLogin;
	}
	
	public static void getLoginCaptcha(WebDriver driver) throws IOException, AWTException {
		File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
        //利用FileUtils工具类的copyFile()方法保存getScreenshotAs()返回的文件对象。
        FileUtils.copyFile(srcFile, new File("e:\\screenshot.png"));
        
        WebElement captchaWebElement = driver.findElement(By.id("login_yzm_img1"));
        Point point = captchaWebElement.getLocation();
        int left = point.getX();
        int top = point.getY();
        int right = captchaWebElement.getSize().getWidth();
        int bottom = captchaWebElement.getSize().getHeight();
        
        Iterator<ImageReader> iterator = ImageIO.getImageReadersByFormatName("PNG");/*PNG,BMP*/
        ImageReader reader = iterator.next();/*获取图片尺寸*/ 
        InputStream inputStream = new FileInputStream("e:\\screenshot.png");   
        ImageInputStream iis = ImageIO.createImageInputStream(inputStream);
        reader.setInput(iis, true);
        
        ImageReadParam param = reader.getDefaultReadParam();
        Rectangle rectangle = new Rectangle(left, top, right, bottom);/*指定截取范围*/      
        param.setSourceRegion(rectangle);     
        BufferedImage bi = reader.read(0,param);   
        ImageIO.write(bi, "PNG", new File("e:\\out.png"));
	}
	
	public static void searchFlight(WebDriver driver) {
		new WebDriverWait(driver, 15).until(
			ExpectedConditions.textToBePresentInElementValue(By.id("orgCity"), "请输入城市")
		);

		driver.findElement(By.id("orgCity")).sendKeys("深圳");
		driver.findElement(By.id("dstCity")).sendKeys("海口");
		driver.findElement(By.id("orgDate")).clear();
		driver.findElement(By.id("orgDate")).sendKeys("2018-02-10");
		
		WebElement blank = driver.findElement(By.xpath("//*[@id='js-ticket']/ul/li[3]/span[1]"));
		blank.click();

		// 等待日期弹窗消失
		new WebDriverWait(driver, 10).until(
				ExpectedConditions.attributeContains(By.id("orgDateDIV"), "style", "display: none")
		);

		WebElement search = driver.findElement(By.xpath("//*[@id='search-flight']"));
		search.click();

		// 等待查询结果
		new WebDriverWait(driver, 10).until(
				ExpectedConditions.presenceOfElementLocated(By.id("priceListDC"))
		);
		
		// 抱歉，该日期无座位或航班。
		String warning = driver.findElement(By.id("priceListDC")).getText();
		if (warning.contains("抱歉，该日期无座位或航班。")) {
			System.out.println("抱歉，该日期无座位或航班。");
			return;
		}
		
		List<WebElement> flightsWebElement = driver.findElements(By.xpath("//*[@class='flightInfo']"));
		System.out.println(flightsWebElement.size());
		
		ListIterator<WebElement> flightIter = flightsWebElement.listIterator();
		while (flightIter.hasNext()) {
			WebElement flightWebElement = flightIter.next();
			
			WebElement flightNoWebElement = flightWebElement.findElement(By.xpath(".//div[@class='desig']"));
			String flightNo = flightNoWebElement.getText();
			System.out.println(flightNo);
			
			if (!flightNo.equals("ZH9317")) {
				continue;
			}
			
			// 没有找到所有价格按钮，表示售罄
			try {
				flightWebElement.findElement(By.cssSelector("dd.btn_all"));
			} catch (Exception e) {
				System.out.println("售罄");
				return;
			}
			
			flightWebElement.findElement(By.cssSelector("dd.btn_all")).click();	// 点击展开所有价格
			
			List<WebElement> cabinsWebElement = flightWebElement.findElements(By.xpath(".//div[@class='all_price']/div[@class='all_price_item classInfo']"));
			
// 			WebElement allPriceWebElement = flightWebElement.findElement(By.xpath("//div[@class='all_price']"));
//			List<WebElement> cabinsWebElement = allPriceWebElement.findElements(By.xpath("//*[@class='all_price_item classInfo']"));
//			ListIterator<WebElement> cabinIter = cabinsWebElement.listIterator();
			ListIterator<WebElement> cabinIter = cabinsWebElement.listIterator(cabinsWebElement.size());
//			while (cabinIter.hasNext()) {
//			WebElement cabinElement = cabinIter.next();
			
			boolean booking = false;
			while (cabinIter.hasPrevious()) {
				WebElement cabinElement = cabinIter.previous();
				
//				WebElement element = cabinElement.findElement(By.xpath("//p[@class='sy']"));
				WebElement element = cabinElement.findElement(By.cssSelector("p.sy"));
		        Actions builder2 = new Actions(driver);
		        builder2.moveToElement(element).build().perform();
		        
//				String priceText = cabinElement.findElement(By.xpath("//p[@class='jg']")).getText();// ￥5060
				String priceText = cabinElement.findElement(By.cssSelector("p.jg")).getText();		// ￥5060
				String price = StringUtils.replace(priceText, "￥", "");

				String seatNumText = cabinElement.findElement(By.cssSelector("p.sy")).getText();				// 剩余座位:6
//				String seatNumText = cabinElement.findElement(By.xpath("//p[@class='sy']")).getText();	// 剩余座位:6
				String seatNum = StringUtils.replace(seatNumText, "剩余座位:", "");
				if (seatNum.contains(">")) {
					seatNum = "10";
				}
		        
//				String cabinText = cabinElement.findElement(By.xpath("//span[@class='cw']")).getText();		// F舱
		        String cabinText = cabinElement.findElement(By.cssSelector("span.cw")).getText();			// F舱
				String cabin = StringUtils.replace(cabinText, "舱", "");

				if (!cabin.equals("F")) {
					continue;
				}
				try {
					cabinElement.findElement(By.cssSelector("a.yd_btn.booking strong")).click();	// 预定
					booking = true;
				} catch (Exception e) {
					System.out.println("点预定按钮失败");
				}
				break;
			}

			if (booking) {
				driver.findElement(By.cssSelector("div.btn_area.nextButton a#jsNext")).click();	// 下一步
				break;
			} else {
				return;
			}
		}
	}
	
	public static void addPassenger(WebDriver driver) {
		List<Passenger> passengers = new ArrayList<>();
		
		Passenger passenger1 = new Passenger();
		passenger1.setBirthday("1993-01-27");
		passenger1.setCertNo("152201199201273025");
		passenger1.setCertType("ID");
		passenger1.setPassengerName("王丹");
		passenger1.setPassengerType("ADULT");
        
		passenger1.setContactName("吴基荣");
		passenger1.setContactMobile("15995721676");
		
		Passenger passenger2 = new Passenger();
		passenger2.setBirthday("2012-10-14");
		passenger2.setCertNo("E80145360");
		passenger2.setCertType("PP");
		passenger2.setPassengerName("黄雅岚");
		passenger2.setPassengerType("CHILD");
		
		Passenger passenger3 = new Passenger();
		passenger3.setBirthday("1993-10-02");
		passenger3.setCertNo("430626199310025113");
		passenger3.setCertType("NI");
		passenger3.setPassengerName("刘家兴");
		passenger3.setPassengerType("ADULT");
		
		
//		passengers.add(passenger1);
		passengers.add(passenger2);
		passengers.add(passenger3);
		
		addOnePassenger(driver, passengers.get(0), 0);
		for (int i = 1; i < passengers.size(); ++i) {
			driver.findElement(By.cssSelector("a.btn-add")).click();
			addOnePassenger(driver, passengers.get(i), i);
		}

		driver.findElement(By.cssSelector("input[name='contactsName']")).sendKeys(passengers.get(0).getContactName());
		driver.findElement(By.cssSelector("input[name='contactsMobile']")).sendKeys(passengers.get(0).getContactMobile());

		driver.findElement(By.cssSelector("a#saveOrder")).click();	// 保存订单
		
	}
	
	private static void submitOrder(WebDriver driver) {
		// 直到弹出乘客信息对话框
		new WebDriverWait(driver, 10).until(
				ExpectedConditions.attributeContains(By.id("orderConfirm"), "style", "display: block")
		);
		
		driver.findElement(By.cssSelector("div.passenger_info input.check")).click();	// 复选框
		driver.findElement(By.cssSelector("input.getPhoneCode")).click();				// 发短信
		driver.findElement(By.cssSelector("input.captchaInput")).sendKeys("abcdef");
		driver.findElement(By.cssSelector("a#submitOrder")).click();
	}
	
	public static void applyPay(WebDriver driver) {
		List<WebElement> wes = driver.findElements(By.cssSelector("div.pay ul.pay_top a"));
		for (WebElement w : wes) {
			if (w.getText().equals("第三方支付")) {
				w.click();
				break;
			}
		}

		driver.findElement(By.cssSelector("div.pay_down li[bankid='alipay']")).click();

		driver.findElement(By.cssSelector("div.pay_down li.bank_info.third.bank_info_clone a.doPay")).click();
		
		
		String curPageHandlers = driver.getWindowHandle();
		Set<String> aliPayHandlers = driver.getWindowHandles();
		for (String s : aliPayHandlers) {
			if (!s.equals(curPageHandlers)) {
				driver.switchTo().window(s);
				break;
			}
		}
		
		driver.findElement(By.cssSelector("input[name='loginId']")).sendKeys("13456524239");
		driver.findElement(By.id("payPasswd_rsainput")).sendKeys("12345678");
		driver.findElement(By.id("J_pay_btn")).click();
	}
	
	private static void addOnePassenger(WebDriver driver, Passenger passenger, int index) {
		WebElement paassengerWebElement = driver.findElement(By.cssSelector("div#passenger" + String.valueOf(index)));

		List<WebElement> paassengerListWebElement = paassengerWebElement.findElements(By.cssSelector("span.sel-in.uiueSelectDisSpan"));
		for (WebElement w : paassengerListWebElement) {
			System.out.println(w.getText());
			if (w.getText().equals("成人票")) {
				w.click();
				break;
			}
		}
//		WebElement paassengerListWebElement = paassengerWebElement.findElement(By.cssSelector("span.sel-in.uiueSelectDisSpan"));
//		if (paassengerListWebElement.getText().equals("成人票")) {
//			paassengerListWebElement.click();
//		}
		
		if (passenger.getPassengerType().equals("ADULT")) {
			driver.findElement(By.cssSelector("div#passenger" + String.valueOf(index))).findElement(By.xpath(".//span[@val='0' and text()='成人票']")).click();
		} else if (passenger.getPassengerType().equals("CHILD")) {
			driver.findElement(By.cssSelector("div#passenger" + String.valueOf(index))).findElement(By.xpath(".//span[@val='1' and text()='儿童票']")).click();
			driver.findElement(By.cssSelector("input#birthday" + String.valueOf(index))).sendKeys(passenger.getBirthday());;
		} else if (passenger.getPassengerType().equals("INFANT")) {
			driver.findElement(By.cssSelector("div#passenger" + String.valueOf(index))).findElement(By.xpath(".//span[@val='2' and text()='婴儿票']")).click();
		}

		List<WebElement> passengerTypeList = paassengerWebElement.findElements(By.cssSelector("span.sel-in.uiueSelectDisSpan"));
		for (WebElement w : passengerTypeList) {
			System.out.println(w.getText());
			if (w.getText().equals("身份证")) {
				w.click();
				break;
			}
		}
		if (passenger.getCertType().equals("NI")) {
			driver.findElement(By.cssSelector("div#passenger" + String.valueOf(index))).findElement(By.xpath(".//span[@val='0' and text()='身份证']")).click();
		} else if (passenger.getCertType().equals("PP")) {
			driver.findElement(By.cssSelector("div#passenger" + String.valueOf(index))).findElement(By.xpath(".//span[@val='1' and text()='护照']")).click();
		} else if (passenger.getCertType().equals("ID")) {
			driver.findElement(By.cssSelector("div#passenger" + String.valueOf(index))).findElement(By.xpath(".//span[@val='9' and text()='其他']")).click();
		}

		paassengerWebElement.findElement(By.cssSelector("input[name='passengerName']")).sendKeys(passenger.getPassengerName());
		paassengerWebElement.findElement(By.cssSelector("input[name='certNo']")).sendKeys(passenger.getCertNo());
	}
	
	public static void queryOrder(WebDriver driver) throws IOException {
		driver.findElement(By.xpath("//ul[@class='nav']//a"));
		WebElement headMenu = driver.findElement(By.xpath("//ul[@class='nav']//a[text()='预订管理']"));
        Actions builder2 = new Actions(driver);
        builder2.moveToElement(headMenu).build().perform();
        
        driver.findElement(By.xpath("//a[text()='订单管理']")).click();

        String indexPageHandle = driver.getWindowHandle();
        Set<String> handles = driver.getWindowHandles();
        for (String h : handles) {
        	if (!h.equals(indexPageHandle)) {
        		driver.switchTo().window(h);
        		break;
        	}
        }
        
        driver.findElement(By.cssSelector("div.r_area1 input#flightDate")).sendKeys("2018-02-17");
        driver.findElement(By.id("orgCity")).sendKeys("SZX");
        driver.findElement(By.id("dstCity")).sendKeys("HFE");
        
        driver.findElement(By.xpath("//span[text()='到达城市：']")).click();
        
        driver.findElement(By.xpath("//form[@id='OrderSearchAction']//a[contains(text(), '查询订单信息')]")).click();
        
        String orderSearchListSource = driver.getPageSource();
        
        String airlineOrderNo = "2018020826125208";
        Document orderListDoc = Jsoup.parse(orderSearchListSource);
        Elements orderDetail =  orderListDoc.select("table#displayTable tr[onclick=viewPassengerinfo('" + airlineOrderNo + "')]");
        if (!orderDetail.isEmpty()) {
            System.out.println(orderDetail.get(0).select("td").get(0).text()); // 2018020726119397
            System.out.println(orderDetail.get(0).select("td").get(1).text()); // 深圳——海口
            System.out.println(orderDetail.get(0).select("td").get(2).text()); // 2018-02-18
            System.out.println(orderDetail.get(0).select("td").get(3).text()); // 2018-02-07 18:53:58
            System.out.println(orderDetail.get(0).select("td").get(4).text()); // 张三亭
            System.out.println(orderDetail.get(0).select("td").get(5).text()); // 已取消
            System.out.println(orderDetail.get(0).select("td").get(6).text()); // 1430
        }

//      driver.close();
//      driver.switchTo().window(indexPageHandle);
//      WebElement we = driver.findElement(By.xpath("//ul[@class='nav']//a"));
        driver.findElement(By.cssSelector("table#displayTable a.underline")).click();
        String orderDetailPage = driver.getPageSource();
        
    	Document orderDetailDoc = Jsoup.parse(orderDetailPage);
		Elements passengerItem = orderDetailDoc.select("div.tinfo_box div.tinfo_item2 div.l_side");
		for (Element e : passengerItem) {
			System.out.println(e.select("span").get(0).text());	// 广州---济南：梁兆辉     成人
			System.out.println(e.select("span").get(1).text());	// 票号：479-2126904319
			System.out.println(e.select("span").get(2).text());	// 身份证： 371522198605067213
		}
	}
	
/*
	@Test
	public void parse() throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("E:\\orderList.txt"));
		String page = "";
		String line = "";
		
		while ((line = br.readLine()) != null) {
			page += line;
		}
		
		String airlineOrderNo = "2018020726119397";
		Document doc = Jsoup.parse(page);
		Elements order = doc.select("tr[onclick=viewPassengerinfo('2018020726119397')]");

		Elements orderDetail =  doc.select("table#displayTable tr[onclick=viewPassengerinfo('" + airlineOrderNo + "')]");
        if (!orderDetail.isEmpty()) {
            System.out.println(orderDetail.get(0).select("td").get(0).text());
            System.out.println(orderDetail.get(0).select("td").get(1).text());
            System.out.println(orderDetail.get(0).select("td").get(2).text());
            System.out.println(orderDetail.get(0).select("td").get(3).text());
            System.out.println(orderDetail.get(0).select("td").get(4).text());
            System.out.println(orderDetail.get(0).select("td").get(5).text());
            System.out.println(orderDetail.get(0).select("td").get(6).text());
        }
	}

	@Test
	public void parseOrderDetail() throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("E:\\orderDetail_2.txt"));
		String page = "";
		String line = "";
		
		while ((line = br.readLine()) != null) {
			page += line;
		}
		
		Document doc = Jsoup.parse(page);
		Elements passengerItem = doc.select("div.tinfo_box div.tinfo_item2 div.l_side");
		for (Element e : passengerItem) {
			System.out.println(e.select("span").get(0).text());	// 广州---济南：梁兆辉     成人
			System.out.println(e.select("span").get(1).text());	// 票号：479-2126904319
			System.out.println(e.select("span").get(2).text());	// 身份证： 371522198605067213
		}
	}
*/
}


