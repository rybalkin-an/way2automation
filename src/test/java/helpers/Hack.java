package helpers;

public class Hack {

    /**
     * hack for Method waitLoadingQuickContactForm from MainPage
     * iFrame has different index in different browsers
     * @param browserName from BaseTest parameters
     * @return 0 if browserName is Firefox
     */
    public int getIndex(String browserName) {
        int index = 2;
        if (browserName.equals("firefox"))
            index = 0;
        return index;
    }
}
