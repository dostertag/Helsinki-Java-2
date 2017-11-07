/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reference;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import reference.domain.Film;
import reference.domain.Person;
import reference.domain.Rating;

/**
 *
 * @author kdost
 */
public class RatingRegister {
    private Map<Film, List<Rating>> register;
    private Map<Person, Map<Film, Rating>> personRating;
    
    public RatingRegister() {
        register = new HashMap<Film, List<Rating>>();
        personRating = new HashMap<Person, Map<Film, Rating>>();
    }
    public void addRating(Film film, Rating rating) {
        if(register.get(film) == null) {
            List<Rating> tempList = new ArrayList<Rating>();
            tempList.add(rating);
            register.put(film, tempList);
        } else {
            register.get(film).add(rating);
        }
    }
    public List<Rating> getRatings(Film film) {
        return register.get(film);
    }
    public Map<Film, List<Rating>> filmRatings() {
        return register;
    }
    public void addRating(Person person, Film film, Rating rating) {
        if (!this.personRating.containsKey(person)) {
            HashMap<Film, Rating> tempMap = new HashMap<Film, Rating>();
            tempMap.put(film, rating);
            this.personRating.put(person, tempMap);
            this.addRating(film, rating);
        } else if (!personRating.get(person).containsKey(film)) {
            this.personRating.get(person).put(film, rating);
            this.addRating(film, rating);
        }
    }
    public Rating getRating(Person person, Film film) {
        if(personRating.get(person).get(film) == null) {
            return Rating.NOT_WATCHED;
        }
        return personRating.get(person).get(film);
    }
    public Map<Film, Rating> getPersonalRatings(Person person) {
        if (personRating.containsKey(person)) {
            return personRating.get(person);
        }
        return new HashMap<Film, Rating>();

    }
    public List<Person> reviewers() {
        return new ArrayList<Person>(personRating.keySet());
    }
}
