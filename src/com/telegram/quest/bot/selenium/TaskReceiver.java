package com.telegram.quest.bot.selenium;

import com.telegram.quest.bot.sender.TelegramMessageSendable;
import com.telegram.quest.bot.sender.TelegramMessageSender;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

/**
 * Created by Daria_Ivanova2 on 8/23/2016.
 */
public class TaskReceiver {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("http://dp.en.cx/");
         driver.manage().window().maximize();
        WebElement enterLink = driver.findElement(By.id("ctl14_ctl04_ctl00_lnkLogin"));
        enterLink.click();
        Thread.sleep(10);

        WebElement login = driver.findElement(By.id("txtLogin"));
        WebElement pswd = driver.findElement(By.id("txtPassword"));
        login.sendKeys("ocmhbr");
        pswd.sendKeys("ocmhbr555235");
        pswd.sendKeys(Keys.ENTER);
        Thread.sleep(20);
        driver.get("http://dp.en.cx/GameDetails.aspx?gid=47955");
        WebElement enterGame = driver.findElement(By.xpath("//*[@id='GameDetail_GameEnterBox_divEnterGameHolder']/a"));
        enterGame.click();
        Thread.sleep(10);
        List<WebElement> elements = driver.findElements(By.xpath("//*[text()='Задание']/following-sibling::*"));
        ////*[@class='content']/h2[1]
        WebElement levelName = driver.findElement(By.xpath("//*[@class='content']/h2[1]"));

        String task = "";
        for (WebElement element : elements) {
            task += element.getText()+"\n";
        }
        String p = driver.findElement(By.xpath("//div[@class='content']")).getText();
        System.out.println(p);
        TelegramMessageSendable sender = new TelegramMessageSender();
        sender.send(p);
        System.out.println(task);
    }
/*
        String b = "http://dp.en.cx/GameDetails.aspx?gid=47955";
        WebElement header = driver.findElement(By.xpath("/html/body/div/div[3]/h2"));
        WebDriverWait waiter = new WebDriverWait(driver, 100000);
        waiter.until(ExpectedConditions.stalenessOf(header));
        String c = driver.findElement(By.tagName("p")).getText();*/
    }

