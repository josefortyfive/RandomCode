package ch12.generics.challenge;

import java.util.List;
import java.util.ArrayList;

public class Layer <T extends Mappable>{

	private List<T> layerElements;

	public Layer(T[] layerElements) {
		this.layerElements = new ArrayList<T>(List.of(layerElements));
	}
	
	public void addElements(T... elements) {
		layerElements.addAll(List.of(elements));
	}
	
	public void renderLayer() {
		for(T element : layerElements) {
			element.render();
		}
	}
}
