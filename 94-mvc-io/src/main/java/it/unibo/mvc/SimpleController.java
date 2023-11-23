package it.unibo.mvc;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * 
 *
 */
public final class SimpleController implements Controller {
    
    private List<String> list = new ArrayList<>();

    @Override
    public void setNext(String s) {
        Objects.requireNonNull(this.list.add(s), "The string cannot be null!");
    }

    @Override
    public String getNext() {
        return this.list.get(this.list.size()-1);
    }

    @Override
    public List<String> getHistory() {
       return List.copyOf(this.list);
    }

    @Override
    public void printString() {
        if (this.getNext() == null) {
            throw new IllegalStateException("The string cannot be unset!");
        }
        System.out.println(this.getNext());
    }

}