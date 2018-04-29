import java.lang.*;

public class gInt {
	private int R, I;
	
	public gInt(int r){
		R = r;
	}
	
	public gInt( int r, int i ){
		R = r;
		I = i;
	}
	
	public int real(){
		return R;
	}
	
	public int imag(){
		return I;
	}
	
	public gInt add( gInt rhs){
		gInt sum = new gInt(this.real()+rhs.real(),this.imag()+rhs.imag());
		return sum;
	}
	
	public gInt multiply( gInt rhs){
		int real_sum = this.real()*rhs.real()-this.imag()*rhs.imag();
		int imag_sum = this.real()*rhs.imag()+this.imag()*rhs.real();
		gInt sum = new gInt(real_sum, imag_sum);
		return sum;
	}
	
	public float norm(){
		float dist = (float)Math.sqrt(R*R + I*I);
		return dist;
	}
}
