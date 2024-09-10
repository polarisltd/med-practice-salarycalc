package lv.polarisit.salarycalc.fidavista;


import lv.polarisit.salarycalc.fidavista.model.BenSet;
import lv.polarisit.salarycalc.fidavista.model.FIDAVISTA;
import lv.polarisit.salarycalc.fidavista.model.Header;
import lv.polarisit.salarycalc.fidavista.model.Payment;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.util.List;

import static lv.polarisit.salarycalc.fidavista.helpers.FidavistaHelper.formatCurrentDate;
import static lv.polarisit.salarycalc.fidavista.helpers.FidavistaHelper.generateCurrentTimestamp;

import lv.polarisit.salarycalc.config.BBsConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import java.util.List;

    @Component
    public class FidaVistaImporter {

        private BBsConfig bbsConfig;

        @Autowired
        public FidaVistaImporter(@Qualifier("BBsConfig") BBsConfig bbsConfig) {
            this.bbsConfig = bbsConfig;
        }

    public static FIDAVISTA sampleExport() {
        Header header = Header.builder()
                .timestamp(generateCurrentTimestamp())
                .from("Sistēma Tildes Jumis TJ7.0.136.d21")
                .build();

        BenSet benSet1 = BenSet.builder()
                .priority("N")
                .comm("OUR")
                .amt(110.11)
                // ben is a receiver info. Saņēmējs kam maksā   .
                .benAccNo("LV10HABA0551009218135")
                .benName("PSD, SIA")
                .benLegalId("40003725708")
                .benAddress("Rīga, Tallinas iela 30A - 37, Latvija")
                .benCountry("LV")
                // bb is receiver bank info. Saņēmēja banka.
                .bbName("Swedbank, AS")
                .bbAddress("Balasta dambis 1a, Rīga, LV-1048")
                .bbSwift("HABALV22")
                .build();

        Payment payment1 = Payment.builder()
                .extId("1822")
                .docNo("06")  // payment number
                .regDate(formatCurrentDate())
                .taxPmtFlg("N")
                .ccy("EUR")
                .pmtInfo("Rēķins nr. 011") // payment reference
                .payLegalId("40003408048") // payer legal id. like polaris or lbprakse vat/reg number.
                .payAccNo("LV93RIKO0000082084099")  // payer account. payer account. like polaris business account.
                .debitCcy("EUR")
                .benSet(benSet1)
                .build();

        // Add more Payment objects as needed

        FIDAVISTA fidavista = FIDAVISTA.builder()
                .header(header)
                .payments(List.of(payment1))
                .build();

        try {
            JAXBContext context = JAXBContext.newInstance(FIDAVISTA.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

            // Marshal to console
            marshaller.marshal(fidavista, System.out);

            // Marshal to file
            marshaller.marshal(fidavista, new File("fidavista.xml"));

        } catch (JAXBException e) {
            e.printStackTrace();
        }

        return fidavista;
    }
}