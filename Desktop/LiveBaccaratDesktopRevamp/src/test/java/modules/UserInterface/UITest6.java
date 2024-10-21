package modules.UserInterface;

import globals.Variables;
import locators.XPath;
import utilities.handlers.VerificationHandler;

public class UITest6 {

    public static void verify() {
        System.out.println();
        System.out.println("Module: USER INTERFACE");
        System.out.println("Test Case: 6");
        System.out.println("Actual Results: ");

        VerificationHandler.verifyIfDisplayed(
                "UI Test 6",
                XPath.GameTable.RoundResult.PlayerCards,
                Variables.WAIT_PHASE_SECONDS
        );

        VerificationHandler.verifyIfDisplayed(
                "UI Test 6",
                XPath.GameTable.RoundResult.BankerCards,
                Variables.WAIT_PHASE_SECONDS
        );

        VerificationHandler.verifyIfDisplayed(
                "UI Test 6",
                XPath.GameTable.RoundResult.WinResult,
                Variables.WAIT_PHASE_SECONDS
        );

        VerificationHandler.verifyIfDisplayed(
                "UI Test 6",
                XPath.GameTable.RoundResult.PlayerTotalPoints,
                Variables.WAIT_PHASE_SECONDS
        );

        VerificationHandler.verifyIfDisplayed(
                "UI Test 6",
                XPath.GameTable.RoundResult.BankerTotalPoints,
                Variables.WAIT_PHASE_SECONDS
        );

        VerificationHandler.verifyIfDisplayed(
                "UI Test 6",
                XPath.GameTable.BettingOption.WinBettingOptions,
                Variables.WAIT_PHASE_SECONDS
        );

        System.out.println();
    }

}
