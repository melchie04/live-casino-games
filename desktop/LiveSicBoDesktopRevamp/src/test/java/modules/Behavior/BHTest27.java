package modules.Behavior;

import locators.XPath;
import utilities.handlers.ConditionHandler;
import utilities.objects.CustomAssert;

public class BHTest27 {

    public static void verify() {
        System.out.println();
        System.out.println("Module: BEHAVIOR");
        System.out.println("Test Case: 27");
        System.out.println("Actual Results: ");

        CustomAssert.assertFalse(
                "BH Test 27",
                ConditionHandler.isDisplayed(XPath.GameTable.MyBets.DefaultTab, 1),
                "The Running Tab is highlighted.",
                "The Running Tab is not highlighted."
        );

        System.out.println();
    }

}
