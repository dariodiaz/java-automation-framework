package com.itx.framework.utilities;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class LogUtil {

    ZonedDateTime date =  ZonedDateTime.now();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("ddMMyyyyHHmmss");
    String fileNameFormat = date.format(formatter);

    private BufferedWriter bufferedWriter = null;

    //Create log file
    public void CreateLogFile() {
        try {
            File dir = new File("/home/dario/Code/Automation/itx-automation-framework-with-selenium/UdemyCourse_Design/UdemyCourse/src/test/resources/Logs");
            if(!dir.exists())
                dir.mkdir();

            //Create file
            File logFile = new File(dir + "/" + fileNameFormat + ".log");
            FileWriter fileWriter = new FileWriter(logFile.getAbsoluteFile());
            bufferedWriter = new BufferedWriter(fileWriter);
        } catch(Exception e) {

        }
    }

    //Write message within the log
    public void Write(String message) {
        try {
            bufferedWriter.write(message);
            bufferedWriter.close();
        } catch (Exception e) {

        }
    }
}
