package application;

import model.entities.Department;

import javax.swing.plaf.synth.SynthOptionPaneUI;

public class Program {
    public static void main(String[] args) {

        Department obj = new Department(1, "BOOKS");

        System.out.println(obj);
    }
}
