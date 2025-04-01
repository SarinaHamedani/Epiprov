import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

// BINOMIAL OPINIONS
public class SBooleanFusion implements Cloneable, Comparable<SBooleanFusion> {
    
    public static final SBooleanFusion UNCERTAIN = new SBooleanFusion(0.0D, 0.0D, 1.0D, 0.5D);

    protected double b; // belief mass: degree of belief that self is TRUE
    protected double d; // disbelief mass: degree of belief that self is FALSE
    protected double u; // uncertainty mass: amount of uncommitted belief  
    protected double a; // base rate: prior probability of self being TRUE

    protected double relativeWeight = 1.0D;

    /**
     * Constructors 
     */
    public SBooleanFusion() {
        this.b = 1.0D; this.d = 0.0D; this.u = 0.0D; this.a = 1.0D;
        this.relativeWeight = 1.0D;
    }

    public SBooleanFusion(boolean b) {
        if (b) { 
            this.b = 1.0D; 
            this.d = 0.0D; 
            this.u = 0.0D; 
            this.a = 1.0D;
        } else { 
            this.b = 0.0D; 
            this.d = 1.0D; 
            this.u = 0.0D; 
            this.a = 0.0D;
        }
        this.relativeWeight = 1.0D;
    }
    
    private double adjust(double value) {
        return (double)Math.round(value * 1000000.0D) / 1000000.0D;
    }

    public SBooleanFusion(double b, double d, double u, double a) {
        this.b = adjust(b); 
        this.d = adjust(d); 
        this.u = adjust(u); 
        this.a = adjust(a);
        this.relativeWeight = 1.0D;
        if (Math.abs(this.b + this.d + this.u - 1.0D) > 0.001D ||
            this.b < 0.0D || this.d < 0.0D || this.u < 0.0D || this.a < 0.0D || 
            this.b > 1.0D || this.d > 1.0D || this.u > 1.0D || this.a > 1.0D) 
            throw new IllegalArgumentException("SBooleanFusion constructor: Invalid parameters. b:" + this.b + ",d:" + this.d + ",u:" + this.u + ",a:" + this.a);
    }
    
    private SBooleanFusion(double b, double d, double u, double a, double relativeWeight) {
        this.b = adjust(b); 
        this.d = adjust(d); 
        this.u = adjust(u); 
        this.a = adjust(a);
        this.relativeWeight = adjust(relativeWeight);
        if (Math.abs(this.b + this.d + this.u - 1.0D) > 0.001 ||
            this.b < 0.0D || this.d < 0.0D || this.u < 0.0D || this.a < 0.0D || 
            this.b > 1.0D || this.d > 1.0D || this.u > 1.0D || this.a > 1.0D) 
            throw new IllegalArgumentException("SBooleanFusion constructor with relative weight: Invalid parameters. b:" + this.b + ",d:" + this.d + ",u:" + this.u + ",a:" + this.a);
    }
    
    public SBooleanFusion(String b, String d, String u, String a) {
        this.b = adjust(Double.parseDouble(b)); 
        this.d = adjust(Double.parseDouble(d)); 
        this.u = adjust(Double.parseDouble(u)); 
        this.a = adjust(Double.parseDouble(a));
        this.relativeWeight = 1.0D;
        if (Math.abs(this.b + this.d + this.u - 1.0D) > 0.001 ||
            this.b < 0.0D || this.d < 0.0D || this.u < 0.0D || this.a < 0.0D || 
            this.b > 1.0D || this.d > 1.0D || this.u > 1.0D || this.a > 1.0D)
            throw new IllegalArgumentException("SBooleanFusion constructor with strings: Invalid parameters. b:" + this.b + ",d:" + this.d + ",u:" + this.u + ",a:" + this.a);
    }
    
    /**
     * Getters (no public setters to respect well-formed rules)
     */
    public double belief() { return this.b; } 
    public double disbelief() { return this.d; } 
    public double uncertainty() { return this.u; } 
    public double baseRate() { return this.a; } 
    
    public double getRelativeWeight() {
        return this.isDogmatic() ? this.relativeWeight : 0.0D;
    }
    
