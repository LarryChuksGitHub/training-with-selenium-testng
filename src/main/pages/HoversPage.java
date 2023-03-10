package main.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class HoversPage {
    private WebDriver webDriver;
    private By figureBox = By.className("figure");
    private By figureCaption = By.className("figcaption");

    public HoversPage(WebDriver webDriver){
        this.webDriver = webDriver;
    }

    /**
     *
     * @param index Statrs with 1
     */
    public FigureCaption hoverOverFigure(int index){
        WebElement figureElement = webDriver.findElements(figureBox).get(index -1);
        Actions actions = new Actions(webDriver);
        actions.moveToElement(figureElement).perform();
        return new FigureCaption(figureElement.findElement(figureCaption));

    }
    public class FigureCaption{

        private WebElement caption ;
        private By header = By.tagName("h5");
        private By link = By.tagName("a");
        public FigureCaption(WebElement caption){
            this.caption = caption;
        }

        public boolean isCaptionDisplayed(){
            return caption.isDisplayed();
        }
        public String getTitle(){
            return caption.findElement(header).getText();
        }
        public String getLink(){
            return caption.findElement(link).getAttribute("href");
        }
        public String getLinkText(){
            return caption.findElement(link).getText();
        }
    }
}
