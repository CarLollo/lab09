package it.unibo.mvc;

import java.lang.reflect.InvocationTargetException;

import it.unibo.mvc.api.DrawNumberController;
import it.unibo.mvc.api.DrawNumberView;
import it.unibo.mvc.controller.DrawNumberControllerImpl;
import it.unibo.mvc.model.DrawNumberImpl;
import it.unibo.mvc.view.DrawNumberStdOutView;
import it.unibo.mvc.view.DrawNumberSwingView;

/**
 * Application entry-point.
 */
public final class LaunchApp {

    private LaunchApp() { }

    /**
     * Runs the application.
     *
     * @param args ignored
     * @throws ClassNotFoundException if the fetches class does not exist
     * @throws SecurityException
     * @throws NoSuchMethodException if the 0-ary constructor do not exist
     * @throws InvocationTargetException if the constructor throws exceptions
     * @throws InstantiationException if the constructor throws exceptions
     * @throws IllegalAccessException in case of reflection issues
     * @throws IllegalArgumentException in case of reflection issues
     */
    public static void main(final String... args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
        final var model = new DrawNumberImpl();
        final DrawNumberController app = new DrawNumberControllerImpl(model);
        final var cswing = Class.forName("it.unibo.mvc.view.DrawNumberSwingView");
        final var cstdout = Class.forName("it.unibo.mvc.view.DrawNumberStdOutView");

        if(DrawNumberView.class.isAssignableFrom(cswing) && DrawNumberView.class.isAssignableFrom(cstdout)){
            final DrawNumberView a = (DrawNumberView)cswing.getConstructor().newInstance();
            final DrawNumberView b = (DrawNumberView)cstdout.getConstructor().newInstance();
            for (int i = 0; i < 3; i++) {
                app.addView(a);
                app.addView(b);
            }
        }
    }
}
