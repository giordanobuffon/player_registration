package br.edu.ifrs.modelo.bean;

import static java.lang.Double.isNaN;
public class Player {

    private String name;
    private String team;
    private double height;
    private double weight;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) throws Exception {
        if (isNaN(height) || height < 0.50 || height > 2.50) {
            throw new Exception("[br.edu.ifrs.modelo.Player.setHeight] A altura deve ser maior que 0,50 e menor que 2,50 metros.");
        }
        this.height = height;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) throws Exception {
        if (isNaN(weight) || weight < 30 || weight > 150) {
            throw new Exception("[br.edu.ifrs.modelo.Player.setWeight] O peso deve ser maior que 30 e menor que 150 kg.");
        }
        this.weight = weight;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) throws Exception {
        if (isNaN(age) || age < 18 || age > 36) {
            throw new Exception("[br.edu.ifrs.modelo.Player.setAge] O peso deve ser maior que 30 e menor que 150 kg.");
        }
        this.age = age;
    }
}
