package com.test.ssh.utils;

import com.test.ssh.domain.Employee;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ExcelUtils {

    public static List<Employee> excelToEmployeeList(String path) throws IOException {
        InputStream in = new FileInputStream(new File(path));
        Workbook book = getWorkBook(in, path);
        List<Sheet> sheets = getSheets(book);
        List<Employee> employeeList = sheetIterator(sheets);
        return employeeList;
    }


    private static Workbook getWorkBook(InputStream in, String path) throws IOException {
        return path.endsWith(".xls") ? (new HSSFWorkbook(in)) :
                (path.endsWith(".xlsx") ? (new XSSFWorkbook(in)) : null);
    }

    private static List<Sheet> getSheets(Workbook book) {
        int numberOfSheets = book.getNumberOfSheets();
        System.out.println("numberOfSheets:" + numberOfSheets);
        List<Sheet> sheets = new ArrayList<Sheet>();
        for (int i = 0; i < numberOfSheets; i++) {
            sheets.add(book.getSheetAt(i));
        }
        return sheets;
    }

    private static List<Employee> sheetIterator(List<Sheet> sheets) {
        List<Employee> employeeList = new ArrayList<Employee>();
        for (int i = 0; i < sheets.size(); i++) {    //循环每一张工作表
            Sheet sheet = sheets.get(i);
            if (sheet.getLastRowNum() > 1) {    //判断是否为空表，获取有数据的最后一行的行数。如果为零则为空表
                System.out.println(sheet.getSheetName() + "=============");     //打印不为空的工作表名字
            }
            Iterator<Row> iterator = sheet.iterator();   //迭代器
            //用两个while循环遍历所有单元格
            while (iterator.hasNext()) {           //遍历每一行
                Row nextRow = iterator.next();
                if (nextRow.getRowNum() < 1) {
                    continue;
                    //nextRow.getRowNum()就是获取行数，由表中看出第一行(getRowNum()=0)为表头，直接跳过
                }
                //从第二行开始是有用的数据，要保存早数据库，第二行：nextRow.getRowNum()=1
                Iterator<Cell> cellIterator = nextRow.cellIterator();

                Employee employee = new Employee();
                while (cellIterator.hasNext()) {         //遍历每一行的每一列
                    Cell cell = cellIterator.next();
                    switch (cell.getColumnIndex()) {
                        //将单元格内容设置为String类型，也可以这样写cell.setCellType(Cell.CELL_TYPE_STRING);
                        case 0:   //第一列（employeeId）
                            cell.setCellType(Cell.CELL_TYPE_STRING);
                            employee.setEmployeeId(cell.getStringCellValue());
                            break;
                        case 1:   //第二列（employeeName）
                            cell.setCellType(Cell.CELL_TYPE_STRING);
                            employee.setEmployeeName(cell.getStringCellValue());
                            break;
                        case 2:   //第三列（employeeNameSpell）
                            cell.setCellType(Cell.CELL_TYPE_STRING);
                            employee.setEmployeeNameSpell(cell.getStringCellValue().toUpperCase());
                            break;
                        case 3:   //第四列(entryTime)
                            cell.setCellType(Cell.CELL_TYPE_STRING);
                            employee.setEntryTime(cell.getStringCellValue());
                            break;
                        case 4:   //第五列(department)
                            cell.setCellType(Cell.CELL_TYPE_STRING);
                            employee.setDepartment(Integer.valueOf(cell.getStringCellValue()));
                            break;
                        case 5:   //第六列(groupOfEmployee)
                            cell.setCellType(Cell.CELL_TYPE_STRING);
                            employee.setGroupOfEmployee(Integer.valueOf(cell.getStringCellValue()));
                            break;
                        case 6:   //第七列(groupLeader)
                            cell.setCellType(Cell.CELL_TYPE_STRING);
                            employee.setGroupLeader(cell.getStringCellValue());
                            break;
                        case 7:   //第八列(isDelete)
                            cell.setCellType(Cell.CELL_TYPE_STRING);
                            employee.setIsDelete(cell.getStringCellValue());
                            break;
                        default:
                            break;
                    }
                    System.out.print("   ");
                }
                //到这里已经遍历完一行Execl的所有单元格，并存储到model里面了
                //但是remark不能为空
                employeeList.add(employee);
                System.out.println("   ");
            }
            System.out.println("   ");
        }
        return employeeList;
    }

}