    private double getRelativeWeight(SBooleanFusion opinion) {
        return adjust(this.relativeWeight / opinion.relativeWeight);
    }
    
    private void setRelativeWeight(double weight) { 
        this.relativeWeight = adjust(weight); 
    }

    /*********
     * Auxiliary operations
     */
    
    public double projection() {
        return adjust(this.b + this.a * this.u);
    }
    
    public double projectiveDistance(SBooleanFusion s) {
        return adjust(Math.abs(this.projection() - s.projection()));
    }
    
    public double conjunctiveCertainty(SBooleanFusion s) {
        return adjust((1.0D - this.u) * (1.0D - s.u));
    }
    
    public double degreeOfConflict(SBooleanFusion s) {
        return adjust(this.projectiveDistance(s) * this.conjunctiveCertainty(s));
    }
    
    public SBooleanFusion increasedUncertainty() {
        if (this.isVacuous()) return this.clone();
        double sqrt_u = Math.sqrt(this.uncertainty());
        double k = 1.0D - (sqrt_u - this.uncertainty()) / (this.belief() + this.disbelief());
        double brBelief = this.belief() * k;
        double brUncertainty = sqrt_u;
        double brDisbelief = this.disbelief() * k;
        return new SBooleanFusion(brBelief, brDisbelief, brUncertainty, this.baseRate());
    }
    
    public boolean isAbsolute() {
        return (this.belief() == 1.0D) || (this.disbelief() == 1.0D);
    }
    
    public boolean isVacuous() {
        return this.uncertainty() == 1.0D;
    }
    
    public boolean isCertain(double threshold) {
        return !isUncertain(threshold);
    }
    
    public boolean isDogmatic() {
        return this.uncertainty() == 0.0D;
    }
    
    public boolean isMaximizedUncertainty() {
        return (this.disbelief() == 0.0D) || (this.belief() == 0.0D);
    }
    
    public boolean isUncertain(double threshold) {
        return 1.0D - this.uncertainty() < threshold;
    }
    
    public SBooleanFusion uncertainOpinion() {
        return this.uncertaintyMaximized();
    }
    
    public final double certainty() {
        if (this.uncertainty() == (0.0D / 0.0D)) return (0.0D / 0.0D);
        return 1.0D - this.uncertainty();
    }
    
    /**
     * Dogmatic opinions are opinions with complete certainty (i.e., uncertainty = 0).
     */
    public static SBooleanFusion createDogmaticOpinion(double projection, double baseRate) {
        if ((projection < 0.0D) || (projection > 1.0D) || (baseRate < 0.0D) || (baseRate > 1.0D)) {
            throw new IllegalArgumentException("Create Dogmatic Opinion: Projections and baseRates should be between 0 and 1");
        }
        return new SBooleanFusion(projection, 1.0D - projection, 0.0D, baseRate);
    }
    
    /**
     * Vacuous opinions have an uncertainty of 1.
     */
    public static SBooleanFusion createVacuousOpinion(double projection) {
        if ((projection < 0.0D) || (projection > 1.0D)) {
            throw new IllegalArgumentException("CreateVacuousOpinion: Projection must be between 0 and 1. p=" + projection);
        }
        return new SBooleanFusion(0.0D, 0.0D, 1.0D, projection);
    }
    
    /*********
     * Type Operations
     */
    
    public SBooleanFusion not() {
        return new SBooleanFusion(this.d, this.b, this.u, 1.0D - this.a, this.relativeWeight);
    }
    
    public SBooleanFusion and(SBooleanFusion s) { // assumes independent variables
        if (this == s) return this.clone(); // x and x = x
        
        double newB = this.b * s.b + (this.a * s.a == 1.0D ? 0.0D : ((1.0D - this.a) * s.a * this.b * this.u + this.a * (1.0D - s.a) * this.u * s.b) / (1.0D - this.a * s.a));
        double newD = this.d + s.d - this.d * s.d;
        SBooleanFusion result = new SBooleanFusion(
            newB,
            newD,
            1 - newD - newB,
            this.a * s.a,
            this.getRelativeWeight() + s.getRelativeWeight()
        );
        return result;
    }
    
