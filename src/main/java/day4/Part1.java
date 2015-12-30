package day4;

import java.nio.charset.Charset;

import com.google.common.hash.HashCode;
import com.google.common.hash.HashFunction;
import com.google.common.hash.Hashing;

public class Part1 {

	private static final String SECRET = "ckczppom";

	public static void main(String[] args) {
		HashFunction md5 = Hashing.md5();
		Charset charset = Charset.forName("ASCII");
		System.out.println(md5.hashString("ckczppom117946", charset).toString());
		if (2 == 2) {
			return;
		}
		for (int i = 1; i < 100000000; i++) {
			HashCode hashCode = md5.hashString(SECRET.concat(String.valueOf(i)), charset);
			if (hashCode.toString().startsWith("000000")) {
				System.out.println(i);
				return;
			}
		}
	}
}
