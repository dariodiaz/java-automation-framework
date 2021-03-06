package com.itx.framework.utilities;

import java.io.File;
import java.io.IOException;
import java.util.Hashtable;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class ExcelUtil {

    static Sheet wrksheet;
    static Workbook wrkbook =null;
    static Hashtable dict= new Hashtable();
    
    public ExcelUtil(String fileName, String sheetName) throws BiffException, IOException {

        ExcelDataFile xlsDataFile = new ExcelDataFile(fileName);

        wrkbook = Workbook.getWorkbook(new File(xlsDataFile.getDataFileFullName()));
        wrksheet = wrkbook.getSheet(sheetName);

        //Call the Column Dictionary to store column Names
        ColumnDictionary();
    }

    public static int RowCount()
    {
        return wrksheet.getRows();
    }

    //Returns the Cell value by taking row and Column values as argument
    private static String ReadCell(int column, int row)
    {
        return wrksheet.getCell(column,row).getContents();
    }

    public static String ReadCell(String columnName, int rowNumber) {
        return ReadCell(GetCell(columnName), rowNumber);
    }

    //Create Column Dictionary to hold all the Column Names
    private static void ColumnDictionary()
    {
        for(int col=0;col < wrksheet.getColumns();col++)
        {
            dict.put(ReadCell(col,0), col);
        }
    }

    private static int GetCell(String colName)
    {
        try {
            int value;
            value = ((Integer) dict.get(colName)).intValue();
            return value;
        } catch (NullPointerException e) {
            return (0);

        }
    }
}