package homeWorkThree;

import java.util.ArrayList;

public class Box<T extends Fruit> {
    ArrayList<T> fruitList = new ArrayList<>();

    public ArrayList<T> getFruitList() {
        return fruitList;
    }

    public void setFruitList(ArrayList<T> fruitList) {
        this.fruitList = fruitList;
    }

    public float getWeight(){
        return fruitList.size() * fruitList.get(0).getWeight();
    }

    public boolean compare(Box anotherBox) {
        if(getWeight() == anotherBox.getWeight()) return true;
        return false;
    }
    public void pourTo(Box <T>anotherBox) {
        anotherBox.fruitList.addAll(fruitList);
        fruitList.clear();
    }

    public void addFruit(T fruit){
        fruitList.add(fruit);
    }
}
