package com.leo.crud.vendas.dto.reports;

import com.leo.crud.vendas.projections.SaleReportProjectionRecord;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ReportSalesDTO {

    @Autowired
    private List<SaleReportProjectionRecord> saleReport;

    public ReportSalesDTO(List<SaleReportProjectionRecord> saleReport) {
        this.saleReport = saleReport;
    }

    public ReportSalesDTO(){
    }

    public List<SaleReportProjectionRecord> getSaleReport() {
        return saleReport;
    }

    public void setSaleReport(List<SaleReportProjectionRecord> saleReport) {
        this.saleReport = saleReport;
    }
}
