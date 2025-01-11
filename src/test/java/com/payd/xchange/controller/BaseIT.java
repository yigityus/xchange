package com.payd.xchange.controller;

import com.payd.xchange.client.CurrencyLayerClient;
import com.payd.xchange.model.ExchangeDto;
import com.payd.xchange.model.HistoryFilterDto;
import com.payd.xchange.model.ProviderExchange;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.specification.RequestSpecification;
import jakarta.annotation.PostConstruct;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.restdocs.RestDocumentationContextProvider;
import org.springframework.restdocs.RestDocumentationExtension;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Map;

import static io.restassured.RestAssured.enableLoggingOfRequestAndResponseIfValidationFails;
import static io.restassured.RestAssured.port;
import static io.restassured.RestAssured.urlEncodingEnabled;
import static org.springframework.restdocs.operation.preprocess.Preprocessors.prettyPrint;
import static org.springframework.restdocs.restassured.RestAssuredRestDocumentation.documentationConfiguration;

@SpringBootTest(
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT
)
@ActiveProfiles("it")
@ExtendWith({RestDocumentationExtension.class, SpringExtension.class})
public abstract class BaseIT {

    @MockitoBean
    CurrencyLayerClient currencyLayerClient;

    @LocalServerPort
    public int serverPort;

    @PostConstruct
    public void initRestAssured() {
        port = serverPort;
        urlEncodingEnabled = false;
        enableLoggingOfRequestAndResponseIfValidationFails();
    }

    protected RequestSpecification spec;

    @BeforeEach
    void setUp(RestDocumentationContextProvider restDocumentation) {
        this.spec = new RequestSpecBuilder().addFilter(
                documentationConfiguration(restDocumentation).operationPreprocessors()
                        .withRequestDefaults(prettyPrint())
                        .withResponseDefaults(prettyPrint()))
                .build();
        RestAssured.filters(new RequestLoggingFilter(), new ResponseLoggingFilter());
    }

    final static String source = "USD";
    final static String target = "TRY";
    final Double rate = Double.valueOf(35.6);
    ProviderExchange providerExchange =
            new ProviderExchange(true, "", "", Instant.now(),
                    source, Map.of("USDTRY", rate));


    static ExchangeDto dto = new ExchangeDto();
    static HistoryFilterDto hfDto = new HistoryFilterDto();
    static {
        dto.setSource(source);
        dto.setTarget(target);
        hfDto.setDate(LocalDateTime.now().minusHours(1));
    }

    @BeforeEach
    void setUpClient() {
        Mockito.when(currencyLayerClient.live(target, source)).thenReturn(providerExchange);
    }



}
