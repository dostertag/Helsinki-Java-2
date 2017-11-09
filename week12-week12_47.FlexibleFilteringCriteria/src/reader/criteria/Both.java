/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reader.criteria;

/**
 *
 * @author kdost
 */
public class Both implements Criterion {
    
    private Criterion crit1;
    private Criterion crit2;
    
    public Both(Criterion crit1, Criterion crit2) {
        this.crit1 = crit1;
        this.crit2 = crit2;
    }

    @Override
    public boolean complies(String line) {
        return (crit1.complies(line) && crit2.complies(line));
    }
    
}
