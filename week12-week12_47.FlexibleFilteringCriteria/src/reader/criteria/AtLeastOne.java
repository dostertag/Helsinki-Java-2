/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reader.criteria;

import java.util.List;

/**
 *
 * @author kdost
 */
public class AtLeastOne implements Criterion {
    private Criterion[] criteria;
    public AtLeastOne(Criterion... values) {
        criteria = values;
    }
    @Override
    public boolean complies(String line) {
        for (Criterion c : criteria) {
            if(c.complies(line)) {
                return true;
            }
        }
        return false;
    }
    
}
