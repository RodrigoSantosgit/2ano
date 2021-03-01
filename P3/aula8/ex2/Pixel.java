package aula8.ex2;

public class Pixel {

	final byte R;
	final byte G;
	final byte B;
	
	public Pixel(byte b, byte g, byte r) {
		this.R = r;
		this.G = g;
		this.B = b;
	}
	
	@Override
	public String toString() {
		return "RGB("+(R & 0xff)+","+(G & 0xff)+","+(B & 0xff)+")";
	}

	public byte getR() {
		return R;
	}

	public byte getG() {
		return G;
	}

	public byte getB() {
		return B;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + B;
		result = prime * result + G;
		result = prime * result + R;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pixel other = (Pixel) obj;
		if (B != other.B)
			return false;
		if (G != other.G)
			return false;
		if (R != other.R)
			return false;
		return true;
	}
	
}
