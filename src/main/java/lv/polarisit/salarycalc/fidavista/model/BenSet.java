package lv.polarisit.salarycalc.fidavista.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlElement;

@Builder
@NoArgsConstructor
@AllArgsConstructor

public class BenSet {
    private String priority;
    private String comm;
    private double amt;
    private String benAccNo;
    private String benName;
    private String benLegalId;
    private String benAddress;
    private String benCountry;
    private String bbName;
    private String bbAddress;
    private String bbSwift;

    @XmlElement(name = "Priority")
    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    @XmlElement(name = "Comm")
    public String getComm() {
        return comm;
    }

    public void setComm(String comm) {
        this.comm = comm;
    }

    @XmlElement(name = "Amt")
    public double getAmt() {
        return amt;
    }

    public void setAmt(double amt) {
        this.amt = amt;
    }

    @XmlElement(name = "BenAccNo")
    public String getBenAccNo() {
        return benAccNo;
    }

    public void setBenAccNo(String benAccNo) {
        this.benAccNo = benAccNo;
    }

    @XmlElement(name = "BenName")
    public String getBenName() {
        return benName;
    }

    public void setBenName(String benName) {
        this.benName = benName;
    }

    @XmlElement(name = "BenLegalId")
    public String getBenLegalId() {
        return benLegalId;
    }

    public void setBenLegalId(String benLegalId) {
        this.benLegalId = benLegalId;
    }

    @XmlElement(name = "BenAddress")
    public String getBenAddress() {
        return benAddress;
    }

    public void setBenAddress(String benAddress) {
        this.benAddress = benAddress;
    }

    @XmlElement(name = "BenCountry")
    public String getBenCountry() {
        return benCountry;
    }

    public void setBenCountry(String benCountry) {
        this.benCountry = benCountry;
    }

    @XmlElement(name = "BBName")
    public String getBbName() {
        return bbName;
    }

    public void setBbName(String bbName) {
        this.bbName = bbName;
    }

    @XmlElement(name = "BBAddress")
    public String getBbAddress() {
        return bbAddress;
    }

    public void setBbAddress(String bbAddress) {
        this.bbAddress = bbAddress;
    }

    @XmlElement(name = "BBSwift")
    public String getBbSwift() {
        return bbSwift;
    }

    public void setBbSwift(String bbSwift) {
        this.bbSwift = bbSwift;
    }
}
