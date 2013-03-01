package main;

import util.CSVParser;

public class Anwendung {
  public static void main (String[] args) {
    System.out.println("Start ...");
    CSVParser parser = new CSVParser("../testdata.csv");
    
    System.out.println("Ending ...");

  }
}