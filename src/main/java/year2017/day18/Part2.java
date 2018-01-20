package year2017.day18;

import java.util.ArrayDeque;
import java.util.Queue;

import org.eclipse.collections.api.map.primitive.MutableCharLongMap;
import org.eclipse.collections.impl.map.mutable.primitive.CharLongHashMap;

public class Part2 {

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

		// TODO wrong asnwer:
		System.out.println(firstCounter(program));
	}

	static int firstCounter(String[] program) {
		Queue<Long> firstQueue = new ArrayDeque<>();
		Queue<Long> secondQueue = new ArrayDeque<>();

		Program first = new Program(0, program, firstQueue, secondQueue);
		Program second = new Program(1, program, secondQueue, firstQueue);

		while (first.running() || second.running()) {
			first.move();
			second.move();
		}

		return second.sendCounter;
	}

	static class Program {
		final int id;
		final String[] program;
		final Queue<Long> recQueue;
		final Queue<Long> sendQueue;
		int sendCounter = 0;
		int index = 0;
		boolean waiting = false;

		final MutableCharLongMap registers = new CharLongHashMap();

		public Program(int id, String[] program, Queue<Long> recQueue, Queue<Long> sendQueue) {
			this.id = id;
			this.program = program;
			this.recQueue = recQueue;
			this.sendQueue = sendQueue;
		}

		boolean running() {
			return !waiting && index < program.length;
		}

		void move() {
			while (running()) {
				turn();
			}
		}

		void turn() {
			String line = program[index];
			String[] split = line.split(" ");
			switch (split[0]) {
			case "snd": {
				sendQueue.add(getVal(split, 1));
				sendCounter++;
				break;
			}
			case "set": {
				long val = getVal(split);
				registers.put(split[1].charAt(0), val);
				break;
			}
			case "add": {
				long val = getVal(split);
				char reg = split[1].charAt(0);
				long prev = registers.getIfAbsentPut(reg, id);
				registers.put(reg, prev + val);
				break;
			}
			case "mul": {
				long val = getVal(split);
				char reg = split[1].charAt(0);
				long prev = registers.getIfAbsentPut(reg, id);
				registers.put(reg, prev * val);
				break;
			}
			case "mod": {
				long val = getVal(split);
				char reg = split[1].charAt(0);
				long prev = registers.getIfAbsentPut(reg, id);
				registers.put(reg, prev % val);
				break;
			}
			case "rcv": {
				Long val = recQueue.poll();
				if (val == null) {
					waiting = true;
				} else {
					waiting = false;
					char reg = split[1].charAt(0);
					registers.put(reg, val);
				}
				break;
			}
			case "jgz": {
				if (getVal(split, 1) > 0L) {
					index += getVal(split);
					index--;
				}
				break;
			}
			default:
				throw new IllegalStateException();
			}
			if (!waiting) {
				index++;
			}
		}

		private long getVal(String[] split) {
			return getVal(split, 2);
		}

		private long getVal(String[] split, int index) {
			long val;
			if (isChar(split[index])) {
				char reg = split[index].charAt(0);
				if(reg == 'p') {
					val = registers.getIfAbsentPut(reg, id);
				} else {
					val = registers.getIfAbsentPut(reg, 0);
				}
			} else {
				val = Integer.valueOf(split[index]);
			}
			return val;
		}

	}

	static boolean isChar(String s) {
		return s.length() == 1 && Character.isAlphabetic(s.charAt(0));
	}

}
