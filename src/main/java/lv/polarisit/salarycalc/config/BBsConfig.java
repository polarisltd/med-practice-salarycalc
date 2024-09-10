package lv.polarisit.salarycalc.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@ConfigurationProperties(prefix = "bbs")
@Setter
@Getter
public class BBsConfig {

    private List<BEN> bens;
    @Setter
    @Getter
    public static class BEN { // saņēmējs
        private String id;
        private String benAccNo;
        private String benName;
        private String benLegalId;
        private String benAddress;
        private String benCountry;
        private String bbName;
        private String bbAddress;
        private String bbSwift;

    }


}