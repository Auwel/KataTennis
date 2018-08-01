package kata.tennis.points;

 public enum ClassicPoint{

	ZERO("0"),
	QUINZE("15"),
	TRENTE("30"),
	QUARANTE("40"),
	WIN("WIN");
	private String point;

	ClassicPoint(String point){
		this.point=point ;
	}

	public final String getEnumPoint() {
		return point;
	}

}

