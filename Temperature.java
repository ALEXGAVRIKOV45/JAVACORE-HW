package main;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import lombok.Data;


public class Temperature {
	@Override
	public String toString() {
		return "Temperature{" +
				"Metric=" + metric +
				", Minimum=" + minimum +
				", Maximum=" + maximum +
				", Imperial=" + imperial +
				'}';
	}


	@JsonProperty(value = "Metric")
	private Metric metric;

	@JsonProperty(value = "Minimum")
	private Minimum minimum;

	@JsonProperty(value = "Maximum")
	private Maximum maximum;

	@JsonProperty(value = "Imperial")
	private Imperial imperial;

	@JsonGetter("Metric")
	public Metric getMetric() {
		return metric;
	}

	@JsonGetter("Minimum")
	public Minimum getMinimum() {
		return minimum;
	}

	@JsonGetter("Maximim")
	public Maximum getMaximum() {
		return maximum;
	}
}