    public SBooleanFusion or(SBooleanFusion s) { // assumes independent variables
        if (this == s) return this.clone(); // x or x = x
        
        double newB = this.b + s.b - this.b * s.b;
        double newD = this.d * s.d + (this.a + s.a == this.a * s.a ? 0.0D : (this.a * (1 - s.a) * this.d * s.u + s.a * (1 - this.a) * this.u * s.d) / (this.a + s.a - this.a * s.a));
        SBooleanFusion result = new SBooleanFusion(
            newB,
            newD,
            1 - newB - newD,
            this.a + s.a - this.a * s.a,
            this.getRelativeWeight() + s.getRelativeWeight()
        );
        return result;
    }
    
    public SBooleanFusion implies(SBooleanFusion s) {
        return this.not().or(s);
    }
    
    public SBooleanFusion equivalent(SBooleanFusion s) {
        return this.xor(s).not();
    }
    
    public SBooleanFusion xor(SBooleanFusion s) {
        SBooleanFusion result = new SBooleanFusion(
            Math.abs(this.b - s.b),
            1.0D - Math.abs(this.b - s.b) - this.u * s.u,
            this.u * s.u,
            Math.abs(this.a - s.a),
            this.getRelativeWeight() + s.getRelativeWeight()
        );
        return result;
    }
    
    public SBooleanFusion uncertaintyMaximized() {
        double p = this.projection();
        if ((this.a == 1.0D) && (p == 1.0D)) return new SBooleanFusion(0.0D, 0.0D, 1.0D, this.a, this.getRelativeWeight());
        if ((this.a == 1.0D) && (this.u == 1.0D)) return new SBooleanFusion(0.0D, 0.0D, 1.0D, this.a, this.getRelativeWeight());
        if (this.a == 0.0D && (this.b == 0.0D)) return new SBooleanFusion(0.0D, 0.0D, 1.0D, this.a, this.getRelativeWeight());
        if (p < this.a)
            return new SBooleanFusion(0.0D, 1.0D - (p / this.a), p / this.a, this.a, this.getRelativeWeight());
        return new SBooleanFusion((p - this.a) / (1.0D - this.a), 0.0D, (1.0D - p) / (1.0D - this.a), this.a, this.getRelativeWeight());
    }
    
