package sumomo.aigasaki.api.modelo;

public class Pelicula {
    //PROPIEDADES
    private final String original_title;
    private final String backdrop_path;
    private final String poster_path;
    private final String overview ;
    private final String release_date;
    private final double vote_average;


    public Pelicula(String original_title, String backdrop_path,String poster_path, String overview, String release_date, double vote_average) {
        this.original_title = original_title;
        this.backdrop_path = backdrop_path;
        this.poster_path=poster_path;
        this.overview = overview;
        this.release_date = release_date;
        this.vote_average = vote_average;
    }

    public String getOriginal_title() {
        return original_title;
    }

    public String getBackdrop_path() {
        return "http://image.tmdb.org/t/p/original"+backdrop_path;
    }

    public String getposter_path() {
        return "http://image.tmdb.org/t/p/original"+poster_path;
    }

    public String getOverview() {
        return overview;
    }

    public String getRelease_date() {
        return release_date;
    }

    public double getVote_average() {
        return vote_average;
    }
}
