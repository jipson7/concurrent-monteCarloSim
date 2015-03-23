import java.util.Random;

public class ThreadedTimeBoundedPi {

	private static void startThreads(int duration, int numThreads) throws Exception {

		long[] circs = new long[numThreads];
		long[] totals = new long[numThreads];

		TestCirc[] threads = new TestCirc[numThreads];

		for (int i = 0; i < threads.length; i++) {

			threads[i] = new TestCirc(duration);
			threads[i].start();

		}

		for (int i = 0; i < threads.length; i++) {

			threads[i].join();

		}


		for (int i = 0; i < threads.length; i++) {

			long[] dataReturn = threads[i].getData();
			
			circs[i] = dataReturn[0];
			totals[i] = dataReturn[1];

		}

		printEstimate(circs, totals);

	}

	private static void printEstimate(long[] circs, long[] totals) {

		long circFinal = 0;

		long totalFinal = 0;

		for (int i = 0; i < totals.length; i++) {

			circFinal += circs[i];

			totalFinal += totals[i];

		}

		double pi = (double) circFinal / totalFinal * 4.0;

		System.out.println("Total iteration: " + totalFinal); 
		System.out.println("Estimation: " + pi); 
		System.out.println("Error: " + Math.abs(Math.PI - pi));

	}
	

	public static void main(String[] args) throws Exception{

		if (args.length != 2) {

			System.err.println("Number of arguments must be 2, " + 
					"The time in milliseconds to run and the number of threads to use.");

			System.exit(1);

		}

		startThreads(Integer.parseInt(args[0]), Integer.parseInt(args[1]));

	}

}

class TestCirc extends Thread {

	private long executionStart;

	long finalTotal;
	long finalInCircle;

	int durationSet = 0;

	public TestCirc(int durationSet) {


		this.durationSet = durationSet;

	}

	public long[] getData() {

		long[] returnData = new long[2];

		returnData[0] = finalInCircle;
		returnData[1] = finalTotal;

		return returnData;

	}

	public void run() {

		runSim(durationSet);	

	}

	private void runSim(int duration) {

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

		finalTotal = total;
		finalInCircle = inCircle;

	}
}