    public SBooleanFusion deduceY(SBooleanFusion yGivenX, SBooleanFusion yGivenNotX) {
        SBooleanFusion y = new SBooleanFusion();
        double px = this.projection();
        double K;
        y.a = (yGivenX.u + yGivenNotX.u < 2.0D) ? 
              (this.a * yGivenX.b + (1.0D - this.a) * yGivenNotX.b) / (1.0D - this.a * yGivenX.u - (1.0D - this.a) * yGivenNotX.u) 
              : yGivenX.a;
        double pyxhat = yGivenX.b * this.a + yGivenNotX.b * (1 - this.a) + y.a * (yGivenX.u * this.a + yGivenNotX.u * (1 - this.a));
        double bIy = this.b * yGivenX.b + this.d * yGivenNotX.b + this.u * (yGivenX.b * this.a + yGivenNotX.b * (1.0D - this.a));
        double dIy = this.b * yGivenX.d + this.d * yGivenNotX.d + this.u * (yGivenX.d * this.a + yGivenNotX.d * (1.0D - this.a));
        double uIy = this.b * yGivenX.u + this.d * yGivenNotX.u + this.u * (yGivenX.u * this.a + yGivenNotX.u * (1.0D - this.a));
        K = 0.0D;
        if ((yGivenX.b > yGivenNotX.b) && (yGivenX.d <= yGivenNotX.d) &&
            (pyxhat <= (yGivenNotX.b + y.a * (1.0D - yGivenNotX.b - yGivenX.d))) &&
            (px <= this.a))
            { K = (this.a * this.u * (bIy - yGivenNotX.b)) / ((this.b + this.a * this.u) * y.a); }
        if ((yGivenX.b > yGivenNotX.b) && (yGivenX.d <= yGivenNotX.d) &&
            (pyxhat <= (yGivenNotX.b + y.a * (1.0D - yGivenNotX.b - yGivenX.d))) &&
            (px > this.a))
            { K = (this.a * this.u * (dIy - yGivenX.d) * (yGivenX.b - yGivenNotX.b)) / ((this.d + (1.0D - this.a) * this.u) * y.a * (yGivenNotX.d - yGivenX.d)); }
        if ((yGivenX.b > yGivenNotX.b) && (yGivenX.d <= yGivenNotX.d) &&
            (pyxhat > (yGivenNotX.b + y.a * (1.0D - yGivenNotX.b - yGivenX.d))) &&
            (px <= this.a))
            { K = ((1.0D - this.a) * this.u * (bIy - yGivenNotX.b) * (yGivenNotX.d - yGivenX.d)) / ((this.b + this.a * this.u) * (1.0D - y.a) * (yGivenX.b - yGivenNotX.b)); }
        if ((yGivenX.b > yGivenNotX.b) && (yGivenX.d <= yGivenNotX.d) &&
            (pyxhat > (yGivenNotX.b + y.a * (1.0D - yGivenNotX.b - yGivenX.d))) &&
            (px > this.a))
            { K = ((1.0D - this.a) * this.u * (dIy - yGivenX.d)) / ((this.d + (1.0D - this.a) * this.u) * (1.0D - y.a)); }
        if ((yGivenX.b <= yGivenNotX.b) && (yGivenX.d > yGivenNotX.d) &&
            (pyxhat <= (yGivenX.b + y.a * (1.0D - yGivenNotX.b - yGivenX.d))) &&
            (px <= this.a))
            { K = ((1.0D - this.a) * this.u * (dIy - yGivenNotX.d) * (yGivenNotX.b - yGivenX.b)) / ((this.b + this.a * this.u) * y.a * (yGivenX.d - yGivenNotX.d)); }
        if ((yGivenX.b <= yGivenNotX.b) && (yGivenX.d > yGivenNotX.d) &&
            (pyxhat <= (yGivenX.b + y.a * (1.0D - yGivenX.b - yGivenNotX.d))) &&
            (px > this.a))
            { K = ((1.0D - this.a) * this.u * (bIy - yGivenX.d)) / ((this.d + (1.0D - this.a) * this.u) * y.a); }
        if ((yGivenX.b <= yGivenNotX.b) && (yGivenX.d > yGivenNotX.d) &&
            (pyxhat > (yGivenX.b + y.a * (1.0D - yGivenX.b - yGivenNotX.d))) &&
            (px <= this.a))
            { K = (this.a * this.u * (dIy - yGivenNotX.b)) / ((this.b + this.a * this.u) * (1.0D - y.a)); }
        if ((yGivenX.b <= yGivenNotX.b) && (yGivenX.d > yGivenNotX.d) &&
            (pyxhat > (yGivenX.b + y.a * (1.0D - yGivenX.b - yGivenNotX.d))) &&
            (px > this.a))
            { K = (this.a * this.u * (bIy - yGivenX.b) * (yGivenX.d - yGivenNotX.d)) / ((this.d + (1.0D - this.a) * this.u) * (1.0D - y.a) * (yGivenNotX.b - yGivenX.b)); }
        
        y.b = adjust(bIy - y.a * K);
        y.d = adjust(dIy - (1.0D - y.a) * K);
        y.u = adjust(uIy + K);
        y.setRelativeWeight(yGivenX.getRelativeWeight() + yGivenNotX.getRelativeWeight());
        return y;
    }
    
