package ttu.rakarh1.backend.enums;

public enum ProductTransactionTypes
{
	TAKE(1),
	REMOVE(2),
	MOVE(3);

	private int value;

	ProductTransactionTypes(int value) {
		this.value = value;
	}

	public int getValue()
	{
		return value;
	}

}
