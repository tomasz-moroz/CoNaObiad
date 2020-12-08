package pl.conaobiad.parser;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.enterprise.context.RequestScoped;
import java.util.List;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;

@RequestScoped
public class ParserService implements Serializable {

    private static String JSON_ROOT = "meals";
    private Logger logger = LoggerFactory.getLogger(getClass().getName());

    public <T> Object parseFile(File json){

        T outputObject = null;

        ObjectMapper objectMapper = new ObjectMapper();
        try {
            JsonNode jsonNode = objectMapper.readTree(json);
            outputObject = (T) objectMapper.readValue(jsonNode.get(JSON_ROOT).toString(), new TypeReference<List<MealApi>>() {
            });
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        logger.info("Parse complete");
        return outputObject;
    }
}