    public final SBooleanFusion bcFusion(SBooleanFusion opinion) {
        // Implemented using equation 12.2 from Josang's book.
        double harmony = this.belief() * opinion.uncertainty() 
                       + this.uncertainty() * opinion.belief() 
                       + this.belief() * opinion.belief();
        double conflict = this.belief() * opinion.disbelief() 
                        + this.disbelief() * opinion.belief();
        if (conflict == 1.0D) {
            return null;
        } else {
            double newB = harmony / (1.0D - conflict);
            double newU = (this.uncertainty() * opinion.uncertainty()) / (1.0D - conflict);
            // Compute the new base rate (atomicity) depending on uncertainties.
            double newA;
            if (Math.abs(this.uncertainty() + opinion.uncertainty() - 2.0D) < 0.001D) {
                newA = (this.baseRate() + opinion.baseRate()) / 2.0D;
            } else {
                newA = (this.baseRate() * (1.0D - this.uncertainty()) 
                      + opinion.baseRate() * (1.0D - opinion.uncertainty())) 
                      / (2 - this.uncertainty() - opinion.uncertainty());
            }
            // The disbelief is then given by 1 - newB - newU.
            return new SBooleanFusion(newB, 1.0D - newB - newU, newU, newA);
        }
    }

    
    /************************************
     *  FUSION OPERATIONS 
     ************************************/
    
    public static SBooleanFusion beliefConstraintFusion(Collection<SBooleanFusion> opinions) {
        if (opinions.contains(null) || opinions.size() < 2)
            throw new IllegalArgumentException("BCF: Cannot fuse null opinions, or only one opinion was passed");
        SBooleanFusion bcf = null;
        for (SBooleanFusion so : opinions) {
            if (bcf == null)
                bcf = so;
            else
                bcf = bcf.bcFusion(so);
            if (bcf == null)
                break;
        }
        return bcf;
    }
    
    public static SBooleanFusion minimumBeliefFusion(Collection<SBooleanFusion> opinions) {
        if (opinions.contains(null) || opinions.size() < 2)
            throw new IllegalArgumentException("MBF: Cannot fuse null opinions, or only one opinion was passed");
        SBooleanFusion min = null;
        for (SBooleanFusion so : opinions) {
            if (min == null)
                min = so;
            min = min.min(so);
        }
        return min.clone();
    }
    
    public static SBooleanFusion majorityBeliefFusion(Collection<SBooleanFusion> opinions) {
        if (opinions.contains(null) || opinions.size() < 2)
            throw new IllegalArgumentException("MajBF: Cannot fuse null opinions, or only one opinion was passed");
        int pos = 0, neg = 0;
        for (SBooleanFusion so : opinions) {
            if (so.projection() < so.a)
                neg++;
            else if (so.projection() > so.a)
                pos++;
        }
        if (pos > neg)
            return new SBooleanFusion(1D, 0D, 0D, 0.5D);
        else if (pos < neg)
            return new SBooleanFusion(0D, 1D, 0D, 0.5D);
        else
            return new SBooleanFusion(0D, 0D, 1D, 0.5D);
    }
    
    public static SBooleanFusion averageBeliefFusion(Collection<SBooleanFusion> opinions) {
        if (opinions == null || opinions.contains(null) || opinions.isEmpty())
            throw new IllegalArgumentException("AVF: Cannot average null opinions");
        double b = 0.0D, u = 0.0D, a = 0.0D;
        double PU = 1.0D;
        int count = 0;
        for (SBooleanFusion o : opinions)
            PU *= o.uncertainty();
        if (PU != 0) {
            for (SBooleanFusion o : opinions) {
                u += PU / o.uncertainty();
                b += o.belief() * (PU / o.uncertainty());
                a += o.baseRate();
            }
            double oBelief = b / u;
            double oAtomicity = a / opinions.size();
            double oUncertainty = opinions.size() * PU / u;
            double oDisbelief = 1.0D - oBelief - oUncertainty;
            return new SBooleanFusion(oBelief, oDisbelief, oUncertainty, oAtomicity);
        } else {
            for (SBooleanFusion o : opinions) {
                if (o.uncertainty() == 0.0D) {
                    b += o.belief();
                    a += o.baseRate();
                    count++;
                }
            }
            double oBelief = b / count;
            double oAtomicity = a / count;
            double oUncertainty = 0.0D;
            double oDisbelief = 1.0D - oBelief - oUncertainty;
            return new SBooleanFusion(oBelief, oDisbelief, oUncertainty, oAtomicity);
        }
    }
    
