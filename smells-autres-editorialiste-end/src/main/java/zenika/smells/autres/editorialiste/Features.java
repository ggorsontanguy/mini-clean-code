package zenika.smells.autres.editorialiste;

import java.util.HashSet;
import java.util.Set;

import static java.util.Arrays.asList;
import static java.util.Collections.unmodifiableSet;

public class Features {
    
    private final Set<String> features;
    
    public Features(String... features) {
        this.features = asSet(features);
    }

    public static FeatureDiff compare(Features f1, Features f2) {
        Set<String> sharedByBoth = new HashSet<>(f1.features);
        sharedByBoth.retainAll(f2.features);
        
        Set<String> specificToFirst = new HashSet<>(f1.features);
        specificToFirst.removeAll(sharedByBoth);
        
        Set<String> specificToSecond = new HashSet<>(f2.features);
        specificToSecond.removeAll(sharedByBoth);
        
        return new FeatureDiff(specificToFirst, specificToSecond, sharedByBoth);                    
    } 

    @SafeVarargs @SuppressWarnings("varargs")
    static <T> Set<T> asSet(T... elts) {
        return unmodifiableSet(new HashSet<>(asList(elts)));
    }
}
