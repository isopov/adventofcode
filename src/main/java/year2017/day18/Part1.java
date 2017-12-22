package year2017.day18;

import org.eclipse.collections.api.map.primitive.MutableCharLongMap;
import org.eclipse.collections.impl.map.mutable.primitive.CharLongHashMap;

public class Part1 {

	public static void main(String[] args) {
		String[] program = {
				"set i 31",
				"set a 1",
				"mul p 17",
				"jgz p p",
				"mul a 2",
				"add i -1",
				"jgz i -2",
				"add a -1",
				"set i 127",
				"set p 952",
				"mul p 8505",
				"mod p a",
				"mul p 129749",
				"add p 12345",
				"mod p a",
				"set b p",
				"mod b 10000",
				"snd b",
				"add i -1",
				"jgz i -9",
				"jgz a 3",
				"rcv b",
				"jgz b -1",
				"set f 0",
				"set i 126",
				"rcv a",
				"rcv b",
				"set p a",
				"mul p -1",
				"add p b",
				"jgz p 4",
				"snd a",
				"set a b",
				"jgz 1 3",
				"snd b",
				"set f 1",
				"add i -1",
				"jgz i -11",
				"snd a",
				"jgz f -16",
				"jgz a -19"
		};
		System.out.println(lastSound(program));
	}

	static long lastSound(String[] program) {
		long sound = -1;
		MutableCharLongMap registers = new CharLongHashMap();
		for (int i = 0; i < program.length; i++) {
			String line = program[i];
			String[] split = line.split(" ");
			switch (split[0]) {
			case "snd":
				sound = getVal(registers, split, 1);
				break;
			case "set": {
				long val = getVal(registers, split);
				registers.put(split[1].charAt(0), val);
				break;
			}
			case "add": {
				long val = getVal(registers, split);
				char reg = split[1].charAt(0);
				long prev = registers.getIfAbsentPut(reg, 0L);
				registers.put(reg, prev + val);
				break;
			}
			case "mul": {
				long val = getVal(registers, split);
				char reg = split[1].charAt(0);
				long prev = registers.getIfAbsentPut(reg, 0L);
				registers.put(reg, prev * val);
				break;
			}
			case "mod": {
				long val = getVal(registers, split);
				char reg = split[1].charAt(0);
				long prev = registers.getIfAbsentPut(reg, 0L);
				registers.put(reg, prev % val);
				break;
			}
			case "rcv":
				if (getVal(registers, split, 1) != 0L) {
					return sound;
				}
				break;
			case "jgz":
				if (getVal(registers, split, 1) > 0L) {
					i += getVal(registers, split);
					i--;
				}
				break;
			default:
				throw new IllegalStateException();
			}
		}
		return sound;
	}

	private static long getVal(MutableCharLongMap registers, String[] split) {
		return getVal(registers, split, 2);
	}

	private static long getVal(MutableCharLongMap registers, String[] split, int index) {
		long val;
		if (isChar(split[index])) {
			val = registers.getIfAbsentPut(split[index].charAt(0), 0L);
		} else {
			val = Integer.valueOf(split[index]);
		}
		return val;
	}

	static boolean isChar(String s) {
		return s.length() == 1 && Character.isAlphabetic(s.charAt(0));
	}

}
