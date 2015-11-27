interface stactADT<E> {
	public void enQueue(E element);
	public void deQueue();
	public int front();
	public boolean isEmpty();
}