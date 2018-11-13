package task1;

/**
 * @author Janik Mayr on 30.10.2018
 */
public class CheeseStats {
    private int numberOfHoles = 0;
    private int circumference = 0;
    private int xLim;
    private int yLim;

    public int getxLim() {
        return xLim;
    }

    public void setxLim(int xLim) {
        this.xLim = xLim;
    }

    public int getyLim() {
        return yLim;
    }

    public void setyLim(int yLim) {
        this.yLim = yLim;
    }

    public int getNumberOfHoles() {
        return numberOfHoles;
    }

    public void setNumberOfHoles(int numberOfHoles) {
        this.numberOfHoles = numberOfHoles;
    }

    public int getCircumference() {
        return circumference;
    }

    public void setCircumference(int ircumference) {
        this.circumference = ircumference;
    }

    public CheeseStats(){

    }
}