    public static SBooleanFusion cumulativeBeliefFusion(Collection<SBooleanFusion> opinions) {
        if (opinions == null || opinions.contains(null) || opinions.isEmpty())
            throw new IllegalArgumentException("aCBF: Cannot average null opinions");
        if (opinions.size() == 1)
            return opinions.iterator().next().clone();
        
        double resultBelief, resultDisbelief, resultUncertainty, resultRelativeWeight = 0, resultAtomicity = -1;
        Collection<SBooleanFusion> dogmatic = new ArrayList<>(opinions.size());
        Iterator<SBooleanFusion> it = opinions.iterator();
        boolean first = true;
        while (it.hasNext()) {
            SBooleanFusion o = it.next();
            if (first) {
                resultAtomicity = o.baseRate();
                first = false;
            }
            if (o.uncertainty() == 0.0D)
                dogmatic.add(o);
        }
        if (dogmatic.isEmpty()) {
            double productOfUncertainties = opinions.stream().mapToDouble(o -> o.uncertainty()).reduce(1.0D, (acc, u) -> acc * u);
            double numerator = 0.0D;
            double beliefAccumulator = 0.0D;
            double disbeliefAccumulator = 0.0D;
            for (SBooleanFusion o : opinions) {
                double productWithoutO = productOfUncertainties / o.uncertainty();
                beliefAccumulator += productWithoutO * o.belief();
                disbeliefAccumulator += productWithoutO * o.disbelief();
                numerator += productWithoutO;
            }
            numerator = numerator - (opinions.size() - 1) * productOfUncertainties;
            resultBelief = beliefAccumulator / numerator;
            resultDisbelief = disbeliefAccumulator / numerator;
            resultUncertainty = productOfUncertainties / numerator;
            resultRelativeWeight = 0.0D;
        } else {
            double totalWeight = dogmatic.stream().mapToDouble(o -> o.getRelativeWeight()).sum();
            resultBelief = dogmatic.stream().mapToDouble(o -> o.getRelativeWeight() / totalWeight * o.belief()).sum();
            resultDisbelief = dogmatic.stream().mapToDouble(o -> o.getRelativeWeight() / totalWeight * o.disbelief()).sum();
            resultUncertainty = 0.0D;
            resultRelativeWeight = totalWeight;
        }
        SBooleanFusion result = new SBooleanFusion(resultBelief, resultDisbelief, resultUncertainty, resultAtomicity, resultRelativeWeight);
        return result.uncertaintyMaximized();
    }
    
    public static SBooleanFusion epistemicCumulativeBeliefFusion(Collection<SBooleanFusion> opinions) {
        if (opinions == null || opinions.contains(null) || opinions.isEmpty())
            throw new IllegalArgumentException("eCBF: Cannot average null opinions");
        if (opinions.size() == 1)
            return opinions.iterator().next().clone();
        double resultBelief, resultDisbelief, resultUncertainty, resultRelativeWeight = 0.0D, resultAtomicity = -1.0D;
        Collection<SBooleanFusion> dogmatic = new ArrayList<>(opinions.size());
        Iterator<SBooleanFusion> it = opinions.iterator();
        boolean first = true;
        while (it.hasNext()) {
            SBooleanFusion o = it.next();
            if (first) {
                resultAtomicity = o.baseRate();
                first = false;
            }
            if (o.uncertainty() == 0.0D)
                dogmatic.add(o);
        }
        if (dogmatic.isEmpty()) {
            double productOfUncertainties = opinions.stream().mapToDouble(o -> o.uncertainty()).reduce(1.0D, (acc, u) -> acc * u);
            double numerator = 0.0D;
            double beliefAccumulator = 0.0D;
            double disbeliefAccumulator = 0.0D;
            for (SBooleanFusion o : opinions) {
                double productWithoutO = productOfUncertainties / o.uncertainty();
                beliefAccumulator += productWithoutO * o.belief();
                disbeliefAccumulator += productWithoutO * o.disbelief();
                numerator += productWithoutO;
            }
            numerator = numerator - (opinions.size() - 1) * productOfUncertainties;
            resultBelief = beliefAccumulator / numerator;
            resultDisbelief = disbeliefAccumulator / numerator;
            resultUncertainty = productOfUncertainties / numerator;
            resultRelativeWeight = 0.0D;
        } else {
            double totalWeight = dogmatic.stream().mapToDouble(o -> o.getRelativeWeight()).sum();
            double sumBelief = dogmatic.stream().mapToDouble(o -> o.getRelativeWeight() / totalWeight * o.belief()).sum();
            double sumDisbelief = dogmatic.stream().mapToDouble(o -> o.getRelativeWeight() / totalWeight * o.disbelief()).sum();
            resultBelief = sumBelief;
            resultDisbelief = sumDisbelief;
            resultUncertainty = 0.0;
            resultRelativeWeight = totalWeight;
        }
        SBooleanFusion result = new SBooleanFusion(resultBelief, resultDisbelief, resultUncertainty, resultAtomicity, resultRelativeWeight);
        return result.uncertaintyMaximized();
    }
    
