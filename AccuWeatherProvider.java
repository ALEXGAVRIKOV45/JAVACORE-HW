package main;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;


import java.io.IOException;

import java.util.List;

public class AccuWeatherProvider implements WeatherProvider {
	private static final String BASE_HOST = "dataservice.accuweather.com";
	private static final String FORECAST_ENDPOINT = "forecasts";
	private static final String FORECAST_TYPE = "daily";;
	private static final String FORECAST_PERIOD = "5day";
	private static final String CURRENT_CONDITIONS_ENDPOINT = "currentconditions";
	private static final String API_VERSION = "v1";
	private static final String API_KEY = ApplicationGlobalState.getInstance().getApiKey();

	private final OkHttpClient client = new OkHttpClient();
	private final ObjectMapper objectMapper = new ObjectMapper();

	@Override
	public void getWeather(Periods periods) throws IOException {
		String cityKey = detectCityKey();
		if (periods.equals(Periods.NOW)) {
			HttpUrl url = new HttpUrl.Builder()
					.scheme("http")
					.host(BASE_HOST)
					.addPathSegment(CURRENT_CONDITIONS_ENDPOINT)
					.addPathSegment(API_VERSION)
					.addPathSegment(cityKey)
					.addQueryParameter("apikey", API_KEY)
					.addQueryParameter("language", "ru-ru")
					.addQueryParameter("metric", "true")
					.build();

			Request request = new Request.Builder()
					.addHeader("accept", "application/json")
					.url(url)
					.build();

			Response response = client.newCall(request).execute();

			String res = response.body().string();
			System.out.println(res);
			JsonNode wth = objectMapper.readTree(res).get(0).at("/WeatherText");
			JsonNode wthdate = objectMapper.readTree(res).get(0).at("/LocalObservationDateTime");
			String wthdateStr = wthdate.asText();
			JsonNode wthtemprMin = objectMapper.readTree(res).get(0).at("/Temperature/Metric/Value");



			System.out.println("Погода в "+ApplicationGlobalState.getInstance().getSelectedCity());
			System.out.println("На дату "+ wthdateStr.substring(0,10));
			System.out.println(wth);
			System.out.println("Температура :  "+wthtemprMin);


			//System.out.println(response.body().string());
			// TODO: Сделать в рамках д/з вывод более приятным для пользователя.
			//  Создать класс WeatherResponse, десериализовать ответ сервера в экземпляр класса
			//  Вывести пользователю только текущую температуру в C и сообщение (weather text)
		}
		if (periods.equals(Periods.FIVE_DAYS)) {
			HttpUrl url5 = new HttpUrl.Builder()
					.scheme("http")
					.host(BASE_HOST)
					.addPathSegment(FORECAST_ENDPOINT)
					.addPathSegment(API_VERSION)
					.addPathSegment(FORECAST_TYPE)
					.addPathSegment(FORECAST_PERIOD)
					.addPathSegment(cityKey)
					.addQueryParameter("apikey", API_KEY)
					.addQueryParameter("language", "ru-ru")
					.addQueryParameter("metric", "true")
					.build();

			Request request5 = new Request.Builder()
					.addHeader("accept", "application/json")
					.url(url5)
					.build();

			Response response5 = client.newCall(request5).execute();

			String res5 = response5.body().string();
			System.out.println(res5);
			String[] date = new String[5];
			for (int i=0; i < 5; i++) {
				String[] date5 = objectMapper.readTree(res5).at("/DailyForecasts/"+ i + "/Date").asText().split("T");
				JsonNode tempMin = objectMapper.readTree(res5).at("/DailyForecasts/"+ i + "/Temperature/Minimum/Value");
				JsonNode tempMax = objectMapper.readTree(res5).at("/DailyForecasts/"+ i + "/Temperature/Maximum/Value");
				JsonNode citywth = objectMapper.readTree(res5).at("/DailyForecasts/"+ i + "/Day/IconPhrase");

				date[i] = date5[0] + "  Tmin:" + tempMin + "  Tmax:" + tempMax + "  Weather:" + citywth;

			}

			System.out.println("Погода в "+ApplicationGlobalState.getInstance().getSelectedCity());
			for (int i=0; i < 5; i++) {
				System.out.println(date[i]);
			}

		}



	}

	public String detectCityKey() throws IOException {
		String selectedCity = ApplicationGlobalState.getInstance().getSelectedCity();

		HttpUrl detectLocationURL = new HttpUrl.Builder()
				.scheme("http")
				.host(BASE_HOST)
				.addPathSegment("locations")
				.addPathSegment(API_VERSION)
				.addPathSegment("cities")
				.addPathSegment("autocomplete")
				.addQueryParameter("apikey", API_KEY)
				.addQueryParameter("q", selectedCity)
				.build();

		Request request = new Request.Builder()
				.addHeader("accept", "application/json")
				.url(detectLocationURL)
				.build();

		Response response = client.newCall(request).execute();

		if (!response.isSuccessful()) {
			throw new IOException("Невозможно прочесть информацию о городе. " +
					"Код ответа сервера = " + response.code() + " тело ответа = " + response.body().string());
		}
		String jsonResponse = response.body().string();
		System.out.println("Произвожу поиск города " + selectedCity);

		if (objectMapper.readTree(jsonResponse).size() > 0) {
			String cityName = objectMapper.readTree(jsonResponse).get(0).at("/LocalizedName").asText();
			String countryName = objectMapper.readTree(jsonResponse).get(0).at("/Country/LocalizedName").asText();
			System.out.println("Найден город " + cityName + " в стране " + countryName);
		} else throw new IOException("Server returns 0 cities");

		return objectMapper.readTree(jsonResponse).get(0).at("/Key").asText();
	}

}
