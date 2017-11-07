/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reference.comparator;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import reference.domain.Film;
import reference.domain.Rating;

/**
 *
 * @author kdost
 */
public class FilmComparator implements Comparator<Film> {
    private Map<Film, List<Rating>> ratings;
    
    public FilmComparator(Map<Film, List<Rating>> ratings) {
        this.ratings = ratings;
    }

    @Override
    public int compare(Film o1, Film o2) {
        double ratings1 = 0;
        double ratings2 = 0;
        
        for(Rating rat : ratings.get(o1)) {
            ratings1 += rat.getValue();
        }
        ratings1 /= ratings.get(o1).size();
        
        for(Rating r : ratings.get(o2)) {
            ratings2 += r.getValue();
        }
        ratings2 /= ratings.get(o2).size();
        
        if(ratings1 == ratings2) {
            return 0;
        } else if(ratings1 > ratings2) {
            return -1;
        } else {
            return 1;
        }
    }
    
}
