package BLL;


import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.MessageFormat;
import java.time.LocalDate;
import java.util.Date;

public abstract class Helper {
    public static String getCurrentDate() {
        return LocalDate.now().toString();
    }

    public static void openFile(String file) {
        File path = new File(file);
        try {
            Desktop.getDesktop().open(path);
        } catch (IOException e) {
            System.out.println(e);
        }

    }

    public static void exportFileExcel(JTable table, JPanel panel) {
        try {
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.showSaveDialog(panel);
            File saveFile = fileChooser.getSelectedFile();
            if (saveFile != null) {
                saveFile = new File(saveFile.toString() + ".xlsx");
                Workbook wb = new XSSFWorkbook();
                Sheet sheet = wb.createSheet("customer");

                Row rowCol = sheet.createRow(0);
                for (int i = 0; i < table.getColumnCount(); i++) {
                    Cell cell = rowCol.createCell(i);
                    cell.setCellValue(table.getColumnName(i));
                }

                for (int i = 0; i < table.getRowCount(); i++) {
                    Row row = sheet.createRow(i);
                    for (int j = 0; j < table.getColumnCount(); j++) {
                        Cell cell = row.createCell(j);
                        if (table.getValueAt(i, j) != null) {
                            cell.setCellValue(table.getValueAt(i, j).toString());
                        }
                    }
                }
                FileOutputStream out = new FileOutputStream(new File(saveFile.toString()));
                wb.write(out);
                wb.close();

                out.close();
                Helper.openFile(saveFile.toString());

            } else {
                JOptionPane.showMessageDialog(panel, "Lỗi xuất file excel");
            }

        } catch (FileNotFoundException ex) {
            System.out.println(ex);

        } catch (IOException io) {
            System.out.println(io);
        }
    }


    public static void print(JTable table, String header) {
        MessageFormat message = new MessageFormat(header);
        MessageFormat footer = new MessageFormat("create by khang");
        try {
            table.print(JTable.PrintMode.FIT_WIDTH, message, footer);
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }


}