    public static SBooleanFusion weightedBeliefFusion(Collection<SBooleanFusion> opinions) {
        if (opinions == null || opinions.contains(null) || opinions.isEmpty())
            throw new IllegalArgumentException("WBF: Cannot average null opinions");
        if (opinions.size() == 1)
            return opinions.iterator().next().clone();
        double resultBelief, resultDisbelief, resultUncertainty, resultRelativeWeight = 0, resultAtomicity;
        Collection<SBooleanFusion> dogmatic = new ArrayList<>(opinions.size());
        Iterator<SBooleanFusion> it = opinions.iterator();
        while (it.hasNext()) {
            SBooleanFusion o = it.next();
            if (o.uncertainty() == 0)
                dogmatic.add(o);
        }
        if (dogmatic.isEmpty() && opinions.stream().anyMatch(o -> o.certainty() > 0)) {
            double productOfUncertainties = opinions.stream().mapToDouble(o -> o.uncertainty()).reduce(1.0D, (acc, u) -> acc * u);
            double sumOfUncertainties = opinions.stream().mapToDouble(o -> o.uncertainty()).sum();
            double numerator = 0.0D;
            double beliefAccumulator = 0.0D;
            double disbeliefAccumulator = 0.0D;
            double atomicityAccumulator = 0.0D;
            for (SBooleanFusion o : opinions) {
                double prod = productOfUncertainties / o.uncertainty();
                beliefAccumulator += prod * o.belief() * o.certainty();
                disbeliefAccumulator += prod * o.disbelief() * o.certainty();
                atomicityAccumulator += o.baseRate() * o.certainty();
                numerator += prod;
            }
            numerator = numerator - opinions.size() * productOfUncertainties;
            resultBelief = beliefAccumulator / numerator;
            resultDisbelief = disbeliefAccumulator / numerator;
            resultUncertainty = (opinions.size() - sumOfUncertainties) * productOfUncertainties / numerator;
            resultAtomicity = atomicityAccumulator / (opinions.size() - sumOfUncertainties);
        } else if (opinions.stream().allMatch(o -> o.uncertainty() == 1)) {
            resultBelief = 0;
            resultDisbelief = 0;
            resultUncertainty = 1;
            double sumBaseRate = 0.0;
            for (SBooleanFusion o : opinions) {
                sumBaseRate += o.baseRate();
            }
            resultAtomicity = sumBaseRate / opinions.size();
        } else {
            double totalWeight = dogmatic.stream().mapToDouble(o -> o.getRelativeWeight()).sum();
            resultBelief = dogmatic.stream().mapToDouble(o -> o.getRelativeWeight() / totalWeight * o.belief()).sum();
            resultDisbelief = dogmatic.stream().mapToDouble(o -> o.getRelativeWeight() / totalWeight * o.disbelief()).sum();
            resultUncertainty = 0.0D;
            resultRelativeWeight = totalWeight;
            resultAtomicity = -1;
            boolean first = true;
            for (SBooleanFusion o : opinions) {
                if (first) {
                    resultAtomicity = o.baseRate();
                    first = false;
                }
            }
        }
        SBooleanFusion result = new SBooleanFusion(resultBelief, resultDisbelief, resultUncertainty, resultAtomicity, resultRelativeWeight);
        return result;
    }
    
    /****
     * DISCOUNTING OPERATIONS
     ****/
    
