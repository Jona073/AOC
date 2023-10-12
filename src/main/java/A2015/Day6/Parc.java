package A2015.Day6;

import lombok.Data;

@Data
public class Parc {
    private final int NUMBER_LINE = 1000;
    private final int NUMBER_COLOMN = 1000;
    private Light[][] lights = new Light[NUMBER_LINE][NUMBER_COLOMN];
    private LightV2[][] lightsV2 = new LightV2[NUMBER_LINE][NUMBER_COLOMN];

    public Parc() {
        for (int line = 0; line < NUMBER_LINE; line++) {
            for (int column = 0; column < NUMBER_COLOMN; column++) {
                this.lights[line][column] = new Light();
                this.lightsV2[line][column] = new LightV2();
            }
        }
    }

    public void action(String input) {
        String[] decoupe = input.split("turn on |turn off |toggle | through |,");
        String action = input.split(" \\d")[0];
        int xDeb = Integer.parseInt(decoupe[1]);
        int yDeb = Integer.parseInt(decoupe[2]);
        int xFin = Integer.parseInt(decoupe[3]);
        int yFin = Integer.parseInt(decoupe[4]);

        for (int line = xDeb; line <= xFin; line++) {
            for (int column = yDeb; column <= yFin; column++) {

                Action actionEnum = Action.get(action);

                switch (actionEnum) {
                    case TOGGLE:
                        this.lights[line][column].switchLight();
                        this.lightsV2[line][column].switchLight();
                        break;
                    case TURN_ON:
                        this.lights[line][column].turnOn();
                        this.lightsV2[line][column].turnOn();
                        break;
                    case TURN_OFF:
                        this.lights[line][column].turnOff();
                        this.lightsV2[line][column].turnOff();
                        break;
                }
            }
        }
    }

    public int computeLightOn() {
        int count = 0;
        for (int line = 0; line < NUMBER_LINE; line++) {
            for (int column = 0; column < NUMBER_COLOMN; column++) {
                if(this.lights[line][column].isEtat()) {
                    count++ ;
                }
            }
        }
        return count;
    }
    public int computeLightV2On() {
        int count = 0;
        for (int line = 0; line < NUMBER_LINE; line++) {
            for (int column = 0; column < NUMBER_COLOMN; column++) {
                count+= lightsV2[line][column].getBrightness();
            }
        }
        return count;
    }

}
