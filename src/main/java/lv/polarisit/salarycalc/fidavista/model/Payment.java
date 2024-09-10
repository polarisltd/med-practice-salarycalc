package lv.polarisit.salarycalc.fidavista.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlElement;

@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Payment {
    private String extId;
    private String docNo;
    private String regDate;
    private String taxPmtFlg;
    private String ccy;
    private String pmtInfo;
    private String payLegalId;
    private String payAccNo;
    private String debitCcy;
    private BenSet benSet;

    @XmlElement(name = "ExtId")
    public String getExtId() {
        return extId;
    }

    public void setExtId(String extId) {
        this.extId = extId;
    }

    @XmlElement(name = "DocNo")
    public String getDocNo() {
        return docNo;
    }

    public void setDocNo(String docNo) {
        this.docNo = docNo;
    }

    @XmlElement(name = "RegDate")
    public String getRegDate() {
        return regDate;
    }

    public void setRegDate(String regDate) {
        this.regDate = regDate;
    }

    @XmlElement(name = "TaxPmtFlg")
    public String getTaxPmtFlg() {
        return taxPmtFlg;
    }

    public void setTaxPmtFlg(String taxPmtFlg) {
        this.taxPmtFlg = taxPmtFlg;
    }

    @XmlElement(name = "Ccy")
    public String getCcy() {
        return ccy;
    }

    public void setCcy(String ccy) {
        this.ccy = ccy;
    }

    @XmlElement(name = "PmtInfo")
    public String getPmtInfo() {
        return pmtInfo;
    }

    public void setPmtInfo(String pmtInfo) {
        this.pmtInfo = pmtInfo;
    }

    @XmlElement(name = "PayLegalId")
    public String getPayLegalId() {
        return payLegalId;
    }

    public void setPayLegalId(String payLegalId) {
        this.payLegalId = payLegalId;
    }

    @XmlElement(name = "PayAccNo")
    public String getPayAccNo() {
        return payAccNo;
    }

    public void setPayAccNo(String payAccNo) {
        this.payAccNo = payAccNo;
    }

    @XmlElement(name = "DebitCcy")
    public String getDebitCcy() {
        return debitCcy;
    }

    public void setDebitCcy(String debitCcy) {
        this.debitCcy = debitCcy;
    }

    @XmlElement(name = "BenSet")
    public BenSet getBenSet() {
        return benSet;
    }

    public void setBenSet(BenSet benSet) {
        this.benSet = benSet;
    }
}
