package com.itx.framework.utilities;

import org.openqa.selenium.Platform;

public class ExcelDataFile {

    private static String testDataExcelFileName; //Global test data excel file
    private static final String currentDir = System.getProperty("user.dir");  //Main Directory of the project
    private static String testDataExcelPath = null;

    public ExcelDataFile(String fileName) {
        this.testDataExcelFileName = fileName;
    }

    public String getDataFileFullName() {
        if (isLinux() || isMac()) {
            return testDataExcelPath = currentDir + "/src/test/resources/" + testDataExcelFileName;
        }

        return testDataExcelPath = currentDir + "\\src\\test\\resources\\" + testDataExcelFileName;

    }

    private boolean isMac() {
        return Platform.getCurrent().toString().equalsIgnoreCase("MAC");
    }

    private boolean isLinux() {
        return Platform.getCurrent().toString().equalsIgnoreCase("LINUX");
    }

    private boolean isWindows() {
        return Platform.getCurrent().toString().contains("WIN");
    }
}
