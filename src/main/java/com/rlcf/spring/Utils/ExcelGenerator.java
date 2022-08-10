package com.rlcf.spring.Utils;

import com.rlcf.spring.models.Demand;

import java.util.Date;
import java.util.List;
import java.io.IOException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelGenerator {
    private List<Demand> demandList;
    private XSSFWorkbook workbook;
    private XSSFSheet sheet;

    public ExcelGenerator(List < Demand > demandList) {
        this.demandList = demandList;
        workbook = new XSSFWorkbook();

    }
    private void writeHeader() {
        sheet = workbook.createSheet("Demandes");
        Row row = sheet.createRow(0);
        CellStyle style = workbook.createCellStyle();
        XSSFFont font = workbook.createFont();
        font.setBold(true);
        font.setFontHeight(16);
        style.setFont(font);

        createCell(row, 0, "Date de creation", style);
        createCell(row, 1, "Date de modification", style);
        createCell(row, 2, "Date de validation", style);
        createCell(row, 3, "Statut du demande", style);

        createCell(row, 4, "Id client", style);
        createCell(row, 5, "Contact", style);
        createCell(row, 6, "Client", style);
        createCell(row, 7, "Contact 2", style);
        createCell(row, 8, "Segment", style);
        createCell(row, 9, "Mail", style);
        createCell(row, 10, "Type de client", style);
        createCell(row, 11, "Telephone", style);
        createCell(row, 12, "Priorite", style);
        createCell(row, 13, "Cdp", style);
        createCell(row, 14, "Sla", style);
        createCell(row, 15, "SlaGtr", style);
        createCell(row, 16, "Ville", style);
        createCell(row, 17, "TAM", style);

        createCell(row, 18, "Id Connexion", style);
        createCell(row, 19, "Acces", style);
        createCell(row, 20, "Ligne de produit", style);
        createCell(row, 21, "bsSecSWPort", style);
        createCell(row, 22, "Type de service", style);
        createCell(row, 23, "vlanVoix", style);
        createCell(row, 24, "Type de lien", style);
        createCell(row, 25, "ipVoix", style);
        createCell(row, 26, "Debit", style);
        createCell(row, 27, "Topologie", style);
        createCell(row, 28, "Numero des canaux", style);
        createCell(row, 29, "popSTraitant", style);
        createCell(row, 30, "Commentaire", style);
        createCell(row, 31, "Designation SDA", style);
        createCell(row, 32, "MSISDN", style);
        createCell(row, 33, "Etat", style);
        createCell(row, 34, "ICC", style);
        createCell(row, 35, "Date de service", style);
        createCell(row, 36, "Numero de serie", style);
        createCell(row, 37, "Date de realisation", style);
        createCell(row, 38, "IMEI", style);

    }
    private void createCell(Row row, int columnCount, Object valueOfCell, CellStyle style) {
        sheet.autoSizeColumn(columnCount);
        Cell cell = row.createCell(columnCount);
        if (valueOfCell instanceof Integer) {
            cell.setCellValue((Integer) valueOfCell);
        } else if (valueOfCell instanceof Long) {
            cell.setCellValue((Long) valueOfCell);
        } else if (valueOfCell instanceof String) {
            cell.setCellValue((String) valueOfCell);
        }else if (valueOfCell instanceof Enum) {
            cell.setCellValue((String) valueOfCell);
        }else if (valueOfCell == null) {
            cell.setCellValue("En cours");
        }else {
            cell.setCellValue((Boolean) valueOfCell);
        }
        cell.setCellStyle(style);
    }
    private void write() {
        int rowCount = 1;
        CellStyle style = workbook.createCellStyle();
        XSSFFont font = workbook.createFont();
        font.setFontHeight(14);
        style.setFont(font);
        for (Demand demand: demandList) {
            Row row = sheet.createRow(rowCount++);
            int columnCount = 0;
            createCell(row, columnCount++, demand.getCreationDate(), style);
            createCell(row, columnCount++, demand.getUpdateDate(), style);
            createCell(row, columnCount++, demand.getValidationDate(), style);
            createCell(row, columnCount++,demand.getStatut(), style);

            createCell(row, columnCount++,demand.getClient().getIdClient(), style);
            createCell(row, columnCount++,demand.getClient().getContact(), style);
            createCell(row, columnCount++,demand.getClient().getClient(), style);
            createCell(row, columnCount++,demand.getClient().getContact2(), style);
            createCell(row, columnCount++,demand.getClient().getSegment(), style);
            createCell(row, columnCount++,demand.getClient().getMail(), style);
            createCell(row, columnCount++,demand.getClient().getTypeClient(), style);
            createCell(row, columnCount++,demand.getClient().getTel(), style);
            createCell(row, columnCount++,demand.getClient().getPriorite(), style);
            createCell(row, columnCount++,demand.getClient().getCdp(), style);
            createCell(row, columnCount++,demand.getClient().getSla(), style);
            createCell(row, columnCount++,demand.getClient().getSlaGtr(), style);
            createCell(row, columnCount++,demand.getClient().getVille(), style);
            createCell(row, columnCount++,demand.getClient().getTam(), style);

            createCell(row, columnCount++,demand.getProduct().getIdConnexion(), style);
            createCell(row, columnCount++,demand.getProduct().getAcces(), style);
            createCell(row, columnCount++,demand.getProduct().getLigneProduit(), style);
            createCell(row, columnCount++,demand.getProduct().getBsSecSWPort(), style);
            createCell(row, columnCount++,demand.getProduct().getTypeService(), style);
            createCell(row, columnCount++,demand.getProduct().getVlanVoix(), style);
            createCell(row, columnCount++,demand.getProduct().getTypeLien(), style);
            createCell(row, columnCount++,demand.getProduct().getIpVoix(), style);
            createCell(row, columnCount++,demand.getProduct().getDebit(), style);
            createCell(row, columnCount++,demand.getProduct().getTopologie(), style);
            createCell(row, columnCount++,demand.getProduct().getNumCanaux(), style);
            createCell(row, columnCount++,demand.getProduct().getPopSTraitant(), style);
            createCell(row, columnCount++,demand.getProduct().getComment(), style);
            createCell(row, columnCount++,demand.getProduct().getDesignationSDA(), style);
            createCell(row, columnCount++,demand.getProduct().getMsisdn(), style);
            createCell(row, columnCount++,demand.getProduct().getEtat(), style);
            createCell(row, columnCount++,demand.getProduct().getIcc(), style);
            createCell(row, columnCount++,demand.getProduct().getDateService(), style);
            createCell(row, columnCount++,demand.getProduct().getNumSerie(), style);
            createCell(row, columnCount++,demand.getProduct().getDateRealisation(), style);
            createCell(row, columnCount++,demand.getProduct().getImei(), style);
        }

    }
    public void generateExcelFile(HttpServletResponse response) throws IOException {
        writeHeader();
        write();
        ServletOutputStream outputStream = response.getOutputStream();
        workbook.write(outputStream);
        workbook.close();
        outputStream.close();
    }
}
