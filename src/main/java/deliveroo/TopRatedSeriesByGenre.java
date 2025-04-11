package deliveroo;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TopRatedSeriesByGenre {

    private static final String uri = "https://jsonmock.hackerrank.com/api/tvseries?page=";
    private static final Gson gson = new GsonBuilder().setFieldNamingStrategy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES).create();

    public static void main(String[] args) {
        String genre =  "Action";
        System.out.println(getMoviesByGenre(genre));
        genre =  "Drama";
        System.out.println(getMoviesByGenre(genre));
    }

    public static String getMoviesByGenre(String genre) {
        Map<String, TvSeries> seriesMap = getTopRatedSeries();
        return seriesMap.get(genre).name;
    }

    private static Map<String, TvSeries> getTopRatedSeries() {
        List<TvSeries> list = new ArrayList<>();

        try {
            HttpClient client = HttpClient.newBuilder().build();
            String uriStr = uri + 1;
            Response response = getResponse(client, uriStr);
            list.addAll(response.data);
            for (int i = 2; i <= response.totalPages; i++) {
                uriStr = uri + i;
                response = getResponse(client, uriStr);
                list.addAll(response.data);
            }
            return prepareMap(list);
        } catch (Exception e) {
            System.err.println(e);
        }
        return prepareMap(list);
    }

    private static Map<String, TvSeries> prepareMap(List<TvSeries> tvSeries) {
        Map<String, TvSeries> map = new HashMap<>();
        for (TvSeries t : tvSeries) {
            String[] genres = t.genre.split(",");
            for (String g : genres) {
                String genre = g.trim();
                if (map.containsKey(genre)) {
                    int c = t.compareTo(map.get(genre));
                    if (c < 0) {
                        map.put(genre, t);
                    }
                } else {
                    map.put(genre, t);
                }
            }
        }
        return map;
    }

    private static Response getResponse(HttpClient client, String uri) throws Exception {
        try {
            HttpRequest request = HttpRequest.newBuilder().uri(new URI(uri)).build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            return gson.fromJson(response.body(), Response.class);
        } catch (URISyntaxException e) {
            System.err.println(e);
        }
        throw new Exception("unable to get response");
    }

    private static class Response {
        int page;
        int totalPages;
        List<TvSeries> data;
    }

    private static class TvSeries implements Comparable<TvSeries> {
        String name;
        String genre;
        double imdbRating;

        @Override
        public int compareTo(TvSeries o) {
            if (this.imdbRating == o.imdbRating) {
                return this.name.compareTo(o.name);
            }
            return Double.compare(o.imdbRating, this.imdbRating);
        }
    }
}
