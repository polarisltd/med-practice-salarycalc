package lv.polarisit.salarycalc.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lv.polarisit.salarycalc.config.BBsConfig;
import lv.polarisit.salarycalc.fidavista.FidaVistaImporter;
import lv.polarisit.salarycalc.fidavista.model.FIDAVISTA;
import lv.polarisit.salarycalc.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/fidavista")
@Tag(name = "Salary", description = "Payment import into online banking APIs")
public class FidavistaController {


    private BBsConfig bbsConfig;
    @Autowired
    public FidavistaController(@Qualifier("BBsConfig") BBsConfig bbsConfig) {
        this.bbsConfig = bbsConfig;
    }
    @GetMapping(value = "/sample")
    @Operation(summary = "Generate sample fidavista", description = "Generates a sample FIDAVISTA object")
    public ResponseEntity<FIDAVISTA> sampleFidavista() {
        FIDAVISTA fidavista = FidaVistaImporter.sampleExport();
        return new ResponseEntity<>(fidavista, HttpStatus.OK);
    }

    @GetMapping(value = "/bens")
    @Operation(summary = "List BBsConfig properties", description = "Lists the BBsConfig properties from application.yaml")
    public ResponseEntity<List<BBsConfig.BEN>> listBensConfig() {
        List<BBsConfig.BEN> bens = bbsConfig.getBens();
        return new ResponseEntity<>(bens, HttpStatus.OK);
    }


}