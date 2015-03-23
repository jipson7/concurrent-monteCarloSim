import java.util.Random;

class TimeBoundedPi {

	private static long executionStart;

	private static void runSim(int duration) {

		long total = 0;
		long inCircle = 0;
		double x   = 0;
		double y   = 0;
		double pi = 0;

		Random R = new Random();

		int iteration = 0;

		executionStart = System.currentTimeMillis();

		while((System.currentTimeMillis() - executionStart) < duration) {

			x = R.nextDouble();
			y = R.nextDouble();
			if(x*x + y*y <= 1) {
				inCircle += 1;
			}
			total += 1;
			iteration += 1;

			pi = (double)inCircle / total * 4.0;

		}	

		System.out.println("Total iteration: " + iteration);
		System.out.println("Estimation: " + pi);
		System.out.println("Error: " + Math.abs(Math.PI - pi));

	}

	public static void main(String[] args) {

		if (args.length != 1) {

			System.err.println("Number of arguments must be 1, The time in milliseconds to run");
			System.exit(1);

		}

		runSim(Integer.parseInt(args[0]));

	}

}
