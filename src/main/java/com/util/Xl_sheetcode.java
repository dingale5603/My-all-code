package com.util;

import java.io.File;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import com.config.Configuration;

public class Xl_sheetcode {
	
	
	public String readstrdata(int row,int cell ) throws EncryptedDocumentException, IOException {
		 File file=new File(Configuration.xlpath);
		Sheet name = WorkbookFactory.create(file).getSheet("Sheet1");
		
		String student = name.getRow(row).getCell(cell).getStringCellValue();
		System.out.println(student);
		
		return student;
	}
}
