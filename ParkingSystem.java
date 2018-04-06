import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ParkingSystem {

	private static final char FORWARD = 'F';
	private static final char LEFT = 'L';
	private static final char RIGHT = 'R';
	private static final String INPUT_REGX = "([0-9]|1[0-5]),([0-9]|1[0-5]):([FLR]+)";
	private List<Position> positions = new ArrayList<Position>();

	public ParkingSystem(String input) {
		processPositions(input);
	}

	// Process the input and get the axis and direction
	private void processPositions(String input) {
		
		Matcher matcher = Pattern.compile(INPUT_REGX).matcher(input);

		if (!matcher.matches()) {
			System.out.println("Invalid expression");
		}

		int vertical = Integer.parseInt(matcher.group(1));

		int horizontal = Integer.parseInt(matcher.group(2));
		
		Position startPosition = new Position(vertical, horizontal);

		positions.add(startPosition);

		Position currentPosition = new Position(startPosition);

		System.out.println("Vehicle current poisition : " + currentPosition.getHori_axis() + ", " + startPosition.getVert_axis());

		String nextMoves = matcher.group(3);

		System.out.println("parsePositions : moves :" + nextMoves);

		for (int i = 0; i < nextMoves.length(); i++) {
			currentPosition = new Position(currentPosition);
			char nextMove = nextMoves.charAt(i);
			System.out.println("Move : " + nextMove);
			switch (nextMove) {
			case LEFT:
				currentPosition.moveLeft();
				break;
			case RIGHT:
				currentPosition.moveRight();
				break;
			case FORWARD:
				currentPosition.moveForward();
				break;
			}

			positions.add(currentPosition);
			System.out.println("Current position : " + currentPosition.getHori_axis() + ", " + currentPosition.getVert_axis());
		}

	}

	public Position getStartPosition() {
		return positions.get(0);
	}

	public Position getEndPosition() {
		return positions.get(positions.size() - 1);
	}

	public List<Position> getPositions() {
		return positions;
	}

}
