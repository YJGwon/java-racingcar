package racingcar;

public class CarDto {
	private final String name;
	private final int position;

	public CarDto(String name) {
		this.name = name;
		this.position = 0;
	}

	public CarDto(String name, int position) {
		this.name = name;
		this.position = position;
	}

	public String getName() {
		return name;
	}

	public int getPosition() {
		return position;
	}
}
