package agh.ics.oop;

public class SetElement implements Comparable{
    private int fitst;
    private int secound;
    public SetElement(int fitst,int secound){
        this.fitst=fitst;
        this.secound=secound;
    }
    public int compareTo(Object other) {
        if (this == other) {
            return 0;
        }
        if (!(other instanceof SetElement)) {
            return -1;
        }
        SetElement that = (SetElement) other;
        if(this.fitst<that.fitst){
            return -1;
        }
        if(this.fitst>that.fitst){
            return 1;
        }
        if(this.secound<that.secound){
            return -1;
        }
        if(this.secound>that.secound){
            return 1;
        }
        return 0;
    }
    public int getFitst(){
        return this.fitst;
    }
    public boolean equals(Object other){
        if (this == other) {
            return true;
        }
        if (!(other instanceof SetElement)) {
            return false;
        }
        SetElement that = (SetElement) other;
        return this.fitst==that.fitst && this.secound==that.secound;
    }
    public int hashCode(){
        return this.fitst+this.secound;
    }
}
