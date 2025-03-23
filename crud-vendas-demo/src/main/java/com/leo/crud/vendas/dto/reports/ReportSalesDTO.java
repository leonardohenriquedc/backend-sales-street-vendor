package com.leo.crud.vendas.dto.reports;

import java.util.ArrayList;
import java.util.List;

public class ReportSalesDTO {

    private List<SaleReportDTO> saleReport = new ArrayList<>();

    public ReportSalesDTO(List<SaleReportDTO> saleReport) {
        this.saleReport = saleReport;
    }

    public ReportSalesDTO(){
    }

    public List<SaleReportDTO> getSaleReport() {
        return saleReport;
    }

    public void setSaleReport(List<SaleReportDTO> saleReport) {
        this.saleReport = saleReport;
    }
}
