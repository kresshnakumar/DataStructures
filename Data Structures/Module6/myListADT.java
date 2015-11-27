interface myListADT<E> {
	public void addElement(E element);
	public void removeElement(E element);
	public void removeElementAtIndex(int index);
	public void modifyByIndex(int index, E element);
	public void modifyByElement(E oldElement, E newElement);
	public void read(int index);
	public void reallocateSize();
	public void removeSize();
	public void printMyArray();
}