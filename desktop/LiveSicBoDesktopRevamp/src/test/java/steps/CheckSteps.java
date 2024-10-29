package steps;

import globals.Variables;
import io.cucumber.java.en.When;
import locators.XPath;
import org.openqa.selenium.WebElement;
import utilities.enums.HandleCollection;
import utilities.handlers.ConditionHandler;
import utilities.handlers.EventHandler;
import utilities.handlers.GetHandler;
import utilities.handlers.WaitHandler;
import utilities.objects.Helper;
import utilities.objects.Printer;

import java.util.List;
import java.util.Objects;

public class CheckSteps {

    @When("I Check {string}")
    public void iCheck(String step) {
        switch (step) {
            // ?  Game Lobby Page
            case "For Any New Announcements In The Game Lobby" -> {
                Variables.hasNewAnnouncement = ConditionHandler.isDisplayed(XPath.GameLobby.NavBar.NewAnnouncementIndicator, 5);
                System.out.println();
                Printer.printInfo("Has New Announcement: " + Variables.hasNewAnnouncement);
            }
            case "For The Announcement Cards Within The Announcement Modal In The Game Lobby" -> {
                if (ConditionHandler.isDisplayed(XPath.GameLobby.Announcement.PinnedAnnouncementCards, 5)) {
                    Variables.pinnedAnnouncementCards = GetHandler.getElements(XPath.GameLobby.Announcement.PinnedAnnouncementCards).size();
                    System.out.println();
                    Printer.printInfo("Pinned Announcement Cards: " + Variables.pinnedAnnouncementCards);
                }
                if (ConditionHandler.isDisplayed(XPath.GameLobby.Announcement.AllAnnouncementCards, 5)) {
                    Variables.allAnnouncementCards = GetHandler.getElements(XPath.GameLobby.Announcement.AllAnnouncementCards).size();
                    System.out.println();
                    Printer.printInfo("All Announcement Cards: " + Variables.allAnnouncementCards);
                }
                if (ConditionHandler.isDisplayed(XPath.GameLobby.Announcement.NewAnnouncementCards, 5)) {
                    Variables.newAnnouncementCards = GetHandler.getElements(XPath.GameLobby.Announcement.NewAnnouncementCards).size();
                    System.out.println();
                    Printer.printInfo("New Announcement Cards: " + Variables.newAnnouncementCards);
                }
            }
            case "For Any Settled Details Within My Bets Modal In The Game Lobby" -> {
                Variables.hasSettledRounds = ConditionHandler.isDisplayed(XPath.GameLobby.MyBets.Settled.HistoryCards, 5);
                System.out.println();
                Printer.printInfo("Has Settled Rounds: " + Variables.hasSettledRounds);
            }
            case "For The Datetime In The Game Lobby" -> {
                Variables.datetime = GetHandler.getText(XPath.GameLobby.Header.getDateTime(Variables.productName));
                System.out.println();
                Printer.printInfo("Datetime: " + Variables.datetime);
            }
            case "For The Username In The Game Lobby" -> {
                EventHandler.click(XPath.GameLobby.NavBar.UserSetting);
                Variables.username = GetHandler.getText(XPath.GameLobby.UserSetting.UserName);
                System.out.println();
                Printer.printInfo("Username: " + Variables.username);
                EventHandler.click(XPath.GameLobby.NavBar.UserSetting);
            }
            case "For The Table Name In The Game Lobby" -> {
                Variables.tableName = GetHandler.getElementByRandom(XPath.GameLobby.Content.getTableNames(Variables.productName)).getText();
                System.out.println();
                Printer.printInfo("Table Name: " + Variables.tableName);
            }
            case "For The Number Of Deals In The Game Lobby" -> {
                WaitHandler.waitVisibility(XPath.GameLobby.Content.getShowTimer(Variables.tableName), Variables.WAIT_PHASE_SECONDS);
                Variables.numberOfDeals = GetHandler.getInt(XPath.GameLobby.Content.getNumberOfDeals(Variables.tableName));
                System.out.println();
                Printer.printInfo("Number Of Deals: " + Variables.numberOfDeals);
            }
            case "For The Latest Results In The Game Lobby" -> {
                List<WebElement> elementsInResultPanel = GetHandler.getElements(XPath.GameLobby.ResultHistory.getLatestResult(Variables.tableName));
                String firstDice = elementsInResultPanel.get(0).getAttribute("class").replaceAll("[^0-9.-]+", "");
                String secondDice = elementsInResultPanel.get(1).getAttribute("class").replaceAll("[^0-9.-]+", "");
                String thirdDice = elementsInResultPanel.get(2).getAttribute("class").replaceAll("[^0-9.-]+", "");
                String totalResult = elementsInResultPanel.get(3).getText();
                String smallOrBig = elementsInResultPanel.get(4).getText();
                String oddOrEven = elementsInResultPanel.get(5).getText();
                Variables.latestResult =  new String[]{firstDice,secondDice, thirdDice, totalResult, smallOrBig, oddOrEven};
                System.out.println();
                Printer.printInfo("Latest Result: " + Helper.toString(Variables.latestResult));
            }
            // ?  Game Table Page
            case "For The Table Name In The Game Table" -> {
                WaitHandler.waitVisibility(XPath.GameTable.Content.ShowTimer, Variables.WAIT_PHASE_SECONDS);
                Variables.tableName = GetHandler.getText(XPath.GameTable.NavBar.TableName);
                System.out.println();
                Printer.printInfo("Table Name: " + Variables.tableName);
            }
            case "For The Round ID In The Game Table" -> {
                WaitHandler.waitVisibility(XPath.GameTable.Content.ShowTimer, Variables.WAIT_PHASE_SECONDS);
                Variables.roundID = GetHandler.getText(XPath.GameTable.NavBar.RoundID);
                System.out.println();
                Printer.printInfo("Round ID: " + Variables.roundID);
            }
            case "For The Table Limit In The Game Table" -> {
                WaitHandler.waitVisibility(XPath.GameTable.Content.ShowTimer, Variables.WAIT_PHASE_SECONDS);
                Variables.tableLimit = GetHandler.getText(XPath.GameTable.NavBar.TableLimit);
                System.out.println();
                Printer.printInfo("Table Limit: " + Variables.tableLimit);
            }
            case "For The Latest Results Within The Jump Table Window In The Game Table" -> {
                WaitHandler.wait(3);
                List<WebElement> elementsInResultPanel = Objects.requireNonNull(GetHandler.getElements(XPath.GameTable.JumpTable.getLatestResult("Table " + Helper.getLastChar(Variables.tableName)), HandleCollection.WithScroll));
                String firstDice = elementsInResultPanel.get(0).getAttribute("class").replaceAll("[^0-9.-]+", "");
                String secondDice = elementsInResultPanel.get(1).getAttribute("class").replaceAll("[^0-9.-]+", "");
                String thirdDice = elementsInResultPanel.get(2).getAttribute("class").replaceAll("[^0-9.-]+", "");
                String totalResult = elementsInResultPanel.get(3).getText();
                String smallOrBig = elementsInResultPanel.get(4).getText();
                Variables.latestResult =  new String[]{firstDice,secondDice, thirdDice, totalResult, smallOrBig};
                System.out.println();
                Printer.printInfo("Latest Result: " + Helper.toString(Variables.latestResult));
            }
            case "For Any New Announcements In The Game Table" -> {
                Variables.hasNewAnnouncement = ConditionHandler.isDisplayed(XPath.GameTable.NavBar.NewAnnouncementIndicator, 5);
                System.out.println();
                Printer.printInfo("Has New Announcement: " + Variables.hasNewAnnouncement);
            }
            case "For The Announcement Cards Within The Announcement Modal In The Game Table" -> {
                if (ConditionHandler.isDisplayed(XPath.GameTable.Announcement.PinnedAnnouncementCards, 5)) {
                    Variables.pinnedAnnouncementCards = GetHandler.getElements(XPath.GameTable.Announcement.PinnedAnnouncementCards).size();
                    System.out.println();
                    Printer.printInfo("Pinned Announcement Cards: " + Variables.pinnedAnnouncementCards);
                }
                if (ConditionHandler.isDisplayed(XPath.GameTable.Announcement.AllAnnouncementCards, 5)) {
                    Variables.allAnnouncementCards = GetHandler.getElements(XPath.GameTable.Announcement.AllAnnouncementCards).size();
                    System.out.println();
                    Printer.printInfo("All Announcement Cards: " + Variables.allAnnouncementCards);
                }
                if (ConditionHandler.isDisplayed(XPath.GameTable.Announcement.NewAnnouncementCards, 5)) {
                    Variables.newAnnouncementCards = GetHandler.getElements(XPath.GameTable.Announcement.NewAnnouncementCards).size();
                    System.out.println();
                    Printer.printInfo("New Announcement Cards: " + Variables.newAnnouncementCards);
                }
            }
            case "For The Other Table Within The Jump Table Window In The Game Table" -> {
                WebElement randomTable = GetHandler.getElementByRandom(XPath.GameTable.JumpTable.InactiveTableCards);
                Variables.tableName = Variables.productName + " " + Helper.getLastChar(randomTable.getAttribute("data-gtm").toUpperCase());
                System.out.println();
                Printer.printInfo("Table Name: " + Variables.tableName);
            }
            case "For The Other Product Table Within The Jump Table Window In The Game Table" -> {
                WebElement randomTable = GetHandler.getElementByRandom(XPath.GameTable.JumpTable.InactiveTableCards);
                Variables.tableName = "Baccarat " + Helper.getLastChar(randomTable.getAttribute("data-gtm").toUpperCase());
                System.out.println();
                Printer.printInfo("Table Name: " + Variables.tableName);
            }
        }
    }

}
