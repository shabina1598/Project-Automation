package utility;

import java.util.List;

import org.openqa.selenium.WebElement;

public class TableUtility {
	

    /**
     * Utility method to check if a specific text is present in a list of table rows
     */
    public static boolean isTextPresentInTable(List<WebElement> tableRows, String searchText) {
        for (WebElement row : tableRows) {
            String rowText = row.getText();
            if (rowText.contains(searchText)) {
                System.out.println("Found Row: " + rowText);
                return true;
            }
        }
        return false;
    }

}
