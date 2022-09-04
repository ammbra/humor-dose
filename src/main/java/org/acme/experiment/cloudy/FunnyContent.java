package org.acme.experiment.cloudy;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record FunnyContent(String[] categories, String value) {

}
