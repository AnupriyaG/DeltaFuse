package org.yash.deltafuse.dataingestion.service.impl;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.yash.deltafuse.dataingestion.model.HighDemand;
import org.yash.deltafuse.dataingestion.repository.DataRepository;
import org.yash.deltafuse.dataingestion.service.ReportService;

import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

@Service("reportService")
public class ReportServiceImpl implements ReportService {

	@Autowired
	DataRepository repository;
	//MobileDataDao mobileDataDao;

	@Override
	public ByteArrayInputStream getAllMobileData() {

		List<HighDemand> list = repository.findAll();
		System.out.println("List Printing from DB!!!");
		System.out.println(list);

		return generateReport(list);
	}

	private static ByteArrayInputStream generateReport(List<HighDemand> mobileDataList) {
		PdfPCell pdfPCell;
		
		Document document = new Document(PageSize.A4);
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		PdfPTable table = new PdfPTable(5);
		float[] columnWidths = new float[] { 20f, 10f, 20f, 10f, 7f };
		Font headFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD);

		try {
			table.setWidths(columnWidths);
			table.setWidthPercentage(100);

			pdfPCell = new PdfPCell(new Phrase("Model Name", headFont));
			pdfPCell.setHorizontalAlignment(Element.ALIGN_LEFT);
			table.addCell(pdfPCell);

			pdfPCell = new PdfPCell(new Phrase("Memory", headFont));
			pdfPCell.setHorizontalAlignment(Element.ALIGN_LEFT);
			table.addCell(pdfPCell);

			pdfPCell = new PdfPCell(new Phrase("Processor", headFont));
			pdfPCell.setHorizontalAlignment(Element.ALIGN_LEFT);
			table.addCell(pdfPCell);

			pdfPCell = new PdfPCell(new Phrase("Price(INR)", headFont));
			pdfPCell.setHorizontalAlignment(Element.ALIGN_LEFT);
			table.addCell(pdfPCell);
			
			pdfPCell = new PdfPCell(new Phrase("Rating", headFont));
			pdfPCell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(pdfPCell);
			
		/*	Document doc = new Document(PageSize.A4, 0f, 0f, 0f, 0f);
			float fntSize, lineSpacing;
			fntSize = 6.7f;
			lineSpacing = 10f;
			p = new Paragraph(new Phrase(lineSpacing,line,
			               FontFactory.getFont(FontFactory.COURIER, fntSize)));
			doc.add(p);*/

			mobileDataList.forEach(highDemand -> {
				float fntSize, lineSpacing;
				fntSize = 7.7f;
				lineSpacing = 10f;
				PdfPCell pdfPCellData;
				Phrase phrase;
				//pdfPCellData = new PdfPCell(new Phrase(highDemand.getModel()));
				
				phrase = new Phrase(lineSpacing,highDemand.getModel(),FontFactory.getFont(FontFactory.COURIER,fntSize));
				pdfPCellData = new PdfPCell(phrase);
				pdfPCellData.setVerticalAlignment(Element.ALIGN_MIDDLE);
				pdfPCellData.setHorizontalAlignment(Element.ALIGN_LEFT);
				table.addCell(pdfPCellData);

				phrase = new Phrase(lineSpacing,highDemand.getStorage(),FontFactory.getFont(FontFactory.TIMES_ROMAN,fntSize));
				pdfPCellData = new PdfPCell(phrase);
				pdfPCellData.setVerticalAlignment(Element.ALIGN_MIDDLE);
				pdfPCellData.setHorizontalAlignment(Element.ALIGN_LEFT);
				table.addCell(pdfPCellData);
				
				phrase = new Phrase(lineSpacing,highDemand.getProcessor(),FontFactory.getFont(FontFactory.TIMES_ROMAN,fntSize));
				pdfPCellData = new PdfPCell(phrase);
				pdfPCellData.setVerticalAlignment(Element.ALIGN_MIDDLE);
				pdfPCellData.setHorizontalAlignment(Element.ALIGN_LEFT);
				table.addCell(pdfPCellData);
				
				phrase = new Phrase(lineSpacing,highDemand.getPrice(),FontFactory.getFont(FontFactory.TIMES_ROMAN,fntSize));
				pdfPCellData = new PdfPCell(phrase);
				pdfPCellData.setVerticalAlignment(Element.ALIGN_MIDDLE);
				pdfPCellData.setHorizontalAlignment(Element.ALIGN_RIGHT);
				table.addCell(pdfPCellData);
				
				phrase = new Phrase(lineSpacing,String.valueOf(highDemand.getRating()),FontFactory.getFont(FontFactory.TIMES_ROMAN,fntSize));
				pdfPCellData = new PdfPCell(phrase);
				pdfPCellData.setVerticalAlignment(Element.ALIGN_MIDDLE);
				pdfPCellData.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(pdfPCellData);

			});

			PdfWriter.getInstance(document, out);

			document.open();
			document.add(table);

			document.close();

		} catch (Exception e) {
			document.close();
			// TODO: handle exception
		}
		return new ByteArrayInputStream(out.toByteArray());
	}

}
