package HW3;

import java.util.ArrayList;

public class BoxF<F> {
	protected float weight = 0f;
	Object object;
	ArrayList<F> fruits = new ArrayList();


	public <F> BoxF(float weightFr) {
		this.weight= weightFr;
	}

	public void addFruit(F newfruit) {
		fruits.add(newfruit);
	}


	public boolean compareBoxs(BoxF<?> comparebox){
		return (getWeight() == comparebox.getWeight());
	}
	public float getSize(){
		return fruits.size();
	}

	public float getWeight(){
		return fruits.size() * weight;
	}

	public void sprinkleFruits(BoxF<F> sprinklebox) {
		fruits.addAll(sprinklebox.fruits);
		sprinklebox.fruits.clear();
		sprinklebox.fruits.trimToSize();
	}


}
/*
Какие основные методы предоставляет нам ArrayList:

add(element) — добавляет элемент в коллекцию;
get(index) — достает элемент по индексу;
clear() — полностью очищает коллекцию;
addAll(another_collection) — добавляет один список в другой;
remove(index) — удяляет объект по индексу;
remove(object) удаляет по объекту;
removeAll(collection_with_remove_elements) — если нужно удалить целый список объектов;
size() — возвращает длину коллекции;
isEmpty() — проверяет на пустоту;
forEach() — обход всех элементов.
 */