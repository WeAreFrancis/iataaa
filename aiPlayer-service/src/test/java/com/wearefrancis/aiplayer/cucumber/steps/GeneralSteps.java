package com.wearefrancis.aiplayer.cucumber.steps;

import com.wearefrancis.aiplayer.AiPlayerApplication;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.commons.lang.math.NumberUtils;
import org.springframework.boot.test.context.ConfigFileApplicationContextInitializer;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.sql.Connection;
import java.sql.Statement;
import java.util.Map;
import java.util.regex.Pattern;

import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ContextConfiguration(classes = AiPlayerApplication.class,
        initializers = ConfigFileApplicationContextInitializer.class)
public class GeneralSteps extends AbstractSteps {

    /**
     * The resultActions attributes is used to test the web service. It contains the data
     * after a request.
     */
    private ResultActions resultActions;

    /**
     * The request attribute is used to build the request.
     */
    private MockHttpServletRequestBuilder request;

    /**
     * The mockMvc attribute is used to mock the Spring application.
     */
    private MockMvc mockMvc;

    @Before
    public void setUp() {
        mockMvc = MockMvcBuilders
                .webAppContextSetup(context)
                .build();
    }

    @After
    public void cleanUp() throws Exception {
        try (Connection connection = dataSource.getConnection(); Statement statement = connection.createStatement()) {
            statement.execute("TRUNCATE SCHEMA PUBLIC RESTART IDENTITY AND COMMIT NO CHECK");
            connection.commit();
        }
    }


    @When("^I set a \"([^\"]*)\" request to \"([^\"]*)\"$")
    public void iSetAnAuthenticatedRequestTo(String method, String endpoint) throws Throwable {
        switch (HttpMethod.valueOf(method)) {
            case POST:
                this.request = post(endpoint);
                break;
            case GET:
                this.request = get(endpoint);
                break;
            case PUT:
                this.request = put(endpoint);
                break;
            case DELETE:
                this.request = delete(endpoint);
                break;
            default:
                break;
        }
    }

    @When("^the request body is :$")
    public void theRequestBodyIs(String bodyRequest) throws Throwable {
        this.request.content(bodyRequest);
    }

    @When("^the \"([^\"]*)\" attribute of the request header is \"([^\"]*)\"$")
    public void theAttributeOfTheRequestHeaderIs(String headerAttribute, String value) throws Throwable {
        this.request.header(headerAttribute, value);
    }

    @When("^I send the request$")
    public void iSendTheRequest() throws Throwable {
        this.resultActions = mockMvc.perform(request);
    }

    @Then("^the response status code is (\\d+)$")
    public void theResponseStatusCodeIs(int code) throws Throwable {
        this.resultActions.andExpect(status().is(code));
    }

    @Then("^the response body is :$")
    public void theResponseBodyIs(String json) throws Throwable {
        this.resultActions.andExpect(content().string(json.replace("\n", "").replace("\r", "").replace(" ", "")));
    }

    @And("^the response body matches :$")
    public void theResponseBodyMatches(Map<String,String> responseFields) throws Throwable {
        Pattern regexFalse = Pattern.compile("^false$");
        Pattern regexTrue = Pattern.compile("^true$");
        Pattern regexNull = Pattern.compile("^null$");

        for (Map.Entry<String, String> field : responseFields.entrySet()) {
            if(NumberUtils.isNumber(field.getValue())){
                if (field.getValue().contains(".")) {
                    this.resultActions.andExpect(jsonPath(field.getKey(),
                            is(Double.valueOf(field.getValue()))));
                } else {
                    this.resultActions.andExpect(jsonPath(field.getKey(),
                            is(Integer.valueOf(field.getValue()))));
                }
            } else if ("[]".equals(field.getValue())) {
                this.resultActions.andExpect(jsonPath(field.getKey(), is(empty())));
            } else if (regexNull.matcher(field.getValue()).find()) {
                this.resultActions.andExpect(jsonPath(field.getKey(), nullValue()));
            } else if (regexFalse.matcher(field.getValue()).find()) {
                this.resultActions.andExpect(jsonPath(field.getKey(), is(false)));
            } else {
                if (regexTrue.matcher(field.getValue()).find()) {
                    this.resultActions.andExpect(jsonPath(field.getKey(), is(true)));
                } else {
                    this.resultActions.andExpect(jsonPath(field.getKey(),
                            is(field.getValue())));
                }
            }
        }
    }

    @Then("^the \"([^\"]*)\" attribute of the response header is \"([^\"]*)\"$")
    public void theAttributeOfTheResponseHeaderIs(String key, String value) throws Throwable {
        this.resultActions.andExpect(
                header().string(key, MediaType.valueOf(value).toString())
        );
    }

    @Then("^the response body contains my connection token$")
    public void theResponseBodyContainsMyConnectionToken() throws Throwable {
        this.resultActions
                .andExpect(jsonPath("$.data.jwt", notNullValue()))
                .andExpect(jsonPath("$.data.jwt", not(isEmptyString())));
    }


    @And("^the \"([^\"]*)\" path of the response body has a size of (\\d+)$")
    public void thePathOfTheResponseBodyHasASizeOf(String path, int size) throws Throwable {
        this.resultActions.andExpect(jsonPath(path, hasSize(size)));
    }
}