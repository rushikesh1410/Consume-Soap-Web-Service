package com.consumeSoap1.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.codejournal.maven.wsdl2java.Calculator;
import com.consumeSoap1.output.output;
import javax.servlet.http.HttpServletRequest;

import org.json.JSONObject;
import org.json.XML;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.HttpHeaders;

import com.consumeSoap1.output.Response;

@RestController
public class Controller {

	@Autowired
	com.consumeSoap1.service.MyService myService;

	HttpHeaders headers = new HttpHeaders();

	@PostMapping(value = "/Res", consumes = { "application/json", "application/soap+xml", MediaType.TEXT_XML_VALUE,
			"application/xml" }, produces = { "application/json", "application/soap+xml", MediaType.TEXT_XML_VALUE,
					"application/xml" })
	public Response Addresult(@RequestBody Response requestbody, HttpServletRequest req) {

		if (req.getHeader("Operation").contains("Add")) {
			return myService.getAddResultService(requestbody);
		}
		if (req.getHeader("Operation").contains("Subtract")) {
			return myService.getSubtractResultService(requestbody);
		}
		if (req.getHeader("Operation").contains("Multiply")) {
			return myService.getMultiplyResultService(requestbody);
		}
		if (req.getHeader("Operation").contains("Divide")) {
			return myService.getDivideResultService(requestbody);
		}
		return null;
	}

	@PostMapping(value = "/SoapRes", consumes = { MediaType.TEXT_XML_VALUE, MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE }, produces = { MediaType.TEXT_XML_VALUE, MediaType.APPLICATION_JSON_VALUE,
					MediaType.APPLICATION_XML_VALUE })
	public output SoapXMLResult(@RequestBody String requestbody, HttpServletRequest req, Response Response)
			throws JsonMappingException, JsonProcessingException {

		if (req.getHeader("Content-Type").equalsIgnoreCase("text/xml")) {

			Calculator calculator = new Calculator();

			JSONObject json = XML.toJSONObject(requestbody);

			String json2 = json.toString();

			ObjectMapper mapper = new ObjectMapper();

			JsonNode jsonNode = mapper.readTree(json2);

			String Inte = jsonNode.get("soapenv:Envelope").get("soapenv:Body").get("tem:Add").get("tem:intA").asText();
			String Inte2 = jsonNode.get("soapenv:Envelope").get("soapenv:Body").get("tem:Add").get("tem:intB").asText();

			int intAA = Integer.parseInt(Inte);
			int intBB = Integer.parseInt(Inte2);

			if (req.getHeader("Operation").contains("Add")) {
				int res = calculator.getCalculatorSoap().add(intAA, intBB);
				output output = new output(intAA, intBB, res);
				return output;
			}
			if (req.getHeader("Operation").contains("Subtract")) {
				int res = calculator.getCalculatorSoap().subtract(intAA, intBB);
				output output = new output(intAA, intBB, res);
				return output;
			}
			if (req.getHeader("Operation").contains("Multiply")) {
				int res = calculator.getCalculatorSoap().multiply(intAA, intBB);
				output output = new output(intAA, intBB, res);
				return output;
			}
			if (req.getHeader("Operation").contains("Divide")) {
				int res = calculator.getCalculatorSoap().divide(intAA, intBB);
				output output = new output(intAA, intBB, res);
				return output;
			}
			
		}
		return null;
	}
}