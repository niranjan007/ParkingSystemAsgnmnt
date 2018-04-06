
public class Position {
	
	private int vert_axis = -1;
	private int hori_axis = -1;
	private Direction direction = Direction.North;
	
	
	public Position(int verti_axis, int hori_axis) {
		this.vert_axis = verti_axis;
		this.hori_axis = hori_axis;
	}

	public Position(Position parent) {
		this.vert_axis = parent.getVert_axis();
		this.hori_axis = parent.getHori_axis();
		this.direction = parent.getDirection();
	}

	
	public int getVert_axis() {
		return vert_axis;
	}

	
	public int getHori_axis() {
		return hori_axis;
	}

	public Direction getDirection() {
		return direction;
	}

	void moveForward() {
		if (direction == Direction.South) {
			vert_axis--;
		} else if (direction == Direction.North) {
			vert_axis++;
		} else if (direction == Direction.West) {
			hori_axis--;
		} else {
			hori_axis++;
		}
	}

	void moveLeft() {
		direction = Direction.values()[direction.ordinal() == 0 ? 3 : direction.ordinal() - 1];
	}

	void moveRight() {
		direction = Direction.values()[direction.ordinal() == 3 ? 0 : direction.ordinal() + 1];
	}

}
