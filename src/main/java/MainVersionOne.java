//This is one way to make comments; the computer ignores these

/*
this is another way
to make comments.
This one's multi-line!
 */

/*
In the case Java doesn't know what we're asking for natively,
these imports let this file know where to look to understand
what we're asking it to do
*/
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/*
This is one way of declaring a "Class" in Java. Classes are
difficult to elegantly define, because they can be.. anything.
Ignore 'public' for now
 */
public class MainVersionOne {
  
  /*
  In java-speak, this is called a "main method"
  For our purposes, this is where the code starts
  
  Wnen you right-click and press "Run", java will
  start on the first line after the { symbol
  and will continue to run code until the } symbol
  
  You can ignore what's meant by
  public, static, void, String[], and input
  for now
   */
  public static void main(String[] input) {
    /*
    For selenium to start, it needs to know what kind of browser
    it's using and where to find the browser software on the
    computer it's running on. Scroll down to the code snippet
    with the same name below to find out more about what's
    going on
     */
    tellJavaWhereItCanFindTheToolsItNeedsForChrome();
    
    /*
    Next we're going to start Selenium using Chrome.
    To explain some Java-ness:
    
    The first word here is asking Java to reserve some
    space on the computer for something we're going to use later --
    in this case, a WebDriver
    
    The second word is what we're naming it, so when we use it later
    the code knows what we're talking about
    
    "=" tells Java that we're going to fill in the space that it
    reserved for us with what comes after
    
    We're going to ignore "new" for now, 'cause it's a bit abstract
    But "ChromeDriver()" here means "Build a WebDriver using
    ChromeDriver parts". It's like saying "This garage holds a "car";
    I'm putting a Kia Seltos in it."
     */
    WebDriver driver = new ChromeDriver();
    
    /*
    Now that we have Selenium started in Chrome, we're going to
    customize the size of the window a bit. Because we can.
    Notice that within the parenthesis, we're using the name of
    the Selenium object we just made above.
     */
    positionChrome(driver);

    /*
    Now that we have a Chrome window that's a size we specified,
    let's go visit a website
     */
    driver.get("https://www.google.com");
    
    //Boom. We at google. Let's search for something
    
    /*
    So we want to do a thing within the browser. Selenium is going
    to need to know what we want to do something with and what we want
    to do it. In comes "WebElements".
    
    A "WebElement" is any of these things. Just like ChromeDriver
    is a type of WebDriver (just a more specific TYPE of WebDriver),
    there are more specific types of WebElements. Everything that a
    website shows you (and many things it doesn't) are considered
    "elements". Could be a picture, a line of text, a button, etc.
    
    Since all we're doing is typing and clicking, we don't need
    anything more specific than just "WebElement"
     */
    WebElement searchTextField = findSearchTextFieldElement(driver);
    
    //Now that we have the text field, let's type something into it to search
    searchTextField.sendKeys("Jensen Ackles");
    
    /*
    As a quirk of Java, we don't need to officially declare the object first.
    Since the method returns the WebElement object, we COULD use the sendKeys
    action on the method directly, done like so:

    findSearchTextFieldElement(driver).sendKeys("Jensen Ackles");
     */
    
    
    /*
    In a similar vein, we CAN just perform the action directly from the driver
    
    Here, we're going to press Enter on the search field
    */
    driver.findElement(By.xpath("//input[@aria-label = 'Search']")).sendKeys(Keys.ENTER);
    
    //Now you have a google search for Jensen Ackles.
    
    // We're going to wait 10 seconds then close the window. We'll talk
    // more about sleep/waiting later
    try {
      Thread.sleep(10000);
    } catch (InterruptedException e) {
    
    }
    driver.quit();
  }
  
  /*
  In Java, there will be frequent use of "Methods" like this one.
  In short, whenever I use the name of the method anywhere else
  on this page, what I'm really telling java is "Run everything
  between { and } of the code block below
  
  "private" tells Java that I can ONLY use this method within THIS
  file. Anywhere else and Java won't know what I'm talking about.
  Doing this makes the method take up less space in computer memory
  
  "static" is something we're going to ignore for now
  
  "void" says "when this code is done running, it will return no
  value to you, so don't look for any value when this code is called"
  With some retooling, "void" could be changed to any other object,
  like "String" or "int"
  
  The next bit of text could be literally anything (with a few
  exceptions - no punctuation, dashes, spaces, etc)
  
  The "()" tells Java that nothing extra is needed to run this code.
  If it had Something like (String someText), then whenever I try to
  use this method anywhere else, I MUST give it a "String" object,
  that it will rename to "someText" while it has it.
   */
  private static void tellJavaWhereItCanFindTheToolsItNeedsForChrome() {
    /*
    Since we're using Chrome, we're
    going to first tell java where it can find the chrome
    software. You can ask me more about the System and setProperty
    later when you like.
    
    Spacing often doesn't matter. The different lines here are only used
    to promote readability, hopefully making it easier to understand.
     */
    System.setProperty(
        "webdriver.chrome.driver",
        System.getProperty("user.dir") + "/drivers/chromeDriver"
    );
  }
  
  /*
  Unlike the method above, this method requires a WebDriver to work.
  Try deleting "WebDriver driver" from the parenthesis and see what
  happens.
  
  We COULD create a WebDriver within the body of the method and use
   that instead. What do you think would be the outcome?
   */
  private static void positionChrome(WebDriver driver) {
    // 'int' is short for "Integer". We're making a number that
    // we're going to call 'width' so we that can use it later
    int width = 680;
    
    // Same thing, but this number we're calling 'height'
    int height = 800;
    
    // A "Dimension" is a pair of integers, width and height
    Dimension desiredBrowserWindowSize = new Dimension(width, height);
    
    /*
    The "." after driver is asking Java to use one of the objects
    associated with it. The "manage()" object is a method someone
    else made that's a part of a driver, that has more objects inside
    and so on. We're using the setPosition method to tell Selenium
    where to put the browser window in relation to the computer screen
    
    A point, like a dimension, is a set of two integers, x and y.
    
    What do you think the numbers here represent?
    */
    driver.manage().window().setPosition(new Point(0, 0));
    
    //Similar to above, we're telling Selenium a size for the browser
    driver.manage().window().setSize(desiredBrowserWindowSize);
  }
  
  /*
  Instead of "void", this method finishes by giving back a WebElement.
  To tell Java exactly what the returned WebElement is, we need to use
  the "return" keyword: the line of code that comes right after that
  better result in a WebElement and anything AFTER that return line
  is reached will be ignored
   */
  private static WebElement findSearchTextFieldElement(WebDriver driver) {
    /*
    The WebDriver object is used to find elements, and it has a bunch of
    different ways to do so.
    
    The findElement method is going to go search the XML of the website
    and look for whatever we tell it to. If it's not there, Selenium
    will often crash and the program will stop running. Whoops.
    
    Anyway, we're going to tell it to find an element using the search
    method "By.xpath()". There are couple different ways to search:
    By.tagName(), By.name(), By.id(), and a few others. Xpath is the
    most flexible way to find and object, but also the most complicated.
    Google's pages suck, so to reliably find the search bar, I need an xpath.
     */
    return driver.findElement(
        By.xpath("//input[@title = 'Search']")
    );
  }
  
  
  
}
