package lv.polarisit.salarycalc.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.web.bind.annotation.RequestBody;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/arstu-algas")
public class ArstuAlgasController {

    @PostMapping("/evaluate")
    @Operation(summary = "Evaluate expressions", description = "Evaluates a list of mathematical expressions and returns the results.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully evaluated expressions"),
            @ApiResponse(responseCode = "400", description = "Invalid input data")
    })
    public ResponseEntity<List<ExpressionResponse>> evaluateExpressions(
            @RequestBody List<ExpressionRequest> requests) {
        List<ExpressionResponse> responses = requests.stream().map(request -> {
            Expression expression = new ExpressionBuilder(request.getExpr()).build();
            double result = expression.evaluate();
            double roundedResult = Math.round(result * 100.0) / 100.0;
            double brutoPct = roundedResult * request.getPct();

            ExpressionResponse response = new ExpressionResponse();
            response.setName(request.getName());
            response.setPeriod(request.getPeriod());
            response.setResult(roundedResult);
            response.setPct(request.getPct());
            response.setBrutoPct(brutoPct);

            return response;
        }).collect(Collectors.toList());

        return new ResponseEntity<>(responses, HttpStatus.OK);
    }
}