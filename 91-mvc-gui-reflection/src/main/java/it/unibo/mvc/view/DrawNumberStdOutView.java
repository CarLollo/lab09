package it.unibo.mvc.view;

import it.unibo.mvc.api.DrawNumberController;
import it.unibo.mvc.api.DrawNumberView;
import it.unibo.mvc.api.DrawResult;

public class DrawNumberStdOutView implements DrawNumberView{

    private DrawNumberController controller;

    public DrawNumberStdOutView() {

    }

    @Override
    public void setController(DrawNumberController observer) {
        this.controller = observer;
    }

    @Override
    public void start() {
        System.out.println("It's a view only on StdOut!");
    }

    @Override
    public void result(DrawResult res) {
         switch (res) {
            case YOURS_HIGH, YOURS_LOW -> {
                System.out.println(res.getDescription());
                return;
            }
            case YOU_WON -> System.out.println("Congratulation, " + res.getDescription());
            case YOU_LOST -> System.out.println("Sorry, " + res.getDescription());
            default -> throw new IllegalStateException("Unknown game state");
        }
    }
    
}
