package clase2;

public class TarjetaDeCredito implements FormaDePago{

	@Override
	public double pagar(double monto) {
		return monto + 240.0;
	}
}
