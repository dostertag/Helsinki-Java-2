/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reference;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import reference.comparator.FilmComparator;
import reference.comparator.PersonComparator;
import reference.domain.Film;
import reference.domain.Person;
import reference.domain.Rating;

/**
 *
 * @author kdost
 */
public class Reference {
    private RatingRegister reg;
    
    public Reference(RatingRegister reg) {
        this.reg = reg;
    }
    public Film recommendFilm(Person person) {
        if(reg.getPersonalRatings(person).isEmpty()) {
            List<Film> tempList = new ArrayList<Film>(reg.filmRatings().keySet());
            Collections.sort(tempList, new FilmComparator(reg.filmRatings()));
            return tempList.get(0);
        }
        List<Person> reviewersSortedBySimilarity = reviewersSortBySimilarity(person);
        
        return getRecommendedFilm(person, reviewersSortedBySimilarity);
    }
    
    private List<Person> reviewersSortBySimilarity(Person viewer) {
        Map<Person, Integer> reviewerSimilarity = reviewerSimilarity(reg.getPersonalRatings(viewer));
        List<Person> similarReviewers = new ArrayList<Person>(reviewerSimilarity.keySet());
        Collections.sort(similarReviewers, new PersonComparator(reviewerSimilarity));
        return similarReviewers;
    }
    
    private Map<Person, Integer> reviewerSimilarity(Map<Film, Rating> filmRatings) {
        Map<Person, Integer> reviewerSimilarity = new HashMap<Person, Integer>();
        
        for (Person reviewer : reg.reviewers()) {
            int similarity = 0;
            
            for (Film film : filmRatings.keySet()) {
                similarity += filmRatings.get(film).getValue() * reg.getRating(reviewer, film).getValue();
            }
            if (similarity > 0) {
                reviewerSimilarity.put(reviewer, similarity);
            }
        }
        return reviewerSimilarity;
    }
    
    private Film getRecommendedFilm(Person viewer, List<Person> reviewersSortedBySimilarity) {
        Map<Film, Rating> viewersSeenFilms = reg.getPersonalRatings(viewer);

        for (Person reviewer : reviewersSortedBySimilarity) {
            if (reviewer == viewer) {
                continue;
            }
            for (Film film : reg.getPersonalRatings(reviewer).keySet()) {
                if (viewersSeenFilms.containsKey(film)) { 
                    continue;
                }
                if (reg.getPersonalRatings(reviewer).get(film).getValue() > 1) {
                    return film;
                }
            }
        }
        return null;
    }     
}