    public final SBooleanFusion discount(SBooleanFusion AtrustOnB) {
        if (AtrustOnB == null)
            throw new IllegalArgumentException("Discount operator parameter cannot be null");
        double p = AtrustOnB.projection();
        double newB = p * this.belief();
        double newD = p * this.disbelief();
        double newU = 1 - p * (this.disbelief() + this.belief());
        double newA = this.baseRate();
        return new SBooleanFusion(newB, newD, newU, newA);
    }
    
    public final SBooleanFusion discountB(SBooleanFusion AtrustOnB) {
        if (AtrustOnB == null)
            throw new IllegalArgumentException("Discount operator parameter cannot be null");
        double p = AtrustOnB.belief();
        double newB = p * this.belief();
        double newD = p * this.disbelief();
        double newU = 1 - newB - newD;
        double newA = this.baseRate();
        return new SBooleanFusion(newB, newD, newU, newA);
    }
    
    public final SBooleanFusion discount(Collection<SBooleanFusion> agentsTrusts) {
        if (agentsTrusts == null)
            throw new IllegalArgumentException("Discount operator parameter cannot be null");
        double p = agentsTrusts.stream().mapToDouble(o -> o.projection()).reduce(1.0, (acc, value) -> acc * value);
        double newB = p * this.belief();
        double newD = p * this.disbelief();
        double newU = 1 - p * (this.disbelief() + this.belief());
        double newA = this.baseRate();
        return new SBooleanFusion(newB, newD, newU, newA);
    }
    
    public final SBooleanFusion discountB(Collection<SBooleanFusion> agentsTrusts) {
        if (agentsTrusts == null)
            throw new IllegalArgumentException("Discount operator parameter cannot be null");
        double p = agentsTrusts.stream().mapToDouble(o -> o.belief()).reduce(1.0, (acc, value) -> acc * value);
        double newB = p * this.belief();
        double newD = p * this.disbelief();
        double newU = 1 - p * (this.disbelief() + this.belief());
        double newA = this.baseRate();
        return new SBooleanFusion(newB, newD, newU, newA);
    }
    
    /****
     * COMPARISON AND CONVERSION OPERATIONS
     ****/
    
    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        SBooleanFusion that = (SBooleanFusion) o;
        return Math.abs(this.belief() - that.belief()) < 0.001D &&
               Math.abs(this.disbelief() - that.disbelief()) < 0.001D &&
               Math.abs(this.uncertainty() - that.uncertainty()) < 0.001D &&
               Math.abs(this.baseRate() - that.baseRate()) < 0.001D;
    }
    
    public boolean distinct(SBooleanFusion b) {
        return !this.equals(b);
    }
    
    public SBooleanFusion min(SBooleanFusion opinion) {
        return this.projection() <= opinion.projection() ? this : opinion;
    }
    
    public SBooleanFusion max(SBooleanFusion opinion) {
        return this.projection() >= opinion.projection() ? this : opinion;
    }
    
    @Override
    public int hashCode() {
        int result;
        result = Math.round((float)this.b * 100) + 10 * Math.round((float)this.d * 100)
                 + 100 * Math.round((float)this.u * 100) + 1000 * Math.round((float)this.a * 100);
        return result;
    }
    
    /******
     * Conversions
     ******/
    
    @Override
    public String toString() {
        return String.format("SBooleanFusion(%5.2f, %5.2f, %5.2f, %5.2f)", this.b, this.d, this.u, this.a);
    }
    
    @Override
    public int compareTo(SBooleanFusion other) {
        double diff = Math.abs(this.belief() - other.belief()) +
                      Math.abs(this.disbelief() - other.disbelief()) +
                      Math.abs(this.uncertainty() - other.uncertainty()) +
                      Math.abs(this.baseRate() - other.baseRate());
        if (diff < 0.001D)
            return 0;
        return (this.projection() - other.projection() < 0 ? -1 : 1);
    }
    
    @Override
    public SBooleanFusion clone() {
        return new SBooleanFusion(this.belief(), this.disbelief(), this.uncertainty(), this.baseRate(), this.relativeWeight);
    }
}
