package at.ac.fhcampuswien.fhmdb.api;

import at.ac.fhcampuswien.fhmdb.models.Genre;

public class MovieApiRequestBuilder {
    private String base;
    private String query;
    private Genre genre;
    private String releaseYear;
    private String ratingFrom;
    private String id;

    public MovieApiRequestBuilder(String base){
        this.base = base;
    }

    public MovieApiRequestBuilder query(String query) {
        this.query = query;
        return this;
    }

    public MovieApiRequestBuilder genre(Genre genre) {
        this.genre = genre;
        return this;
    }

    public MovieApiRequestBuilder releaseYear(String releaseYear) {
        this.releaseYear = releaseYear;
        return this;
    }

    public MovieApiRequestBuilder ratingFrom(String ratingForm) {
        this.ratingFrom = ratingForm;
        return this;
    }

    public MovieApiRequestBuilder id(String id) {
        this.id = id;
        return this;
    }

    public String build() {
        String url = base;

        if (this.id != null){
            return url + "/" + id;
        }

        boolean parameterAdded = false;
        if (this.query != null){
            url += "?query=" + query;
            parameterAdded = true;
        }
        if (this.genre != null){
            if (parameterAdded){
                url += "&genre=" + this.genre;
            }else{
                url += "?genre=" + this.genre;
                parameterAdded = true;
            }
        }
        if (this.releaseYear != null){
            if (parameterAdded){
                url += "&releaseYear=" + this.releaseYear;
            }else{
                url += "?releaseYear=" + this.releaseYear;
                parameterAdded = true;
            }
        }
        if (this.ratingFrom != null){
            if (parameterAdded){
                url += "&ratingFrom=" + this.ratingFrom;
            }else{
                url += "?ratingFrom=" + this.ratingFrom;
                parameterAdded = true;
            }
        }

        if (!parameterAdded) return url;

        return url;
    }
}
