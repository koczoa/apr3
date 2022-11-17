package optiSim;

public interface Movable {
	public default void move(Vector v) {
		setPos(getPos().add(v));
	}
	
	public default void move(double x, double y) {
		this.move(new Vector(x, y));
	}
	
	public Vector getPos();
	public void setPos(Vector v);
}