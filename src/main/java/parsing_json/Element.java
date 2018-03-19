package parsing_json;

import com.google.gson.Gson;

import java.io.Reader;
import java.util.ArrayList;

public class Element {




    private String name;
    private String appearance;
    private double atomic_Mass;
    private double boil;
    private String category;
    private String color;
    private double density;
    private String discovered_By;
    private double melt;
    private double molar_heat;
    private String named_By;
    private int number;
    private int period;
    private String phase;
    private String source;
    private String spectral_img;
    private String summary;
    private String symbol;
    private int xpos;
    private int ypos;
    private ArrayList<Integer> shells;

    Gson jsonParser = new Gson();
    public Element(Reader inputString){
        jsonParser.fromJson(inputString, Element.class);
    }

    public Element(String name, String appearance, double atomic_Mass, double boil, String category, String color,
                   double density, String discovered_By, double melt, double molar_heat, String named_By, int number,
                   int period, String phase, String source, String spectral_img, String summary, String symbol,
                   int xpos, int ypos, ArrayList<Integer> shells) {
        this.name = name;
        this.appearance = appearance;
        this.atomic_Mass = atomic_Mass;
        this.boil = boil;
        this.category = category;
        this.color = color;
        this.density = density;
        this.discovered_By = discovered_By;
        this.melt = melt;
        this.molar_heat = molar_heat;
        this.named_By = named_By;
        this.number = number;
        this.period = period;
        this.phase = phase;
        this.source = source;
        this.spectral_img = spectral_img;
        this.summary = summary;
        this.symbol = symbol;
        this.xpos = xpos;
        this.ypos = ypos;
        this.shells = shells;
    }

    public String getName() {
        return name;
    }

    public String getAppearance() {
        return appearance;
    }

    public double getAtomic_mass() {
        return atomic_Mass;
    }

    public double getBoil() {
        return boil;
    }

    public String getCategory() {
        return category;
    }

    public String getColor() {
        return color;
    }

    public double getDensity() {
        return density;
    }

    public String getDiscovered_by() {
        return discovered_By;
    }

    public double getMelt() {
        return melt;
    }

    public double getMolar_heat() {
        return molar_heat;
    }

    public String getNamed_by() {
        return named_By;
    }

    public int getNumber() {
        return number;
    }

    public int getPeriod() {
        return period;
    }

    public String getPhase() {
        return phase;
    }

    public String getSource() {
        return source;
    }

    public String getSpectral_img() {
        return spectral_img;
    }

    public String getSummary() {
        return summary;
    }

    public String getSymbol() {
        return symbol;
    }

    public int getXpos() {
        return xpos;
    }

    public int getYpos() {
        return ypos;
    }

    public ArrayList<Integer> getShells() {
        return shells;
    }
}