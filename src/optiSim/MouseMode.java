package optiSim;

public enum MouseMode {
	MOVE("Move"),
	POINT_EMITTER("Point Emitter"),
	SINGLE_EMITTER("Single Emitter"),
	PARALLEL_EMITTER("Parallel Emitter"),
	BLOCKER("Blocker"),
	MIRROR("Mirror"),
	LENS("Lens");
	
	public String name;
	
	private MouseMode(String name) {
		this.name = name;
	}
}