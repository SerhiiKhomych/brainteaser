package com.rhcloud.controllers;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Sergey on 24.05.2015.
 */
@Named("brainteaser")
@ApplicationScoped
public class Brainteaser {
    private String brainteaser = "ЕЕМРТООРДВГОНЛЕА";
    private String solution = "ДЕРМАТОВЕНЕРОЛОГ";
    private String answer;
    private Integer attempts = 0;
    private Map<Integer, String> tooltips = new HashMap<>();
    private boolean isSolved;

    @PostConstruct
    public void init() {
        tooltips.put(0, "Слово-розгадка пов\'язане з медициною");
        tooltips.put(1, "Перша буква Д");
        tooltips.put(2, "Остання буква Г");
        tooltips.put(3, "Четверта буква М");
        tooltips.put(4, "Передостання буква О");
        tooltips.put(5, "Це слово - назва лікарської професії");
        tooltips.put(6, "І не соромно?");
        tooltips.put(7, "А якщо гарно подумати?");
        tooltips.put(8, "ДЕР---ОВЕН--ОЛОГ");
    }

    public String getBrainteaser() {
        return brainteaser;
    }

    public void setBrainteaser(String brainteaser) {
        this.brainteaser = brainteaser;
    }

    public String getSolution() {
        return solution;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public void setSolution(String solution) {
        this.solution = solution;
    }

    public boolean isSolved() {
        return isSolved;
    }

    public void setSolved(boolean isSolved) {
        this.isSolved = isSolved;
    }

    public Integer getAttempts() {
        return attempts;
    }

    public void setAttempts(Integer attempts) {
        this.attempts = attempts;
    }

    public Map<Integer, String> getTooltips() {
        return tooltips;
    }

    public void setTooltips(Map<Integer, String> tooltips) {
        this.tooltips = tooltips;
    }

    public void enterResult(){
        answer.replaceAll("\\s+","");
        isSolved = answer.toUpperCase().equals(solution.toUpperCase());
        System.out.println("ANSWER="+answer);
        System.out.println("SOLUTION="+solution);
        answer = "";
        iterateAttempts();
    }

    public void iterateAttempts() {
        attempts++;
    }

    public String getToolTip() {
        return tooltips.get(attempts);
    }
}
