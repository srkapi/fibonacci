package com.srkapi.base.shared;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.io.Serializable;
import java.util.HashMap;
import lombok.experimental.UtilityClass;

@UtilityClass
public class JsonUtils {
  public String jsonEncode(HashMap<String, Serializable> map) {
    try {
      return new ObjectMapper().writeValueAsString(map);
    } catch (JsonProcessingException e) {
      return "";
    }
  }

  public HashMap<String, Serializable> jsonDecode(String body) {
    try {
      return new ObjectMapper().readValue(body, HashMap.class);
    } catch (IOException e) {
      return null;
    }
  }
}
