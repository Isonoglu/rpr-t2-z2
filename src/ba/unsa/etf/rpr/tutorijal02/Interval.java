package ba.unsa.etf.rpr.tutorijal02;

public class Interval {
    private double t1, t2;
    private boolean b1, b2;
    public Interval(double t1, double t2, boolean b1, boolean b2){
        if(t1 > t2) throw new IllegalArgumentException("GRESKA");
        this.t1 = t1;
        this.t2 = t2;
        this.b1 = b1;
        this.b2 = b2;
    }

    public Interval() {
        this.t1 = 0;
        this.t2 = 0;
        this.b1 = false;
        this.b2 = false;
    }

    public static Interval intersect(Interval i, Interval i2) {
        {
            Interval vrati = new Interval();
            double dole = 0, gore = 0;
            boolean Tdole = false, Tgore = false;

            if(i.isIn(i2.getT1())) {
                dole = i2.getT1();
                Tdole = i2.isB1();
            }

            if(i.isIn(i2.getT2())) {
                gore = i2.getT2();
                Tgore = i2.isB2();
            }

            if(i2.isIn(i.getT1())) {
                dole = i.getT1();
                Tdole = i.isB1();
            }

            if(i2.isIn(i.getT2())) {
                gore = i.getT2();
                Tgore = i.isB2();
            }
            vrati.setT1(dole);
            vrati.setB1(Tdole);
            vrati.setT2(gore);
            vrati.setB2(Tgore);
            return vrati;
        }
    }

    public double getT1() {
        return t1;
    }

    public void setT1(double t1) {
        this.t1 = t1;
    }

    public double getT2() {
        return t2;
    }

    public void setT2(double t2) {
        this.t2 = t2;
    }

    public boolean isB1() {
        return b1;
    }

    public void setB1(boolean b1) {
        this.b1 = b1;
    }

    public boolean isB2() {
        return b2;
    }

    public void setB2(boolean b2) {
        this.b2 = b2;
    }

    @Override
    public String toString() {
        String zagradaLijevo = "(", zagradaDesno = ")";
        if(this.isB1()) zagradaLijevo = "[";
        if(this.isB2()) zagradaDesno = "]";

        if(Double.compare(this.t1,0) == 0 && Double.compare(this.t2,0) == 0)return "()";
        return zagradaLijevo + t1 + "," + t2 + zagradaDesno;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Interval)) return false;
        Interval interval = (Interval) o;
        return  Double.compare(interval.t1, t1) == 0 &&
                Double.compare(interval.t2, t2) == 0 &&
                b1 == interval.b1 &&
                b2 == interval.b2;
    }

    public boolean isIn(double v) {
        System.out.println(this.getT1() + " " + this.getT2());
        if(this.b1 && this.b2)
            if((Double.compare(this.t1,v) == 0 || Double.compare(this.t1,v) == -1) && (Double.compare(this.t2,v) == 0 || Double.compare(this.t2,v) == 1))  return true;
        if(this.b1)
            if (Double.compare(this.t2, v) == 1 && (Double.compare(this.t1, v) == 0 || Double.compare(this.t1, v) == -1)) return true;
        if(this.b2)
            if(Double.compare(this.t1,v) == -1 && (Double.compare(this.t2,v) == 0 || Double.compare(this.t2,v) == 1)) return true;
        if(Double.compare(this.t1,v) == -1 && Double.compare(this.t2,v) == 1) return true;
        return false;
    }

    public boolean isNull() {
        if ( Math.abs(this.t1 -this.t2) < 0.001 ) return true;
        return false;
    }


    public Interval intersect(Interval interval) {
        return Interval.intersect(this,interval);
    }
}
