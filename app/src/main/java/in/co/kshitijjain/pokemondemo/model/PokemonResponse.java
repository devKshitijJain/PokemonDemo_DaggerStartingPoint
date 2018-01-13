package in.co.kshitijjain.pokemondemo.model;

import java.util.List;

public class PokemonResponse {

    private int count;
    private String previous;
    private String next;
    private List<Pokemon> results;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getPrevious() {
        return previous;
    }

    public void setPrevious(String previous) {
        this.previous = previous;
    }

    public String getNext() {
        return next;
    }

    public void setNext(String next) {
        this.next = next;
    }

    public List<Pokemon> getResults() {
        return results;
    }

    public void setResults(List<Pokemon> results) {
        this.results = results;
    }

    public static class Pokemon {

        private String url;
        private String name;
        private int number;

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getName() {
            return name.substring(0, 1).toUpperCase() + name.substring(1);
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getNumber() {
            String[] urlParts = url.split("/");
            return Integer.parseInt(urlParts[urlParts.length - 1]);
        }

        public void setNumber(int number) {
            this.number = number;
        }
    }
}
